(ns word-count
  (:require [clojure.string :as str]))

(defn word-count [phrase]
  (->> phrase ;; clean input string
      (re-seq #"\w+")
      (map str/lower-case)
      frequencies))

;; (word-count "This is a Phrase, is a 1 1 1 phrase indeed!")
