;; # Remove Characters  Share on LinkedIn
;; 
;; ## Description:
;; Write a program to remove specific characters from a string.
;; 
;; ## Input sample:
;; The first argument will be a text file containing an input string followed
;; by a comma and then the characters that need to be scrubbed. e.g. 
;; 
;;      how are you, abc
;;      hello world, def
;;
;; ## Output sample:
;; Print to stdout, the scrubbed strings, one per line. Trim out any
;; leading/trailing whitespaces if they occur. e.g.
;; 
;;      how re you
;;      hllo worl

(use '[clojure.string :only (join split)])

(defn -main [& args]

  (def lines (split (slurp (first args)) #"\n"))

  (defn process-line [line]
    (let [[text ch] (split line #", ")
          ch (reduce conj #{} ch)]
      (apply str (remove #(contains? ch %) text))))


  (println (join "\n" (map process-line lines) )))

(apply -main *command-line-args*)
