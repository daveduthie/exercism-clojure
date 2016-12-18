(ns grade-school)

(defn add
  "Add a student to a database."
  [db name grade]
  (update-in db [grade] (fn [existing]
                          (vec (conj existing name)))))

(defn grade
  "Get students in a grade."
  [db grade]
  (db grade []))

(defn sorted
  "Sort a db."
  [db]
  (let [grades (sort (keys db))]
    (reduce (fn [srt-db k]
              (assoc srt-db k (sort (db k))))
            {}
            grades)))

;;;; bmaddy's version \O/:
;; (defn sorted [db]
;;   (into (sorted-map-by <)
;;         (for [[k v] db]
;;           [k (sort v)])))
