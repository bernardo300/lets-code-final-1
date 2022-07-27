package br.com.mybank.projetofinal02;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Cliente {
    private String nome;
    private BigDecimal desconto = BigDecimal.ZERO; 
    private Integer diariasMinimasParaDesconto;
     
    public Cliente(String nome, BigDecimal desconto, Integer diariasMinimasParaDesconto){
        this.nome = nome;
        this.desconto = desconto;
        this.diariasMinimasParaDesconto = diariasMinimasParaDesconto;
    }

    public BigDecimal getDesconto(Integer diarias) {
        if(diarias > diariasMinimasParaDesconto) {
            return desconto.setScale(2, RoundingMode.DOWN);
        }
        return BigDecimal.ZERO;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }         

    public String getNome() {
        return nome;
    }
      
    public void setNome(String nome) {
        this.nome = nome;
    }
      
    @Override
        public String toString() {
        return this.nome;
    }
}
