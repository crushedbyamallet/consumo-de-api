package service;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import com.google.gson.Gson;
import model.Endereco;

public class CepService {

    public Endereco getEndereco(String cep) throws ClientProtocolException, IOException {
        Endereco endereco = null;

        String url = "https://brasilapi.com.br/api/cep/v1/" + cep;
        HttpGet request = new HttpGet(url);

        try (CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
             CloseableHttpResponse response = httpClient.execute(request)) {

            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString(entity);
                    System.out.println("Informações resgatadas: " + result);
                    Gson gson = new Gson();
                    endereco = gson.fromJson(result, Endereco.class);
                }
            } else {
                System.out.println("Erro na requisição: " + response.getStatusLine().getStatusCode());
            }
        }
                                                                      
        return endereco;
    }
}
