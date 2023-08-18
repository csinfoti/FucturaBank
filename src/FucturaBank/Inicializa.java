package FucturaBank;

import java.util.Scanner;

public class Inicializa {

	//cabeçalho inicial
	public void Cabecalho() {
		
		System.out.println("FFFFFF   FF  FF  FFFFFF  FFFFFF  FF  FF   FFFFFF  FFFFFF ");
		System.out.println("FF       FF  FF  FF        FF    FF  FF   FF  FF  FF  FF ");
		System.out.println("FFFF     FF  FF  FF        FF    FF  FF   FFFFFF  FF  FF ");
		System.out.println("FF       FF  FF  FF        FF    FF  FF   FFFF    FFFFFF ");
		System.out.println("FF       FF  FF  FF        FF    FF  FF   FF FF   FF  FF ");
		System.out.println("FF       FFFFFF  FFFFFF    FF    FFFFFF   FF FFF  FF  FF ");
		System.out.println(" ");
		System.out.println("Bem Vindo ao Fuctura Bank!");
		System.out.println("Digite 'Sair' para encerrar a aplicação.");
		System.out.println("Digite seu CPF para cadastrar contas, conforme exemplo:");
		System.out.println("XXX.XXX.XXX-XX");
			
	}
	
	//menu Conta Corrente
	public int MenuCC() {
		int opcao = 0;	
		boolean loop = true;
		do {
			try{ 
				System.out.println(" ");
				System.out.println("Selecione a opção desejada: ");
				System.out.println("1 - Depósito");
				System.out.println("2 - Saque");
				System.out.println("3 - Aplicar Conta Poupança");
				System.out.println("4 - Consulta Saldo");
				System.out.println("5 - Consulta Extrato");
				System.out.println("6 - Menu Inicial");
				Scanner scan = new Scanner(System.in);
				opcao = scan.nextInt();
				loop = false;
			}catch (Exception ae){
				System.out.println("Opção inválida, tente novamente!");
				System.out.println("");
			}
		}while (loop == true);
		return opcao;
	}
	
	//menu Conta Poupança

	public int MenuCP() {
		int opcao = 0;	
		boolean loop = true;
		do {
			try{ 
				System.out.println(" ");
				System.out.println("Selecione a opção desejada: ");
				System.out.println("1 - Resgatar Valor");
				System.out.println("2 - Consulta Saldo");
				System.out.println("3 - Consulta Extrato");
				System.out.println("4 - Menu Inicial");
				Scanner scan = new Scanner(System.in);
				opcao = scan.nextInt();
				loop = false;
			}catch (Exception ae){
				System.out.println("Opção inválida, tente novamente!");
				System.out.println("");
			}
		}while (loop == true);
		return opcao;
	}
	
	//menu Alternar CC e CP
	public int MenuAlternar() {
		int opcao = 0;	
		boolean loop = true;
		do {
			try{ 
				System.out.println(" ");
				System.out.println("Selecione a opção desejada: ");
				System.out.println("1 - Acessar Conta Corrente");
				System.out.println("2 - Conta Poupança");
				System.out.println("3 - Encerrar Aplicação");
				Scanner scan = new Scanner(System.in);
				opcao = scan.nextInt();
				loop = false;
			
			}catch (Exception ae){
				System.out.println("Opção inválida, tente novamente!");
				System.out.println("");
			}
		}while (loop == true);
		return opcao;
	}
		
	
}
