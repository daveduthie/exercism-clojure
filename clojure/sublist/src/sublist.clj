(ns sublist)


(defn match? [xs ys pos]
        (let [x-len  (count xs)
              y-trim (->> ys (drop pos) (take x-len))]
          ;; (prn xs 'match y-trim '?)
          (= xs y-trim)))


(defn sublist? [xs ys]
  ;; (prn xs 'sub 'of ys '?)
  (some identity
        (for [drop-len (range (- (inc (count ys)) (count xs)))]
           (match? xs ys drop-len))))


(defn classify [xs ys]
  ;; (prn "TESTING" xs ys)
  (cond (= xs ys)        :equal
        (sublist? xs ys) :sublist
        (sublist? ys xs) :superlist
        :else            :unequal))

