;; # First Non-Repeated Character
;; 
;; ## Description:
;; Write a program to find the first non repeated character in a string.
;; 
;; ## Input sample:
;; The first argument will be a text file containing strings. e.g. 
;; 
;;      yellow
;;      tooth
;;
;; ## Output sample:
;; Print to stdout, the first non repeating character, one per line.
;; 
;;      y
;;      h

(use '[clojure.string :only (join split trim)])

(defn first-nrc [str]
  (-> (filter #(= (val %) 1) (frequencies str)) first key ))

(defn process-line [line]
  (if (= line "") nil (first-nrc line)))

(defn -main [& args]
  (def lines (split (slurp (first args)) #"\n"))
  (println (join "\n" (remove nil? (map process-line lines)))))

(apply -main *command-line-args*)

; (first-nrc "yellow")
; (first-nrc "tooth")
; (first-nrc "toothsy")
