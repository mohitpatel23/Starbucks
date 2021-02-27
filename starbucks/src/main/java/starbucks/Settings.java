/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks;

/** Settings Screen */
public class Settings extends Screen
{
   
	private IFrame frame ;
	public IScreen addcard ;
	
	public Settings(IScreen s)
	{
		addcard = s;
	}
	
	/**
     * Set screen on valid touch
     * @param x touch coordinate x 
     * @param y touch coordinate y
     */
	public void touch(int x, int y) 
    {
        if (( x==1 && y==1 ) || ( x==2 && y==1) || ( x==3 && y==1 ))
        {
            System.err.println( "Touched at (" + x + ", " + y + ")" ) ; 
            frame.setCurrentScreen( addcard ) ;
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
        String value = "    Add Card\n  Delete Card\n    Billing\n    Passcode\n\n  About|Terms\n      Help" ;
        
         return value  ;
    }
	
	public void getFrame(IFrame f)
	{
		frame=f;
	}
	
	
   
}
