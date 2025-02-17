package conta;

import java.util.Scanner;
import conta.util.Cores;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {
	public static void main(String[] args) {
		//variáveis
		int opcao;
		
		//incializar scanner
		Scanner scanner = new Scanner(System.in);
		
		// teste conta corrente
		ContaCorrente cc1 = new ContaCorrente(1, 123, 1, "José da Silva", 0.0f, 1000.0f);
		cc1.visualizar();
		cc1.sacar(12000.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();
		
		// teste conta poupança
		ContaPoupanca cp1 = new ContaPoupanca(2, 123, 2, "Maria dos Santos", 100000.0f, 15);
		cp1.visualizar();
        cp1.sacar(1000.0f);
		cp1.visualizar();
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
			
			opcao = scanner.nextInt();
			
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
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "listar todas as contas\n\n");
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "consultar dados da conta - por números\n\n");
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "atualizar dados da conta\n\n");
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "apagar conta\n\n");
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "saque\n\n");
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "depósito\n\n");
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "transferência entre contas\n\n");
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "insira uma opção válida!\n\n");
				break;
			}
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
