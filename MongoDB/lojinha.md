## 16/05/2022
```
// Collection auxiliares
// Tags
use('lojinha')
db.tags.insertMany([
  {descricao: 'gamer'},
  {descricao: 'geek'}
])

// Categorias
use('lojinha')
db.tags.find()

use('lojinha')
db.categorias.insertMany([
  {descricao: 'hardware'},
  {descricao: 'papelaria'}
])

use('lojinha')
db.categorias.find()

// Documentos Principais
use('lojinha')
db.produtos.insertMany([{
  nome: 'Notbook Dell A51',
  codigoBarras: '01234567890123',
  preco: 4850.00,
  categorias: '62826a50e500fb0d88a58efc',
  tags: [
    {tag: '62826987710389b98eb61ccf'},
    {tag: '62826987710389b98eb61cd0'}
  ]
}])

use('lojinha')
db.produtos.find()
```
