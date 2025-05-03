package projetoFinal.Projeto.Final;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"projetoFinal.Projeto.Final.model"})
public class ProjetoFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoFinalApplication.class, args);
	}

}
