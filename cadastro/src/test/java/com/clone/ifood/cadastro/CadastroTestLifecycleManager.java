package com.clone.ifood.cadastro;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.HashMap;
import java.util.Map;

public class CadastroTestLifecycleManager implements QuarkusTestResourceLifecycleManager {
    public static final PostgreSQLContainer<?> POSTGRE = new PostgreSQLContainer<>("postgres:12.2");

    @Override
    public Map<String, String> start() {
        POSTGRE.start();
        Map<String, String> propriedades = new HashMap<String, String>();

        // Banco de dados
        propriedades.put("quarkus.datasource.jdbc.url", POSTGRE.getJdbcUrl());
        propriedades.put("quarkus.datasource.username", POSTGRE.getUsername());
        propriedades.put("quarkus.datasource.password", POSTGRE.getPassword());
        return propriedades;
    }

    @Override
    public void stop() {
        if (POSTGRE != null && POSTGRE.isRunning()) POSTGRE.stop();
    }
}
