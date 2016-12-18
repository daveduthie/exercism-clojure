(ns flatten-array)

(defn flatten [a]
  (mapcat (fn  [elem]
            (if (vector? elem)
              (flatten elem)
              (if-not (nil? elem)
                (conj [] elem)
                [])))
          a))

;; (flatten [1 2 [3 4 [[1 1 1] 3] 6 7] 4 [5 6 [7]]])
(flatten [1 nil [3 4 [[1 1 1] 3] 6 7] 4 [5 6 [7]]])
