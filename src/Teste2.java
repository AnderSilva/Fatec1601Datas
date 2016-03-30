import java.util.Date;

public class Teste2 {
	
		public Data(String data){		
		//Recebe uma string e 
		//atribui cada termo no vetor de componentes
		//conforme o formato que estiver atualmente
		
		//1.o splitar (separar a string) usando o separador e descobrir quem é dia,mes,ano		
		//2.o preencher o vetor de componentes
	}	
	
	----------------------------------------------------------------------------------------------
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
		----------------------------------------------------------------------------------------------
	public Data sub(int dias){
		if ( (mes==1) || (mes==2) || (mes==4) || (mes==6) || (mes==8) || (mes==9) || (mes==11) ) {
			if (dia > 1) {
				dia= dia-1;
			}
			else {
				if ( mes != 1 ) {	
					if ( dia==1 ) {
						dia=31;
					}
				}
				else {	
					dia= 31;
					mes=12;
					ano= ano-1;
				}
			}
		}
	else {
		if ( (mes==5) || (mes==7) || (mes==10) || (mes==12) ) {
			if ( dia > 1 ) { 
				dia= dia-1;
			}
			else {
				dia=30;
				mes= mes-1;
			}
		}
		else {
			if ( bissexto(ano) )=true {
				if ( dia >1 ) {
					dia= dia-1
				}
				else {
					dia=29;
					mes=2;
				}
			}
			else {
				dia=28;
				mes=2;
			}
		}
		
	}
	
		//Subtração 1: Data – dias => Data anterior em dias
		//Data dt = new Data(13,3,2016);
		//return dt;
	}
		----------------------------------------------------------------------------------------------
	public long sub(Data d){
		//Subtração 2: Data – Data => dias decorridos entre as duas datas.
		long sub=1000;
		return sub;
	}
		----------------------------------------------------------------------------------------------
	private void diasData(long d){
		int anoAnterior = 0;
		int i = diasMes[1]; 
		// i representa o primeiro mes do diasMes
		// problema: como colocar o parametro ano
			
		if ( d >= 366 ) {											
		// verifica se d e maior que o numero de um ano bissexto
			int numeroAnos = (int) (d / 366);								
			// conta mais ou menos quantos anos inteiros tem
			// tem que pegar a parte inteira do decimal
			anoAnterior = 1900 + numeroAnos;					
			// verifica o intervalo de anos, de 1900 ate x anos
			for ( int i = 1900 ; i <= anoAnterior ; i++ ) {			
			// para 1900 ate x anos, vai incrementando
				if ( bissexto(i) ) {				 				
				// se e bissexto
					int d-= 366;									
					// e subtraido de d o valor de 366 dias
				}
				else {
					int d-= 365;									
					// senao e subtraido de d o valor de 365 dias
				}
			} 
			return d;												
			// retorna o resto da subtracao
		}
		else {
			while ( d != 0 ) {										
			// enquanto d for diferente de zero
				int ano = anoAnterior + 1;  				
				// ano atual e o anterior mais um
				bissexto(ano);										
				// chama bissexto
				diasMes(i);								
				// chama diasMes para i
				i++;
				// incrementa i
				// TODO: como saber quando parar se verificar os meses, quando o d for menor de 30 ou 28
				// TODO: verificar o resto dos dias.
			}
		}
		int dia = ?;
		// resto do dia que e o dia da data atual
		int mes = i;
		// mes que parou a verificacao
		int ano = ano;
		// ano atual da data
	}
	
	
	
	
	public static void main(String[] args){
		Date data = new Date();
		System.out.println(data);

	}
}
