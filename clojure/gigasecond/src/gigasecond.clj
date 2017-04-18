(ns gigasecond)

(defn- leap-year? [y]
  (and (zero? (mod y 4))
       (or (not= 0 (mod y 100))
           (zero? (mod y 400)))))

(defn- month-length [month year]
  (condp = month
    1  31
    2  (if (leap-year? year) 29 28)
    2  28
    3  31
    4  30
    5  31
    6  30
    7  31
    8  31
    9  30
    10 31
    11 30
    0  31)) ; because (mod 12 12) is 0

(def days-in-gs
  (quot 1000000000 (* 60 60 24)))

(defn from [year month day]
  ;; set a preposterous date
  (let [day' (+ day days-in-gs)]
    ;; loop until we balance things out
    (loop [y year m month d day']
      (let [max-d (month-length (rem m 12) y)]
        (cond

          ;; it's important to increment year each time we roll over 12 months,
          ;; otherwise we get errors when trying to figure out if it's a leap year.
          (> m 12)
          (recur (+ y (quot m 12)) (rem m 12) d)

          (> d max-d)
          (recur y (inc m) (- d max-d))

          :else [y m d])))))
