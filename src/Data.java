
/**
 * @author 
 *
 */
public class Data {
	//Variaveis de Classe
	static int formato = 0;
	static String separador = "/";
	int ano = 0;
	int mes = 0;
	int dia = 0;
	
	//Variaveis de instancia
	
	//Construtores
	public Data(){}
	public Data(int dia, int mes, int ano ){
		this.ano = ano;
		this.mes = mes;
		this.dia = dia;
	}
	public Data(Data d) {
		
	}
	
	
	
	//Metodos 
	
	static boolean mudaFormato(int f){
		// retorna false se o formato for invalido
		return false;
	}
	
	
	static boolean bissexto(int ano){
		if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
			return true;
		}
		return false;
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
	
	
	public boolean stringData(String s){
		/*
		 * A instancia que ativa este método deve assumir o valor 
		 * correspondente à string recebida como parâmetro. 
		 * A data passará pela consistencia, 
		 * retornará true para data OK, e false para data inválida.
		 */
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
		Data dt = new Data();
		return dt;
	}
	public Data sub(int dias){
		//Subtração 1: Data – dias => Data anterior em dias
		Data dt = new Data();
		return dt;
	}
	public long sub(Data d){
		//Subtração 2: Data – Data => dias decorridos entre as duas datas.
		long sub=1000;
		return sub;
	}
	
	//Metodos auxiliares privativos	
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
			diasMeses += diasMes(mes);   //???;  	(variável diasMeses que conterá o valor do total de dias dos meses)
			mes--;		//	(problema: colocar outra variável com os dias de cada mes pra somar)
		}

		//long totalDias = diasAnos + diasMeses + dia;
		return 100;
	}
	
	private void diasData(long d){
		/*
		 * A partir de d, que representa dias desde 1-jan-1900, 
		 * define o conteúdo da instancia que ativa o método
		 */
	}
	
	

}
