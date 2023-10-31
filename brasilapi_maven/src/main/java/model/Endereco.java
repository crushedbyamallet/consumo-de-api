package model;

import com.google.gson.annotations.SerializedName;

public class Endereco {
    private String cep;
    
    @SerializedName("estado")
    private String uf;
    
    @SerializedName("city")
    private String cidade;
    
    @SerializedName("neighborhood")
    private String bairro;
    
    @SerializedName("street")
    private String logradouro;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    @Override
    public String toString() {
        return "Endereco [CEP=" + cep + ", UF=" + uf + ", Cidade=" + cidade + ", Bairro=" + bairro + ", Logradouro=" + logradouro + "]";
    }
}
