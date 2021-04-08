(ns simplex.crypto
  (:import
    [io.github.sokrato.crypto App])
  (:gen-class))

(defn -main [& args]
  (let [arr (make-array String (count args))]
    (loop [args args
           i 0]
      (when-not (empty? args)
        (aset arr i (first args))
        (recur (rest args) (inc i))))
    (App/main arr)))
