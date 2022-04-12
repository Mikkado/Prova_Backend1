package br.com.tech4me.tech4music.shared;

public class MusicaDto {
    private String titulo;
    private String álbum;
    private String genero;
    private int anoLancamento;
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
    public void setId(String id) {
    }

    
    
}
