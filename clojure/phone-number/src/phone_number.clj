(ns phone-number)

(defn number
  "Cleans telco numbers, yo."
  [num]
  (let [n   (clojure.string/replace num #"\D" "")
        len (count n)]
    (cond
      (= 10 len)             n
      (and (= 11 len)
           (= \1 (first n))) (apply str (rest n))
      :else                  "0000000000")))

(defn area-code
  "Gets area code from telco number."
  [num]
  (apply str (take 3 (number num))))

(defn pretty-print
  "Prints nicely formatted numbers"
  [num]
  (let [n (number num)]
    (str "(" (area-code n) ") " (subs n 3 6) "-" (subs n 6))))
