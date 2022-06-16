
/*gere les exceptions des scanner, que l'on utilisera dans le main*/
public class ScannerException extends Exception{

	/*
	 constructeurs pour un message predefinie ou un message personnel
	 */
	public ScannerException(int n) {
		super("Porblème de lecture, veuillez ecrire comme suit : \n 100 , 200 , 400  ");
	}
	
	
	public ScannerException(String s ) {
		super(s);
	}

}
