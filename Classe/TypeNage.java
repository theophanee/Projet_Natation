/*pattern singleton*/
public class TypeNage {
	private static String typeDeNage ;
	private static int cpt=0;
	private TypeNage() {/*constructeur privé pour ne pas pouvoir l'appelé*/
		cpt++;
	}
	public static String getTypeNage() {/*obtenir la nage*/
		return typeDeNage;
	}
	public static void setNage(String n) {/*attribuer la nage*/
		typeDeNage = n ;
	}
	
	public static int getCpt() {/*pour verifier qu'il n'y a bien qu'une seule instance de la classe créer*/
		return cpt;
	}
	

}
