/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks;

/**
 * Add New Card Screen
 */
public class AddCard extends Screen 
{
	
	private CardID cardid;
	private CardCode cardcode;
	private IFrame frame;
	private IScreen mycards;
	private IScreen settings;
	Device d = Device.getInstance() ;
	AddCardKeypad addcardkeypad;
	
	/**
     * Set Name of Screen
     * @return s name of screen
     */
	public String name()
	{
		String s="Add Card";
		return(s);
	}
	
	public AddCard(CardID a, CardCode b, IFrame f, IScreen s, AddCardKeypad kp)
    {
		cardid=a;
		cardcode=b;
		frame=f;
		mycards=s;
		addcardkeypad=kp;
    }
	
	/**
     * Set 
     * @param next Event Handler
     */
	public void next()
	{
		if(((cardid.id).length()==9) && ((cardcode.id).length()==3))
		{
			
			d.cardid=cardid.id;
			d.balance=20;
			cardid.id="";
			cardcode.id="";
			//System.out.println(cardid.id);
			//System.out.println(d.balance);
			//System.out.println(d.cardid);
			frame.setCurrentScreen(mycards);
			
		}
		else
		{
			cardid.id="";
			cardcode.id="";
			
		}
		addcardkeypad.current=0;
		cardid.functioncalled=1;
		cardcode.functioncalled=1;
	}
	
	/**
     * Set Next Touch Event Handler
     * @param next Event Handler
     */
	public void prev()
	{
		
		cardid.id="";
		cardcode.id="";
		addcardkeypad.current=0;
		cardid.functioncalled=1;
		cardcode.functioncalled=1;
		frame.setCurrentScreen(settings);
	}
	public void getScreen(IScreen s)
	{
		settings=s;
	}
	
}




