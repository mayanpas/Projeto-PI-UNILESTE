package projetoHUB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoHubApplication {

     static void main(String[] args) {
        SpringApplication.run(ProjetoHubApplication.class, args);
        System.out.println("🚀 Aplicação iniciada!");
        System.out.println("📍 Acesse: http://localhost:8080");
        System.out.println("📍 Demo completo: http://localhost:8080/demo");
    }
}