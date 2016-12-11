(ns robot-name)

(def alph-start 65)
(def alph-end 91)
(def alph (map (comp str char) (range alph-start alph-end)))

(defn random-name []
  (str (rand-nth alph)
       (rand-nth alph)
       (rand-int 10)
       (rand-int 10)
       (rand-int 10)))

(defn robot [] (atom (random-name)))

(defn robot-name [rob] @rob)

(defn reset-name [rob] (reset! rob (random-name)))
