package br.com.tech4me.tech4music.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.tech4music.model.Musica;
import br.com.tech4me.tech4music.repository.MusicaRepository;
import br.com.tech4me.tech4music.shared.MusicaDto;


@Service
public class MusicaServiceImpl implements MusicaService{
    @Autowired
    //armazena essa variavel no contexto da aplicação
    private MusicaRepository repositorio; //esta conversando com o repositorio / diz olá para o repositorio
    ModelMapper mapper = new ModelMapper();
    
    @Override
    public MusicaDto criarMusica(MusicaDto musicasDto) {

        Musica musicas = mapper.map(musicasDto, Musica.class);
        musicas = repositorio.save(musicas);
        MusicaDto dto = mapper.map(musicas, MusicaDto.class);
        return dto;
        //conversa com o repositorio
        //corresponde ao insertOne do MongoDB
        //db.musicas.insertOne({"codigo": 123, "})
       /// return repositorio.save(musicas); /*retorna a variavel musicas*/
    }

    @Override
    public List<MusicaDto> obterMusicas() {
        
        //return repositorio.findAll(); //retora uma lista de musicas/ igual o metodo find no mongo
        List<Musica> musicas = repositorio.findAll();
        List <MusicaDto> musicasDto = 
        musicas.stream()
        .map(m -> mapper.map(m, MusicaDto.class))
        .collect(Collectors.toList());

        return musicasDto;
    }

    @Override
    public Optional<MusicaDto> obterPorId(String id) {
        //return repositorio.findById(id);
        Optional <Musica> musica = repositorio.findById(id);
        if(musica.isPresent())
        {
            MusicaDto musicaDto = mapper.map(musica.get(), MusicaDto.class); //definir origem(instancia que queremos mapear) e destino(instancia do tipo de destino)
            return Optional.of(musicaDto);
        }
        return Optional.empty();
    }

    @Override
    public MusicaDto atualizarMusica(String id, MusicaDto musicasDto) {
        Musica musicas = mapper.map(musicasDto, Musica.class);
        musicasDto.setId(id);
        musicas = repositorio.save(musicas);;
        MusicaDto dto = mapper.map(musicas, MusicaDto.class);
        return dto;
      
      
        // musicas.setId(id); //faz incluir o id quando ele vai alterar o document, pq no corpo do produto tem q ter todos menos o id
       // return repositorio.save(musicas);
       //save
       //quando nao enviamos um id -- cria-se um registro
       //quando enviamos um id -- sobre escreve-se o registro
       //sem id ele tem comportamento de post, quando enviamos o id ai sim que ele tem comportamento de put
    }

    @Override
    public void removerMusica(String id) {
        repositorio.deleteById(id);
        
    }

   
   


    
}
