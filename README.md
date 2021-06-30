# udemy-quarkus-ifood
Curso da Udemy

## Commits baseados nas aulas

Dividos em conceitos para conforme o andamento das aulas

### Modulo 01 - Aula 03

``` bash
├── udemy-quarkus-ifood
├   ├── cadastro
├   ├── marketingplace
├   └── pedido
└── pom.xml
```
### Modulo 02 - Aula 01

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

### Modulo 02 - Aula 02

Criação do Docker Compose para provisionamento do recurso do banco para o módulo de __cadastro__

[docker-compose.yml](docker-compose.yml)

### Módulo 02 - Aula 03

Criação do CRUD em quarkus acessando um endpoint para acesso dentro do api de cadastro.

#TODO
