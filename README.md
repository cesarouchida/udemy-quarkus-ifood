# udemy-quarkus-ifood
Curso da Udemy

## Commits baseados nas aulas

Dividos em conceitos para conforme o andamento das aulas

### Seção 01 - Aula 03

``` bash
├── udemy-quarkus-ifood
├   ├── cadastro
├   ├── marketingplace
├   └── pedido
└── pom.xml
```
### Seção 02 - Aula 04

Instalação das extensões do quarkus 

Code usage : 
```bash
$ mvn quarkus:add-extension -dextensions="$nome das extensões"
```
- quarkus-jdbc-postgresql
- quarkus-hibernate-orm-panache
- quarkus-resteasy-jsonb
- quarkus-hibernate-validator
- quarkus-smallrye-openapi

Uso do datasource dentro do [application.properties](cadastro/src/main/resources/application.properties)

### Seção 02 - Aula 05

Criação do Docker Compose para provisionamento do recurso do banco para o módulo de __cadastro__

[docker-compose.yml](docker-compose.yml)

### Seção 02 - Aula 06 e Aula 07

Aula 06 - Criação do CRUD em quarkus acessando um endpoint para acesso dentro do api de cadastro.

Aula 07 - Conferindo os Pratos criados para instalação 

### Seção 02 - Aula 08

Criando Classes de Test com Database Rider , TestContainer e Approval Test.