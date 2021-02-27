package starbucks;

/** Five Pin Digit State */
public class FivePinDigits implements IPinState {
	IPinStateMachine machine ;

    /**
     * Constructor
     * @param  m Reference to State Machine
     */
    public FivePinDigits( IPinStateMachine m )
    {
        this.machine = m ;
    }

    /**
     * Backspace Event
     */
    public void backspace() {
        machine.setStateFourPinDigits(null) ;
    }

    /**
     * Digit Entry Event
     * @param digit Digit Value
     */
    public void number( String digit ) {
    	machine.setStateSixPinDigits( digit ) ;
    }

    /**
     * Valid Pin Event
     */
    public void validPin() {
        return ;
    }

    /**
     * Invalid Pin Event
     */
    public void invalidPin() {
        
    }

}
