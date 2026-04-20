package ejercicio3_boxing_unboxing;

public class product {
	private generic<Integer>dt1_p;
	private generic<String>dt2_p;
	private generic<Double>dt3_p;
	
	public product() {
		this.dt1_p=null;
		this.dt2_p=null;
		this.dt3_p=null;
	}
	
	//boxing
	public product(int id,String name, int units, double price){
		dt1_p=new generic (Integer.valueOf(id), Integer.valueOf(units));
		dt2_p=new generic (name);
		dt3_p=new generic(Double.valueOf(price));
	}
	
	
	//Unboxing-Getters
	public int getId() {
		return dt1_p.getAttributeT1().intValue();//unboxing
	}
	
	@Override
	public String toString() {
		return "product [getId()=" + getId() + ", getName()=" + getName() + ", getUnits()=" + getUnits()
				+ ", getPrice()=" + getPrice() + "]";
	}

	public String getName() {
		return dt2_p.getAttributeT1();
	}
	
	public int getUnits() {
		return dt1_p.getAttributeT2().intValue();
	}
	
	
	public double getPrice() {
		return dt3_p.getAttributeT1().doubleValue();
	}
	
	//Boxing-Setters
	public void setUnits(int units) {
		dt1_p.setAttributeT2(Integer.valueOf(units));
	}
	
	public void setPrice(double price) {
		dt3_p.setAttributeT1(Double.valueOf(price));
	}
	
	
	}
