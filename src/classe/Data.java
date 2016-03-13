package classe;
/**
 * 
 */

/**
 * @author 
 *
 */
public class Data {
	//Variaveis de Classe
	static int formato = 0;
	static String separador = "/";
	
	//Variaveis de instancia
	
	//Construtores
	public Data(){}
	public Data(int dia, int mes, int ano ){
		
	}
	public Data(Data d) {
		
	}
	
	
	
	//Metodos 
	
	static boolean mudaFormato(int f){
		// retorna false se o formato for invalido
		return false;
	}
	
	
	static boolean bissexto(int ano){
		return false;
	}
	static int diasMes(int m){
		//Retorna quantos dias tem o mes m informado
		
		//if mes = 2 e ano for bissexto , return 29
		//else , caso normal , abaixo:
		
		int meses [] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		return meses[m];		
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
	private long dataDias(){
		/*
		 * Fornece um valor long que significa o nº de dias 
		 * decorridos desde 1 de janeiro de 1900 até a data conteúdo da instancia.
		 */
		long dias=1000;
		return dias;
	}
	
	private void diasData(long d){
		/*
		 * A partir de d, que representa dias desde 1-jan-1900, 
		 * define o conteúdo da instancia que ativa o método
		 */
	}
	
	

}
