(ns robot-name)

(def alph-start 65)
(def alph-end 91)
(def alph (map (comp str char) (range alph-start alph-end)))

(defn robot
  ([name]
   (let [new-name (robot)]
     (if (= name new-name)
       (robot name)
       (new-name))))
  ([]
   (atom (str (rand-nth alph)
              (rand-nth alph)
              (rand-int 10)
              (rand-int 10)
              (rand-int 10)))))

(defn robot-name [rob]
  (deref rob))

(defn reset-name [rob]
  (reset! rob (str (rand-nth alph)
                   (rand-nth alph)
                   (rand-int 10)
                   (rand-int 10)
                   (rand-int 10))))
