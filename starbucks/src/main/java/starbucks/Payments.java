/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/** Payments Screen */
public class Payments extends Screen
{

	/**
     * Set Display of Screen
     * @return value
     */
	public String display() 
    {
        String value = "Find Store\nEnable Payments" ;
        
         return value  ;
    }
	
	public Payments()
    {

    }
	/**
     * Set screen on valid touch
     * @param x touch coordinate x 
     * @param y touch coordinate y
     */
	public void touch(int x, int y) 
    {
		x=y;
		y=x;
    }
}
