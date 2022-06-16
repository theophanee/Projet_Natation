/*permet de gérer les exceptions*/

public class MyException extends Exception {


	public MyException(String s ) {/*constructeur*/
		super(s);
	}
	
	public MyException() {/*gerer le temps*/
		super("Attention il y a un problème de chrono");
	}
	
	public MyException( int n ) {/*gerer le nombre de couloirs*/
		super( "La limite n'est pas respecter, choisissez un nombre entre 3 et 8 " );
		
	}
	
	public MyException( Piscine p1 , Piscine p2 ) {/*gerer si un clonage a bien fonctionner*/
		super ( "Le clonage n'a pas fonctionner \n"  );
	}

}
