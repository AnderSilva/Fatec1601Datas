
public class Teste {

	//public void print(String parametro){
	//	System.out.println(parametro);
	//}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Data data = new Data(14,3,2016);
		// bissexto ok
		System.out.println(Data.bissexto(data.ano));
		// Instancia da data ok
		System.out.println(""+data.ano+"-"+data.mes+"-"+data.dia);
		// Teste de DiasMes
		System.out.println(Data.diasMes(13, 2016));
		System.out.println(Data.diasMes(data.mes, data.ano));
		
		Data dtbx = new Data(14,2,2016);
		System.out.println(Data.diasMes(dtbx.mes, dtbx.ano));
	}

}
