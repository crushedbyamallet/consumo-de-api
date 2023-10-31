package programm;

import java.io.IOException;
import javax.swing.JOptionPane;
import org.apache.http.client.ClientProtocolException;
import model.Endereco;
import service.CepService;

public class Teste {

    public static void main(String[] args) throws ClientProtocolException, IOException {
        CepService cepService = new CepService();

        try {
            String cep = JOptionPane.showInputDialog("Digite o CEP");

            Endereco endereco = cepService.getEndereco(cep);

            if (endereco != null) {
                String uf = endereco.getUf();
                String cidade = endereco.getCidade();
                String bairro = endereco.getBairro();
                String logradouro = endereco.getLogradouro();

                System.out.println(endereco + "\n");
                System.out.println("Cidade: " + (cidade != null ? cidade : "Parâmetro não disponível") + "\n");
                System.out.println("UF: " + (uf != null ? uf : "Parâmetro não disponível") + "\n");
                System.out.println("Bairro: " + (bairro != null ? bairro : "Parâmetro não disponível") + "\n");
                System.out.println("Logradouro: " + (logradouro != null ? logradouro : "Parâmetro não disponível") + "\n");
            } else {
                System.out.println("Endereço não encontrado.: " + cep);
            }

        } catch (NullPointerException e) {
            System.out.println("Erro: Endereço é nulo.");
        }
    }
}
