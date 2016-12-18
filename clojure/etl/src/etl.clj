(ns etl
  (:require [clojure.string :as str]))

(defn transform [m]
  (reduce (fn [new [k vals]]
            (into new
                  (reduce (fn [inner v]
                            (assoc inner (str/lower-case v) k))
                          {}
                          vals)))
          {}
          m))
