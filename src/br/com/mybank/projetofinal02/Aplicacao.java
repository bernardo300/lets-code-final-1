package models;

public class Aplicacao {
    public static void main(String[] args) {
        
        Cliente cliente = new ClientePessoaJuridica("teste");
        Veiculo veiculo = new VeiculoSuv();

        Aluguel aluga = new Aluguel(cliente, veiculo, 2);
        aluga.calculaAluguel();
    }
    
}
