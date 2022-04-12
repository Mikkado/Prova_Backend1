package br.com.tech4me.tech4music.view.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MusicaRequest {
   
    @NotBlank(message = "O titulo da música deve estar preenchido")
    @NotEmpty(message = "O título da música deve ser preenchido com caracteres válidos")
    @Size(min = 2, message = "O título da música deve ter no mínimo dois caractéres")
    private String titulo;
    
    @NotBlank(message = "O álbum da música deve estar preenchido")
    @NotEmpty(message = "O álbum da música deve ser preenchido com caracteres válidos")
    @Size(min = 2, message = "O álbum da música deve ter no mínimo dois caractéres")
    private String álbum;
   
    @NotBlank(message = "O gênero da música deve estar preenchido")
    @NotEmpty(message = "O gênero da música deve ser preenchido com caracteres válidos")
    @Size(min = 2, message = "O gênero da música deve ter no mínimo dois caractéres")
    private String genero;
    
    @NotBlank(message = "O ano de lançamento da música deve estar preenchido")
    @NotEmpty(message = "O ano de lançamento da música deve ser preenchido com caracteres válidos")
    @Size(min = 2, message = "O ano de lançamento da música deve ter no mínimo dois caractéres")
    private int anoLancamento;
    
    @NotBlank(message = "O compositor da música deve estar preenchido")
    @NotEmpty(message = "O compositor da música deve ser preenchido com caracteres válidos")
    @Size(min = 2, message = "O compositor da música deve ter no mínimo dois caractéres")
    private String compositor;

    //getteres e setteres

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getÁlbum() {
        return álbum;
    }

    public void setÁlbum(String álbum) {
        this.álbum = álbum;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getCompositor() {
        return compositor;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }
    

    

    
}
