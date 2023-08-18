package FucturaBank;

import java.util.Scanner;


public class main {

	public static void main(String[] args) {
		//Inicializando Contas
		ContaCorrente contacorrente = new ContaCorrente();
		ContaPoupanca contapoupanca = new ContaPoupanca();
		
		//classe para inicialização de menus padrões
		Inicializa inicializa = new Inicializa();
		
		//chamada de cabeçalho padrão
		inicializa.Cabecalho();
		
		//Inicializa método para entrada de dados
		Scanner scan = new Scanner(System.in);
		
		//variável para leitura de String
		String LerStr = scan.next();
		
		//variável de leitura Double
		double LerDouble;
		
		//variável de loop de aplicação
		Boolean Loop = true;
		
		//variável de leitura de opções de menu
		int opcao;

		//Inicializa aplicação
	
			if(LerStr.equalsIgnoreCase("Sair")){
				System.out.printf("Encerrando aplicação!");
				System.exit(0);
			} else {
				//criação das contas
				contacorrente.CriarCC(LerStr);	
				contapoupanca.CriarCP(contacorrente.getCpf(), contacorrente.getTitular());
				
					//looping de execução da aplicação
					do {
						//seleçao entre menu CC e CP
						opcao = inicializa.MenuAlternar();
						switch (opcao){
						case 1:
							//acessando menu CC
							opcao = inicializa.MenuCC();
							switch (opcao) {
								case 1: 
									//realizando depósito CC
									System.out.println("Digite o valor do depósito: ");
									LerDouble = scan.nextDouble();
									contacorrente.Depósito(LerDouble);
									break;
								case 2:
									//Realizando Saque CC
									System.out.println("Digite o valor do Saque: ");
									LerDouble = scan.nextDouble();
									contacorrente.Saque(LerDouble);
									break;
								case 3: 
									//Aplicando Na conta poupança
									System.out.println("Digite o valor a ser aplicado na Conta Poupança: ");
									LerDouble = scan.nextDouble();
									//atualizar saldo da poupanca após confirmar operação
									if(contacorrente.AplicacaoPoupanca(LerDouble)== true) {
										double saldopoupanca = contapoupanca.getSaldo();
										saldopoupanca = saldopoupanca + LerDouble;
										contapoupanca.setSaldo(saldopoupanca);
										System.out.println("Saldo atualizado da Conta Poupança: ");
										contapoupanca.MostraSaldo();
									}
									break;
								case 4:
									//Consultando Saldo CC
									contacorrente.MostraSaldo();
									break;
								case 5:
									//Consultando Extrato CC
									System.out.printf("\n Dados da Conta corrente: ");
									contacorrente.Extrato();
									break;
								case 6:
									//Voltando Menu Inicial
									System.out.println("Voltando ao menu inicial.");
									break;
								default:
									//opção inexistente
									System.out.println("Opção inválida, tente novamente!");
									break;
							}
							break;
						case 2:
							//acessando menu Conta Poupança
							opcao = inicializa.MenuCP();
							switch (opcao) {
								case 1:
									//Realizando resgate da Conta Poupança para Conta Corrente
									System.out.println("Digite o valor a ser resgatado da Conta Poupança: ");
									LerDouble = scan.nextDouble();
									//atualizar saldo da contacorrente após confirmar operação
									if(contapoupanca.ResgataCC(LerDouble)== true) {
										double saldocontacorrente = contacorrente.getSaldo();
										saldocontacorrente = saldocontacorrente + LerDouble;
										contacorrente.setSaldo(saldocontacorrente);
										System.out.println("");
										System.out.println("Saldo atualizado da Conta Corrente: ");
										contacorrente.MostraSaldo();
									}
									break;
								case 2:
									//Consultando Saldo
									contapoupanca.MostraSaldo();
									break;
								case 3:
									System.out.printf("\n Dados da Conta Poupança: ");
									contapoupanca.Extrato();
									break;
								case 4:
									//Voltando ao menu inicial
									System.out.println("Voltando ao menu inicial");
									break;
								default:
									//opção iniexistente
									System.out.println("Opção inválida, tente novamente!");
									break;
							}
							break;
						case 3:
							System.out.printf("Encerrando aplicação!");
							System.exit(0);
							
						
						default:
							System.out.println("Opção inválida, tente novamente!");
							break;
						}
					}while (Loop == true);	
		
	}
	}
}
