package br.com.tech4me.tech4music.view.controller;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import br.com.tech4me.tech4music.model.Musica;
import br.com.tech4me.tech4music.service.MusicaService;

import br.com.tech4me.tech4music.shared.MusicaDto;
import br.com.tech4me.tech4music.view.model.MusicaRequest;
import br.com.tech4me.tech4music.view.model.MusicaResponse;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/musicas")
public class MusicaController { // a personalização do programaé feita aqui no ontroller

    @Autowired
    private MusicaService servico;
    ModelMapper mapper = new ModelMapper();

    @GetMapping
    public ResponseEntity<List<MusicaResponse>> obterMusicas() {
        //return servico.obterMusicas();
        //return new ResponseEntity<>(body, Status); body é o corpo da emplementação, o antigo return. e o status vai ser oque eu quiser
       List<MusicaDto> dtos = servico.obterMusicas();
       List<MusicaResponse> response = dtos.stream()
       .map(d -> mapper.map(d, MusicaResponse.class))
       .collect(Collectors.toList());

       return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<MusicaResponse> criarMusica(@RequestBody @Valid MusicaRequest request){ 
        MusicaDto musicaDto = mapper.map(request, MusicaDto.class);
        musicaDto = servico.criarMusica(musicaDto);
        MusicaResponse response = mapper.map(musicaDto, MusicaResponse.class);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @GetMapping(value= "/{Id}")
    public ResponseEntity<MusicaResponse> obterPorId(@PathVariable String id){ //@PathVariable, variavel que varia kkk
        Optional<MusicaDto> music = servico.obterPorId(id);
        
        if(music.isPresent()){
           
            MusicaResponse response = mapper.map(music.get(), MusicaResponse.class);
            return new ResponseEntity<>(response, HttpStatus.FOUND);
            
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    
    @PutMapping(value = "/{Id}")
    public ResponseEntity<MusicaResponse> alterarMusica( @PathVariable String id, @RequestBody @Valid MusicaRequest request){
        MusicaDto musicaDto = mapper.map(request, MusicaDto.class);
        musicaDto = servico.atualizarMusica(id, musicaDto);
        MusicaResponse response = mapper.map(musicaDto, MusicaResponse.class);
        
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @DeleteMapping(value= "/{Id}") // valor parametrizado, o @pathVariable indica o que é que vai ser o value, o"/{id} é só uma explicação para o programador.
    public ResponseEntity<String> removerMusica(@PathVariable String id){ //não precisa por o body pq vc ja mandda deletar na url 
        servico.removerMusica(id);
        return new ResponseEntity<String>("Removido com sucesso!", HttpStatus.OK);

    }


    
}
