
/**
 * @authores
 * 		ANGELICA ROCHA - 14201566
 * 	    ANDERSON SILVA - 15213661
 * 		CAROLINA LOPES - 14211778
 * 		DEVIDE         - 
 * 		JESSICA VILELA - 14201575
 * 		SILVIO LUIS JR - 14211811
 * 
 */
public class Data {
	// 0 - Britânico: DD/MM/AAAA
	// 1 - Americano: MM/DD/AAAA
	// 2 - Italiano : DD-MM-AAAA
	// 3 - Germânico: DD.MM.AAAA
	// 4 - ANSI     : AAAA.MM.DD
	
	//Variaveis de Classe	
	static int  formato   = 0;
	static char separador = '/';	
	static int termos[] = {0, 1, 2};
	
	//indice dos vetores abaixo correspondem ao separador e formato (entre 0 e 4) respectivo
	private static char vetsep[] = { '/' , '/' , '-' , '.' , '.' }; 
	private static char vetfor[][]  = { {0,1,2}, {1,0,2}, {0,1,2}, {0,1,2}, {2,1,0} };
	
	//Variaveis de instancia
	int  componentes[] = {0, 0, 0}; // dia, mes, ano

	//Construtores
	public Data(int dia, int mes, int ano){
		this.componentes[0] = dia;
		this.componentes[1] = mes;
		this.componentes[2] = ano;
		
		if (!ConsisteData() ){
			zeraComponentes();
		}
		
	}
	
	public Data(String data){
		
		if (!stringData(data)){
			zeraComponentes();
		}
		
	}
	public Data(Data d) {
		componentes[0] = d.componentes[0];
		componentes[1] = d.componentes[1];
		componentes[2] = d.componentes[2];		
	}
	
	//Metodos
	public boolean stringData(String s){
		/*
		 * A instancia que ativa este método deve assumir o valor 
		 * correspondente à string recebida como parâmetro. 
		 * A data passará pela consistencia, 
		 * retornará true para data OK, e false para data inválida.
		 */ 
		
		int k=0, 
			pos1 = 0,
			pos2 = 0;
		String sub1 = null, 
			   sub2 = null,sub3 = null;
		
		for (int i=0 ; i==s.length(); i++) {
   			if ((s.charAt(i) == separador) && (k==0)) {
   				sub1 = s.substring(0, i);
				pos1 = i;
				k++;
   			}
   			else if ((k==1) && (s.charAt(i) == separador)) {
   				sub2 = s.substring(pos1+1, i);
		        pos2 = i;
			   	k++;
		    }
   			else if (k == 2){
   				sub3 = s.substring(pos2+1);
   			}
			else 
   				return false;
   			
		} 
		// Chegando aqui, os separadores estao ok
		// chamaremos o restante da consistencia
		this.componentes[0] = Integer.parseInt(sub1);
		this.componentes[1] = Integer.parseInt(sub2);
		this.componentes[2] = Integer.parseInt(sub3);
		
		return ConsisteData();		
	}
	
	public String dataString(){
		/*
		 * Retorna uma string a partir do conteúdo da instancia que 
		 * ativa o método, de modo que seja respeitado o formato
		 */
		return  "" 	+ this.componentes[ vetfor[ formato ][0] ] + vetsep[formato]
				    + this.componentes[ vetfor[ formato ][1] ] + vetsep[formato]
				    + this.componentes[ vetfor[ formato ][2] ];
	}	
	
