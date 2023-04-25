(ns intro.intro)

(defn aplica-desconto?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor for estritamente maior que 100."
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let
     [taxa-de-desconto (/ 10 100)
      desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(valor-descontado aplica-desconto? 100)

(valor-descontado #(> %1 100) 1000)

(valor-descontado #(> % 100) 1000)

(def mais-caro-que-100? #(> % 100))

(println (valor-descontado mais-caro-que-100? 100))

(def precos [30 700 1000])

(println (precos 0))
(println (get precos 17 0))
(println (conj precos 5))
(println (inc 5))
(update precos 0 inc)

(def resultado (map valor-descontado precos))

resultado

(range 10)

(filter even? (range 10))

(map valor-descontado (filter aplica-desconto? precos))

(reduce + precos)

(defn soma
  [valor-1 valor-2]
  (+ valor-1 valor-2))

(reduce soma precos)

(def estoque 
  {
   "Mochila" 10,
   "Camiseta" 5
  })

estoque

(count estoque)

(keys estoque)

(vals estoque)

(def estoque 
  {
   :mochila 10,
   :camiseta 5
  })

(assoc estoque :cadeira 3)

(update estoque :mochila inc)

(update estoque :mochila #(- % 3))

(dissoc estoque :mochila)

(def pedido{:mochila {:quantidade 2, :preco 80}
            :camiseta {:quantidade 3, :preco 40}})

(def pedido (assoc pedido :chaveiro {:quantidade 1, :preco 10}))

(pedido :mochila)
(get pedido :mochila)
(get pedido :cadeira {})

(:mochila pedido)

(:quantidade (:mochila pedido))

(update-in pedido [:mochila :quantidade] inc)

(-> pedido :mochila :quantidade)

(defn imprime [[chave valor]] (println chave "e" valor))

(map imprime pedido)

(defn preco-por-produto [[chave valor]]
  (* 
   (:quantidade valor) 
   (:preco valor)))

(reduce + (map preco-por-produto pedido))

(->> pedido
    (map preco-por-produto)
    (reduce +))

(defn preco-total-do-produto [produto]
  (* (:quantidade produto) (:preco produto)))

(defn total-do-pedido
  [pedido]
  (->> pedido
       vals
       (map preco-total-do-produto)
       (reduce +)))

(total-do-pedido pedido)