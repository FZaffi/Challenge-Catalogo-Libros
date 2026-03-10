package com.alura.literalura;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test") // 1. Usa un perfil de configuración separado para pruebas
class LiteraluraApplicationTests {

    @Test
    @DisplayName("Verifica que el contexto de Spring carga correctamente")
    void contextLoads() {
        // 2. Una prueba vacía es válida, pero una aserción la hace explícita
        // Si llega aquí sin lanzar excepciones, el contexto cargó bien.
        assertThat(true).isTrue(); 
    }
}
