package models;

import java.math.BigDecimal;

public class Veiculo {
    String tipo;
    BigDecimal diaria = BigDecimal.ZERO;

    public Veiculo(String tipo, BigDecimal diaria) {
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public BigDecimal getDiaria() {
        return diaria;
    }
    public void setDiaria(BigDecimal diaria) {
        this.diaria = diaria;
    }
}
