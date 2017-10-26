(ns roman-numerals)


;;;; First try


(def numeral-map {1000 "M", 500 "D", 100 "C", 50 "L", 10 "X", 5 "V", 1 "I"})


(defn romaniser
  [remainder k]
  (cond
    (and (contains? numeral-map (- k remainder))
         (not= k (* 2 remainder)))
    [(list (get numeral-map (- k remainder)) (get numeral-map k))
     0]
    (>= remainder k)
    [(repeat (/ remainder k) (get numeral-map k))
     (rem remainder k)]))


(defn translate
  [ch zeroes]
  (let [d    (Integer/parseUnsignedInt (str ch))
        mult (reduce * (repeat zeroes 10))
        i    (* mult d)]
    (loop [acc [] remainder i]
      (if (zero? remainder)
        acc
        (let [[to-append remainder']
              (some (partial romaniser remainder)
                    (keys numeral-map))]
          (recur (into acc to-append) remainder'))))))


;;;; Second try


(def numeral-map-2 {1 {0 "I" 1 "X" 2 "C" 3 "M"}
                    5 {0 "V" 1 "L" 2 "D"}})


(defn translate-2
  [ch zeroes]
  (loop [acc   []
         digit (Integer/parseUnsignedInt (str ch))]
    (case digit
      0 acc
      4 [(get-in numeral-map-2 [1 zeroes]) (get-in numeral-map-2 [5 zeroes])]
      9 [(get-in numeral-map-2 [1 zeroes]) (get-in numeral-map-2 [1 (inc zeroes)])]
      (let [k      (if (< digit 5) 1 5)
            digit' (- digit k)]
        (recur (into acc (get-in numeral-map-2 [k zeroes])) digit')))))


(defn numerals
  [n]
  (loop [roman    []
         arabic   (str n)]
    (cond
      (empty? arabic)
      (apply str roman)

      (= \0 (first arabic))
      (recur roman (rest arabic))

                         ; translate-2 has same params as translate
      :else
      (recur (into roman (translate-2 (first arabic) (dec (count arabic))))
             (rest arabic)))))


(prn "It is" (numerals 2017))
