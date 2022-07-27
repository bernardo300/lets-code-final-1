package models;

import java.math.BigDecimal;

public class VeiculoMedio extends Veiculo{
    
    public VeiculoMedio(){
        super(new BigDecimal(150));
    }
    public VeiculoMedio(BigDecimal diariaAluguel){
        super(diariaAluguel);
    }
}


