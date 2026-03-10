package com.alura.literalura;

import com.alura.literalura.principal.Principal;
import com.alura.literalura.repository.AutorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

    // 1. Usamos final para mayor seguridad e inmutabilidad
    private final AutorRepository repository;

    // 2. Inyección por constructor (Spring la detecta automáticamente)
    public LiteraluraApplication(AutorRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(LiteraluraApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // 3. Pasamos el repositorio a la clase lógica Principal
        Principal principal = new Principal(repository);
        principal.mostrarMenu();
    }
}