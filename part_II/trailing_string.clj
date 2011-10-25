;; # Trailing String
;; 
;; ## Description:
;; You are given two strings 'A' and 'B'. Print out a 1 if string 'B'
;; occurs at the end of string 'A'. Else a zero.
;; 
;; ## Input sample:
;; 
;; The first argument is a file, containing two strings, comma delimited,
;; one per line. Ignore all empty lines in the input file.e.g. 
;; 
;;      Hello World,World
;;      Hello CodeEval,CodeEval
;;      San Francisco,San Jose
;;
;; ## Output sample:
;; Print out 1 if the second string occurs at the end of the first string.
;; Else zero. Do NOT print out empty lines between your output. 
;; 
;;      1
;;      1
;;      0

(use '[clojure.string :only (join split)])

(defn -main [& args]

  (def lines (split (slurp (first args)) #"\n"))

  (defn process-line [line]
    (let [[wa wb] (split line #",")]
      (if (.endsWith wa wb) 1 0)))
  
  (println (join "\n" (map process-line lines))))

(apply -main *command-line-args*)
