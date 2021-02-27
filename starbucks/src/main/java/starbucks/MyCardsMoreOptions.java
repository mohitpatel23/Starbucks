/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks;

/** My Card More Options Screen */
public class MyCardsMoreOptions extends Screen
{
  
	//private IFrame frame ;
	
	/**
     * Set Display of Screen
     * @return value
     */
	public String display() 
    {
        String value = "Refresh\nReload\nAuto Reload\nTransactions" ;
        
         return value  ;
    }
	
	public MyCardsMoreOptions()
    {
    }
	
	/*public void getFrame(IFrame f)
	{
		frame=f;
	}*/
	
	
	/**
     * Display Name of Screen
     * @return String My Cards
     */
	public String name()
	{
		return("My Cards");
	}
	/**
     * Touch event ignored 
     * @param x touch coordinate x 
     * @param y touch coordinate y
     */
	public void touch(int x, int y) 
    {
		x=y;
		y=x;
    }
}
