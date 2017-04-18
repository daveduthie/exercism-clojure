(ns grains)

(defn lazy-squares* [n]
  (lazy-cat (cons n (lazy-squares (*' 2 n)))))

(def squares*
  (lazy-squares* 1))

(defn square [n]
  (last (take n squares*)))

(defn total [n]
  (reduce +' (take n squares*)))
