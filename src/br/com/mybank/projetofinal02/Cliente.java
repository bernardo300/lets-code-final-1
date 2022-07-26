package models;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Cliente {
    private String nome;
    private BigDecimal desconto = BigDecimal.ZERO; 
    private Integer diariasMin;
     
    public Cliente(String nome, BigDecimal desconto, Integer diariasMin){
        this.nome = nome;
        this.desconto = desconto;
        this.diariasMin = diariasMin;
    }

    public BigDecimal getDesconto(Integer diarias) {
        if(diarias > diariasMin) {
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
