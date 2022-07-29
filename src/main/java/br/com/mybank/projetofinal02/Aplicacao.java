package br.com.mybank.projetofinal02;

public class Aplicacao {
    public static void main(String[] args) {
        
        Cliente cliente = new ClientePessoaJuridica("Bernardo");
        Veiculo veiculo = new VeiculoSuv();

        Aluguel aluga = new Aluguel(cliente, veiculo, 4);
        aluga.calculaAluguel();
    }
    
}
