;; # Pangrams
;;
;; ##Description:
;; The sentence 'A quick brown fox jumps over the lazy dog' contains every
;; single letter in the alphabet. Such sentences are called pangrams.
;; You are to write a program, which takes a sentence, and returns all 
;; the letters it is missing (which prevent it from being a pangram). 
;; You should ignore the case of the letters in sentence, and your return
;; should be all lower case letters, in alphabetical order. 
;;
;; You should also ignore all non US-ASCII characters.In case the input
;; sentence is already a pangram, print out the string NULL
;;
;; ## Input sample:
;; Your program should accept as its first argument a filename. 
;; This file will contain several text strings, one per line. 
;; Ignore all empty lines. eg.
;; 
;;        A quick brown fox jumps over the lazy dog
;;        A slow yellow fox crawls under the proactive dog
;;
;; ## Output sample:
;; Print out all the letters each string is missing in lowercase,
;; alphabetical order .e.g.
;; 
;;        NULL
;;        bjkmqz
;;
(use '[clojure.string :only (join split trim)])

(def alphabet (sorted-set \a \b \c \d \e \f \g \h \i \j \k \l \m
                          \n \o \p \q \r \s \t \u \v \w \x \y \z ))

(defn missing-letters [alphabet text]
  ;; evaluates the alphabet (or any set of letters) against
  ;; each character in a string and returns any missing letters.
  (if (empty? text)
    alphabet
    (recur (disj alphabet (first text)) (rest text))))

(defn process-line [line]
  (let [ret (missing-letters alphabet (.toLowerCase line))]
    (if (empty? ret) "NULL" (apply str ret))))

(defn -main [& args]
  (def lines (split (slurp (first args)) #"\n"))
  (println (join "\n" (map process-line lines))))

(apply -main *command-line-args*)



(missing-letters alphabet "A quick brown fox jumps over the lazy dog")
(missing-letters alphabet "A slow yellow fox crawls under the proactive dog")
(missing-letters alphabet "A Eslow yllow fox crawls undr th proactiv dog")


