## 09/05/2022
<h3>
  <a href="https://github.com/math7b/fatecData/blob/main/MongoDB/homeWork/restaurante/data.md">
    Data's link
  </a>
</h3>

```
use('db_restaurantes')
db.restaurantes.insertMany(
  data
)
```
```
// 1. Defina a query NoSQL para exibir todos os documentos da collectionrestaurantes.
use('db_restaurantes')
db.restaurantes.find()
```
```
// 2. Defina a query NoSQL para exibir os campos restaurante_id, nome,bairro e cozinha de todos os documentos da collection restaurantes.
use('db_restaurantes')
db.restaurantes.find({},{
  "restaurante_id": 1,
  "nome": 1,
  "bairro": 1,
  "cozinha": 1
})
```
```
// 3. Defina a query NoSQL para exibir os campos restaurante_id, nome,bairro e cozinha, porém, excluindo o campo _id de todos os documentosda collection restaurantes.
use('db_restaurantes')
db.restaurantes.find({},{
  "restaurante_id": 1,
  "nome": 1,
  "bairro": 1,
  "cozinha": 1,
  "_id": 0
})
```
```
// 4. Defina a query NoSQL para exibir os campos restaurante_id, nome,bairro ecep, porém, excluindo o campo _id de todosos documentos dacollection restaurantes.
use('db_restaurantes')
db.restaurantes.find({},{
  "restaurante_id": 1,
  "nome": 1,
  "bairro": 1,
  "endereço.cep": 1,
  "_id": 0
})
```
```
// 5. Defina a query NoSQL para exibir todos os restaurantes que estãolocalizados no bairro Bronx.
use('db_restaurantes')
db.restaurantes.find({
  "bairro": "Bronx"
},{})
db.restaurantes.find({
  "bairro": {$eq: "Bronx"}
},{})
```
```
// 6. Defina a query NoSQL para exibir os 5 primeiros restaurantes que estão localizados no bairro Bronx.
use('db_restaurantes')
db.restaurantes.find({
  "bairro": "Bronx"
},{}).limit(5)
```
```
// 7. Defina a query NoSQL para exibir os próximos 5 restaurantes após“pular” os 5 primeiros que estão localizados no bairro Bronx.
use('db_restaurantes')
db.restaurantes.find({
  "bairro": "Bronx"
},{}).skip(5).limit(5)
```
```
// 8. Defina a query NoSQL para exibir todos os restaurantes que obtiveramuma avaliação maior que 90 pontos.
use('db_restaurantes')
db.restaurantes.find({
  "avaliações": {
    $elemMatch: {"pontos": {$gt: 90}}
  }
},{
  "nome": 1,
  "_id": 0
})
```
```
// 9. Defina a query NoSQL para exibir todos os restaurantes que obtiveramuma avaliação maior que 80 e menor que 100.
use('db_restaurantes')
db.restaurantes.find({
  "avaliações": {
    $elemMatch: {"pontos": {$gt: 80, $lt: 100}}
  }
},{
  "nome": 1,
  "_id": 0
})
```
```
// 10. Defina a query NoSQL para exibir todos os restaurantes que estãolocalizados em uma latitude menor que  -95.754168.
use('db_restaurantes')
db.restaurantes.find({
  "endereço.coord.0": {$lt: -95.754168}
},{
  "nome": 1,
  "endereço.coord": 1,
  "_id": 0
})
```
```
// 11. Defina a query NoSQL para exibir todos os restaurantes que não sãoda cozinha 'American', que tenham pelo menos 70 pontos de avaliação eque a latitude seja menor que  -65.754168. (utilize o operador $and)
use('db_restaurantes')
db.restaurantes.find({
  $and: [
    {"cozinha": {$ne: "American"}},
    {"avaliações.pontos": {$gte: 70}},
    {"endereço.coord.0": {$lt: -65.754168}}
  ]
},{
  "nome": 1,
  "cozinha": 1,
  "avaliações.pontos": 1,
  "endereço.coord": 1
})
```
```
// 12. Defina a query NoSQL para exibir todos os restaurantes que não sãoda cozinha 'American', que tenham pelo menos 70 pontos de avaliação eque a latitude seja menor que  -65.754168. (Não utilize o operador $andpara esta query)
use('db_restaurantes')
db.restaurantes.find({
  "cozinha": {$ne: "American "},
  "avaliações.pontos": {$gte: 70},
  "endereço.coord.0": {$lt: -65.754168}
},{
  "nome": 1,
  "cozinha": 1,
  "avaliações.pontos": 1,
  "endereço.coord": 1
})
```
```
// 13. Defina a query NoSQL para exibir todos os restaurantes que não sãoda cozinha 'American', e obtiveram uma nota 'A' na avaliação e que nãopertencem ao bairro Brooklyn. Exibir a consulta ordenada por cozinha emordem descendente.
use('db_restaurantes')
db.restaurantes.find({
  $and: [
    {"cozinha": {$ne: "American "}},
    {"avaliações.nota": {$eq: "A"}},
    {"bairro": {$ne: "Brooklyn"}}
  ]
},{
  "nome": 1,
  "cozinha": 1,
  "bairro": 1,
  "_id": 0
}).sort({
  "cozinha": -1
})
```
```
// 14. Defina a query NoSQL para exibir o Id, nome, bairro e cozinha dos restaurantes cujo nome comecem com o texto Wil. Dica: /^ /
use('db_restaurantes')
db.restaurantes.find({
  "nome": /^Wil/
},{
  "nome": 1,
  "cozinha": 1,
  "bairro": 1,
})
```
```
// 15. Defina a query NoSQL para exibir o Id, nome, bairro e cozinha dos restaurantes cujo nome terminem com o texto ces. Dica : / $/
use('db_restaurantes')
db.restaurantes.find({
  "nome": /ces$/
},{
  "nome": 1,
  "cozinha": 1,
  "bairro": 1,
})
```
```
// 16. Defina a query NoSQL para exibir o Id, nome, bairro e cozinha dos restaurantes cujo nome contém o texto 'Reg' em alguma parte do nome.Dica : / /
use('db_restaurantes')
db.restaurantes.find({
  "nome": /Reg/i
},{
  "nome": 1,
  "cozinha": 1,
  "bairro": 1,
})
```
```
// 17. Defina a query NoSQL para exibir os restaurantes que estão no bairroBronx e preparam a cozinha American ou Chinese. (utilize o operador $or)
use('db_restaurantes')
db.restaurantes.find({
  "bairro":"Bronx",
  $or: [
    {"cozinha":"American "},
    {"cozinha":"Chinese"}
  ]
},{
  "nome": 1,
  "cozinha": 1,
  "_id": 0
})
```
```
// 18. Defina a query NoSQL para exibir o Id, nome, bairro e cozinha detodos os restaurantes que estão em um dos seguintes bairros: StatenIsland, Queens, Bronx ou Brooklyn.  (utilize o operador $in)
use('db_restaurantes')
db.restaurantes.find({
  "bairro": {
    $in: [
      "Staten Island",
      "Queens",
      "Bronx",
      "Brooklyn"
    ]
  }
},{
  "nome": 1,
  "bairro": 1,
  "cozinha": 1
})
```
```
// 19. Defina a query NoSQL para exibir o Id, nome, bairro e cozinha detodos os restaurantes que não estão em um dos seguintes bairros: StatenIsland, Queens, Bronx ou Brooklyn. (utilize o operador $nin)
use('db_restaurantes')
db.restaurantes.find({
  "bairro": {
    $nin: [
      "Staten Island",
      "Queens",
      "Bronx",
      "Brooklyn"
    ]
  }
},{
  "nome": 1,
  "bairro": 1,
  "cozinha": 1
})
```
```
// 20. Defina a query NoSQL para exibir o Id, nome, bairro e cozinha detodos os restaurantes que não conseguiram obter pontos na avaliaçãomaior que 10.
use('db_restaurantes')
db.restaurantes.find({
  "avaliações.pontos": {$not: {$gt: 10}}
},{
  "nome": 1,
  "bairro": 1,
  "cozinha": 1,
  "avaliações.pontos": 1
})
```
