/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/** Rewards Screen */
public class Rewards extends Screen
{

	/**
     * Set Display of Screen
     * @return value
     */
	public String display() 
    {
        String value = "Make Every\nVisit Count" ;
        
         return value  ;
    }
	
	/**
     * Set screen on valid touch
     * @param  touch coordinates x and y
     */
	public Rewards()
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
