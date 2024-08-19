(ns com.iraqidata.day-one)



;;1
(defn pr [arg]
  arg)
(pr 4)

;;---------------------------------------------------

;;2
(defn add [a b]
  (if (odd? b)
    (+ a b)
    :error))
(add 1 2)


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

;;------------------------------------------------------
;;4

(if (>= (:age my-map) 18) true false)

