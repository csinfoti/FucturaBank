package FucturaBank;

import java.util.Scanner;

public abstract class Contas {
	
//variáveis que não devem ser acessadas diretamente por outros métodos/classes
private String Conta;
private String Titular;
private double Saldo;
private String Cpf;


//Métodos de acesso para variáveis declaradas

public String getConta() {
	return Conta;
}
public void setConta(String conta) {
	Conta = conta;
}

public String getTitular() {
	return Titular;
}
public void setTitular(String titular) {
	Titular = titular;
}

public double getSaldo() {
	return Saldo;
}
public void setSaldo(double saldo) {
	Saldo = saldo;
}

public String getCpf() {
	return Cpf;
}
public void setCpf(String cpf) {
	Cpf = cpf;
}

//métodos comuns para classe conta e suas "herdeiras"

//método para exibir saldo
public void MostraSaldo() {
	System.out.println(" ");
	System.out.println("O Saldo atual é de: " + this.getSaldo());
}

//método para exibir extrato
public void Extrato() {
	System.out.println(" ");
	System.out.println("Número da conta: " + this.getConta());
	System.out.println("Nome do Titular: " + this.getTitular());
	System.out.println("CPF: " + this.getCpf());
	System.out.println("Saldo Atual: " + this.getSaldo());
	
}

//método para depósito
public void Depósito(double ValorDep) {
	double SaldoAtual;
	int opcao;
	System.out.println(" ");
	System.out.println("Confirma o depósito de R$ " + ValorDep + "?");
	System.out.println(" 1 - Sim");
	System.out.println(" 2 - Não");
	try {
		Scanner scan = new Scanner(System.in);
		opcao = scan.nextInt();
		if (opcao == 1) {
			SaldoAtual = this.getSaldo()+ValorDep;
			System.out.println("Depósito efetuado. Saldo atual da Conta Poupança: R$ " + SaldoAtual);
			this.setSaldo(SaldoAtual);
		} else if (opcao == 2) {
			System.out.println("Depósito cancelado, refaça a operação!");
		} else {
			System.out.println("Opção inválida, refaça a operação!");
		}
	} catch (Exception ae) {
		System.out.println("Opção inválida, refaça a operação!");
	}
	
	
}


}
