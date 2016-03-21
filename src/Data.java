
/**
 * @author 
 *
 */
public class Data {
	//Variaveis de Classe	
	static int  formato   = 0;
	// 0 - Britânico: DD/MM/AAAA
	// 1 - Americano: MM/DD/AAAA
	// 2 - Italiano : DD-MM-AAAA
	// 3 - Germânico: DD.MM.AAAA
	// 4 - ANSI     : AAAA.MM.DD
	static char separador = '/';	
	static int termos[] = {0, 1, 2};
	
	//indice dos vetores abaixo correspondem ao separador e formato (entre 0 e 4) respectivo
	private static char vetsep[] = { '/' , '/' , '-' , '.' , '.' }; 
	private static char vetfor[][]  = { {0,1,2}, {1,0,2}, {0,1,2}, {0,1,2}, {2,1,0} };
	
	
	//Variaveis de instancia
	int  componentes[] = {0, 0, 0}; // dia, mes, ano	
	
	//Exemplo de montagem da string da data:
	//“” + componentes[termos[0]]+separador+componentes[termos[1]]+separador+componentes[termos[2]];
		
	//Construtores	
	public Data(int dia, int mes, int ano){
		this.componentes[0] = dia;
		this.componentes[1] = mes;
		this.componentes[2] = ano;		
	}
	public Data(String data){		
		//Recebe uma string e 
		//atribui cada termo no vetor de componentes
		//conforme o formato que estiver atualmente
		
		//1.o splitar (separar a string) usando o separador e descobrir quem é dia,mes,ano		
		//2.o preencher o vetor de componentes
	}
	
	public Data(Data d) {
		componentes[0] = d.componentes[0];
		componentes[1] = d.componentes[1];
		componentes[2] = d.componentes[2];		
	}
	
	
	private String getStringData(){ // testar
		//Recebe a data instanciada e retorna uma string de data
		//Exemplo 13,6,2016 retornaria 13/06/2016 no formato britanico (0)
		
		return  "" 	+ this.componentes[ vetfor[ formato ][0] ] + separador
					+ this.componentes[ vetfor[ formato ][1] ] + separador
					+ this.componentes[ vetfor[ formato ][2] ];
	}

	
	//Metodos 
	public boolean ConsisteData(Data d){ //testar
		// Esse método recebe uma variavel do tipo Data e apos 
		// passar por validações, retorna True se for uma data válida
		String strdata = getStringData();
		
		if (!this.stringData( strdata )) return false; //Se stringData for falso, retorna falso
										
		int diasM = diasMes(this.componentes[0],this.componentes[2]);
		return (diasM>=28 && diasM<=31); //se diasMes estiver fora do range => falso		
	}
		
	static boolean bissexto(int ano){ //ok
		return ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0));	
	}	

	static int diasMes(int mes, int ano){
		//Retorna quantos dias tem o mes m informado
		
		if ((mes == 2) && (bissexto(ano))) {
			return 29;
		}

		if ((mes >=1) && (mes <=12)) {
			int meses [] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			return meses[mes-1];
		}

		return 0;	
	}
	
	static boolean mudaFormato(int f){ //testar
		
		if ( (f<0) || (f>4) ) return false;
		
		formato = f;
		separador = vetsep[formato];
		
		return true;
	}
	
	public boolean stringData(String s){ //testar
		/*
		 * A instancia que ativa este método deve assumir o valor 
		 * correspondente à string recebida como parâmetro. 
		 * A data passará pela consistencia, 
		 * retornará true para data OK, e false para data inválida.
		 */
		
		String strdata = getStringData(); 
		
		int k=0, 
			pos1 = 0,
			pos2 = 0;
		String sub1 = null, 
			   sub2 = null,sub3 = null;
		
		for (int i=0 ; i==strdata.length(); i++)
		{
   			if ((strdata.charAt(i) == separador) && (k==0)) {
   				sub1 = strdata.substring(0, i);
				pos1 = i;
				k++;
   			}
   			else if ((k==1) && (strdata.charAt(i) == separador)) {
   				sub2 = strdata.substring(pos1+1, i);
		        pos2 = i;
			   	k++;
		    }
   			else if (k == 2){
   				sub3 = strdata.substring(pos2+1);
   			}
			else 
   				return false;	        
		} 
		
		componentes[ vetfor[ formato ][0] ] = Integer.parseInt(sub1);
		componentes[ vetfor[ formato ][1] ] = Integer.parseInt(sub2);
		componentes[ vetfor[ formato ][2] ] = Integer.parseInt(sub3);
		return true;
		
	}
	
	public String dataString(){
		/*
		 * Retorna uma string a partir do conteúdo da instancia que 
		 * ativa o método, de modo que seja respeitado o formato
		 */
		return "15/02/2016";
	}	
	public Data soma(int dias){
		// Soma: Data + dias => Outra Data posterior em dias
		Data dt = new Data(12,3,2016);
		return dt;
	}
	public Data sub(int dias){
		//Subtração 1: Data – dias => Data anterior em dias
		Data dt = new Data(13,3,2016);
		return dt;
	}
	public long sub(Data d){
		//Subtração 2: Data – Data => dias decorridos entre as duas datas.
		long sub=1000;
		return sub;
	}
	
	//Metodos auxiliares privativos	
	@SuppressWarnings("unused")
	private long dataDias() {
		int bis = 0;											
		int noBis = 0;
		for(int anoInicial = 1900; anoInicial < this.componentes[2]; anoInicial++) {
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
		
		int diasMeses = 0;
		
		int mes = this.componentes[1];
		while (mes != 0) {
			
			diasMeses += diasMes(mes, this.componentes[2]);   //???;  	(variável diasMeses que conterá o valor do total de dias dos meses)
			mes--;		//	(problema: colocar outra variável com os dias de cada mes pra somar)
		}

		long totalDias = diasAnos + diasMeses + this.componentes[0];
		return totalDias;
	}
	
	@SuppressWarnings("unused")
	private void diasData(long d){
		/*
		 * A partir de d, que representa dias desde 1-jan-1900, 
		 * define o conteúdo da instancia que ativa o método
		 */
	}
	
	

}
