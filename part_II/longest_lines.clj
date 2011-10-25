;; # Longest Lines
;;
;; ## Description:
;; Write a program to read a multiple line text file and write the 'N'
;; longest lines to stdout. Where the file to be read is specified on
;; the command line.
;;
;; ## Input sample:
;; Your program should read an input file (the first argument to your program).
;; The first line contains the value of the number 'N' followed by multiple lines.
;; You may assume that the input file is formatted correctly and the number on the
;; first line i.e. 'N' is a valid positive integer.e.g.
;;
;;      2
;;      Hello World
;;
;;      CodeEval
;;      Quick Fox
;;      A
;;      San Francisco
;;
;; ## Output sample:
;; The 'N' longest lines, newline delimited. Do NOT print out empty lines.
;; Ignore all empty lines in the input. Ensure that there are no trailing empty
;; spaces on each line you print.
;;
;; Also ensure that the lines are printed out in decreasing order of length
;; i.e. the output should be sorted based on their length e.g.
;;
;;      San Francisco
;;      Hello World

(use '[clojure.string :only (join split)])

(defn -main [& args]

  ;(def lines (split "2\nHello World\n\nCodeEval\nQuick Fox\nA\nSan Francisco" #"\n"))

  (def lines (split (slurp (first args)) #"\n"))

  (defn process-lines [lines]
    (let [n     (-> lines first Integer/parseInt)
          lines (rest lines)]
      (take n (reverse (sort (group-by count lines))))))

  (println (join "\n" (mapcat val (process-lines lines)))))

(apply -main *command-line-args*)




