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

;; In the Wild
;; Wrapping Up


;; CHAPTER 2
;; Vectors and Lists

;; One Thing after Another
[1 2 3 4]
[1 "two" 3 "four"]
[true 3 "four" 5]
[1 [true 3 "four" 5] 6]
[0 [1 [true 3 "four" 5] 6] 7]

;; A Toolkit of Functions
(vector true 3 "four" 5)
(vector)
(def novels ["Emma" "Coma" "War and Peace"])
(count novels)
(first novels)
(rest novels)
(rest (rest novels))
(rest ["Ready Player One"])
(rest [])
(def year-book ["1491" "April 1865" "1984" "2001"])
(def third-book (first (rest (rest year-book))))
third-book
(nth year-book 2)
(year-book 2)

;; Growing Your Vectors
(conj novels "Carrie")
(cons "Carrie" novels)

;; Lists
'(1 2 3)
()
'(1 2 3 "four" 5 "six")
'(1 2.0 2.999 "four" 5.001 "six")
'([1 2 ("a" "list" "inside a" "vector")] "inside" "a" "list")
(list 1 2 3 "four" 5 "six")
(def poems '("Iliad" "Odyssey" "Now We Are Six"))
(count poems)
(first poems)
(rest poems)
(nth poems 2)

;; Lists versus Vectors
(conj poems "Jabberwocky")
(def vector-poems ["Iliad" "Odyssey" "Now We Are Six"])
(conj vector-poems "Jabberwocky")

;; Staying Out Of Trouble
(def novels ["Emma" "Coma" "War and Peace"])
(conj novels "Jaws")
(def more-novels (conj novels "Jaws"))
(def novels '("Emma" "Coma" "War and Peace"))
(conj novels "Jaws")

;; In the Wild
;; Wrapping Up


;; CHAPTER 3
;; Maps, Keywords, and Sets
;; This Goes with That

{"title" "Oliver Twist" "author" "Dickens" "published" 1838}
(hash-map "title"     "Oliver Twist"
          "author"    "Dickens"
          "published" 1838)
(def book {"title"     "Oliver Twist"
           "author"    "Dickens"
           "published" 1838})
(get book "published")
(book "published")
(book "title")
(book "author")
(book "copyright")

;; Keywords
:title
:author
:published
:world-count
:preface&introduction
:chapter-1-and-2
(def book {:title     "Oliver Twist"
           :author    "Dickens"
           :published 1838})
(println "Title:"     (book :title))
(println "By:"        (book :author))
(println "Published:" (book :published))
(:title book)

;; Changing Your Map Without Changing It
(assoc book :page-count 362)
(assoc book :page-count 362 :title "War & Peace")
(dissoc book :published)
(dissoc book :title :author :published)
(dissoc book :paperback :illustrator :favorite-zoo-animal)
(assoc [:title :by :published] 1 :author)
(assoc [:title :by :published] 2 :page-count)

;; Other Hand Map Functions
(keys book)
(sorted-map :title     "Oliver Twist"
            :author    "Dickens"
            :published 1838)
(vals book)
{:title "Oliver Twist", :author "Dickens", :published 1838}

;; Sets
(def genres #{:sci-fi :romance :mystery})
(def authors #{"Dickens" "Austen" "King"})
;; #{"Dickens" "Austen" "Dickens"}
(contains? genres "Dickens")
(contains? authors "Dickens")
(authors "Austen")
(genres :historical)
(:sci-fi genres)
(:historical genres)
(def more-authors (conj authors "Clarke"))
(conj more-authors "Clarke")
(disj more-authors "King")

;; In The Wild
;; Staying Out Of Trouble
(book "Title")
(assoc book "Title" "Pride and Prejudice")
(book :some-key-that-is-clearly-not-here)
(def anonymous-book {:title "The Arabian Nights" :author nil})
(contains? anonymous-book :title)
(contains? anonymous-book :author)
(contains? anonymous-book :favorite-color)
(def possible-authors #{"Austen" "Dickens" nil})
(contains? possible-authors "Austen")
(contains? possible-authors "King")
(contains? possible-authors nil)
(first book)
(second book)
(count book)

;; Wrapping Up


;; CHAPTER 4
;; Logic

;; The Fundamental If
(defn print-greeting [preferred-customer]
  (if preferred-customer
    (println "Welcome back to Blotts Books!")
    (println "Welcome to Botts Books!")))
(print-greeting true)
(print-greeting false)
(defn shipping-charge [preferred-customer order-amount]
  (if preferred-customer
    0.00
    (* order-amount 0.10)))
(shipping-charge false 100)

;; Asking Question
(= 1 1)
(= 2 (+ 1 1))
(= "Anna Karenina" "Jane Eyre")
(= "Emma" "Emma")
(= (+ 2 2) 4 (/ 40 10) (* 2 2) (- 5 1))
(= 2 2 2 2 3 2 2 2 2 2)
(not= "Anna Karenina" "Jane Eyre")
(not= "Anna Karenina" "Anna Karenina")
(if (> 3 1)
  (println "3 is bigger than 1"))
(if (< 1 3)
  (println "1 is smaller than 3"))
(number? 1984)
(number? "Anna Karenina")
(string? "Anna Karenina")
(keyword? "Anna Karenina")
(map? :anna-karenina)
(map? {:title 1984})
(vector? 1984)
(vector? [1984])
(defn shipping-surcharge? [preferred-customer express oversized]
  (and (not preferred-customer) (or express oversized)))

;; Truthy and Falsy
(if 1
  "I like science fiction!"
  "I like mysteries!")
(if "hello"
  "I like science fiction!"
  "I like mysteries!")
(if [1 2 3]
  "I like science fiction!"
  "I like mysteries!")
(if false
  "I like scifi!"
  "I like mysteries!")
(if 0 "yes" "no")
(if 1 "yes" "no")
(if 1.0 "yes" "no")
(if :russ "yes" "no")
(if "Russ" "yes" "no")
(if "true" "yes" "no")
(if "false" "yes" "no")
(if "nil" "yes" "no")
(if []
  (println "An empty vector is true!"))
(if [1 2 3]
  (println "So is a populated vector!"))
(if {}
  (println "An empty map is true!"))
(if {:title "Make Room! Make Room!"}
  (println "So is a full map!"))
(if () 
  (println "An empty list is true!"))
(if '(:full :list)
  (println "So is a full list!"))

;; Do and When
(do
  (println "This is four expression.")
  (println "All grouped together as one")
  (println "That prints some stuff and then evaluates to 44")
  44)
(defn shipping-charge [preferred-customer order-amount]
  (if preferred-customer
    (do
      (println "Preferred customer, free shipping!")
      0.0)
    (do
      (println "Regular customer, charge them for shipping.")
      (* order-amount 0.10))))
(when true
  (println "Hello returning customer!")
  (println "Welcome back to Blotts Books!"))

;; Dealing with Multiple Conditions
(defn shipping-charge [preferred-customer order-amount]
  (if preferred-customer
    0.0
    (if (< order-amount 50.0)
      5.0
      (if (< order-amount 100.0)
        10.0
        (* 0.1 order-amount)))))
(defn shipping-charge [preferred-customer order-amount]
  (cond
    preferred-customer 0.0
    (< order-amount 50.0) 5.0
    (< order-amount 100.0) 10.0))
(defn shipping-charge [preferred-customer order-amount]
  (cond
    preferred-customer 0.0
    (< order-amount 50.0) 5.0
    (< order-amount 100.0) 10.0
    (>= order-amount 1000.) (* 0.1 order-amount)))
(defn shipping-charge [preferred-customer order-amount]
  (cond
    preferred-customer 0.0
    (< order-amount 50.0) 5.0
    (< order-amount 100.0) 10.0
    :else (* 0.1 order-amount)))
(defn customer-greeting [status]
  (case status
    :gold      "Welcome, welcome, welcome back!!!"
    :preferred "Welcome back!"
               "Welcome to Blotts Books"))
(customer-greeting :gold)
(customer-greeting :preferred)
(customer-greeting :another-thing)

;; Throwing and Catching
;; (try
;;   (publish-book book)
;;   (catch ArithmeticException e (println "Math Problem"))
;;   (catch StackOverflowError e (println "Unable to publish...")))
(defn publish-book [book]
  (when (not (:title book))
    (throw
      (ex-info "A book needs a title!" {:book book}))))

;; In the Wild
;; Staying Out of Trouble
(and true 1984)
(and 2001 "Emma")
(and 2001 nil "Emma")
(if (= (number? 20) true)
  "ok")

;; Wrapping Up


;; CHAPTER 5
;; More Capable Functions
