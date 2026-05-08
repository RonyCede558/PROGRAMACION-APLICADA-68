package ejercicio1_patternMatcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * ER=^(0|1)*(0.1)$
		 * ER=[A-Z][a-z]{3,5}[a]
		 */
//		Pattern patron=Pattern.compile("^[A-Z][a-z]{3,6}[a]$");
//		String cadenas=("Carolina Pamela Sol Fernanda Juliana Marissa Carlos");
//		String[] palabras =cadenas.split("\s");
//		for(String p:palabras) {
//			Matcher analisis=patron.matcher(p);
//			if(analisis.find()) {
//				System.out.println(analisis.group());
//			}
//		}
//		Matcher analisis=patron.matcher("");
//		System.out.println(analisis.replaceAll("Accept"));
		
		Pattern patron=Pattern.compile("^[A][a-z]*[s]$");
		String cadenas=("Amirs Asmodeus Camila ");
		String[] palabras = cadenas.split("\s");
		for(String p:palabras) {
			Matcher analisis=patron.matcher(p);
			if(analisis.find()) {
				System.out.println(analisis.group());
			}
		}
		
	
	}

}
