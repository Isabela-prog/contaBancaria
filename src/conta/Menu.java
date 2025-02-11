package conta;

import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		//variáveis
		int opcao;
		
		//incializar scanner
		Scanner scanner = new Scanner(System.in);
		
		//menu que rodará até entrar na opção 9
		while(true) {
			System.out.println("*************************************************************\n");
			System.out.println("                   Banco do Brazil\n");
			System.out.println("*************************************************************\n");
			System.out.println("                   1 - criar conta");
			System.out.println("                   2 - listar todas contas");
			System.out.println("                   3 - buscar conta pro número");
			System.out.println("                   4 - atualizar dados da conta");
			System.out.println("                   5 - apagar conta");
			System.out.println("                   6 - sacar");
			System.out.println("                   7 - depositar");
			System.out.println("                   8 - transferir valores entre contas");
			System.out.println("                   9 - sair\n");
			System.out.println("*************************************************************\n");
			System.out.println("Entre com a opção desejada:\n");
			
			opcao = scanner.nextInt();
			
			//caso entre em 9 método sobre é acionado e o while fechado
			if(opcao == 9) {
				System.out.println("\nBanco do Brazil com Z, seu futuro começa aqui!");
				sobre();
				scanner.close();
				System.exit(0);
			}
			
			//opções em swtich case
			switch(opcao) {
			case 1:
				System.out.println("criar conta\n\n");
				break;
			case 2:
				System.out.println("listar todas as contas\n\n");
				break;
			case 3:
				System.out.println("consultar dados da conta - por números\n\n");
				break;
			case 4:
				System.out.println("atualizar dados da conta\n\n");
				break;
			case 5:
				System.out.println("apagar conta\n\n");
				break;
			case 6:
				System.out.println("saque\n\n");
				break;
			case 7:
				System.out.println("depósito\n\n");
				break;
			case 8:
				System.out.println("transferência entre contas\n\n");
				break;
			default:
				System.out.println("insira uma opção válida!\n\n");
				break;
			}
		}
				
	}
	
	public static void sobre() {
		System.out.println("*****************************************\n");
		System.out.println("Projeto desenvolvido por:");
		System.out.println("Isabela Santos - isantos.ipereira@gmail.com");
		System.out.println("https://github.com/Isabela-prog\n\n");
		System.out.println("*****************************************\n");
		
		}
	
}
