;; # Endianness
;; 
;; ## Description:
;; Write a program to print out the endianness of the system.
;; 
;; ## Input sample:
;; None
;; 
;; ## Output sample:
;; Print to stdout, the endianness, wheather it is LittleEndian or BigEndian.
;; 
;;      BigEndian
;; 
(defn -main [& args]
  (let [endianness (System/getProperty "sun.cpu.endian")]
    (println (if (= endianness "little")
               "LittleEndian"
               "BigEndian"))))

(apply -main *command-line-args*)
