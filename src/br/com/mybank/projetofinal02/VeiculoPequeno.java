package models;

import java.math.BigDecimal;

public class VeiculoPequeno extends Veiculo {

    public VeiculoPequeno(){
        super(new BigDecimal(100));
    }

    public VeiculoPequeno(BigDecimal diariaAluguel){
        super(diariaAluguel);
    }
}