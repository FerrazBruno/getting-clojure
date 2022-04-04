(ns getting-clojure.core
  (:gen-class))

;; CHAPTER 1
;; Hello, Clojure

(println "Hello, world!")

(str "Clo" "jure")
(str "Hello," " " "world" "!")
(str 3 " " 2 " " 1 " Blast off!")

(count "Hello, world")
(count "Hello")
(count "")

(println true)
(println false)

(println "Nobody's home:" nil)

(println "We can print many things:" true false nil)

;; Arithmetic
(* 16 124)
(- 2000 16)
(/ 25792 13)

(/ (+ 1984 2010) 2)

(- 2000 10 4 2)

(/ (+ 1984.0 2010.0) 2.0)

;; Not Variable Assignment, but Close
(def first-name "Russ")

(def the-average (/ (+ 20 40.0) 2.0))

;; A Function of Your Own
(defn hello-world [] (println "Hello, world!"))
(hello-world)

(defn hellor-world []
  (println "Hello, world!"))

(defn say-welcome [what]
  (println "Welcome to" what))
(say-welcome "Clojure")

(defn average [a b]
  (/ (+ a b) 2.0))
(average 5.0 10.0)

(defn chatty-average [a b]
  (println "chatty-aberage called")
  (println "** first argument:" a)
  (println "** second argument:" b)
  (/ (+ a b) 2.0))
(chatty-average 10 20)

;; Staying Out of Trouble
;; (/ 100 0) Execution error (ArithmeticException)
;; (+ (* 2 2) 10)) RuntimeException Unmatched delimiter: )


;; CHAPTER 2
;; Vectors and Lists


