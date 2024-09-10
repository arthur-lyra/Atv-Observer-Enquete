package util;

public interface EnqueteListener {
    void novoVoto(EnqueteEvent event);
    void novaOpcao(EnqueteEvent event);
}
