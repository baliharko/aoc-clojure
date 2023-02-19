(ns twentyone.day3.d3p1
  (:require [clojure.string :as str]))

(def input (slurp "resources/twentyone/day3/example.txt"))

(defn char->num [c]
  (- (int c) (int \0)))

(def rows (count (str/split-lines input)))
(def bits-per-row (count (get (str/split-lines input) 0)))

(defn bits-by-column [input col]
  (->> input
       (str/split-lines)
       (mapv (fn [line]
               (-> line
                   (get col)
                   (char->num))))))

(defn flip-input [input]
      (for [i (range bits-per-row)]
           (bits-by-column input i)))

(defn most-common-bit [input]
  (if (> input (/ rows 2)) 1 0))

(defn least-common-bit [input]
  (if (< input (/ rows 2)) 1 0))

(defn gamma [input]
    (->> (into-array (flip-input input))
      (map (fn [line] (reduce + line)))
      (map most-common-bit)
      (apply str)))

(defn epsilon [input]
  (->> (into-array (flip-input input))
     (map (fn [line] (reduce + line)))
     (map least-common-bit)
     (apply str)))

(*
  (Integer/parseInt (gamma input) 2)
  (Integer/parseInt (epsilon input) 2))





