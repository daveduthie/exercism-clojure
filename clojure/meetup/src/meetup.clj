(ns meetup
  (:require [java-time :as t]))

(defn meetup [m y d occ]
  (let [start (t/local-date y m 01)
        date
        (cond
          (= occ :first)  (t/adjust start :next-or-same-day-of-week d)
          (= occ :second) (t/adjust (t/plus start (t/days 7)) :next-or-same-day-of-week d)
          (= occ :third)  (t/adjust (t/plus start (t/days 14)) :next-or-same-day-of-week d)
          (= occ :fourth) (t/adjust (t/plus start (t/days 21)) :next-or-same-day-of-week d)
          (= occ :teenth) (t/adjust (t/plus start (t/days 12)) :next-or-same-day-of-week d)
          (= occ :last)   (t/adjust start :last-in-month d))]
    (vec (t/as date :year :month-of-year :day-of-month))))
