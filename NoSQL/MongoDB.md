```
use('labBD')

db.pessoas.insertOne({
    "nome": "Edu Alves Aparecido 😋",
    "totalVendas": 10000.43,
    "sexo": "Feminino",
    "fumante": true,
    "calçado": 42,
    "endereço": {
        "logradouro": "Rua dos Andradas",
        "numero": 50,
        "bairo": "Centro",
        "cidade": "Itu",
        "uf": "SP"
    }
})

// Comando equivalente ao Select * from
db.pessoas.find()

// Exemplo de insert Many
db.pessoas.insertMany(
  [
    {
      "nome": "1.José Alves Aparecido 😋",
      "totalVendas": 1580.43,
      "sexo": "1.Masculino",
      "fumante": true,
      "calçado": 42,
      "endereço": {
          "logradouro": "1.Rua dos Andradas",
          "numero": 50,
          "bairo": "1.Centro",
          "cidade": "1.Itu",
          "uf": "1.SP"
      }
    }, {
      "nome": "2.José Alves Aparecido 😋",
      "totalVendas": 1580.43,
      "sexo": "2.Masculino",
      "fumante": false,
      "calçado": 42,
      "endereço": {
          "logradouro": "2.Rua dos Andradas",
          "numero": 50,
          "bairo": "2.Centro",
          "cidade": "2.Itu",
          "uf": "2.SP"
      }
    }
  ]
)

// listando os documentos
db.pessoas.find(
  {}, {
    nome:1,
    sexo:1,
    calçado:1,
    fumante:1,
    _id:0
  }
)

// listando apenas as colunas nome, sexo e calçados apenas dos fumantes
db.pessoas.find(
  {
    nome: {$eq: true}
  }, {
    nome:1,
    sexo:1,
    calçado:1,
    fumante:1,
    _id:0
  }
)

// Listando o nome, sexo, calçado das pessas que não calçam 40
db.pessoas.find(
  { 
    calçado: {$ne: 40}
  }, {
    nome:1,
    sexo:1,
    calçado:1,
    _id:0
  }
)

// Listando o nome, sexo e calçado das pessoas que o calçado é <= 42
db.pessoas.find(
  {
    calçado: {$lte: 42}
  }, {
    nome:1,
    sexo:1,
    calçado:1,
    "endereço.cidade":1,
    _id:0
  }
)

// Listando todas as pessoas do sexo MASCULINO **E** com calçadp >= 38
db.pessoas.find(
  {
    $and: [
      {calçado: {$gte: 38}},
      {sexo: {$eq: "Masculino"}}
    ]
  }, {}
)

// Liste o nome, cidade, estado e totalVendido de todas as pessoas com o totalVendas >= 9000 e que são do estado de SP

db.pessoas.find(
  {
    $and: [
      {totalVendas: {$gte: 9000}},
      {"endereço.uf": {$eq: "SP"}},
      {"endereço.cidade": {$eq: "Itu"}}
    ]
  }, {
    nome:1,
    cidade:1,
    "endereço.cidade":1,
    "endereço.uf":1,
    totalVendas:1,
    _id:0
  }
)

// Liste o nome, sexo e o calçado das pessoas que são do sexo Feminino OU calçado seja 36, 38, ou 40

db.pessoas.find({
  $or: [
    {calçado: {$in: [36, 38, 40]}},
    {sexo: /m/i}
  ]
}, {
  nome:1,
  sexo:1,
  calçado:1,
  _id:0
}).sort({
  nome:1, sexo:1
})

db.pessoas.find()

// DeleteOne
db.pessoas.deleteOne({
  _id: {$eq: ObjectId("6266a4e1dc2604b81f7e37ad")}
})

// DeleteMany
db.pessoas.deleteMany({
  sexo: {$eq: "2.Masculino"}
})

// pada DROPAR uma collection (evitar de usar!)
db.pessoas.drop()

db.dropDatabase()

```
