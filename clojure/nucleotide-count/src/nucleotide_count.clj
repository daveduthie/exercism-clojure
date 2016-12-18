(ns nucleotide-count)

(defn count [base nucleotide]
  (if (= base \X) (throw (AssertionError. "invalid base passed as input")))
  (clojure.core/count (filter #(= base %) (seq nucleotide))))

(defn nucleotide-counts [nucleotide]
  {\A (count \A nucleotide)
   \T (count \T nucleotide)
   \C (count \C nucleotide)
   \G (count \G nucleotide)})
