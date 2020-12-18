package bancos;

public class ContaEspecial extends ContaCorrente 
{
    private double limiteEspecial = 1000.00;
    private double limiteCadastro;
    
    public ContaEspecial(int numeroConta, String cpfConta) {
        super(numeroConta, cpfConta);
    }
    public double getLimiteEspecial() {
        return limiteEspecial;
    }
    public void setLimiteEspecial(double limiteEspecial) {
        this.limiteEspecial = limiteEspecial;
    }
    public double getLimiteCadastro() {
        return limiteCadastro;
    }
    public void setLimiteCadastro(double limiteCadastro) {
        this.limiteCadastro = limiteCadastro;
    }
    
    @Override
    public void depositar(double valor) {
    	if(this.limiteEspecial<1000) {
    		this.limiteEspecial+=valor;
    		if(this.limiteEspecial>1000) {
    			super.depositar(this.limiteEspecial-1000);
    			this.limiteEspecial = 1000;
    		}
    	
    	}
    	else {
    		super.depositar(valor);
    	}
		//this.saldoConta = this.saldoConta + valor;
	}
    @Override
    public void retirar(double valor) {
        if (valor > (super.getSaldoConta()+this.limiteEspecial)) {
            System.out.println("Operação cancelada. Saldo e limite de crédito insuficientes.");
        } else if (valor<super.getSaldoConta()){
            super.retirar(valor);
        } else {
            this.limiteEspecial = this.limiteEspecial-(valor-super.getSaldoConta());
            super.retirar(super.getSaldoConta());
        }
    }

}