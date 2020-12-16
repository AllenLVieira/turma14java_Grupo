package bancos;

public abstract class Conta {
	private String cpfConta;
	private double saldoConta = 0.0;
	private int numConta;

	public Conta(int numConta) {
		super();
		this.numConta = numConta;
	}

	public Conta(int numConta, String cpfConta) {
		super();
		this.cpfConta = cpfConta;
		this.numConta = numConta;
	}

	public String getCpfConta() {
		return cpfConta;
	}

	public void setCpfConta(String cpfConta) {
		this.cpfConta = cpfConta;
	}

	public double getSaldoConta() {
		return saldoConta;
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public double mostraSaldo() {
		return this.saldoConta;
	}

	public void depositar(double valor) {
		this.saldoConta = this.saldoConta + valor;
	}

	public void retirar(double valor) {
		if (valor > this.saldoConta) {
			System.out.println("Operação cancelada. Saldo insuficiente.");
		} else {
			this.saldoConta = this.saldoConta - valor;
		}
	}

}