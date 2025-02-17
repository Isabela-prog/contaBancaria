package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository{
	
	// criar um armazenamento local das contas, como um "banco de dados"
	private ArrayList<Conta> listarContas = new ArrayList<Conta>();
	// armazenar número da última conta criada
	int numero = 0;
	
	// método para listar todas as contas através do for each
	@Override
	public void listarTodas() {
		for(var conta : listarContas) {
			conta.visualizar();
		}
	}
	
	// implementar todos os métodos da interface
	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			conta.visualizar();
		}else {
			System.out.println("\nConta número: " + numero + " não foi encontrada!");
		}	
	}
	
	//cadastrar o objeto criado na lista de contas
	@Override
	public void cadastrar(Conta conta) {
		listarContas.add(conta);
		System.out.println("\nA conta número: " + conta.getNumero() + " foi criada com sucesso!");
	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());
		
		if (buscaConta != null) {
			listarContas.set(listarContas.indexOf(buscaConta), conta);
			System.out.println("\nA conta número: " + conta.getNumero() + " foi atualizada com sucesso!");		
		}else {
			System.out.println("\nA conta número: " + conta.getNumero() + " não foi encontrada");
		}
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if(listarContas.remove(conta) == true) {
				System.out.println("\nA conta número " + numero + " foi deletada com sucesso");
			}else {
				System.out.println("\nA conta número " + numero + " não foi encontrada!");
			}
		}
		
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		
	}
	
	// gerar o número da conta
	public int gerarNumero() {
		return ++ numero;
	}
	
	public Conta buscarNaCollection(int numero) {
		for(var conta: listarContas) {
			if(conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}

}
