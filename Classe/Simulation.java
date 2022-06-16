/*simulation (le main)*/

import java.util.InputMismatchException;
import java.util.Scanner;
public class Simulation {
	
	public static void coucou() throws MyException{/*petit test d'exceptions*/
		throw new MyException("Lancement de la Simulation");
	}

	
	public static void verifieTemps( Piscine p ) throws MyException {/*permet de verifier si les temps sont correctes*/
		
		for( int i = 0 ; i < p.nageurs.length ; i++ ) {
			
			if ( p.nageurs[i] != null ){
			
				if ( p.nageurs[i].getMin() >60 || p.nageurs[i].getSec() > 60 || p.nageurs[i].getSec() <0 || p.nageurs[i].getMin() < 0 ) {
					throw new MyException();
				}
			}
		}	
	}
	
	public static void verifieScanner( String s ) throws ScannerException {/*gere les exceptions de scanner string*/
		
		if ( !s.equals("crowl") && !s.equals("dos") && !s.equals("brasse") && !s.equals("papillon") && !s.equals("libre")  ) {
			throw new ScannerException( "Porblème de lecture \"" + s + "\" veuillez ecrire comme suit : \ndos , papillon , crowl , libre , brasse " );
		}
	}
	
	public static void verifieScanner( int n, String typeScanne) throws ScannerException{/*gere les exceptions d'entiers*/
		
	/*le typeScanne sert à savoir quelle exception on veut gerer*/
		if( typeScanne == "longueur" && n != 100 && n != 200 && n != 400) {/*ici la longueur de l'épreuve*/
			throw new ScannerException("Pobleme de lecture, veuillez ecrire comme suit :\n100 , 200 , 400");
		}
		
		if( typeScanne == "couloirs" && n != 3 && n != 4 && n != 5 && n != 6 && n != 7 && n != 8) {
			throw new ScannerException("Pobleme de lecture, veuillez choisir un nombre donné");
		}
		
		if( typeScanne == "piscine" && n != 1 && n != 2 && n != 3 && n != 4 ) {
			throw new ScannerException("Problème de lecture, veuilez choisir un chiffre de 1 à 4");
		}
		
	}
	
	public static void temp( int n ) throws MyException{/*gere la temperature de l'eau*/
		
		if ( n < 23 || n > 28 ) {
			throw new MyException( "La temperature doit respecter les bornes [ 23 ; 28 ]" );
		}
		System.out.println( "Les piscines sont chauffées à " + n + "°C "  );
	
	}
	
	public static void coul( int n ) throws MyException{/*gere le nombre de couloirs*/
		
		if ( n > 2 && n < 9 ) {
			System.out.println( "Il y a " + n + " couloirs" );
			
		}else {
			throw new MyException ( n );
		}
	}
	
	public static boolean verificationClonage( Piscine p1 , Piscine p2 ) throws MyException {
		
		return ( p1.equals( p2 ) );
	}

	
	
