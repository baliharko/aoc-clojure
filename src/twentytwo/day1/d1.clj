(ns twentytwo.day1.d1
  (:require [clojure.string :as str]))

(def input (slurp "resources/twentytwo/day1/input.txt"))

(defn elf-cals-sum [items]
  (->> items
       (str/split-lines)
       (map (fn [n]
              (-> n
                  (Integer/parseInt))))
       (#(reduce + %))))

(defn most-cals [input]
  (let [elves (str/split input #"\n\n")]
    (->> elves
         (map elf-cals-sum)
         (sort)
         (last))))

(most-cals input)

;Part 2

(defn top-three-cals [input]
  (let [elves (str/split input #"\n\n")]
    (->> elves
         (map elf-cals-sum)
         (sort)
         (take-last 3)
         (reduce +))))

(top-three-cals input)