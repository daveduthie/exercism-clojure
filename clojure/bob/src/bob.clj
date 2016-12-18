(ns bob)

(defn response-for [words]
  (cond
    (re-find #"^\s*$" words)         (str "Fine. Be that way!")
    (and
     (re-find #"[A-Z][A-Z]" words)
     (not (re-find #"[a-z]" words))) (str "Whoa, chill out!")
    (re-find #"\?$" words)           (str "Sure.")
    :else                            (str "Whatever.")))
