package service.entity;

public class ImpostoBrasileiroService implements ImpostoService {
	
	public double imposto(double quantidade) {
		
		if (quantidade<=100) {
			 return quantidade * 0.2;
			 	
		}else {
			 return quantidade * 0.15;
		}
	}
}
