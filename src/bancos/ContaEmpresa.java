package bancos;

public class ContaEmpresa extends Conta {
	private double emprestimoEmpresa = 5000.00;

	// Construtor
	public ContaEmpresa(int numeroConta, String cpf) {
		super(numeroConta, cpf);
	}

	// Encapsulamento

	public double getEmprestimoEmpresa() {
		return emprestimoEmpresa;
	}

	public void setEmprestimoEmpresa(double emprestimoEmpresa) {
		this.emprestimoEmpresa = emprestimoEmpresa;
	}

	public void emprestar(double valorEmprestimo) {
		if (valorEmprestimo <= this.emprestimoEmpresa) {
			this.emprestimoEmpresa = this.emprestimoEmpresa - valorEmprestimo;
			super.depositar(valorEmprestimo);
			System.out.println("Valor de emprestimo disponivel:" + this.emprestimoEmpresa);
			System.out.println("Saldo Atual: " + super.getSaldoConta());
		} else {
			System.out.println("ERRO.O seu limite é " + this.emprestimoEmpresa);
		}
	}
}