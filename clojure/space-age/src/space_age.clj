(ns space-age)

(def earth-orbit 31557600)
(def mercury-orbit (* earth-orbit 0.2408467))
(def venus-orbit (* earth-orbit 0.61519726))
(def mars-orbit (* earth-orbit 1.8808158))
(def jupiter-orbit (* earth-orbit 11.862615))
(def saturn-orbit (* earth-orbit 29.447498))
(def uranus-orbit (* earth-orbit 84.016846))
(def neptune-orbit (* earth-orbit 164.79132))

(defn on-earth [seconds]
  (/ seconds earth-orbit))

(defn on-mercury [seconds]
  (/ seconds mercury-orbit))

(defn on-venus [seconds]
  (/ seconds venus-orbit))

(defn on-mars [seconds]
  (/ seconds mars-orbit))

(defn on-jupiter [seconds]
  (/ seconds jupiter-orbit))

(defn on-saturn [seconds]
  (/ seconds saturn-orbit))

(defn on-uranus [seconds]
  (/ seconds uranus-orbit))

(defn on-neptune [seconds]
  (/ seconds neptune-orbit))

;; good canditate for a macro
