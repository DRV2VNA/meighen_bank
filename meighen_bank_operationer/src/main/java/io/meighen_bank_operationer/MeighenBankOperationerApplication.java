package io.meighen_bank_operationer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@SpringBootApplication
@EnableSpringConfigured
public class MeighenBankOperationerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeighenBankOperationerApplication.class, args);
	}

}
