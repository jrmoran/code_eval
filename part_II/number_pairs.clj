;; # Number Pairs
;; 
;; ## Description:
;; You are given a sorted array of positive integers and a number 'X'.
;; Print out all pairs of numbers whose sum is equal to X. Print out 
;; only unique pairs and the pairs should be in ascending order
;; 
;; ## Input sample:
;; Your program should accept as its first argument a filename.
;; This file will contain a comma separated list of sorted numbers and then
;; the sum 'X', separated by semicolon.
;; Ignore all empty lines. 
;;
;; If no pair exists, print the string NULL eg.
;; 
;;      1,2,3,4,6;5
;;      2,4,5,6,9,11,15;20
;;      1,2,3,4;50
;;      10,20,30,40,50,60,70,80,90;60
;;      100,200,300,400,600;800
;;      2,3,4;20 
;; 
;; ## Output sample:
;; Print out the pairs of numbers that equal to the sum X.
;; The pairs should themselves be printed in sorted order i.e the first number
;; of each pair should be in ascending order .e.g.
;; 
;;      1,4;2,3
;;      5,15;9,11
;;      NULL

(use '[clojure.string :only (join split trim)])

(defn process-line [line]
  (let [[nums x] (split (trim line) #";")
        x        (Integer/parseInt x)
        nums     (map #(Integer/parseInt %) (split nums #","))
        sum-x?   #(= x (+ (first %) (second %)))
        pairs    (filter #(<= 2 (count %))
                         (reduce (fn[acc x](conj acc x)) #{} 
                                 (for [x nums y nums] (sorted-set x y))))
        ret     (sort-by first (filter sum-x? pairs))]
    (if (empty? ret)
      "NULL"
      (join ";" (map #(apply str (interpose "," %)) ret)))))

(defn -main [& args]
  (def lines (split (slurp (first args)) #"\n"))
  (println (join "\n" (map process-line lines))))

(apply -main *command-line-args*)


; (process-line "2,4,5,6,9,11,15;20")

; (process-line "1,2,3,4,6;5")

; (process-line "2,4,5,6,9,11,15;20")

; (process-line "1,2,3,4;50")

; (process-line "10,20,30,40,50,60,70,80,90;60")

; (process-line "100,200,300,400,600;800")

; (process-line "2,3,4;20")



