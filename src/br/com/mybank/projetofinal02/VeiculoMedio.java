package models;

import java.math.BigDecimal;

public class VeiculoMedio extends Veiculo{
    
    public VeiculoMedio(String tipo){
        super("medio", new BigDecimal(150));
    }
    public VeiculoMedio(String tipo, BigDecimal diariaAluguel){
        super("medio", new BigDecimal(150));
    }
}


