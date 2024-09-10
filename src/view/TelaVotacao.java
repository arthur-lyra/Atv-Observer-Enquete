package view;

import controller.TelaVotacaoCtrl;
import model.EnqueteSimples;

import javax.swing.*;
import java.awt.*;

public class TelaVotacao extends JFrame {
    public TelaVotacao(EnqueteSimples enquete, TelaVotacaoCtrl controller) {
        setTitle("Votação de Filme");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));

        for (String opcao : enquete.getOpcoes()) {
            JButton btn = new JButton(opcao);
            btn.addActionListener(controller);
            add(btn);
        }
    }
}
