;; # Number of Ones  Share on LinkedIn
;; 
;; ## Description:
;; Write a program to determine the number of 1 bits in the internal
;; representation of a given integer.
;;
;; ## Input sample:
;; The first argument will be a text file containing an integer, one per line. e.g. 
;; 
;;      10
;;      22
;;      56
;;
;; ## Output sample:
;; Print to stdout, the number of ones in the binary form of each number.
;; 
;;      2
;;      3
;;      3

(use '[clojure.string :only (join split)])

(defn -main [& args]

  (def lines (split (slurp (first args)) #"\n"))

  (defn process-line [line]
    (let [n    (Integer/parseInt line)
          nstr (Integer/toString n 2)]
      ((frequencies nstr) \1)))

  (println (join "\n" (map process-line lines))))

(apply -main *command-line-args*)
