package models;

import java.math.BigDecimal;

public class ClientePessoaFisica extends Cliente{
    private String cpf;
//    private BigDecimal desconto = BigDecimal.ZERO;

    public ClientePessoaFisica(String nome, String cpf) {
        super(nome,new BigDecimal(10), 5);
    }

    public ClientePessoaFisica(String nome, String cpf, BigDecimal desconto, Integer diariaMin) {
        super(nome,desconto, diariaMin);
        }

    public String getCpf() {
        return cpf;
    }
      
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }  
}

