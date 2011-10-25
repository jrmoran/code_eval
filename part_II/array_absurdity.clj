;; ## Array Absurdity
;; 
;; ## Description:
;; Imagine we have an immutable array of size N which we know to be filled
;; with integers ranging from 0 to N-2, inclusive.
;;
;; Suppose we know that the array contains exactly one duplicated entry and
;; that duplicate appears exactly twice. Find the duplicated entry.
;; (For bonus points, ensure your solution has constant space and time
;; proportional to N)
;; 
;; ## Input sample:
;; Your program should accept as its first argument a path to a filename.
;; Each line in this file is one test case. Ignore all empty lines.
;; Each line begins with a positive integer(N) i.e. the size of the array,
;; then a semicolon followed by a comma separated list of positive numbers 
;; ranging from 0 to N-2, inclusive. i.e eg.
;; 
;;      5;0,1,2,3,0
;;      20;0,1,10,3,2,4,5,7,6,8,11,9,15,12,13,4,16,18,17,14
;; 
;; ## Output sample:
;; Print out the duplicated entry, each one on a new line eg
;; 
;;      0
;;      4
(use '[clojure.string :only (join split trim)])

(defn find-duplicated [xs nums]
  "Evaluates the items of an array and returns the duplicated item.
   first parameter must be a set and the second any sequential type"
  (let [x (first nums)]
    (if (or (nil? x) (contains? xs x))
      x
      (recur (conj xs (first nums)) (rest nums)))))


(defn process-line [line]
  (if (= line "")
    nil
    (let [[n nums] (split (trim line) #";")
          nums (map #(Integer/parseInt %) (split nums #","))]
      (find-duplicated #{} nums))))

(defn -main [& args]
  (def lines (split (slurp (first args)) #"\n"))
  (println (join "\n" (remove nil? (map process-line lines)))))

(apply -main *command-line-args*)




;; testing
; (process-line "20;0,1,10,3,2,4,5,7,6,8,11,9,15,12,13,4,16,18,17,14")

; (process-line "5;0,1,2,3,0")

; (find-duplicated #{} [20 0 0 1 10 3])
;


; (def lines [ "5;0,1,2,3,0"
;              "20;0,1,10,3,2,4,5,7,6,8,11,9,15,12,13,4,16,18,17,14"])

; (println (join "\n" (map process-line lines)))
