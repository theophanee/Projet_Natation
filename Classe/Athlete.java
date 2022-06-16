
/*Classe mère qui permet de creer nos sportifs*/
public abstract class Athlete implements Temps{
	
	public abstract void nage(String type_nage);/*fait nager l'athlete*/
	
	public abstract boolean testDopage();/*permet de tester si l'athlete est doper*/
	
	public abstract void position( int x , int y );/*positionne 'athlete'*/
	
	public abstract int getI();/*obtenir ses positions*/
	
	public abstract int getJ();
	
	public abstract boolean getAllee();
	
	public abstract void setAllee( boolean b );
	
	public abstract void setANager( boolean b );/*permet de changer la direction de l'athlete*/
	
	public abstract int getMin() ;/*obtenir les temps*/
	
	public abstract int getSec() ;
	
	public abstract int getMs() ;
	
	public abstract void setMin( int min );/*permet de modifier les temps*/
	
	public abstract void setSec( int sec );
	
	public abstract void setMs( int ms );
	
	public abstract void setFini( boolean b );/*attribuer une arrivée à l'athlete*/
	
	public abstract boolean getFini();/*savoir si l'athlete a fini sa course*/
	

}
