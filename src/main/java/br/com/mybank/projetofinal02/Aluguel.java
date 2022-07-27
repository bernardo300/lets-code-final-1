package br.com.mybank.projetofinal02;

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
        cliente.getTaxaDesconto(diarias);
        System.out.println("Taxa de desconto: " + cliente.getTaxaDesconto(diarias));
        veiculo.getDiariaAluguel();
        System.out.println("Valor da diria do aluguel: " + veiculo.getDiariaAluguel());
        System.out.println("diarias: " + diarias);

        valorTotal = new BigDecimal(this.diarias).multiply(veiculo.getDiariaAluguel()).multiply
          (new BigDecimal(1).subtract(cliente.getTaxaDesconto(diarias)));
        System.out.println("Total do aluguel a ser pago: " + valorTotal);
    }
}
