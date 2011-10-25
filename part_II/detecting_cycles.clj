;; # Detecting Cycles
;;
;; ## Description:
;; Given a sequence, write a program to detect cycles within it.
;;
;; ## Input sample:
;; A file containing a sequence of numbers (space delimited).
;; The file can have multiple such lines. e.g
;; 
;;      2 0 6 3 1 6 3 1 6 3 1
;;
;; Ensure to account for numbers that have more than one digit eg. 12.
;; If there is no sequence, ignore that line.
;;
;; ## Output sample:
;; Print to stdout the first sequence you find in each line. Ensure that
;; there are no trailing empty spaces on each line you print. e.g.
;; 
;;      6 3 1

;; helper method to extract a range from a sequence
(defn extract-range [s start end]
  (drop start (take end s)))

;; This is based in Floyd's cycle-finding algorithm
;;
;; The first step is to find if there's a cycle, by finding if there's a
;; repetition. The return value is the initial position of the hare if
;; there's a cycle in the sequence.
(defn find-cycle [s]
  (let [c (dec (count s))]
    (loop [i 1]
      (let [tortoise (get s i)
            hare     (get s (* i 2))]
      (cond (= tortoise hare) i
            (nil? hare) nil
            :else (recur (inc i)))))))

(defn get-cycle [s]
  (let [hare-index (find-cycle s)]
    (if (nil? hare-index)
      nil
      (let [;; the second step is to find the initial position of the cycle
            initial-index (loop [i 0]
                            (let [tortoise (get s i)
                                  hare     (get s (+ hare-index i))]
                              (if (= tortoise hare) i (recur (inc i)))))
            ;; the third step is to find the length of the cycle
            tortoise      (get s initial-index)
            length        (loop [i 1]
                            (let [hare (get s (+ initial-index i))]
                              (if (= tortoise hare) i (recur (inc i)))))]
        ;; finally return the repeating sequence
        (extract-range s initial-index (+ initial-index length))))))

;; putting it together
(use '[clojure.string :only (join split)])
(defn -main [& args]
  (def lines (split (slurp (first args)) #"\n"))

  (defn process-line [line]
    (let [s (vec (map #(Integer/parseInt %) (split line #" ")))
          c (get-cycle s)]
      (if (nil? c)
        nil
        (join " " (get-cycle s)))))

  (println (join "\n" (remove nil? (map process-line lines)))))

(apply -main *command-line-args*)


(process-line "2 0 6 3 1 6 3 1 6 3 1" )



;; Other stuff
(get-cycle [2 0 6 3 1 6 3 1 6 3 1])

(get-cycle [1 2 3 4 2 3 4])

(get-cycle [1 5 7 8 12 5 7 8 12])

(get-cycle [1 2 3 4])

(find-cycle [ 2 0 6 3 1 6 3 1 6 3 1 ])

(find-cycle [ 1 2 3 4 2 3 4 ])

(find-cycle [ 1 5 7 8 12 5 7 8 12 ])

(find-cycle [ 1 2 3 4 ])

(extract-range (range 10) 2 (+ 2 3))

(def lines (split "1 2 3 4 2 3 4\n1 5 7 8 12 5 7 8 12\n1 2 3 4" #"\n") )
