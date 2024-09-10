package view;

import util.EnqueteEvent;
import util.EnqueteListener;

import javax.swing.*;
import java.awt.*;

public class TelaResultadoPercentual extends JFrame implements EnqueteListener {
    private JTextArea resultados;

    public TelaResultadoPercentual() {
        setTitle("Resultados Percentuais");
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
        int totalVotos = event.getEnquete().getTotalVotos();
        for (String opcao : event.getEnquete().getOpcoes()) {
            int votos = event.getEnquete().getVotos(opcao);
            double percentual = totalVotos > 0 ? (votos * 100.0 / totalVotos) : 0;
            sb.append(opcao)
              .append(": ")
              .append(String.format("%.2f", percentual))
              .append("%\n");
        }
        resultados.setText(sb.toString());
    }
}
