;; # Cash Register
;; 
;; ## Description:
;; The goal of this challenge is to design a cash register program. 
;; You will be given two float numbers.
;;
;; * The first is the purchase price (PP) of the item.
;; * The second is the cash (CH) given by the customer.
;;
;; Your register currently has the following bills/coins within it:
;; 
;;        'PENNY': .01,
;;        'NICKEL': .05,
;;        'DIME': .10,
;;        'QUARTER': .25,
;;        'HALF DOLLAR': .50,
;;        'ONE': 1.00,
;;        'TWO': 2.00,
;;        'FIVE': 5.00,
;;        'TEN': 10.00,
;;        'TWENTY': 20.00,
;;        'FIFTY': 50.00,
;;        'ONE HUNDRED': 100.00
;;
;; The aim of the program is to calculate the change that has to be
;; returned to the customer.
;;
;; ## Input sample:
;; Your program should accept as its first argument a path to a filename.
;; The input file contains several lines. Each line is one test case.
;; Each line contains two numbers which are separated by a semicolon.
;; The first is the Purchase price (PP) and the second is the cash(CH)
;; given by the customer. eg.
;; 
;;        15.94;16.00
;;        17;16
;;        35;35
;;        45;50
;;
;; ## Output sample:
;; For each set of input produce a single line of output which is the
;; change to be returned to the customer. In case the CH < PP, print
;; out ERROR. If CH == PP, print out ZERO.
;;
;; For all other cases print the amount that needs to be returned,
;; in terms of the currency values provided. The output should be
;; alphabetically sorted. eg.
;; 
;;        NICKEL,PENNY
;;        ERROR
;;        ZERO
;;        FIVE

(use '[clojure.string :only (join split trim)])

(def curr-map { 0.01   "PENNY"
                0.05   "NICKEL"
                0.10   "DIME"
                0.25   "QUARTER"
                0.50   "HALF DOLLAR"
                1.00   "ONE"
                2.00   "TWO"
                5.00   "FIVE"
                10.00  "TEN"
                20.00  "TWENTY"
                50.00  "FIFTY"
                100.00 "ONE HUNDRED" })

(def currs (reverse (sort (keys curr-map))))

;; this rounds floats to 2 decimals, it's used by `collect` in order to
;; break down the change correctly, otherwise pennies can be missed.
(defn to2f [n] (* 0.01 (Math/round (* 100.0 n))))

;; * `currencies` is a list of currency denominations 
;; * `acc` is a map that will collect amount per denomination
(defn collect [acc currencies amount]
  "Recursive function that will break down the amount into currencies
  and return a map"
  (let [currency (first currencies)
        amount (to2f amount)]
    (if (nil? currency)
      acc
      (let [a>c? (if (>= amount currency) true false)]
        (recur (if a>c? 
                 (assoc-in acc [currency] (Math/floor (/ amount currency)))
                 acc)
               (rest currencies)
               (if a>c? (mod amount currency) amount))))))

(defn process-line [line]
  (let [[ch pp] (map #(Float/parseFloat %) (split line #";"))]
    (cond (< pp ch) "ERROR"
          (= pp ch) "ZERO"
          :else (let [ret (collect {} currs (- pp ch))]
                  (join "," (sort (map #(curr-map (key %))
                                          ret)))))))

(defn -main [& args]
  (def lines (split (slurp (first args)) #"\n"))
  (println (join "\n" (map process-line lines))))

(apply -main *command-line-args*)

;; testing lines
(process-line "15.94;16.00")

(process-line "17;16")

(process-line "35;35")

(process-line "45;50")

;; Testing `collect`
(def currs '(100.0 50.0 20.0 10.0 5.0 2.0 1.0 0.5 0.25 0.1 0.05 0.01))

(collect {} currs 35)

(collect {} currs 15)

(collect {} currs 11.09)

(collect {} currs 1.75)

(collect {} currs 25.8)

;; printing results
(join "," (sort (map #(curr-map (key %)) {0.01 4, 0.05 2, 1.0 1, 10.0 1})))

(join "," (sort (mapcat #(repeat (val %) (curr-map (key %)))
                  {0.01 4, 0.05 2, 1.0 1, 10.0 1})))

(join "," (sort (map #(curr-map (key %))
                     {0.05 1.0, 0.25 1.0, 0.5 1.0, 5.0 1.0, 20.0 1.0})))

; (defn to2f [n] (* 0.01 (Math/round (* 100 n))))


;; codeeval test cases

(process-line "15.94;16.00")    ; "NICKEL,PENNY"

(process-line "24;29")          ; "FIVE"

(process-line "30;15")          ; "ERROR"

(process-line "296;297")        ; "ONE"

(process-line "398.50;400.25")  ; "HALF DOLLAR,ONE,QUARTER"

;; got a weird bug here... When I evaluate collect with 25.8 I get the
;; right answer, but when I evaluate process line I'm missing one cent.
;;
;; Ok, after printing out the different values of amount it appears to
;; be a rounding problem, So I just implemented the to2f function I
;; wrote yesterday and now it passed the tests.
(process-line "63.55;89.35")    ; "FIVE,HALF DOLLAR,NICKEL,QUARTER,TWENTY"

(process-line "100;100")        ; "ZERO"
