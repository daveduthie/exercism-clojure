(ns scrabble-score)

(def values
  {#{"a" "e" "i" "o" "u" "l" "n" "r" "s" "t"} 1
   #{"d" "g"} 2
   #{"b" "c" "m" "p"} 3
   #{"f" "h" "v" "w" "y"} 4
   #{"k"} 5
   #{"j" "x"} 8
   #{"q" "z"} 10})

(defn score-letter [c]
  (let [c (.toLowerCase c)]
    (or (some (fn [[set value]] (if (set c) value))
              values)
        0)))

(defn score-word [word]
  (reduce + (map (comp score-letter str) word)))
