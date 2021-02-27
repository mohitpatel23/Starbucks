package starbucks;

import java.util.ArrayList;

/** Add Card Key Pad */
public class AddCardKeypad implements ITouchEventHandler, IDisplayComponent, IKeyPadSubject
{
	ITouchEventHandler nextHandler ;
    private ArrayList<IKeyPadObserver> observers ;
    int countPinDigits = 0 ;
    String lastKey = "" ;
    public int current=0;

    public AddCardKeypad()
    {
        observers = new ArrayList<IKeyPadObserver>() ;
    }

    /**
     * Touch Event
     * @param x X Coord
     * @param y Y Coord
     */
    public void touch(int x, int y) 
    { 
        
    	System.err.println( "KeyPad Touched at (" + x + ", " + y + ")" ) ; 
    	if(y==2 && (x==1 || x==2 || x==3))
        {
    		 
    		current=0;
        	
        }
        else if(x==2 && y==3)
        {
        	 
        	current=1;
        	
        }
        else if ( y > 4 )
        {
             
            
            if ( x==3 && y==8   )
            {
                //countPinDigits-- ;
            	this.lastKey = getKey( x, y ) ;
                notifyObservers() ;
            }
            else if ( (x < 4 && y < 8 && x > 0) || (x==2 && y==8))
            {
                //countPinDigits++ ;
            	this.lastKey = getKey( x, y ) ;
                notifyObservers() ;
            }
            //notifyObservers() ;            
        }
        else
        {
        	
        	/*if ( nextHandler != null )
                nextHandler.touch(x,y) ;*/
        }
    }

    /**
     *  Get Last Key Pressed 
     * @return Lasy Key
     */
    public String lastKey() { 
        System.err.println( "Key Pressed: " + this.lastKey ) ;
        return this.lastKey ; 
    }

    /**
     * Get Key Number from (X,Y) Touch Coord's
     * @param  x [description]
     * @param  y [description]
     * @return   [description]
     */
    private String getKey( int x, int y )
    {
        int kx = 0, ky = 0 ;
        kx = x;
        ky = y-4 ;
        if ( kx==3 && ky ==4 )
            return "X" ;
        else if ( kx==2 && ky == 4 )
            return "0" ;
        else if ( kx==1 && ky ==4 )
            return " " ;
        else if (kx < 4 && ky < 4 && kx > 0)
            return Integer.toString(kx+3*(ky-1)) ; 
        else
        	return " ";
    }

    /*
    kx = 1, ky = 1  ==> 1
    kx = 1, ky = 2  ==> 4
    kx = 1, ky = 3  ==> 7

    kx = 2, ky = 1  ==> 2
    kx = 2, ky = 2  ==> 5
    kx = 2, ky = 3  ==> 8

    kx = 3, ky = 1  ==> 3
    kx = 3, ky = 2  ==> 6
    kx = 3, ky = 3  ==> 9

    n = kx + 3 * (ky-1)

    */

    /**
     * Set Next Touch Event Handler
     * @param next Event Handler
     */
    public void setNext( ITouchEventHandler next) { 
        nextHandler = next ;
    }

    /**
     * Get Key Pad Display
     * @return Key Pad View Contents
     */
    public String display() 
    {
        //return " [1] [2] [3]\n [4] [5] [6]\n [7] [8] [9]\n [_] [0] [X]"  ;
        
        String output =  "  [1] [2] [3]\n" ;
               output += "  [4] [5] [6]\n" ;
               output += "  [7] [8] [9]\n" ;
               output += "  [_] [0] [X]" ;

        return output ;
    }

    /**
     * Add Sub Component (Not used)
     * @param c Display Component
     */
    public void addSubComponent( IDisplayComponent c ) 
    {
    }

    /**
     * Attach a Key Pad Observer
     * @param obj Observer
     */
    public void attach( IKeyPadObserver obj ) 
    {
        observers.add( obj ) ;
    }

    /**
     * Remove Key Pad Observer
     * @param obj Observer
     */
    public void removeObserver( IKeyPadObserver obj )
    {
        int i = observers.indexOf(obj) ;
        if ( i >= 0 )
            observers.remove(i) ;
    }

    /**
     * Notify all Observers of Update Event
     */
    public void notifyObservers( )
    {
        for (int i=0; i<observers.size(); i++)
        {
            IKeyPadObserver observer = observers.get(i) ;
            observer.keyEventUpdate( current, lastKey ) ;
        }
    }
}
