;; # Email Validation
;; 
;; ## Description:
;; You are given several strings that may/may not be valid emails.
;; You should write a regular expression that determines if the email
;; id is a valid email id or not. You may assume all characters are
;; from the english language.
;; 
;; ## Input sample:
;; Your program should accept as its first argument a filename.
;; This file will contain several text strings, one per line.
;; Ignore all empty lines. eg.
;; 
;;      foo@bar.com
;;      this is not an email id
;;      admin#codeeval.com
;;      good123@bad.com
;;
;; ## Output sample:
;; Print out 'true' (all lowercase) if the string is a valid email.
;; Else print out 'false' (all lowercase) .e.g.
;; 
;;      true
;;      false
;;      false
;;      true

(use '[clojure.string :only (join split trim)])

(defn re-email? [str]
  (if (re-matches #"\b([\w-\.]+)@((?:[\w]+\.)+)([a-zA-Z]{2,4})\b" str) true false))

(defn process-line [line]
  (if (= line "") nil (re-email? line)))

(defn -main [& args]
  (def lines (split (slurp (first args)) #"\n"))
  (println (join "\n" (remove nil? (map process-line lines)))))

(apply -main *command-line-args*)


;; Testing
(process-line "foo@bar.com")
(process-line "this is not an email id")
(process-line "admin#codeeval.com")
(process-line "good123@bad.com")



; \b[A-Z0-9._%+-]+@(?:[A-Z0-9-]+\.)+[A-Z]{2,4}\b

(re-matches #"([\w-\.]+)@((?:[\w]+\.)+)([a-zA-Z]{2,4})\b" "f3oo@bar.com")

(re-matches #"^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,6}$" "foo@bar.com")

(re-email? "foo@bar.com")

(re-email? "this is not an email id")

(re-email? "admin#codeeval.com")

(re-email? "good123@bad.com")

(re-email? "john@aol...com")
