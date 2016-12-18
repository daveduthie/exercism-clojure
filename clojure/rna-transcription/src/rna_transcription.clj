(ns rna-transcription
  (:require [clojure.string :as str]))

(defn complement [b]
  (cond
    (= b \G) "C"
    (= b \C) "G"
    (= b \T) "A"
    (= b \A) "U"
    :else (throw (AssertionError. "Invalid DNA sequence in input"))))

(defn to-rna [strand]
  (str/join (map #(complement %) strand)))
