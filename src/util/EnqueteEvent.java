package util;

import model.EnqueteSimples;

public class EnqueteEvent {
    private String opcao;
    private EnqueteSimples enquete;

    public EnqueteEvent(String opcao, EnqueteSimples enquete) {
        this.opcao = opcao;
        this.enquete = enquete;
    }

    public String getOpcao() {
        return opcao;
    }

    public int getVotos() {
        return enquete.getVotos(opcao);
    }

    public int getTotalVotos() {
        return enquete.getTotalVotos();
    }

    public EnqueteSimples getEnquete() {
        return enquete;
    }
}
