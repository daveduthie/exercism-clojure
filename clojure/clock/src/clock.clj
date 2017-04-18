(ns clock)

(defn clock [hrs mins]
  (let [hrs'  (mod (+ hrs (Math/floorDiv mins 60)) 24)
        mins' (mod mins 60)]
    [hrs' mins']))

;; bccox wrote a nice clock fn
;; http://exercism.io/submissions/9d3a3db045e74fd8b231c8929253ad69
;; (defn clock [h m]
;;   (let [h-shift (if (neg? m) -1 0)]
;;     (list (mod (+ h h-shift (quot m 60)) 24) (mod m 60))))

(defn add-time [time add]
  (let [[hrs mins] time]
    (clock hrs (+ mins add))))

(defn clock->string [time]
  (let [[hrs mins] time]
    (format "%02d:%02d" hrs mins)))
