/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks;

/** My Card Pay Screen */
public class MyCardsPay extends Screen
{
    
	private IFrame frame ;
	private IScreen mycards, addcard;
	Device d = Device.getInstance() ;
	
	/**
     * Set screen on valid touch
     * @param x touch coordinate x 
     * @param y touch coordinate y
     */
	public void touch(int x, int y) 
    {
        if ( x==3 && y==3 && d.x==1)
        {
        	
        	mycards.getFrame(frame);
        	System.err.println( "Touched at (" + x + ", " + y + ")" ) ; 
            frame.setCurrentScreen( mycards ) ;
        }
        else if(((x==2 && y==2) || (x==3 && y==2)) && d.x==1)
        {
        	if(d.balance>=1.50)
        	{
        		d.balance=(float) ((d.balance)-1.5);
        	}
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
        String value = "  ["+d.cardid+"]  " ;
        value+="\n\n\n";
        value+="    Scan Now";
        
         return value  ;
    }
	
	/**
     * Set frame
     * @param f Frame
     */
	public void getFrame(IFrame f)
	{
		frame=f;
	}
	
	/**
     * Set screens
     * @param s Screen
     * @param t Screen
     */
	public void getScreens(IScreen s, IScreen t)
	{
		mycards=s;
		addcard=t;
	}
	
	public MyCardsPay()
    {
		
    }
	
	/**
     * Display Name of Screen
     * @return String My Cards
     */
	public String name()
	{
		return("My Cards");
	}
	
	/**
     * Navigate to Next Screen
     */
	public void next()
	{
		frame.setCurrentScreen( addcard ) ;
	}

}