	@SuppressWarnings("unused")
	private long dataDias() {
		/* Fornece um valor long que significa o nº de dias decorridos desde 
		 * 1 de janeiro de 1900 até a data conteúdo da instancia
		 */
		int bis = 0;
		int noBis = 0;
		
		for(int ano = 1900; ano < this.componentes[2]; ano++) {			
			if ( bissexto(ano) ) bis+=1;			
			else noBis+=1;
		}
		int diasAnos = (bis * 366) + (noBis * 365);
		
		int diasMeses = 0;
		for (int mes=1; mes< this.componentes[1]; mes++){					
			diasMeses += diasMes(mes);
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
		int dia = 1;
		int mes = 1;
		int ano = 1900;
		
		for (long dias = d; dias > 1; dias--) {
	        int diasNoMes = diasMes(mes,ano);
	        
	        if (dia < diasNoMes) dia++;
	        else if (mes < 12) {
	            dia = 1;
	            mes++;
	        } else {
	            dia = 1;
	            mes = 1;
	            ano++;
	        }
	    }
		
	}
	
	private void zeraComponentes(){
		
		for (int i=0;i<=2;i++) {
			this.componentes[i] = 0;	
		}
		
	}

	//Metodos 
	public boolean ConsisteData(){
		// Esse método efetua validações, retorna True se for uma data válida
		int dia = this.componentes[0];
		int mes = this.componentes[1];
		int ano = this.componentes[2];
		
		int diasM = diasMes(mes,ano);
				
		return ( diasM!=0 && (dia >0 && dia <= diasM) );
	}
		
	static boolean bissexto(int ano){ 
		
		return ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0));
		
	}	

	static int diasMes(int mes){
		//Retorna quantos dias tem o mes m informado e 0 quando houver erro
		
		if ((mes >=1) && (mes <=12)) {
			int meses [] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			return meses[mes-1];
		}

		return 0;
	}
	
	static int diasMes(int mes, int ano){
		/* Retorna quantos dias tem o mes informado, considerando o ano para
		 * checagem de bissexto.
		 * Qualquer erro é retornado zero. 
		 */	
		int meses [] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		if ( (mes == 2) && ( bissexto(ano) ) ) return 29;		
		if ( (mes >= 1) && ( mes <=12) )       return meses[mes-1];
		
		return 0;
	}
	
	static boolean mudaFormato(int f){
		
		if ( (f<0) || (f>4) ) return false;
		
		formato = f;
		separador = vetsep[formato];
		
		return true;
	}
		
	public Data soma(int dias){
		// Soma: Data + dias => Outra Data posterior em dias
		int dia = this.componentes[0];
		int mes = this.componentes[1];
		int ano = this.componentes[2];
		
        for (int idia = dias; idia > 1; idia--) {
            int diasNoMes = diasMes(mes,ano);
            
            if (dia < diasNoMes) dia++;
            else if (mes < 12) {
                dia = 1;
                mes++;
            } 
            else {
                dia = 1;
                mes = 1;
                ano++;
            }
        }
        return new Data(dia, mes, ano);
	}
	
	public Data sub(int dias){
		int dia = this.componentes[0];
		int mes = this.componentes[1];
		int ano = this.componentes[2];
        
        for (int idia = dias; idia > 1; idia--) {
            
        	if (dia > 1) dia--;
            else if (mes > 1) {
                mes--;
                dia = diasMes(mes,ano);
            } else {
                ano--;
                mes = 12;
                dia = 31;
            }        	
        }
        
        return new Data(dia, mes, ano);
	}
	
	public long sub(Data d){
		//Subtração 2: Data – Data => dias decorridos entre as duas datas.
        long diasDiff = 0;
        int dia = d.componentes[0];
        int mes = d.componentes[1];
        int ano = d.componentes[2];
        
        int idia = this.componentes[0];
        int imes = this.componentes[1];
        int iano = this.componentes[2]; 
        
        if (ano < iano || (ano == iano && mes < imes) || 
           (ano == iano && mes == imes && dia < imes)) {
            return diasDiff;
        }
        
        while (dia != idia && mes != imes && ano != iano) {
            if (dia > 1) {
                dia--;
                diasDiff++;
            } else if (mes > 1) {
                mes--;
                dia = diasMes(mes,ano);
                diasDiff++;
            } else {
                ano--;
                mes = 12;
                dia = 31;
                diasDiff++;
            }
        }
        
        return diasDiff;
	}
	
	

}
