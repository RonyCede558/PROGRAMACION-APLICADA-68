package libreria_generica;

public class test implements operation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		generic<String, Integer>obj1=new generic("Programacion Aplicada", "Programacion Generica",1,2026);
				System.out.println(obj1.toString());
				obj1.setAttributeT2("Tercer Nivel");
				obj1.setAttributeS4(4);
				System.out.println(obj1.toString());
				test t=new test();
				t.oper();
	}
	private void oper() {
		System.out.println(maxNumber(4,5,8,5));
		System.out.println(sumatory(14,15,48));
	}

}
