package FucturaBank;

import java.util.Scanner;

public class ContaPoupanca extends Contas{
	
	public void CriarCP(String cpf, String titular) {
		boolean Loop = true;
		double deposito;
		Integer opcao = 0;
		
		//importando dados do cliente
		this.setCpf(cpf);
		this.setTitular(titular);
		Scanner scan = new Scanner(System.in);
		
		//solicitando dados iniciais
		System.out.println(" ");
		System.out.println("Digite o numero da Conta Poupança desejada: ");
		this.setConta(scan.nextLine());
	
		
		//verificação do saldo inicial em um loop com verificador
		
		try {
			do {
				System.out.println(" ");
				System.out.println("Depósito inicial?");
				System.out.println("1 Sim");
				System.out.println("2 Não");
				opcao = scan.nextInt();
				if (opcao == 1) {
					System.out.println("Informe o valor do depósito: ");
					deposito = scan.nextDouble();
					System.out.println(" ");
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
			System.out.println("Erro!! Reiniciando processo de Cadastro de Conta Poupança!");
			CriarCP(this.getCpf(), this.getTitular());
		}
			

		
	}
	
	public boolean ResgataCC(double valresgate) {
		double ValResgate = valresgate;
		double saldo = this.getSaldo();
		
		//verificação do saldo antes da operação
		if ((saldo > 0.00) && (saldo >= ValResgate)) {
			try {
				Scanner scan = new Scanner(System.in);
				int opcao;
				System.out.println(" ");
				System.out.println("Confirma o regate de R$ " + ValResgate + "?");
				System.out.println(" 1 - Sim");
				System.out.println(" 2 - Não");
				opcao = scan.nextInt();
				if (opcao == 1) {
					saldo = saldo - ValResgate;
					System.out.println("Realizada o resgate de R$ " + ValResgate + ". Saldo atual de: " + saldo);
					this.setSaldo(saldo);
					return true;
				} else if (opcao == 2) {
					System.out.println("Resgade de Conta Poupança cancelada, refaca a operação!");
					return false;
				} else {
					System.out.println("Opção inválida, refaca a operação!");
					return false;
				}
			} catch (Exception ae) {
				System.out.println("Opção inválida, refaca a operação!");
				return false;
			}
		} else {
				System.out.println("Saldo insuficiente para operação! Consulte o saldo para tentar novamente!");
				return false;
		}
	}


}
	


	
