(ns collatz-conjecture)

(defn collatz [n]
  (if (< n 1) (throw (IllegalArgumentException. "Cannot calculate for values < 1"))
      (loop [it 0 rem n]
        (let [even? (zero? (bit-and rem 1))]
          (cond (= rem 1) it
                even? (recur (inc it) (/ rem 2))
                :else (recur (inc it) (inc (* rem 3))))))))
