package ejercicio3_boxing_unboxing;

public class generic <T>{
	private T attributeT1;
	private T attributeT2;

	public generic() {
		super();
		this.attributeT1=null;
		this.attributeT2=null;
	}
	
	public generic(T attributeT1) {
		super();
		this.attributeT1 = attributeT1;
	}

	public generic(T attributeT1, T attributeT2) {
		super();
		this.attributeT1 = attributeT1;
		this.attributeT2 = attributeT2;
	}

	public T getAttributeT1() {
		return this.attributeT1;
	}
	public void setAttributeT1(T attribute) {
		this.attributeT1 = attribute;
	}
	
	public T getAttributeT2() {
		return this.attributeT2;
	}
	
	public void setAttributeT2(T attribute) {
		this.attributeT2=attribute;
	}
	
	@Override
	public String toString() {
		return "generic [attributeT1=" + attributeT1 + ", attributeT2=" + attributeT2 + "]";
	}

	
	
	
	
}
