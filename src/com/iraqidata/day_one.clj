(ns com.iraqidata.day-one)

;; Issues:
;; 1. The branch was not checked out from the correct branch.
;; 2. Too many files were committed at once. (1501 files changed, 1641 insertions(+)).

;;1
;; (defn pr [arg]
;;   arg)
;; (pr 4)

(defn my-pr [arg]
  arg )
;; Kindly check the warning provided by VSCode for the naming of the function,
;; `pr` is a built in function.

(my-pr 4)

;; Incorrect, the function returns `4` rather than `nil` and does not print any
;; value.

;;---------------------------------------------------

;;2
(defn add [a b]
  (if (odd? b)
    (+ a b)
    :error))
(add 1 2)

;; Correct, one full point.

;;----------------------------------------------------

;;3

;;first_try:
;; (defn my_map {
;;               :name "ali"
;;               :born 2001
;;               :year 2024
;;               :age (- year born)
;; })

;;---------5th try
(def my-map
  {:name "ali"
   :born 2001
   :year 2024
   :age (let [born 2020
              year 2024]
          (- year born))})
(:age my-map)

;; The tasks specified a function to be made rather than a map.

;; Incorrect.

;;------------------------------------------------------
;;4

(if (>= (:age my-map) 18) true false)

;; Same as 3, the tasks specified a function to be made rather than an call.

;; Total: 1 point.
