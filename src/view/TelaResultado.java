package view;

import util.EnqueteEvent;
import util.EnqueteListener;

import javax.swing.*;
import java.awt.*;

public class TelaResultado extends JFrame implements EnqueteListener {
    private JTextArea resultados;

    public TelaResultado() {
        setTitle("Resultados Absolutos");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        resultados = new JTextArea();
        resultados.setEditable(false);
        add(new JScrollPane(resultados), BorderLayout.CENTER);
    }

    @Override
    public void novoVoto(EnqueteEvent event) {
        atualizarResultados(event);
    }

    @Override
    public void novaOpcao(EnqueteEvent event) {
        atualizarResultados(event);
    }

    private void atualizarResultados(EnqueteEvent event) {
        StringBuilder sb = new StringBuilder();
        for (String opcao : event.getEnquete().getOpcoes()) {
            sb.append(opcao)
              .append(": ")
              .append(event.getEnquete().getVotos(opcao))
              .append(" votos\n");
        }
        resultados.setText(sb.toString());
    }
}
