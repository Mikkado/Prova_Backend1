package br.com.tech4me.tech4music.service;

import java.util.List;
import java.util.Optional;


import br.com.tech4me.tech4music.shared.MusicaDto;

public interface MusicaService {
    MusicaDto criarMusica(MusicaDto musicasDto);
    List<MusicaDto> obterMusicas();
    Optional <MusicaDto> obterPorId(String id);
    MusicaDto atualizarMusica(String id, MusicaDto musicasDto); // onde vc quer alterar e o que vc quer alterar/ o arquivo que vc vai alterar e onde ele esta, onde ele é salvo
    void removerMusica(String id);
} //contem todos os metodos