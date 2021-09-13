EXTENSIONS_CADASTRO = quarkus-smallrye-metrics, quarkus-smallrye-opentracing, flyway
EXTENSIONS_MARKETPLACE = quarkus-resteasy-mutiny, resteasy-reactive,jdbc-postgres, flyway, reactive-pg-client, quarkus-hibernate-reactive-panache

.PHONY: help cadastro marketplace

all: .PHONY

help:
	echo Inserindo extensao

cadastro:
	cd cadastro && mvnw.cmd quarkus:add-extension -Dextensions="$(EXTENSIONS_CADASTRO)"

marketplace:
	cd marketingplace && mvnw.cmd quarkus:add-extension -Dextensions="$(EXTENSIONS_MARKETPLACE)"