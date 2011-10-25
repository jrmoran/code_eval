;; # Sum of integers
;; 
;; ## Description:
;; Write a program to determine the largest sum of contiguous integers in a list.
;; 
;; ## Input sample:
;; The first argument will be a text file containing a comma separated list
;; of integers, one per line. e.g. 
;; 
;;      -10, 2, 3, -2, 0, 5, -15
;;      2,3,-2,-1,10
;;
;; ## Output sample:
;; Print to stdout, the largest sum. In other words, of all the possible
;; contiguous subarrays for a given array, find the one with the largest
;; sum, and print that sum.
;; 
;;      8
;;      12

(use '[clojure.string :only (join split trim)])

(defn -main [& args]

  (def lines (split (slurp (first args)) #"\n"))

  (defn max_subseq-sum [s]
    (let [maxes {:so-far 0 :curr 0}
          f     (fn [maxes x]
                  (let [curr   (max 0 (+ (maxes :curr) x)) 
                        so-far (max (maxes :so-far) curr)]
                    { :curr curr  :so-far so-far}))]
  ((reduce f maxes s) :so-far)))

  (defn process-line [line]
    (let [nums (map #(Integer/parseInt (trim %)) (split line #",") )]
       (max_subseq-sum nums)))

  (println (join "\n" (map process-line lines))))

(apply -main *command-line-args*)


;; # Kadane's algorithm
;; This is also known as the maximum subarray problem
;;
;;      def max_subarray(A):
;;          max_so_far = max_ending_here = 0
;;          for x in A:
;;              max_ending_here = max(0, max_ending_here + x)
;;              max_so_far = max(max_so_far, max_ending_here)
;;          return max_so_far

(defn max_subseq-sum [s]
  (let [maxes {:so-far 0 :curr 0}
        f     (fn [maxes x]
                (let [curr   (max 0 (+ (maxes :curr) x)) 
                      so-far (max (maxes :so-far) curr)]
                  { :curr curr  :so-far so-far}))]
    ((reduce f maxes s) :so-far)))

(max_subseq-sum [-10 2 3 -2 0 5 -15])   ;; 8
(max_subseq-sum [2 3 -2 -1 10])         ;; 12
