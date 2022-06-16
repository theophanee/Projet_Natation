
/*creer des sportifs*/
public class Homme extends Nageur {
	
	/*Les Instances*/
	private String nom;
	private String prenom;
	private String pays;
	/*le temps en min sec ms*/
	private int min;
	private int sec;
	private int ms;
	private int positionI , positionJ ; /*positionner dans la piscine*/
	private boolean aNager = false ; /*savoir si l'athlete à sauter*/
	private boolean allee ;/*savoir si il est au retour*/
	private boolean fini ;/*savoir si il est arrivé*/

	
	public Homme(String pays , String nom , String prenom) {
		/*constructeur*/
		this.pays = pays;
		this.nom = nom;
		this.prenom = prenom;
		allee = false;
		fini = false ;
	
	}
	
	
	/*genre aleatoirement un entier*/
	public static int rendAlea( int inf , int sup ) {
		
		return (int)(Math.random() * ( sup - inf + 1 ) + inf );
	
	}
	
	
	public void temps_nage( String typeDeNage , int longueur ) {
		
		double coef = longueur * 0.0033 ;
		longueur = longueur / 100 ;
		
		if( typeDeNage == "papillon" ) {
			sec = rendAlea( 55 , 80 ) * longueur;
			sec += sec*coef ;
		}
		if( typeDeNage == "brasse" ) {
			sec = rendAlea( 64 , 90 ) * longueur;
			sec += sec*coef ;
		}
		if( typeDeNage == "dos" ) {			
			sec = rendAlea( 58 , 75 ) * longueur;
			sec += sec*coef ;
		}
		if( typeDeNage == "libre" ) {
			sec = rendAlea ( 53 , 90 ) * longueur;
			sec += sec*coef ;
		}
		else {
			sec = rendAlea( 53 , 72 ) * longueur;
			sec += sec*coef ;
		}
		
	}
	
	public void temps() {
		
		ms = (int)(Math.random()*100);
		min = sec / 60 ;
		sec = sec % 60 ;
	}
	
	
	public boolean testDopage() {
		
		System.out.println( "Verificaion anti-dopage de " + nom + " " + prenom );
		int doper = (int)(Math.random() * 60 ) ;
		return ( doper == 1 );
	}
	
	 
	
	public void position(int x , int y) {
		
		positionI = x ;
		positionJ = y ;
		
	}
	
	
	
	public void nage(String typeDeNage) {
		
		System.out.println(nom + " nage "+typeDeNage);
	
	}
	
	public void setANager( boolean b ) {
		aNager = b ;
		
	}
	
	
	public void setMin(int min) {
		this.min = min ;
		
	}

	public void setSec(int sec) {
		this.sec = sec ;
		
	}

	public void setMs(int ms) {
		this.ms = ms ;
		
	}
	
	public void setAllee( boolean  b ) {
		if ( this != null )
			allee = b ;
	}
	
	public void setFini( boolean b ) {
		if ( this != null )
			fini = b ;
	}

	
	public boolean getAllee() {
		
		return allee ;
	}
	
	public int getMin() {
		return min ;
	}
	
	public int getSec() {
		return sec ;
	}
	
	public int getMs() {
		return ms ;
	}
	
	public int getI() {
		return positionI;
	}
	
	public int getJ() {
		return positionJ;
	}
	
	public boolean getFini() {
		return fini;
	}
	
	/*retourne les informations du nageur*/
	public String toString() {
		
		if ( aNager == true ) {
			return "(" + pays + ") Nageur " + nom + " " + prenom + " a fait un temps de " + min + "min " + sec + "sec " + ms ;
		}
			
		return "(" + pays + ") Nageur " + nom + " " + prenom; 
	
	}





}
