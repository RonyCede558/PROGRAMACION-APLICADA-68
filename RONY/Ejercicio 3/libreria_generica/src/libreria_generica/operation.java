package libreria_generica;

public interface operation<N extends Number> {

    public default N maxNumber(N... numbers) {
        N max = numbers[0];
        for (N n : numbers) {
            if (max.doubleValue() < n.doubleValue()) {
                max = n;
            }
        }
        return max;
    }

    public default double sumatory(N... numbers) {
        double res = 0.0;
        for (N n : numbers) {
            res += n.doubleValue();
        }
        return res;
    }

    // 🔽 MÍNIMO
    public default N minNumber(N... numbers) {
        N min = numbers[0];
        for (N n : numbers) {
            if (min.doubleValue() > n.doubleValue()) {
                min = n;
            }
        }
        return min;
    }

    // 🔽 PROMEDIO
    public default double average(N... numbers) {
        double suma = 0.0;
        for (N n : numbers) {
            suma += n.doubleValue();
        }
        return suma / numbers.length;
    }

    // 🔽 IVA (ejemplo: 12%)
   
    public default double iva(N value) {
        double porcentajeIVA = 0.12;
        return value.doubleValue() * porcentajeIVA;
    }
    
    public default double percent(N value, N percent) {
    	return (value.doubleValue()*percent.doubleValue())/100;
    }
}