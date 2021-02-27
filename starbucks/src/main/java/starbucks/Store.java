/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/** Store Screen */
public class Store extends Screen
{

	/**
     * Set Display of Screen
     * @return value
     */
	public String display() 
    {
        String value = "         X\n   X\n       X\n      X\n  X\n           X\n  X\n" ;
        
         return value  ;
    }
	
	public Store()
    {

    }
	/**
     * Display Name of Screen
     * @return String Find Store
     */
	public String name()
	{
		return("Find Store");
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
