package models;

import java.math.BigDecimal;

public class VeiculoPequeno extends Veiculo {

    public VeiculoPequeno(String tipo, BigDecimal diariaAluguel){
        super("pequeno", new BigDecimal(100));
    }
}
