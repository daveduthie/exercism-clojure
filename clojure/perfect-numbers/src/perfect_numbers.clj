(ns perfect-numbers
  (:require [clojure.core.logic :refer [run* fresh !=]]
            [clojure.core.logic.fd :as fd]))

(defn- factors [n]
  (run* [q]
        (fresh [x]
               (!= q n)
               (fd/in q x (fd/interval 0 n))
               (fd/* q x n))))

(defn classify [n]
  (if (>= n 0)
    (let [aliquot (reduce + (factors n))]
      (cond
        (= aliquot n) :perfect
        (< aliquot n) :deficient
        (> aliquot n) :abundant))
    (throw (IllegalArgumentException. "unnatural input"))))
