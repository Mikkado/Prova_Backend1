package br.com.tech4me.tech4music.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.tech4music.model.Musica;

public interface MusicaRepository extends MongoRepository<Musica, String>  {// 1= classe do produto, 2- tipo do dado que identifica o produto (id)
    //o numero de classe tem que ser igual ao numero de o repository
    
}
// cria as funções create, delete...