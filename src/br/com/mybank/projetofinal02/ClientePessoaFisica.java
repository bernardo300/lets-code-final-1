package models;

import java.math.BigDecimal;

public class ClientePessoaFisica extends Cliente{
    String cpf;

    public ClientePessoaFisica(String nome) {
        super(nome,new BigDecimal(0.05), 5);
    }

    public ClientePessoaFisica(String nome, BigDecimal desconto, Integer diariaMin) {
        super(nome,desconto, diariaMin);
        }

    public String getCpf() {
        return cpf;
    }
      
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }  
}

