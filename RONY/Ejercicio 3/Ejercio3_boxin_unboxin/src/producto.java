public class producto {
		private generic<Integer> dt1_p;
		private generic<String> dt2_p;
		private generic<Double> dt3_p;

		public producto(int id, String name, int units, double price) {
			dt1_p = new generic(Integer.valueOf(id), Integer.valueOf(units));
			dt2_p = new generic(name);
			dt3_p = new generic(Double.valueOf(price)); // boxing
		}

		public int getId() {
			return dt1_p.getAttributeT1().intValue();// unboxing
		}

		public int getUnits() {
			return dt1_p.getAttributeT2().intValue();
		}

		public String getName() {
			return dt2_p.getAttributeT1();
		}

		public double getPrice() {
			return dt3_p.getAttributeT1().doubleValue();
		}

		public void setUnits(int units) {
			dt1_p.setAttributeT2(Integer.valueOf(units));
		}

		public void setPrice(double price) {
			dt3_p.setAttributeT1(Double.valueOf(price));
		}

		@Override
		public String toString() {
			return "producto [dt1_p=" + dt1_p + ", dt2_p=" + dt2_p + ", dt3_p=" + dt3_p + ", getId()=" + getId()
					+ ", getUnits()=" + getUnits() + ", getName()=" + getName() + ", getPrice()=" + getPrice() + "]";
		}
	}


