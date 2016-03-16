
public class Teste {
	public int dia = 20;  
	public int mes = 4;
	public int ano = 2016;


	public static boolean bissexto (int ano) {

		if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}
	
	private long dataDias() {	
		int bis = 0;											
		int noBis = 0;
		for(int anoInicial = 1900; anoInicial < ano; anoInicial++) {
			if ( bissexto(anoInicial)) {						
				bis+=1;											
				anoInicial++;									
			}
			else {												
				noBis+=1;										
				anoInicial++;									
			}
		}
		int diasAnos = (bis * 366) + (noBis * 365);
	
		while (mes != 0) {
			int diasMeses = 0;
			diasMes(mes);
			int diasMeses += ???;  	(variável diasMeses que conterá o valor do total de dias dos meses)
			mes--;			(problema: colocar outra variável com os dias de cada mes pra somar)
		}

		long totalDias = diasAnos + diasMeses + dia;
		return totalDias;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Data data = new Data(14,3,2016); 
		System.out.print(data.stringData("14/02/2016"));
		
		System.out.print(totalDias);
	}

}
