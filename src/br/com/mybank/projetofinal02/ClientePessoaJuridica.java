package models;

import java.math.BigDecimal;

public class ClientePessoaJuridica extends Cliente{
    private String Cnpj;
     
    public ClientePessoaJuridica(String nome) {
        super(nome,new BigDecimal(0.10), 3);
    }

    public ClientePessoaJuridica(String nome, BigDecimal desconto, Integer diariaMin) {
        super(nome,desconto, diariaMin);
        }

    
    public String getCnpj() {
        return Cnpj;
    }
          
    public void setCnpj(String Cnpj) {
        this.Cnpj = Cnpj;
    }  

}    
