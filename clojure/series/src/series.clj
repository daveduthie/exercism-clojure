(ns series)

(defn slices [string n]
  (cond (zero? n)            [""]
        (> n (count string)) []
        :else                (map (partial apply str) (partition n 1 string))))
