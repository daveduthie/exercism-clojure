(ns triangle)

(defn type [x y z]
  (let [[a b c] (sort [x y z])]
    (cond (<= (+ a b) c)    :illogical
          (= x y z)         :equilateral
          (distinct? x y z) :scalene
          :else             :isosceles)))
