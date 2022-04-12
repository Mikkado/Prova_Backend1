package br.com.tech4me.tech4music.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("musicas")//indica que este documento esta representando um documento de uma collection
public class Musica{
    @Id
    private String id;
    private String titulo;
    private String álbum;
    private String genero;
    private int anoLancamento;
    private String compositor;

    //getteres e setteres

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
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