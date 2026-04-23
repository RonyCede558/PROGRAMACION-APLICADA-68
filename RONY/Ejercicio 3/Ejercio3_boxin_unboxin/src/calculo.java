

public class calculo {

	public static double sumatoria(double...values) {
		double value=0.0;
		for(double v:values) {
			value+=v;
		}
		return value;
	}
	 public static  double maxNumber(double...values) {
	    double max = values[0]; // asumimos que el primero es el mayor

	    for (double v : values) {
	        if (v > max) {
	            max = v;
	        }
	    }

	    return max;
	}
}
