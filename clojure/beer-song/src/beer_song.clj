(ns beer-song)

(defn verse [num]
  (cond
    (> num 1)
    (let [unit (if (> num 2) " bottles " " bottle ")]
      (str num " bottles of beer on the wall, " num " bottles of beer.\n"
           "Take one down and pass it around, " (- num 1) unit "of beer on the wall.\n"))
    (= num 1)
    (str "1 bottle of beer on the wall, 1 bottle of beer.\n"
         "Take it down and pass it around, no more bottles of beer on the wall.\n")
    (= num 0)
    (str "No more bottles of beer on the wall, no more bottles of beer.\n"
         "Go to the store and buy some more, 99 bottles of beer on the wall.\n")))

(defn sing
  ([start end]
   (apply str
          (interpose "\n" (map verse (reverse (range end (+ 1 start)))))))
  ([start]
   (sing start 0)))

;; yuck...
