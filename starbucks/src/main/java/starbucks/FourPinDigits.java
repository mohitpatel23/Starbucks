/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/** For Pin Digits State */
public class FourPinDigits implements IPinState
{
    IPinStateMachine machine ;
    Device d = Device.getInstance() ;
    private int c= (d.getPin()).length();

    /**
     * Constructor
     * @param  m Reference to State Machine
     */
    public FourPinDigits( IPinStateMachine m )
    {
        this.machine = m ;
    }

    /**
     * Backspace Event
     */
    public void backspace() {
        machine.setStateThreePinDigits(null) ;
    }

    /**
     * Digit Entry Event
     * @param digit Digit Value
     */
    public void number( String digit ) {
    	if(c==4)
    	{
	        System.err.println( "Digit: " + digit ) ;
	        return ;																						
    	}
    	else if(c==6)
    	{
    		machine.setStateFivePinDigits( digit ) ;
    	}
    }

    /**
     * Valid Pin Event
     */
    public void validPin() {
    	if(c==4) {
        return ;
    	}
    }

    /**
     * Invalid Pin Event
     */
    public void invalidPin() {
    	if(c==4)
    	{
    		machine.setStateNoPinDigits() ;
    	}
    }

}
