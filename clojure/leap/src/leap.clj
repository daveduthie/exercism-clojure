(ns leap)

(defn leap-year? [y]
  (and
   (= 0 (mod y 4))
   (or
    (not= 0 (mod y 100))
    (=    0 (mod y 400)))))
