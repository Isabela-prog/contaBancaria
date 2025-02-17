package conta.model;

public class ContaCorrente extends Conta{
	
	// acessível só na classe CC
	private float limite;
	// criar construtor que recebe todos os parâmetros
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		// método super para acessar para acessar os parâmetros da classe Conta
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}
	
	/*
	 *  gerar getters e setters para poder acessar e modificar
	 *  os atributos da classe CC
	 */
	public float getLimite() {
		return limite;
	}
	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	@Override
	public boolean sacar(float valor) {
		// verificar se o valor a ser sacado é menor do que o saldo + limite
		if(this.getSaldo() + this.getLimite() < valor) {
			System.out.println("\n Saldo insuficiente!");
			return false;
		}
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	
	// usar método visualizar da classe Conta
	public void visualizar() {
		super.visualizar();
		System.out.println("Limite de crédito: " + this.limite);
	}
	
	

}
