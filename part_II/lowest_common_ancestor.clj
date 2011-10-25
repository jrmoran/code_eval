;; # Lowest Common Ancestor  Share on LinkedIn
;; 
;; ## Description:
;; Write a program to determine the lowest common ancestor of two nodes in
;; a binary search tree. You may hardcode the following binary search tree
;; in your program:
;; 
;;          30
;;          |
;;        ____
;;        |   |
;;        8   52
;;        |
;;      ____
;;      |   |
;;      3  20
;;          |
;;         ____
;;        |   |
;;        10 29
;;
;; ## Input sample:
;; The first argument will be a text file containing 2 values that represent
;; two nodes within the tree, one per line. e.g. 
;; 
;;      8 52
;;      3 29
;;
;; ## Output sample:
;; Print to stdout, the least common ancestor, one per line.
;; 
;;      30
;;      8

; tree-node has a key, left and right leaf
(defstruct tree-node :k :l :r)

(defn bst-insert [bst x]
  ; if the tree-node is empty just add a key
  (if (nil? bst)
    (struct tree-node x)
    (let [k (:k bst)]
      ; otherwise compare the current value to be inserted with the key
      ; and decide whether add it to the left or to the right
      (if (= x k)
        bst
        (if (< x k)
          (struct tree-node k (bst-insert (:l bst) x) (:r bst))
          (struct tree-node k (:l bst) (bst-insert (:r bst) x)))))))


(defn lca [bst low high]
  (cond (and (not (< (bst :k) low)) (not (< high (bst :k)))) (bst :k)
        (< (bst :k) low) (lca (bst :r) low high)
        :else (lca (bst :l) low high)))

(use '[clojure.string :only (join split)])

(defn -main [& args]

  (def lines (split (slurp (first args)) #"\n"))

  ;; initializing binary tree
  (def tree (let [adder (fn [acc x] (bst-insert acc x))]
              (reduce adder nil [30 8 52 3 20 10 29])))

  (defn process-line [line]
    (let [[low high] (map #(Integer/parseInt %) (split line #" "))]
      (lca tree low high)))

  (println (join "\n" (map process-line lines))))

(apply -main *command-line-args*)




