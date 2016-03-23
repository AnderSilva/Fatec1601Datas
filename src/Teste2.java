import java.util.Date;

public class Teste2
{
	public Data soma(int dias){
		//  TODO: Soma: Data + dias => Outra Data posterior em dias
		int ano = 2004;
		int mes = 3;
		int dia = 20;  
		//TODO: como pegar dia?
		if ( (mes=1) || (mes=3) || (mes=5) || (mes=7) || (mes=8) || (mes=10) ) {
			diasMes(mes);
			if (dia != 31) {
				dia += 1;
			} else {
				dia = 1;
				mes += 1;
			}	
		}
		
		if ( (mes=4) || (mes=6) || (mes=9) || (mes=11) ) {
			diasMes(mes);
			if (dia != 30) {
				dia += 1;
			} else {
				dia = 1;
				mes += 1;
			}
		}
	
		if (mes = 12) {
			diaMes(12);
			if (dia != 31) {
				dia += 1;
			} else {
				dia = 1;
				mes = 1;
				ano += 1;
			}
		}
			
		if (mes = 2) {
			diaMes(2);
			if (bissexto(2) {
				if (dia != 29) {  
					dia += 1;
				} else {
					dia = 1;
					mes += 1;
			}
			else if (dia != 28) {  
				dia += 1;
			} else {
				dia = 1;
				mes += 1;
			}
		}
		
		//Data dt = new Data();
		//return dt;
	}
	public static void main(String[] args){
		Date data = new Date();
		System.out.println(data);

	}
}
