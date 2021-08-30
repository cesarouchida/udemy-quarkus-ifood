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

### Seção 02 - Aula 09

Refatoração do código (DTO) para documentação do Swagger com MapStruct

### Seção 02 - Aula 10

Uso do Hibernate Validator 

### Seção 02 - Aula 11

Melhorando as Validações, criando um package ___infra___ onde tem validações genericas para as mensagens.
Exemplo 

### Seção 02 - Aula 12

Inserindo dentro do [docker-compose.yml](docker-compose.yml) o keycloak e começando a configuração

- Criar Relm
- Criar Client

### Seção 02 - Aula 13

Finalizando as configuração do keycloak

- Configurar Login 
- Criar user - proprietario1
- Alterar Senha: senha123
- Criar role no realm: proprietario
- Vincular role ao cliente
- Entrar no client -> Mappers -> add built in, realm roles, mapear para groups


### Seção 02 - Aula 14

Inserindo acesso via JWT monitorado pelo keycloak. Dentro da classe __RestaurateResource__  

### Seção 02 - Aula 15

Gerando um token para os testes classe __TokenUtils__ pego no proprio exemplo do quarkus, pós implementação do keycloak .

Realizando os testes para os __RestaurateResource__ com o token valido 


### Seção 02 - Aula 16

Inserindo Jaeger dentro do __docker_compose.yml__ 


### Seção 02 - Aula 17

Inserindo o Opentraccing dentro do projeto, para os traccing de JDBC refletirem no Jaeger 

Obs.: Inserindo volume para keycloak

### Seção 02 - Aula 18

Inserindo prometheus e grafana no docker-compose.yml

Obs.: Alterando a networking para bridge no docker e inserindo host para docker prometheus 

[Config Prometheus](.local/prometheus/prometheus.yml)

````yml
static_configs:
  - targets: ['host.docker.internal:8080']
````

### Seção 02 - Aula 19

Adicionando Métricas para monitação dentro do [RestaurateResource](cadastro/src/main/java/com/clone/ifood/cadastro/RestauranteResource.java), e criando um dashboard para grafana.

### Seção 02 - Aula 20

Inserindo o Flyway para versionamento do banco de dados.

### Seção 03 - Aula 21
