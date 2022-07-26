package models;

import java.math.BigDecimal;

public class Aluguel {
    BigDecimal valorTotal = BigDecimal.ZERO;
    Integer diarias;
    Cliente cliente;
    Veiculo veiculo;
   
    public Aluguel (Cliente cliente, Veiculo veiculo, Integer diarias){
       this.cliente = cliente;
       this.veiculo = veiculo;
       this.diarias = diarias;
    }

    public void calculaAluguel(){
        cliente.getDesconto(diarias);
        System.out.println("desconto: " + cliente.getDesconto(diarias));
        veiculo.getDiariaAluguel();
        System.out.println("diariaaluguel: " + veiculo.getDiariaAluguel());
        System.out.println("diarias: " + diarias);

        valorTotal = new BigDecimal(this.diarias).multiply(veiculo.getDiariaAluguel()).multiply
          (new BigDecimal(1).subtract(cliente.getDesconto(diarias)));
        System.out.println("total do aluguel: " + valorTotal);
    }
}
