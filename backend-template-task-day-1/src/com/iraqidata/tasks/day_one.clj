(ns com.iraqidata.tasks.day-one
  (:require [clj-time.core :as time]
            [clj-time.local :as local]))


;; 1. Write a function that takes one argument as input and prints that
;; argument.
(defn print-Arg [argument]
  (println argument))
;; example
(print-Arg "hello friend")


;; 2. Write a function that adds `1` to a number only if the input is odd,
(defn ureEven [v]
  (if (odd? v)
    (+ v 1)
    :error))
;;example
(ureEven 3)
(ureEven 2)

;; 3. Write a function that takes 3 arguments, `name`, `year-of-birth`, and
;; `current-year`. and returns a map with the following keys: `name`, `age`.
(defn infoo [name yearOB current-year]
  (let [age (- current-year yearOB)]
  {:name name :age age}))
;;example
(infoo "Abdullah Muslim" 2000 2024)


;; 4. Write a function that takes the output of the above function and returns
;; `true` if the person is allowed to vote (assume the voting age is 18).
(defn Ability-to-vote [x]
   (>= (:age x) 18)
    )
;;example 
(Ability-to-vote (infoo "Abdullah Muslim" 2000 2024))


;; OPTIONAL FOR BONUS POINTS

;; 5. Modify the function from number 3 to not need the `current-year`.




(defn mod-infoo [name yearOB]
  (let [current-year (time/year (local/local-now))
  age (- current-year yearOB)]
  {:name name :age age}))

;;example
(mod-infoo "abdullah" 2002)

