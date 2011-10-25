;; # Decimal To Binary  Share on LinkedIn
;; 
;; ## Description:
;; Given a decimal (base 10) number, print out its binary representation.
;; 
;; ## Input sample:
;; File containing positive whole decimal numbers, one per line. e.g. 
;; 
;;      2
;;      10
;;      67
;;
;; ## Output sample:
;; Print the decimal representation, one per line.
;; 
;;      10
;;      1010
;;      1000011

(use '[clojure.string :only (join split)])

(defn -main [& args]

  (def lines (split (slurp (first args)) #"\n"))

  (defn process-line [line]
    (let [n (Integer/parseInt line)]
      (Integer/toString n 2)))

  (println (join "\n" (map process-line lines))))

(apply -main *command-line-args*)

