/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks;

/** My Card Options Screen */
public class MyCardsOptions extends Screen
{
   
	private IFrame frame ;
	public IScreen mycardsmore; 
	
	/**
     * Set screen on valid touch
     * @param x touch coordinate x 
     * @param y touch coordinate y
     */
	public void touch(int x, int y) 
    {
        if (( x==1 && y==7 ) || ( x==2 && y==7) || ( x==3 && y==7 ))
        {
            
        	System.err.println( "Touched at (" + x + ", " + y + ")" ) ; 
            frame.setCurrentScreen( mycardsmore ) ;
        }
        
        else 
        {
                
        }
    }
	
	/**
     * Set Display of Screen
     * @return value
     */
	public String display() 
    {
        String value = "Reload\nRefresh\nMore Options\nCancel" ;
        
         return value  ;
    }
	
	public MyCardsOptions(IScreen s)
    {
		mycardsmore=s;
    }
	
	public void getFrame(IFrame f)
	{
		frame=f;
	}
	/**
     * Display Name of Screen
     * @return String My Cards
     */
	public String name()
	{
		return("My Cards");
	}
   
}
