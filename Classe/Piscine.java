
/*creer une piscine*/
public class Piscine{
	
	/*Les Instances*/
	private int temperature;/*temperature de l'eau*/
	protected Athlete[] nageurs;/*tableau qui contient les nageurs dans la piscine*/
	private int nbNageur = 0;
	private int nbNageurTab = 0 ;
	private int nbcouloirs;
	private static int cpt = 0;/*compteur static pour avoir le nombre d'instances de Piscine*/
	private int numero;/*prendra son identifiant*/
	private String[][] tab;/*tableau 2D qui permet de visualiser la simulation*/
	private int taille;
	private String typeDeNage;
	private int longueur;/*longueur de la piscine*/
	
	private int place = 0 ;/*position classement*/
	private Athlete[] classement ;/*tableau pour les gagnants*/
	
	private int[] tabSec ; /*tableau qui prend l'ensemble des chronos*/
	private int iSec = 0 ;/*position dans le tableau du temps*/
	
	
	public Piscine( int temp , int couloirs ) {/*constructeur*/
		cpt++;
		numero=cpt;/*prend son identifiant*/
		
		/*initialise la temperature de l'eau ainsi que le nombres de couloirs de la piscine, donc son nombre de nageurs, de temps,etc*/
		temperature = temp;
		nbcouloirs = couloirs;
		nageurs = new Athlete[nbcouloirs];
		
		tabSec = new int[nbcouloirs];
		
		classement = new Athlete [ nbcouloirs ];
		
		taille = couloirs * 2 - 1 ;
		tab = new String [taille][85];
		
		for( int i=0 ; i < taille ; i++ ) {/*creer le tableau 2D*/
			
			tab[i][0] = "|" ;
			tab[i][tab[i].length-1] = "|" ;
			
			for( int j=1 ; j < tab[i].length-1 ; j++ ) {
				
				if( i % 2 != 0 ) {
					if( j % 7 == 0 ) {
						tab[i][j] = "o" ;
					}else {
						tab[i][j] = "-" ;
					}
				}
				else {
					tab[i][j] = " " ;
				}

				
			}
		}
		
	}
	
	/*accesseur  sur cpt*/
	public static int nombrePiscine() {
		
		return cpt;
	}
	
