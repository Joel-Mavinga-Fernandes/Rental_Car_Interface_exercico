package model.entity;

public class Fatura {

	private double pagamentoBasico;
	private double imposto;
	
	
	public Fatura() {
	
	}
	
	public Fatura(double pagamentoBasico, double imposto) {
		this.pagamentoBasico = pagamentoBasico;
		this.imposto = imposto;
	}

	public double getPagamentoBasico() {
		return pagamentoBasico;
	}

	public void setPagamentoBasico(double pagamentoBasico) {
		this.pagamentoBasico = pagamentoBasico;
	}

	public double getImposto() {
		return imposto;
	}

	public void setImposto(double imposto) {
		this.imposto = imposto;
	}	
	
	public double total() {
		return getPagamentoBasico() + getImposto();
	}


	
	
}
