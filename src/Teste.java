
public class Teste {

	//public void print(String parametro){
	//	System.out.println(parametro);
	//}
	public static void Teste1() {
		// TODO Auto-generated method stub

		
		Data data = new Data(14,3,2016);
		// bissexto ok
		System.out.println(Data.bissexto(data.componentes[2]));
		
		// Instancia da data ok
		System.out.println(""+data.componentes[0]+"-"+data.componentes[1]+"-"+data.componentes[2]);
		
		// Teste de DiasMes
		System.out.println(Data.diasMes(13, 2016));
		System.out.println(Data.diasMes(data.componentes[1], data.componentes[2]));
		
		
		Data dtbx = new Data(14,2,2016);
		System.out.println(Data.diasMes(dtbx.componentes[1], dtbx.componentes[2]));
	}
	public static void Teste2() {
		// TODO Auto-generated method stub
		
		Data data = new Data("23/34/2015");

		System.out.println(data.componentes[0]);
		System.out.println(data.componentes[1]);
		System.out.println(data.componentes[2]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Teste1();
		
		Teste2();
	}

}
