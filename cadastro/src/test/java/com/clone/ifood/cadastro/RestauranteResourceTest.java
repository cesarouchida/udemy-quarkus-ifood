package com.clone.ifood.cadastro;

import com.clone.ifood.cadastro.dto.AdicionarRestauranteDTO;
import com.clone.ifood.cadastro.dto.AtualizarRestauranteDTO;
import com.clone.ifood.cadastro.util.TokenUtils;
import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.configuration.Orthography;
import com.github.database.rider.core.api.dataset.DataSet;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static javax.ws.rs.core.Response.Status;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DBRider
@DBUnit(caseInsensitiveStrategy = Orthography.LOWERCASE)
@QuarkusTest
@QuarkusTestResource(CadastroTestLifecycleManager.class)
class RestauranteResourceTest {

    private String token;

    // Gerando token para os Testes
    @BeforeEach
    public void gereToken() throws Exception {
        token = TokenUtils.generateTokenString("/JWTProprietarioClaims.json", null );
    }

    // Uso padrão para given Informando o contentType
    // Implementação do token para os testes
    private RequestSpecification given(){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .header(new Header("Authorization", "Bearer " + token));
    }

    @Test
    @DataSet("restaurantes-cenario-1.yml")
    void buscarRestaurantes(){
        var resultado = given()
            .when().get("/restaurantes")
            .then()
            .statusCode(Status.OK.getStatusCode())
            .extract().asString();
        Approvals.verifyJson(resultado);
    }

    @Test
    void inseriRestaurante(){
        AdicionarRestauranteDTO dto = new AdicionarRestauranteDTO();
        dto.cnpj = "43.843.541/0001-94";
        dto.nomeFantasia = "Potato";
        dto.proprietario = "Joao";

        given()
            .body(dto)
            .when().post("/restaurantes")
            .then()
            .statusCode(Status.CREATED.getStatusCode());

        Restaurante findById = Restaurante.findById(1L);
//        System.out.println(Restaurante.findAll().stream().count());


        assertEquals(dto.nomeFantasia, findById.nome);
    }

    @Test
    @DataSet("restaurantes-cenario-1.yml")
    void atualizaRestaurante(){
        AtualizarRestauranteDTO dto = new AtualizarRestauranteDTO();
        dto.nomeFantasia = "Potato";
        Long idRestaurante = 123L;
        given()
                .with().pathParam("id", idRestaurante)
                .body(dto)
                .when().put("/restaurantes/{id}")
                .then()
                .statusCode(Status.NO_CONTENT.getStatusCode());

        Restaurante findById = Restaurante.findById(idRestaurante);

        assertEquals(dto.nomeFantasia, findById.nome);
    }

    @Test
    @DataSet("restaurantes-cenario-1.yml")
    void deleteRestaurante(){
        Long idRestaurante = 123L;

        given()
                .with().pathParam("id", idRestaurante)
                .when().delete("/restaurantes/{id}")
                .then()
                .statusCode(Status.NO_CONTENT.getStatusCode());

        assertEquals(Restaurante.count(), 1);
    }


}


