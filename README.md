# Documentação
## Projeto do módulo UP-JV-001
### Enunciado
Crie uma aplicação que simule uma app bancária. Os clientes podem ser pessoa física ou jurídica, sendo que para PJ existe a cobrança de uma taxa de 0.5% para cada saque ou transferência. Além do produto conta-corrente, os clientes PF podem abrir uma conta-poupança e conta-investimento. Clientes PJ não abrem poupança, mas seus rendimentos em conta-investimento rendem 2% a mais.

Crie as funcionalidades: abrir conta, sacar, depositar, transferência, investir e consultar saldo (poupança e corrente).

Use a classe "Aplicacao" para criar seu método "main" e demonstrar o funcionamento do seu código.

### Entrega
A entrega deverá ser feita fornecendo o link Github do projeto (link unico para o grupo).

<p style="color:red">Prazo: : 11/07</p>

### Avaliação
Serão avaliados os seguintes quesitos:

- Completude das funcionalidades
- Aplicação das regras de negócio
- Modelagem de domínio orientado a objetos
- Aplicação de encapsulamento, abstração e polimorfismo

## Descrição das classes
### Conta
A classe Conta é uma classe abstrata com os atributos:
- agencia -> do tipo String;
- numeroConta -> do tipo inteiro;
- contas que começam com "10" são pessoas jurídicas;
### ContaCorrente
Filha da classe Conta, com uma sobreescrita do método "sacar" 
- ### Transferências
- As transferências para outros titulares ou bancso somente são feitas a partir da conta corrente. 
- Transferências entre contas correntes, investimento e poupança do mesmo titular e banco não sofrem taxação.
- Implementamos a interface com o método consultaSaldo, que foi detalhado nas classes ContaCorrente e ContaPoupanca; 
### contaInvestimento
- a taxa de rendimento da pessoa física poderá ser alterada com o método setTaxaRendimento. A taxa da pessoa física é a taxa básica, sendo que a taxa da pessoa jurídica será sempre a taxa básica mais 2%; 
- o valor dos juros pode pode ser obtido com o método jurosInvestimento. O método getSaldo permite obter os valor dos investimentos com juros.
-### contaPoupança
- Implementamos a interface com o método consultaSaldo, que foi detalhado nas classes ContaCorrente e ContaPoupanca; 

