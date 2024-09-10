import controller.TelaVotacaoCtrl;
import model.EnqueteSimples;
import view.TelaResultado;
import view.TelaResultadoPercentual;
import view.TelaVotacao;

public class Main {
    public static void main(String[] args) {

        EnqueteSimples enquete = new EnqueteSimples();
        enquete.addOpcao("Avatar");
        enquete.addOpcao("Vingadores: Guerra Infinita");
        enquete.addOpcao("Star Wars: The Clone Wars");
        enquete.addOpcao("Planeta dos Macacos");
        enquete.addOpcao("Mad Max");

        TelaResultado telaResultado = new TelaResultado();
        TelaResultadoPercentual telaPercentual = new TelaResultadoPercentual();
        TelaVotacaoCtrl controller = new TelaVotacaoCtrl(enquete);
        
        enquete.addEnqueteListener(telaResultado);
        enquete.addEnqueteListener(telaPercentual);

        TelaVotacao telaVotacao = new TelaVotacao(enquete, controller);

        // Posiciona as telas em diferentes coordenadas
        telaResultado.setLocation(500, 100); // Posição da tela de resultados
        telaPercentual.setLocation(1000, 100); // Posição da tela de resultados percentuais
        telaVotacao.setLocation(750, 400); // Posição da tela de votação

        telaResultado.setVisible(true);
        telaPercentual.setVisible(true);
        telaVotacao.setVisible(true);
    }
}
