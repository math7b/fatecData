## 09-05-2022

```
use('LabBd')
db.categorias.insertMany([
  {"nome":"kg", "descricao":"Comida por kg"},
  {"nome":"Luxo", "descricao":"Restaurantes de Luxo"},
  {"nome":"Parmegiana", "descricao":"Possuem File a Parmegiana"},
  {"nome":"Churrasco", "descricao":"Possuem churrasco"},
])

use('LabBd')
db.restaurantes.insertOne({
  "nome": "Bar do Alemão",
  "inauguracao": new Date("1970-08-14"),
  "categorias": ["Parmegiana", "Luxo"]}
)

use('LabBd')
db.restaurantes.insertOne({
  "nome": "Restaurante dos Meninos",
  "inauguracao": new Date("2016-05-01"),
  "categorias": ["kg", "Parmegiana", "Churrasco"]}
)

use("LabBd")
db.categorias.find()

use("LabBd")
db.restaurantes.find()

use("LabBd")
db.restaurantes.aggregate([{
  $lookup: {
      from: "categorias",
      localField: "categorias",
      foreignField: "nome",
      as: "detalhe_categoria"
  }
},{
  $project: {
    _id: 0,
    nome: 1,
    inauguracao: 1,
    "detalhe_categoria.descricao": 1
  }
}])
```
