package FucturaBank;

import java.util.Scanner;

public class ContaCorrente extends Contas{

	
	//método para criar Conta Corrente
	public void CriarCC(String cpf) {
		boolean Loop = true;
		double deposito;
		Integer opcao = 0;
		
		//importando dados de leitura
		this.setCpf(cpf);
		
		//iniciando processo de criação de conta
		Scanner scan = new Scanner(System.in);
		System.out.println(" ");
		System.out.println("Digite o nome do titular: ");
		this.setTitular(scan.nextLine());
		System.out.println("Digite o número da conta desejada: ");
		this.setConta(scan.nextLine());
	
		
		//verificação do saldo inicial em um loop com verificador
		
		try {
			do {
	
				System.out.println("Depósito inicial?");
				System.out.println("1 Sim");
				System.out.println("2 Não");
				opcao = scan.nextInt();
				if (opcao == 1) {
					System.out.println("Informe o valor do depósito: ");
					deposito = scan.nextDouble();
					System.out.println("Confirma depósito inicial de R$ " + deposito + "?");
					System.out.println("1 Sim");
					System.out.println("2 Não");
					opcao = scan.nextInt();
					if (opcao == 1) {
						this.setSaldo(deposito);
						Loop = false;
						
					} else if (opcao == 2) {
						System.out.println("Iniciando processo de depósito inicial novamente!");
						
					} else {
						System.out.println("Opção inválida! Iniciando processo de depósito inicial novamente!");
					}
				} else if (opcao == 2) {
					System.out.println("Criação de Conta Corrente Concluída");
					Loop = false;
					
					
				} else {
					System.out.println("Opção inválida! Reiniciando processo de depósito inicial!");
				}
				} while (Loop == true);
		} catch (Exception ae) {
			System.out.println("Erro!! Reiniciando processo de Cadastro de Conta Corrente!");
			CriarCC(this.getCpf());
		}
			

		
	}

	
	
	//método para saque
	public void Saque(double valsaque) {
		double ValSaque = valsaque;
		double saldo = this.getSaldo();
		
		
		if ((saldo > 0.00) && (saldo >= ValSaque)) {
			try {
				saldo = saldo - ValSaque;
				int opcao;
				Scanner scan = new Scanner(System.in);
				System.out.println(" ");
				System.out.println("Confirma o saque de R$ " + ValSaque + "?");
				System.out.println(" 1 - Sim");
				System.out.println(" 2 - Não");
				opcao = scan.nextInt();
				if (opcao == 1) {
					System.out.println("Realizado saque de R$ " + ValSaque + ". Saldo atual de: " + saldo);
					this.setSaldo(saldo);
				}else if (opcao == 2) {
					System.out.println("Saque de Conta Corrente cancelado, refaça a operação!");
				} else {
					System.out.println("Opção inválida, refaça a operação!");
				}
			}catch (Exception ae) {
				System.out.println("Opção inválida, refaça a operação!");
			}	
		} else {
			System.out.println("Saldo insuficiente para operação! Consulte o saldo para tentar novamente!");
		}
		

			
		
	}
	
	//metodo de aplicação na Conta Poupanca retorna bolleano para informar a Conta Poupança se deve atualizar saldo
	public boolean AplicacaoPoupanca(double valaplicado) {
		double ValAplicado= valaplicado;
		double saldo = this.getSaldo();
		
		//verificação do saldo antes da operação
		if ((saldo > 0.00) && (saldo >= ValAplicado)) {
			try {
				Scanner scan = new Scanner(System.in);
				int opcao;
				System.out.println(" ");
				System.out.println("Confirma o aplicação na Conta Poupança de R$ " + ValAplicado + "?");
				System.out.println(" 1 - Sim");
				System.out.println(" 2 - Não");
				opcao = scan.nextInt();
				if (opcao == 1) {
					saldo = saldo - ValAplicado;
					System.out.println("Realizada a aplicação de R$ " + ValAplicado + ". Saldo atual de: " + saldo);
					this.setSaldo(saldo);
					return true;
				} else if (opcao == 2) {
					System.out.println("Aplicação em Conta Poupança cancelada, refaça a operação!");
					return false;
				} else {
					System.out.println("Opção inválida, refaça a operação!");
					return false;
				}
			} catch (Exception ae) {
				System.out.println("Opção inválida, refaça a operação!");
				return false;
			}
		} else {
				System.out.println("Saldo insuficiente para operação! Consulte o saldo para tentar novamente!");
				return false;
		}
		
		
		}
}


		
	

