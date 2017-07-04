(ns gigasecond
  (:require [clojure.string :as str])
  (:import java.util.Calendar))

(defn from [yyyy mm dd]
  (let [g 1000000000
        d (doto (Calendar/getInstance)
            (.set yyyy (dec mm) dd)
            (.add Calendar/SECOND g))
        yyyy' (.get d Calendar/YEAR)
        mm' (inc (.get d Calendar/MONTH))
        dd' (.get d Calendar/DATE)]
    [yyyy' mm' dd']))

;; (add-time 2017 07 04)
;; (add-time 2011 4 25)
;; (add-time 1977 6 13)
