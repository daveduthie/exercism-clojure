(ns binary-search)

(defn middle [v]
  (let [c (count v)]
    (int (if (even? c)
           (/ c 2)
           (- (/ c 2) 1/2)))))

(defn search-for
  ([e vect] (search-for e vect 0))
  ([e vect index]
   (let [v        (vec vect)
         mid      (middle v)
         mid-elem (get v mid)]
     (cond
       (= e mid-elem)  (+ index mid)
       (= 1 (count v)) (throw (AssertionError. "element not found"))
       (> e mid-elem)  (search-for e (subvec v mid) (+ index mid))
       (< e mid-elem)  (search-for e (subvec v 0 mid) index)))))
