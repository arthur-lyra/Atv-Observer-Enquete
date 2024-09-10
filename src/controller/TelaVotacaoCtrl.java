package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.EnqueteSimples;

public class TelaVotacaoCtrl implements ActionListener {
    private EnqueteSimples enquete;

    public TelaVotacaoCtrl(EnqueteSimples enquete) {
        this.enquete = enquete;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String opcao = event.getActionCommand();
        enquete.votar(opcao); 
    }
}