	/*affiche la piscine*/
	public void afficherPiscine() {
		
		
		System.out.println("\n\n\n\n|===================================================================================|");
		for( int i=0 ; i < taille ; i++ ) {
			for( int j=0 ; j < tab[i].length ; j++ ) {
				System.out.print( tab[i][j] );
			}System.out.println();
		}System.out.print("|===================================================================================|\n\n\n\n");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/*methode de clonage*/
	public Piscine clone() {
		
		return new Piscine( this.temperature , this.nbcouloirs );
		
	}
	
	/*savoir si la piscine est pleine ou non*/
	public boolean piscinePleine() {
		
		return ( nbNageur < nbcouloirs ) ;
	
	}
	
	/*ajoute le nageur en argument à la piscine*/
	public void ajouteNageur( Athlete a ) throws TabPlein{/*gere l'exception si le tableau est plein*/
		
		if( piscinePleine() ) {
			
			if ( a != null ) {
			
				
				nageurs[nbNageur] = a ;
				nbNageur++;
				
			}
			
		}else{
			throw new TabPlein("Piscine pleine");
		}
	
	}
	
	/*fait nager les nageurs*/
	/*affiche le type d'epreuve etc*/
	public void faireNager( String typeDeNage , int longueur) {
		
		this.typeDeNage = typeDeNage ;
		this.longueur = longueur ;
		
		System.out.println("______________________________________________________________________________________\n");
		
		System.out.println("\nPiscine " + numero );
		
		System.out.println("Epreuve : " + longueur + " mètres nage " +typeDeNage + "\n");
		
		for( int i=0 ; i < nbNageur ; i++ ) {
			
			if ( nageurs[i] != null ) {
				
				nageurs[i].nage( typeDeNage );
				((Nageur) nageurs[i]).temps_nage( typeDeNage , longueur );
				
				tabSec[ iSec ] = nageurs[i].getSec(); iSec ++ ;
				
				
			}

			
		}
	}
	
	/*simule une course*/
	/*deplace les nageurs dans la piscine*/
	/*gere les allees retour*/
	public void courses() {
		
		for( int i =0 ; i < nbNageur ; i++ ) {
			
			int nage = (int)( Math.random() * 5 ) ;/*entier aleatoire qui permet de savoir si le nageur avance ou non*/
			/*se qui permet de ne pas avoir tout les nageurs à la meme vitesse dans la piscine*/
			
			
			if ( nage != 1 && nageurs[i] != null && nageurs[i].getAllee() == false ) {
				
				tab[ nageurs[i].getI() ][ nageurs[i].getJ() ] = " " ;
				
				nageurs[i].position( nageurs[i].getI() , nageurs[i].getJ() + 1 ) ;
				tab[ nageurs[i].getI() ][ nageurs[i].getJ() ] = "X" ;
				
				
			}
			
			if ( nageurs[i] != null && nageurs[i].getJ()  == 83  ) {
				nageurs[i].setAllee( true );
			}
			
			
			if ( nage != 1 && nageurs[i] != null && nageurs[i].getAllee() == true && retour ( nageurs[i] ) == true ) {
				
				tab[ nageurs[i].getI() ][ nageurs[i].getJ() ] = " " ;
					
				nageurs[i].position( nageurs[i].getI() , nageurs[i].getJ() - 1 ) ;
				tab[ nageurs[i].getI() ][ nageurs[i].getJ() ] = "X" ;
				
				nageurs[i].setAllee( true );
				
				
			}	
		}
	}
	
	/*savoir si des nageurs ont finileur course*/
	/*leur attribue une position d'arrivée*/
	public void arriver() {
			
		for( int i = 0 ; i < nbNageur ; i ++ ) {
				
			if  ( nageurs[i] != null &&  nageurs[i].getAllee()  == true && nageurs[i].getJ() == 1 && nageurs[i].getFini()  == false ) {
				
				nageurs[i].setFini( true );
				System.out.println (nageurs[i].toString() + " est arrivée ! ");
				nageurs[i].setANager( true );
				donneTemps( nageurs[i] , tabSec );
				System.out.println(nageurs[i].toString());
					
				classement[ place ] = nageurs[i] ;
				place ++ ;
			}
		}
	}
	


	/*retourne le meilleur temps dans le tableau des temps, pour le donner au premier arriver*/
	public int meilleurTemps( int[] tab ) {
		
		int rang = 0 ;
		
		for( int i = 1 ; i < tab.length ; i++ ) {
			
			if( tab[rang] >= tab[i] && tab[i] != 0 ) {
				
				rang = i ;
			}
			
		}return rang ;
	}
	

	/*donne le meilleur temps au nageur arrivé*/
	public void donneTemps( Athlete a , int[] tabSec ) {
		
		
		a.setSec( tabSec [ meilleurTemps( tabSec ) ] );
		a.temps();
		tabSec[ meilleurTemps( tabSec ) ] = 10000 ;
		
	}
	
	/*savoir si tout les nageurs sont arrivés*/
	public boolean fin() {
		
		for(int i = 0 ; i < nbNageur ; i++ ) {
			
			if( nageurs[i] != null && ( nageurs[i].getAllee()  == false || nageurs[i].getJ() != 1 ) ) {
				return false;
			}
			
		}
		return true;
	}
	
	/*savoir si il est à allee ou au retour*/
	public boolean retour( Athlete a ) {
		
		return ( a.getJ() > 1 );
	
	}
	
	/*teste l'ensemble des nageurs */
	public void testdopage() {
		
		System.out.println("\nPiscine " + numero );
		
		for( int i =0 ; i < nbNageur ; i++ ) {
			/*si un nageur est positif au test, il est disqualifier et retirer de la course*/
			if ( nageurs[i].testDopage() == true ) {
				System.out.println( nageurs[i].toString()  + " est disqualifier pour dopage ! " );
				nageurs[i] = null ;
				
			}
			if ( nageurs[i] != null ) {
				
				nageurs[i].position( nbNageurTab , 1 ) ;
				tab[ nageurs[i].getI() ][ nageurs[i].getJ() ] = "X" ; 
				
			}
			nbNageurTab += 2 ;

		}
		
		
		
	}

	
	/*informations de la piscine*/
	public String toString() {
		
		String p = "\nPiscine " + numero + " :\n";
		
		for( int i=0 ; i < nbNageur ; i++ ) {
			
			if ( nageurs[i] != null ) {
				
				p += "Couloir " + (i+1) + " : " + nageurs[i].toString()+"\n";
			}
			
		}
		
		return p ;
	}
	
	/*retourne le classement final*/
	public String resultas() {
		
		String res = "Classement Final pour le " + longueur + "m " + typeDeNage + " : \n\n" ;
		
		for( int i = 0 ; i < place ; i++ ) {
			res += "Position " + ( i + 1 ) + " : " + classement[i].toString() +"\n" ;
			classement[i].setANager( false );
		}
		return res ;
		
	}
	
	/*retourne les recompenses aux gagnants*/
	public String recompenses() {
		String s= "\n\n\nRECOMPENSES" ;
		
		if(classement[0] != null ) {
			s += "\n\nMedaille d'Or : \n" + classement[0].toString();
		}if(classement[1] != null ) {
			s += "\n\nMedaille d'Argent :\n" + classement[1].toString();
		}if(classement[2] != null ) {
			s += "\n\nMedaille de Bronze :\n" + classement[2].toString() ;
		}
		
		return s ;
		
	}

	

}
