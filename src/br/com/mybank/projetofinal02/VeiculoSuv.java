package models;

import java.math.BigDecimal;

public class VeiculoSuv extends Veiculo{

    public VeiculoSuv() {
        super(new BigDecimal(200));
    }

    public VeiculoSuv(BigDecimal diariaAluguel) {
        super(diariaAluguel);
    }
}
