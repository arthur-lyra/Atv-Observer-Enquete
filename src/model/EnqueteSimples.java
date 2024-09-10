package model;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import util.EnqueteEvent;
import util.EnqueteListener;

public class EnqueteSimples {
    // HashMap que armazena as opções e seus respectivos votos
    private HashMap<String, Integer> votos = new HashMap<>();

    private List<EnqueteListener> listeners = new ArrayList<>();

    public List<String> getOpcoes() {
        return new ArrayList<>(votos.keySet());
    }

    public int getTotalVotos() {
        int total = 0;
        for (int v : votos.values()) {
            total += v;
        }
        return total;
    }

    public int getVotos(String opcao) {
        return votos.getOrDefault(opcao, 0);
    }

    public void addEnqueteListener(EnqueteListener listener) {
        listeners.add(listener);
    }

    public void addOpcao(String opcao) {
        if (!votos.containsKey(opcao)) {
            votos.put(opcao, 0);
            this.dispararNovaOpcao(opcao);
        } else {
            System.out.println("Opção já existe!");
        }
    }
    
    public void dispararNovoVoto(String opcao) {
        for (EnqueteListener listener : listeners){
            
            EnqueteEvent event = new EnqueteEvent(opcao, this);
            listener.novoVoto(event); 
        }
    }

    public void dispararNovaOpcao(String opcao) {
        for (EnqueteListener listener : listeners) {
            EnqueteEvent event = new EnqueteEvent(opcao, this);
            listener.novaOpcao(event);
        }
    }

    public void votar(String opcao){
        if (votos.containsKey(opcao)) {
            votos.put(opcao, votos.get(opcao) + 1);
            this.dispararNovoVoto(opcao); 
        } else {
            System.out.println("Opção inválida");
        }
    }

}
