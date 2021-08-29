EXTENSIONS = quarkus-smallrye-metrics, quarkus-smallrye-opentracing

.PHONY: cadastro

cadastro:
	cd cadastro && mvnw.cmd quarkus:add-extension -Dextensions="$(EXTENSIONS)"

all: .PHONY