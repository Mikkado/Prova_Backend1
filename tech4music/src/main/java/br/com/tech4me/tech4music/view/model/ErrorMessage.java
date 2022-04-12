package br.com.tech4me.tech4music.view.model;

import java.util.List;

public class ErrorMessage {
    private List<String> erros;
    
    public List<String> getErros() {
        return erros;
    }
    public void setErros(List<String> erros) {
        this.erros = erros;
    }
    
    public ErrorMessage( List<String> erros) {
        this.erros = erros;
    }

    

    
}
