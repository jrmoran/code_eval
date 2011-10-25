;; # Mth to last element
;; 
;; ## Description:
;; Write a program to determine the Mth to last element of a list.
;;
;; ## Input sample:
;; The first argument will be a text file containing a series of space
;; delimited characters followed by an integer representing a index into
;; the list(1 based), one per line. e.g. 
;; 
;;      a b c d 4
;;      e f g h 2
;;
;; ## Output sample:
;; Print to stdout, the Mth element from the end of the list, one per line.
;; If the index is larger than the list size, ignore that input. 
;; 
;;      a
;;      g

(use '[clojure.string :only (join split trim)])

(defn process-line [line]
  (when (not= line "")
    (let [l (split line #" ")
          c (dec (count l))
          i (- c (Integer/parseInt (last l)))]
      (when (and (>= i 0) (< i c))
        (nth l i)))))

(defn -main [& args]
  (def lines (split (slurp (first args)) #"\n"))
  (println (join "\n" (remove nil? (map process-line lines)))))

(apply -main *command-line-args*)


(process-line "a b c d 4")   ; a

(process-line "e f g h 2")   ; g

(process-line "e f g h 5")   ; nil

