package models;

import java.math.BigDecimal;

public class VeiculoSuv extends Veiculo{

    public VeiculoSuv(String tipo, BigDecimal diaria) {
        super("SUV", new BigDecimal(200));
    }
}
