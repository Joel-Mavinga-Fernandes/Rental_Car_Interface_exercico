package service.entity;

import model.entity.AluguelCarros;
import model.entity.Fatura;

public class AluguelService {
	
	private double precoPorHora;
	private double precoPorDia;
	
	private ImpostoService impostoService;
	
	public AluguelService() {

	}
	
	public AluguelService(double precoPorHora, double precoPorDia, ImpostoService impostoService) {
		this.precoPorHora = precoPorHora;
		this.precoPorDia = precoPorDia;
		this.impostoService = impostoService;
	}
	
	public void processoFatura(AluguelCarros aluguelCarros) {
		
		long t1 = aluguelCarros.getInicio().getTime();
		long t2 = aluguelCarros.getFim().getTime();
		
		double horas = (t2 - t1)/ 1000 / 60 / 60;
		
		double pagamentoBasico;
		if(horas<= 12) {
			pagamentoBasico= precoPorHora * Math.ceil(horas);
		}else {
			pagamentoBasico= precoPorDia * Math.ceil(horas);
		}
		
		double imposto = impostoService.imposto(pagamentoBasico);
		
		aluguelCarros.setFatura(new Fatura(pagamentoBasico, imposto));
	}
}
