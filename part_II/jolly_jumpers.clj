;; # Jolly Jumpers
;; 
;; ## Description:
;; >Credits: Programming Challenges by Steven S. Skiena and Miguel A. Revilla
;; A sequence of n > 0 integers is called a jolly jumper if the absolute values
;; of the differences between successive elements take on all possible values
;; 1 through n - 1. eg.
;; 
;;      1 4 2 3
;;
;; is a jolly jumper, because the absolute differences are 3, 2, and 1, respectively.
;; The definition implies that any sequence of a single integer is a jolly jumper.
;; Write a program to determine whether each of a number of sequences is a jolly jumper.
;;
;; ## Input sample:
;; Your program should accept as its first argument a path to a filename.
;; Each line in this file is one test case. Each test case will contain 
;; an integer n < 3000 followed by n integers representing the sequence.
;;
;; The integers are space delimited.
;;
;; ##Output sample:
;; For each line of input generate a line of output saying 'Jolly' or 'Not jolly'.


(use '[clojure.string :only (join split trim)])

(defn process-line [line]
  (let [nums          (map #(Integer/parseInt %) (split line #" "))
        n             (- 1 (count nums))
        pair-diff     #(- (first %) (second %))
        pair-abs-diff #(Math/abs (pair-diff %))
        pairs         (map pair-abs-diff (partition 2 1 nums))]
    (if (= true (some #(> (pair-abs-diff %) 1)
                      (partition 2 1 pairs)))
      "Not jolly"
      "Jolly")))

(defn -main [& args]
  (def lines (split (slurp (first args)) #"\n"))
  (println (join "\n" (map process-line lines))))

(apply -main *command-line-args*)


(process-line "4 1 4 2 3")

(process-line "5 1 4 2 -1 6")

(process-line "6 1 5 2 3 6 9")

(process-line "3 6 8 7")


;; these are jolly
(process-line "1 4 2 3")

(process-line "1 2 4")

(process-line "4 2 1")

(process-line "104 102 101")

(process-line "-5 -7 -6")

; not jolly
(process-line "1 4 2 -1 6")
