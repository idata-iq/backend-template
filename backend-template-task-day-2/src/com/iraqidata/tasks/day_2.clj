(ns com.iraqidata.tasks.day-2
  (:require
   [clojure.string :as str]
   [tablecloth.api :as tc]
   tech.v3.datatype.casting))

(def ds (tc/dataset "./resources/data/flights.csv"
                    {:key-fn #(keyword (str/replace (name %) "_" "-"))}))

;; 1. How many flights were there in total?

(-> ds (tc/row-count))

;; 2. How many unique carriers were there in total?

(-> ds (tc/unique-by :carrier)
    (tc/row-count))


;; 3. How many unique airports were there in total?


(tc/row-count (set (concat (:dest ds)
                    (:origin ds))))

;; 4. What is the average arrival delay for each month?

(-> ds (tc/group-by :month) (tc/mean :arr-delay))

;a double check
(-> ds (tc/select-rows (fn [row] 
                         (= (:month row) 11)) )
    (tc/mean :arr-delay))

;; Optional: Use the `airlines` dataset to get the name of the carrier with the
;; highest average distance.

(def airlines
  (tc/dataset "./resources/data/airlines.csv"
              {:key-fn keyword}))


(-> airlines
    (tc/inner-join ds {:left :carrier :right :carrier}) 
    (tc/group-by [:carrier])                                 
     (tc/mean :distance)
    (tc/rename-columns [:airlines :average-distance])
    (tc/order-by :average-distance :desc)                 
    (tc/first))                  




