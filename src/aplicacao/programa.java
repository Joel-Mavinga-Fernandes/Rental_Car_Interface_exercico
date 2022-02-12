 package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entity.AluguelCarros;
import model.entity.Fatura;
import model.entity.Veiculo;
import service.entity.AluguelService;
import service.entity.ImpostoBrasileiroService;

public class programa {

	public static void main(String[] args) throws ParseException {


		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		System.out.println("Entre com os dados do aluguel");
		
		System.out.print("Modelo do carro: ");
		String veiculo = sc.nextLine();
		System.out.print("Levantamento: ");
		Date inicio = sdf.parse(sc.nextLine());
		System.out.print("Devolução");
		Date fim = sdf.parse(sc.nextLine());
		
		System.out.print("Digite o preço por hora: ");
		double precoPorHora = sc.nextDouble();
		System.out.print("Digite o preço por dia: ");
		double precoPorDia = sc.nextDouble();
		
		AluguelCarros aluguel = new AluguelCarros(inicio, fim, new Veiculo(veiculo));
		
		AluguelService aluguelService = new AluguelService(precoPorDia, precoPorDia, new ImpostoBrasileiroService());
		
		aluguelService.processoFatura(aluguel);
		
		System.out.println("Fatura");
		System.out.println("Pagamento Básico: " + aluguel.getFatura().getPagamentoBasico());
		System.out.println("Imposto: " + aluguel.getFatura().getImposto());
		System.out.println("Total: " + new Fatura().total() );

	}

}
