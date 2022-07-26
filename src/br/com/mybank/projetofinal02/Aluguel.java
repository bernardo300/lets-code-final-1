package models;

import java.math.BigDecimal;

public class Aluguel {
    BigDecimal valorTotal = BigDecimal.ZERO;
    Integer diarias;
    Cliente cli;
    Veiculo veic;
   
    public Aluguel (Cliente cliente, Veiculo veiculo, Integer diarias){
       cli = cliente;
       veic = veiculo;
       this.diarias = diarias;
    }

    public void calculaAluguel(Cliente cliente, Veiculo veiculo, Integer diarias){
        cli = cliente;
        veic = veiculo;
        this.diarias = diarias;

        cli.getDesconto(diarias);
        System.out.println("desconto: " + cli.getDesconto(diarias));
        veic.getDiariaAluguel();
        System.out.println("diariaaluguel: " + veic.getDiariaAluguel());
        valorTotal = new BigDecimal(this.diarias).multiply(veic.getDiariaAluguel()).multiply
            (new BigDecimal(1).subtract(cli.getDesconto(diarias)));
        System.out.println("total do aluguel: " + valorTotal);
    }
}
