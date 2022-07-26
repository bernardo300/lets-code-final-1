package models;

import java.math.BigDecimal;

public class Veiculo {
    String tipo;
    BigDecimal diariaAluguel = BigDecimal.ZERO;

    public Veiculo(String tipo, BigDecimal diariaAluguel) {
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public BigDecimal getDiariaAluguel() {
        return this.diariaAluguel;
    }
    public void setDiariaAluguel(BigDecimal diariaAluguel) {
        this.diariaAluguel = diariaAluguel;
    }
}
