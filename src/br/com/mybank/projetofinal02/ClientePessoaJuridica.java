package models;

import java.math.BigDecimal;

public class ClientePessoaJuridica extends Cliente{
    private String Cnpj;
//  private BigDecimal desconto = BigDecimal.ZERO;
     
    public ClientePessoaJuridica(String nome, String cpf) {
        super(nome,new BigDecimal(10), 5);
    }

    public ClientePessoaJuridica(String nome, String cpf, BigDecimal desconto, Integer diariaMin) {
        super(nome,desconto, diariaMin);
        }

    
    public String getCnpj() {
        return Cnpj;
    }
          
    public void setCnpj(String Cnpj) {
        this.Cnpj = Cnpj;
    }  

}    
