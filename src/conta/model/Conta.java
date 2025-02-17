package conta.model;

public abstract class Conta {	
	/*
	 * atributos da classe Conta
	 * private: 
	 * - acessível apenas na classe conta - encapsulamento; atributos só
	 * podem ser capturados e manipulados por outra classe utilizando o GET e SET
	 */
	
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;
	
	/*
	 * construtor:
	 * - quando o objeto novo é instanciado os construtor recebe todos os dados pelos
	 * parâmetros dele e os atribui aos atributos do objeto
	 * o this diferencia o atributo da classe do construtor -> this.numero (classe)
	 */
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}
	
	//método GET e SET
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	//recebe o valor a ser sacado
	public boolean sacar(float valor) {
		//tratar quando usuário não tive saldo
		if (this.getSaldo() < valor) {
			System.out.println("\nSaldo insuficiente!");
			return false;
		}
		//o get busca o valor do saldo e set atualiza com a subtraçãod do valor
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	
	public void depositar(float valor) {
		this.setSaldo(this.getSaldo() + valor);
	}
	
	public void visualizar() {
		//receber textualmente o tipo da conta
		String tipo = "";
		
		switch (this.getTipo()) {
		case 1:
			tipo = "Conta Corrente";
			break;
		case 2:
			tipo = "Conta Poupança";
			break;
		}
		
		System.out.println("\n\n************************************");
		System.out.println("Dados da conta:");
		System.out.println("************************************");
		System.out.println("Número da conta: " + this.numero);
		System.out.println("Agência: " + this.agencia);
		System.out.println("Tipo da conta: " + tipo);
		System.out.println("Titular: " + this.titular);
		System.out.println("Saldo: " + this.saldo);
	}
}
