package ejercicio3_boxing_unboxing;

public class main {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		generic<Integer>obj1=new generic();
//		generic<Double>obj2=new generic();
//		
//		obj1.setAttributeT1(100);//autoboxing
//		obj1.setAttributeT2(Integer.valueOf(100));//boxing
//		
//		int value1=obj1.getAttributeT1();//autoboxing
//		int value2=obj1.getAttributeT2().intValue();//unboxing
////		
//		product p=new product(101,"Teclado",10,8.99);
//		System.out.println(p.toString());
		
		System.out.println(calculo.sumatoria(1,3,6));
		System.out.println(calculo.sumatoria(3,4,67,8,4));
		double[]values= {2,3,5,6,7};
		System.out.println(calculo.sumatoria(values));
		
		
		System.out.println(calculo.maxNumber(3,5,6,56,7));
	}

}
