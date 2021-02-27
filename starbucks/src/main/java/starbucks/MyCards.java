/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */
package starbucks ;

/** My Cards Screen */
public class MyCards extends Screen
{
   
	private IFrame frame ;
	public IScreen mycardspay;
	public IScreen mycardsoptions;
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
        	mycardspay.getFrame(frame);
        	System.err.println( "Touched at (" + x + ", " + y + ")" ) ; 
            
            frame.setCurrentScreen( mycardspay ) ;
        }
        else if( x==2 && y==4 && d.x==1)
        {
        	mycardsoptions.getFrame(frame);
        	System.err.println( "Touched at (" + x + ", " + y + ")" ) ; 
        	frame.setCurrentScreen( mycardsoptions ) ;
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
		
		String abc=String.format("%.2f",(d.balance));
		String value ="";
        if(d.x==1)
        {
			int namelen=(abc.length()+1);
	        int pad;
	        if(namelen%2==0)
	        {
	        	pad= ((15-namelen)/2)+1;
	        }
	        else {
	        	pad= (15-namelen)/2;
	        }
	        
	        value += padSpaces( pad ) ;
	        value+="$";
	        value+=abc;
        }
        else
        {
        	value="$"+abc;
        }
               
         return value  ;
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
	
	public MyCards(IScreen s, IScreen t)
    {
		mycardspay=s; 
		mycardsoptions=t;
    }
	   
}
