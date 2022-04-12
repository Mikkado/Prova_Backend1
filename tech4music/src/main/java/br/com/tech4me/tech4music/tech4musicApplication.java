package br.com.tech4me.tech4music;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.tech4me.tech4music.tech4musicApplication;

@SpringBootApplication
public class tech4musicApplication {

	public static void main(String[] args) {
		SpringApplication.run(tech4musicApplication.class, args);
		//vazio é diferente de nulo
		//Optional <String> opt = Optional.empty(); // é igual a vazio
		Optional <String> opt = Optional.of("Existe"); // String é o tipo de variavel que esta dentro do optional, opt é o nome do optinal, e of faz o optional receber a variavel "óla"
		System.out.println(opt.orElse("Não Existe"));//chama o metodo optional e se não estiver presente(tiver valor) ele retorna o valor Claro
		System.out.println(opt.get());
	}

}
