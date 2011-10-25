;; # Double Squares
;; 
;; ## Description:
;; 
;; *Credits: This challenge appeared in the Facebook Hacker Cup 2011.*
;; 
;; A double-square number is an integer X which can be expressed as the sum of
;; two perfect squares. For example, 10 is a double-square because
;; `10 = 3^2 + 1^2`. 
;;
;; Your task in this problem is, given X, determine the number of ways in which
;; it can be written as the sum of two squares. For example, 10 can only be 
;; written as `3^2 + 1^2` (we don't count 1^2 + 3^2 as being different).
;;
;; On the other hand, 25 can be written as `5^2 + 0^2` or as `4^2 + 3^2`. 
;;
;; NOTE: Do NOT attempt a brute force approach. It will not work.
;; The following constraints hold: 
;; 
;;      0 <= X <= 2147483647
;;      1 <= N <= 100
;; 
;; ## Input sample:
;; You should first read an integer N, the number of test cases.
;; The next N lines will contain N values of X.
;; 
;;      5
;;      10
;;      25
;;      3
;;      0
;;      1
;; 
;; ## Output sample:
;; 
;;      1
;;      2
;;      0
;;      1
;;      1

;; Sol
;;
;; A double square number is equal to the sum of squares
;;
;;      c = a^2 + b^2
;;
;; since the value of `c` is known, we can solve by `a`
;;
;;      a = (c - b^2)^0.5

;; we get the maximum square root
(-> 10  Math/sqrt Math/ceil)    ; 4

;; and evaluate each integer `b` from 0 to 4 and obtain `a`. we only consider
;; integers to be valid pairs.
(Math/sqrt (- 10 (* 0 0)))           ; 3.16
(Math/sqrt (- 10 (* 1 1)))           ; 3
(Math/sqrt (- 10 (* 2 2)))           ; 2.45
(Math/sqrt (- 10 (* 3 3)))           ; 1

;; we get 1,3 and 3,1, which is are considered the same pair so 
;; we avoid duplicates by testing only integers up to the half max square
(-> 10 (/ 2) Math/sqrt Math/ceil)    ; 3

(Math/sqrt (- 10 (* 0 0)))           ; 3.16
(Math/sqrt (- 10 (* 1 1)))           ; 3
(Math/sqrt (- 10 (* 2 2)))           ; 2.45

;; now we only get 1, 3

;; since we only want natural numbers we do the following
(mod 3.16 1)    ; 0.16
(mod 3.00 1)    ; 0

;; solution
(use '[clojure.string :only (join split trim)])

(defn dsqr [x]
  (when (and (>= x 0) (<= x 2147483647))
    (if (or (= x 0) (= x 1)) 1 
      (let [msqr (-> x (/ 2) Math/sqrt Math/ceil)]
        (count (filter #(= 0 (mod % 1))
                       (map #(Math/sqrt (- x (* % %)))
                            (range 0 msqr))))))))

(defn process-line [line]
  (when (not= line "") 
    (let [x (Integer/parseInt line)]
      (dsqr x))))
    
(defn -main [& args]
  (def lines (rest (split (slurp (first args)) #"\n")))
  (println (join "\n" (remove nil? (map process-line lines)))))

(apply -main *command-line-args*)




;; Other stuff

(-> 1328649093 (/ 2) Math/sqrt Math/ceil)

(dsqr 1328649093)


;; 13 is giving me trouble.
(dsqr 13)

(-> 13 (/ 2) Math/sqrt Math/ceil)

(Math/sqrt (- 13 (* 0 0)))           ; 3.61

(Math/sqrt (- 13 (* 1 1)))           ; 3.46

(Math/sqrt (- 13 (* 2 2)))           ; 3

(map #(Math/sqrt (- 13 (* % %))) (range 0 3))

;; Tests
;; 0
;; 1
;; 1
;; 1
;; 4
;; 0
;; 48
;; 4
;; 0
;; 4
;; 32
;; 0
;; 16
