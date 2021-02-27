/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/** Passcode Screen Component */
public class Passcode implements ITouchEventHandler, IDisplayComponent, IKeyPadObserver
{
    ITouchEventHandler nextHandler ;
    private int count = 0;
    Device d = Device.getInstance() ;
    int x=0;
    String k;

    /**
     * Touch Event Ignored by Passcode
     * @param x Touch X
     * @param y Touch Y
     */
    public void touch(int x, int y) 
    {
        if ( y==2 )
        {
            System.err.println( "Passcode Touched at (" + x + ", " + y + ")" ) ; 
        }
        else
        {
            if ( nextHandler != null )
                nextHandler.touch(x,y) ;
        }
    }
    
    /**
     * Set Next Touch Handler
     * @param next Touch Event Handler
     */
    public void setNext( ITouchEventHandler next) 
    { 
        nextHandler = next ;
    }
    
    
    /**
     * Display "Echo Feedback" on Pins entered so far
     * @return Passcode String for Display
     */
    public String display() 
    {
        int c;
        c=(d.getPin()).length();
        String value = "" ;
        if(c==4)
    	{
	        value=display4(); 
    	}
    	else if(c==6) 
    	{
    	   value=display6();
    	}
        
    	return value  ;
    }
    
    /**
     * Display "Echo Feedback" on Pins entered so far
     * @return  4 pin Passcode String for Display
     */
    public String display4()
    {
    	String value="";
    	switch ( count )
        {
            case 0: value = "\n\n  [_][_][_][_]" ; break ;
            case 1: value = "\n\n  [*][_][_][_]" ; break ;
            case 2: value = "\n\n  [*][*][_][_]" ; break ;
            case 3: value = "\n\n  [*][*][*][_]" ; break ;
            case 4: value = "  Invalid Pin\n\n  [_][_][_][_]" ; break ;
        }
    	return value;
    }
    
    /**
     * Display "Echo Feedback" on Pins entered so far
     * @return 6 pin passcode String for Display
     */
    public String display6()
    {
    	String value="";
    	switch ( count )
        {
            case 0: value = "\n\n  _ _ _ _ _ _" ; break ;
            case 1: value = "\n\n  * _ _ _ _ _" ; break ;
            case 2: value = "\n\n  * * _ _ _ _" ; break ;
            case 3: value = "\n\n  * * * _ _ _" ; break ;
            case 4: value = "\n\n  * * * * _ _" ; break ;
            case 5: value = "\n\n  * * * * * _" ; x++;break ;
            case 6: value = "  Invalid Pin\n\n  _ _ _ _ _ _" ; break ;
        }
    	return value;
    }
    /**
     * Add Sub Component (Not used)
     * @param c Sub Component to Add
     */
    public void addSubComponent( IDisplayComponent c ) 
    {
        
    }   
    
    /**
     * Key Event Update
     * @param c   Count of Keys So Far
     * @param key Last key Pressed
     */
    public void keyEventUpdate( int c, String key ) 
    {
        System.err.println( "Key: " + key ) ;
        count = c ;
        //d.getPinNo(c);
        k=key;
    }
}