	public static void main(String[] args) throws ScannerException {
		
		int done = 0 ;/*variable qui servira pour les test de Scanner*/
		
		try {
			coucou();
		}catch(MyException e) {
			System.out.println(e.getMessage());
		}
		
		
		Scanner s = new Scanner (System.in );
		
		System.out.println( "Saisir le nombre de couloirs des piscines ( 3 à 8 ) :" );
		int nbCouloirs = 0;
		
		
		while( done != 1) {/*tant que le scanner n'obtient pas une bonne valeur, il continue de demandé à l'utilisateur de choisir*/
			
			try {
				nbCouloirs = s.nextInt();
				coul( nbCouloirs );
				done = 1;
			}catch ( MyException nn ) {/*si la valeur n'est pas celle espéré*/
				System.out.println( nn.getMessage() ) ;
					
			}
			catch (InputMismatchException s3) {/*si la valeur n'est pas un int*/
				s.nextLine();
				System.out.println("Saisi non correcte, veuillez choisir un nombre de couloirs valide (3 à 8) ");
			}
			
		}
		

		
		
		

		System.out.println( "Saisir la température de l'eau (entre 23 et 28 °C) :" );
		int temperature = 0;
		
		while( done != 2) {
			
			try {
				temperature = s.nextInt();
				
				temp( temperature );
				done = 2 ;
			}catch (MyException c ) {
				s.nextLine();
				System.out.println( c.getMessage() );
			
			}catch (InputMismatchException s3) {
				s.nextLine();
				System.out.println("Veuillez choisir un entier ");
				
				
			}
			
		}
		

		Piscine piscineHomme=new Piscine( temperature , nbCouloirs );
		Piscine piscineHomme2 = piscineHomme.clone();
		
		try {
			verificationClonage ( piscineHomme , piscineHomme2 );
		}catch ( MyException p ) {
			System.out.println( p.getMessage() );
		}
	
		
		
		
		Piscine piscineFemme=new Piscine( temperature , nbCouloirs );/*crée les piscines*/
		
		
		Piscine piscineFemme2=piscineFemme.clone();
		
		
		Homme[] tabHomme1 = new Homme[8];
		tabHomme1[0] = new Homme("USA","PHELPS","Michael");
		tabHomme1[1] = new Homme("CHN","YANG","Sun");
		tabHomme1[2] = new Homme("ITA","PALTRINIERI","Gregorio");
		tabHomme1[3] = new Homme("FRA","MANAUDOU","Florent");
		tabHomme1[4] = new Homme("BEL","TIMMERS","Pieter");
		tabHomme1[5] = new Homme("RSA","LE CLOS","Chad");
		tabHomme1[6] = new Homme("GBR","PEATY","Adam");
		tabHomme1[7] = new Homme("AUS","LARKIN","Mitch");

		for ( int i = 0 ; i < nbCouloirs ; i ++ ){/*ajoute les nageurs en fonction du nombre de couloirs choisis*/
			try {
				piscineHomme.ajouteNageur( tabHomme1[i] );
			}catch (TabPlein tt){/*gere les sortis de taille*/
				System.out.println(tt.getMessage());
			}
		}


		Homme[] tabHomme2 = new Homme[8];
		tabHomme2[0] = new Homme("AUS","CHALMERS","Kyle");
		tabHomme2[1] = new Homme("RUS","CHUPKOV","Anton");
		tabHomme2[2] = new Homme("KAZ","BALANDIN","Dmitriy");
		tabHomme2[3] = new Homme("SIN","SCHOOLING","Joseph");
		tabHomme2[4] = new Homme("HUN","CSEH","LASZLO");
		tabHomme2[5] = new Homme("JPN","MASATO","Sakai");
		tabHomme2[6] = new Homme("GRE","YIANNIOTIS","Spyridon");
		tabHomme2[7] = new Homme("NED","WEERTMAN","Ferry");

		for ( int i = 0 ; i < nbCouloirs ; i ++ ){
			try {
				piscineHomme2.ajouteNageur( tabHomme2[i] );
			}catch (TabPlein tt2){
				System.out.println(tt2.getMessage());
			}
		}
		
		
		
		Femme[] tabFemme = new Femme[8];
		tabFemme[0] = new Femme("DAN","BLUME","Pernille");
		tabFemme[1] = new Femme("CAN","OLEKSIAK","Penny");
		tabFemme[2] = new Femme("USA","LEDECKY","Katie");
		tabFemme[3] = new Femme("SWE","SJOSTROM","Sarah");
		tabFemme[4] = new Femme("GBR","CARLIN","Jazmin");
		tabFemme[5] = new Femme("AUS","MCKEON","Emma");
		tabFemme[6] = new Femme("CHN","UANHUI","Fu");
		tabFemme[7] = new Femme("RUS","EFIMOVA","Yuliya");

		for ( int i = 0 ; i < nbCouloirs ; i ++ ){
			try {
				piscineFemme.ajouteNageur( tabFemme[i] );
			}catch (TabPlein ff){
				System.out.println(ff.getMessage());
			}
		}



		Femme[] tabFemme2 = new Femme[8];
		tabFemme2[0] = new Femme("HUN","KAPAS","BOGLARKA");
		tabFemme2[1] = new Femme("ESP","BELMONTE","Mireia");
		tabFemme2[2] = new Femme("ITA","BRUNI","Rachele");
		tabFemme2[3] = new Femme("NED","VAN ROUWENDAAL","Sharon");
		tabFemme2[4] = new Femme("BRA","OKIMOTO","Poliana");
		tabFemme2[5] = new Femme("ITA","BRUNI","Rachele");
		tabFemme2[6] = new Femme("JPN","SHIWEN","Ye");
		tabFemme2[7] = new Femme("FRA","MUFFAT","Camille");

		for ( int i = 0 ; i < nbCouloirs ; i ++ ){
			try {
				piscineFemme2.ajouteNageur( tabFemme2[i] );
			}catch (TabPlein ff){
				System.out.println(ff.getMessage());
			}
		}
		
		System.out.println( "\nTest dopage des athlètes" );
		piscineHomme.testdopage();
		piscineHomme2.testdopage();
		piscineFemme.testdopage();
		piscineFemme2.testdopage();
		
		System.out.println("\nPrésentation :\n\nIl y a "+ Piscine.nombrePiscine() + " piscines olympiques avec 8 couloirs maximum" );

		

		/*presentation des piscines avec les parametres choisis*/
		
		
		piscineHomme.afficherPiscine();
		System.out.println( piscineHomme.toString() );
		
		
		piscineHomme2.afficherPiscine();
		System.out.println( piscineHomme2.toString() );
		
		
		piscineFemme.afficherPiscine();
		System.out.println( piscineFemme.toString() );
		
		
		piscineFemme2.afficherPiscine();
		System.out.println( piscineFemme2.toString() + "\n\n" );


		System.out.println( "Saisir la piscine \n( 1 : première piscine pour homme , 2 : deuxième piscine pour homme , 3 : première piscine pour femme , 4 : deuxième piscine pour femme)" );
		int numPiscine = 0;
		
		/*demande de choisir une des piscines présentées*/
		while( done != 3) {
			
			try {
				numPiscine = s.nextInt();
				verifieScanner( numPiscine , "piscine" );
				done = 3 ;
			}catch (ScannerException s3) {
				System.out.println(s3.getMessage());

			}catch (InputMismatchException s3) {
				s.nextLine();
				System.out.println("Saisie non correcte, veuillez choisir un entier de 1 à 4 ");
				
				
			}
			
		}
		
		

		
		
		System.out.println("Choisir la longueur \n( 100m / 200m / 400m ) ");
		int longueur = 0;
		
		while( done != 4) {
			
			try {
				longueur = s.nextInt();
				verifieScanner( longueur , "longueur" );
				done = 4 ;
			}catch (ScannerException s2) {
				System.out.println(s2.getMessage());	

			}catch (InputMismatchException s3) {
				s.nextLine();
				System.out.println("Saisie non correcte, veuillez choisir un entier de une longueur de 100, 200 ou 400m ");
				
				
			}
			
		}
		

		
		Scanner ss = new Scanner (System.in);
		
		System.out.println( "Choisir l'épreuve\n( papillon , brasse , dos , crowl , libre )" ) ;
		String typeNage = "";
		
		
		while( done != 5 ) {
			
			try {
				typeNage = ss.nextLine();
				verifieScanner( typeNage );
				done = 5 ;
			}catch (ScannerException s1) {
				System.out.println(s1.getMessage());
			
			}catch (InputMismatchException s3) {
				s.nextLine();
				System.out.println("Saisie non correcte, veuillez choisir une nage (crowl, brasse, dos, papillon ou libre) ");
				
				
			}
			
		}
		
		TypeNage.setNage(typeNage);
		System.out.println("\nNage : " + TypeNage.getTypeNage());
		

		/*informe sur la taille de la piscine, en fonction de l'épreuve choisi, (pour plus de lisibilité en terme d'échelle)*/
		if( longueur == 100 ) {
			System.out.println( "Piscine de 50 mètres de longueur" ) ;
		}
		if( longueur == 200 ) {
			System.out.println( "Piscine de 100 mètres de longueur" ) ;
		}
		if( longueur == 400 ) {
			System.out.println( "Piscine de 200 mètres de longueur" ) ;
		}

		System.out.println("\nL'épreuve va bientot commencé, prenez part des informartions données au dessus");
		
		
		/*permet à l'utilisateur une petite pause pour lire les informations fournies ci dessus avant le début de l'épreuve*/
		try {
			Thread.sleep(20000);
		}catch(InterruptedException i) {
			System.out.println("InterruptedException\n");
		}

		/*chrono avant le départ*/
		try {
			Thread.sleep(500);
			System.out.println("\n3\n");
			Thread.sleep(500);
			System.out.println("2\n");
			Thread.sleep(500);
			System.out.println("1\n");
			Thread.sleep(500);
			System.out.println("GO !\n");
		}catch(InterruptedException i) {
			System.out.println("InterruptedException\n");
		}

		
		
		
		/*choisi une simulation en fonction de la piscine choisi*/
		if( numPiscine == 1 ) {
			
			piscineHomme.faireNager( TypeNage.getTypeNage() , longueur );/*fait nager les athletes*/
			piscineHomme.afficherPiscine();/*affiche une première fois la piscine*/
			
			for ( int i = 0 ; i < 250 && piscineHomme.fin() == false ; i ++ ) {/*tant que tout les nageurs ne sont pas arrivés*/
				
				piscineHomme.courses();/*les deplaces*/
				piscineHomme.arriver();/*verifie les arrivées*/
				
				if( i % 6 == 0 ) {/*affiches la piscine toutes les 6 itérations, plus de lisibilité*/
					piscineHomme.afficherPiscine();
				}
				
			}piscineHomme.afficherPiscine();/*affiche à la fin*/
			
			try {
				verifieTemps( piscineHomme );/*verifie les temps*/
			}catch(MyException t) {
				System.out.println(t.getMessage());
			}
			
			
			System.out.println( piscineHomme.resultas() );/*affiche les resultats et les recompenses*/
			System.out.println( piscineHomme.recompenses() );
		}
		
		if( numPiscine == 2 ) {
			
			piscineHomme2.faireNager( TypeNage.getTypeNage() , longueur );
			piscineHomme2.afficherPiscine();
			
			for ( int i = 0 ; i < 250 && piscineHomme2.fin() == false ; i ++ ) {
				
				piscineHomme2.courses();
				piscineHomme2.arriver();
				
				if( i % 6 == 0 ) {
					piscineHomme2.afficherPiscine();
				}
				
			}piscineHomme2.afficherPiscine();
			
			try {
				verifieTemps( piscineHomme2 );
			}catch(MyException t) {
				System.out.println(t.getMessage());
			}
			
			
			System.out.println( piscineHomme2.resultas() );
			System.out.println( piscineHomme2.recompenses() );
		}
		
		if( numPiscine == 3 ) {
			
			piscineFemme.faireNager( TypeNage.getTypeNage() , longueur );
			piscineFemme.afficherPiscine();
			
			for ( int i = 0 ; i < 250 && piscineFemme.fin() == false ; i ++ ) {
				
				piscineFemme.courses();
				piscineFemme.arriver();
				
				if( i % 6 == 0 ) {
					piscineFemme.afficherPiscine();
				}
				
			}piscineFemme.afficherPiscine();
			
			try {
				verifieTemps( piscineFemme );
			}catch(MyException t) {
				System.out.println(t.getMessage());
			}
			
			
			System.out.println( piscineFemme.resultas() );
			System.out.println( piscineFemme.recompenses() );
		}
		
		if ( numPiscine == 4 ) {
			
			piscineFemme2.faireNager(TypeNage.getTypeNage() , longueur );
			piscineFemme2.afficherPiscine();
			
			for ( int i = 0 ; i < 250 && piscineFemme2.fin() == false ; i ++ ) {
				
				piscineFemme2.courses();
				piscineFemme2.arriver();
				
				if( i % 6 == 0 ) {
					piscineFemme2.afficherPiscine();
				}
				
			}piscineFemme2.afficherPiscine();
			
			try {
				verifieTemps( piscineFemme2 );
			}catch(MyException t) {
				System.out.println(t.getMessage());
			}
			
			
			System.out.println( piscineFemme2.resultas() );
			System.out.println( piscineFemme2.recompenses() );
		}
		
		
	}

}



















