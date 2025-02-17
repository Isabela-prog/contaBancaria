package conta;

import java.io.IOException;

import java.util.InputMismatchException;
import java.util.Scanner;
import conta.util.Cores;
import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {
	
	
	public static void main(String[] args) {
		//variáveis
		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;
		
		System.out.println("\nCriar Contas\n");
		ContaController contas = new ContaController();
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);
		
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 1000f, 100.0f);
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 1000f, 12);
		contas.cadastrar(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Juliana Ramos", 1000f, 15);
		contas.cadastrar(cp2);
		
		contas.listarTodas();
		
		//incializar scanner
		Scanner scanner = new Scanner(System.in);
		
		// teste conta corrente
		ContaCorrente cc3 = new ContaCorrente(1, 123, 1, "José da Silva", 0.0f, 1000.0f);
		cc1.visualizar();
		cc1.sacar(12000.0f);
		//cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();
		
		// teste conta poupança
		ContaPoupanca cp3 = new ContaPoupanca(2, 123, 2, "Maria dos Santos", 100000.0f, 15);
		cp1.visualizar();
        cp1.sacar(1000.0f);
		//cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();
		
		//menu que rodará até entrar na opção 9
		while(true) {
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND + 
					"***************************************************************");
			System.out.println("                                                               ");
			System.out.println("                   Banco do Brazil                             ");
			System.out.println("                                                               ");
			System.out.println("***************************************************************");
			System.out.println("                                                               ");
			System.out.println("                   1 - criar conta                             ");
			System.out.println("                   2 - listar todas contas                     ");
			System.out.println("                   3 - buscar conta pro número                 ");
			System.out.println("                   4 - atualizar dados da conta                ");
			System.out.println("                   5 - apagar conta                            ");
			System.out.println("                   6 - sacar                                   ");
			System.out.println("                   7 - depositar                               ");
			System.out.println("                   8 - transferir valores entre contas         ");
			System.out.println("                   9 - sair                                    ");
			System.out.println("                                                               ");
			System.out.println("***************************************************************");
			System.out.println("                                                               ");
			System.out.println("Entre com a opção desejada:                                    " + 
			Cores.TEXT_RESET);
			
			// tratar quando o usuário não digitar inteiros
			try {
				// tenta pedir
				opcao = scanner.nextInt();
			}catch(InputMismatchException e){
				// senão gera erro
				System.out.println("\nDigite valores inteiros!");
				scanner.nextLine();
				opcao = 0;
			}
			
			
			//caso entre em 9 método sobre é acionado e o while fechado
			if(opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z, seu futuro começa aqui!");
				sobre();
				scanner.close();
				System.exit(0);
			}
			
			//opções em swtich case
			switch(opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "criar conta\n\n");
				
				// entrada dos dados
				System.out.println("Digite o Número da Agência: ");
				agencia = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Digite o Nome do Titular: ");
				// ignorar a quebra de linha
				scanner.skip("\\R?");
				titular = scanner.nextLine();
				scanner.nextLine();
				
				// garantir que o usuário digitará 1 ou 2
				do {
					System.out.println("Digite o tipo de conta (1 - CC ou 2 - CP): ");
					tipo = scanner.nextInt();
					scanner.nextLine();
				}while(tipo < 1 && tipo >2);
				
				System.out.println("Digite o saldo da conta (R$): ");
				saldo = scanner.nextFloat();
				scanner.nextLine();
				
				// checar o tipo de conta
				switch(tipo) {
				case 1 -> {
					System.out.println("Digite o Limite de Crédito: ");
					limite = scanner.nextFloat();
					//usou o método cadastras para cadastrar na classe conta corrente todos os parâmetros
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					scanner.nextLine();
				}
				case 2 -> {
					System.out.println("Digite o Aniversário da Conta: ");
					aniversario = scanner.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					scanner.nextLine();
				}
				}
				
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "listar todas as contas\n\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "consultar dados da conta - por números\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = scanner.nextInt();
				
				contas.procurarPorNumero(numero);
				
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "atualizar dados da conta\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = scanner.nextInt();
				
				var buscaConta = contas.buscarNaCollection(numero);
				
				if(buscaConta != null) {
					
					tipo = buscaConta.getTipo();
					
					System.out.println("Digite o Número da Agência: ");
					agencia = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Digite o Nome do Titular: ");
					scanner.skip("\\R?");
					titular = scanner.nextLine();
					scanner.nextLine();
					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = scanner.nextFloat();
					scanner.nextLine();
				
				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o Limite do Crédito: ");
					limite = scanner.nextFloat();
					
					contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o Aniversário da Conta: ");
					aniversario = scanner.nextInt();
					
					contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
				}
				default -> {
					System.out.println("Tipo de conta inválido!");
				}
				}}else {
					System.out.println("A conta não foi encontrada!");
				}
				
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "apagar conta\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = scanner.nextInt();
				scanner.nextLine();
				
				contas.deletar(numero);
				
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "saque\n\n");
				
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "depósito\n\n");
				
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "transferência entre contas\n\n");
				
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "insira uma opção válida!\n\n");
				
				keyPress();
				break;
			}
		}
				
	}
	
	//método de teclar enter para continuar
	public static void keyPress() {
		try {
		System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
		//leitura das teclas -> se for digitado qlqr outra tecla, retorna -1 (método Keyoress)
		System.in.read();
		}catch(IOException e) {
			System.out.println("Você pressionou uma tecla diferente");
		}
	}
	
	public static void sobre() {
		System.out.println( "*****************************************\n");
		System.out.println("Projeto desenvolvido por:");
		System.out.println("Isabela Santos - isantos.ipereira@gmail.com");
		System.out.println("https://github.com/Isabela-prog\n\n");
		System.out.println("*****************************************\n");
		
		}
	
}
