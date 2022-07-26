package models;

public class Aplicacao {
    public static void main(String[] args) {
        
        Cliente cliente = new ClientePessoaFisica("teste");
        Veiculo veiculo = new VeiculoMedio("medio");

        Aluguel aluga = new Aluguel(cliente, veiculo, 8);
        aluga.calculaAluguel(cliente, veiculo, 8);
    }
    
}
