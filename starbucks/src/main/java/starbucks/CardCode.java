package starbucks;

/** Card Code Screen Component */
public class CardCode extends Screen implements IKeyPadObserver,ITouchEventHandler, IDisplayComponent
{
	protected String id="";
	protected int counter=0;
	ITouchEventHandler nextHandler ;
	public int functioncalled=0;
	
	/**
     * Key Event Update
     * @param c   Count of Keys So Far
     * @param key Last key Pressed
     */
	public void keyEventUpdate( int c, String key ) 
    {
        if(c==1)
        {
        	if(functioncalled==1)
    		{
    			counter=0;
    		}
        	if ( key.equals(" ") )
        	{
        		
        	}
        	else if(key=="X")
        	{
        		
        		if(counter>0)
        		{
        			id=id.substring(0, id.length()-1);
        			counter--;
        		}
        	}
        	else
        	{
        		if(counter<3)
        		{
        			id+=key;
            		counter++;
            		
        		}
        		
        	}
        	
        }
        
    }
	
	/**
     * Set Display of Screen
     * @return value
     */
	public String display() 
    {
		String value ="";
        int namelen=(id.length()+2);
        int pad;
        if(namelen%2==0)
        {
        	pad= (15-namelen)/2+1;
        }
        else
        {
        	pad= (15-namelen)/2;
        }
        value += padSpaces( pad ) ;
        value+="[";
        value+=id;
        value+="]";
        
        
         return value  ;
    }

	
	/**
     * Add Sub Component (Not used)
     * @param c Sub Component to Add
     */
	public void addSubComponent(IDisplayComponent c) {
		
		
	}

	
	/**
     * Touch Event Ignored by CardCode
     * @param x Touch X
     * @param y Touch Y
     */
	public void touch(int x, int y) {
		
		if ( nextHandler != null )
            nextHandler.touch(x,y) ;
    
		
	}

	/**
     * Set Next Touch Handler
     * @param next Touch Event Handler
     */
	public void setNext( ITouchEventHandler next) 
    { 
        nextHandler = next ;
    }
	
}
