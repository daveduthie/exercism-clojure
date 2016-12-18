(ns anagram
  (:require [clojure.string :as str]))

(defn clean-and-seq [word]
  (seq (str/lower-case word)))

(defn anagrams-for [word possible-anagrams]
  (filter #(and (= (frequencies (clean-and-seq word))
                   (frequencies (clean-and-seq %)))
                (not= (clean-and-seq word)
                      (clean-and-seq %)))
          possible-anagrams))
