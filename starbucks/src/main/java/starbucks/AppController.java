/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/**
 * Main App Controller Class
 */
public class AppController implements IApp {

    private IScreen mycards ;
    private IScreen mycardspay ;
    private IScreen mycardsoptions ;
    private IScreen mycardsmore ;
    private IScreen store ;
    private IScreen rewards ;
    private IScreen payments ;
    private IScreen settings ;
    private IScreen addcard ;
    private Spacer sp ;
    private CardID id;
    private AddCardKeypad kp;
    private CardCode code;
    private IMenuCommand displayMyCards ;
    private IMenuCommand displayPayments ;
    private IMenuCommand displayRewards ;
    private IMenuCommand doStore ;
    private IMenuCommand displaySettings ;
    private IFrame frame ;
    //private String current;

    public AppController() {
        
    	mycardsmore = new MyCardsMoreOptions() ;
    	mycardspay = new MyCardsPay() ;
        mycardsoptions = new MyCardsOptions(mycardsmore) ;
        mycards = new MyCards(mycardspay,mycardsoptions) ;
        
        
        sp = new Spacer() ;
        store = new Store() ;
        rewards = new Rewards() ;
        payments = new Payments() ;
        kp = new AddCardKeypad();
        id = new CardID();
        code=new CardCode();
        frame = new Frame( mycards,id ) ;
        addcard = new AddCard(id,code,frame,mycards,kp) ;
        settings = new Settings(addcard) ;
        addcard.getScreen(settings);
        mycardspay.getScreens(mycards,addcard);
        
        mycards.getFrame(frame);
        settings.getFrame(frame);
        ((Screen)addcard).addSubComponent( id ) ;
        ((Screen)addcard).addSubComponent( (IDisplayComponent)code ) ;
        ((Screen) addcard).addSubComponent( sp ) ;
       ((Screen)addcard).addSubComponent((IDisplayComponent) kp ) ;
       
       ((IKeyPadSubject)kp).attach( id ) ;
       ((IKeyPadSubject)kp).attach( code ) ;
        // setup command pattern
        displayMyCards  = new MenuCommand() ;
        displayPayments = new MenuCommand() ;
        displayRewards  = new MenuCommand() ;
        doStore         = new MenuCommand() ;
        displaySettings  = new MenuCommand() ;
        displayMyCards.setReceiver(
          new IMenuReceiver() {
              /** Command Action */
              public void doAction() {
                  frame.setCurrentScreen( mycards ) ;
                  id.id="";
                  code.id="";
                  id.counter=0;
                  code.counter=0;
                  kp.current=0;
                  System.out.println("A");
              }
        }
        ) ;
        displayPayments.setReceiver(
          new IMenuReceiver() {
              /** Command Action */
              public void doAction() {
                  frame.setCurrentScreen( payments ) ;
                  id.id="";
                  code.id="";
                  id.counter=0;
                  code.counter=0;
                  kp.current=0;
                  System.out.println("B");
              }
        }
        ) ;
        displayRewards.setReceiver(
          new IMenuReceiver() {
              /** Command Action */
              public void doAction() {
                  frame.setCurrentScreen( rewards ) ;
                  id.id="";
                  code.id="";
                  id.counter=0;
                  code.counter=0;
                  kp.current=0;
                  System.out.println("C");
              }
        }
        ) ;
        doStore.setReceiver(
          new IMenuReceiver() {
              /** Command Action */
              public void doAction() {
                  frame.setCurrentScreen( store ) ;
                  id.id="";
                  code.id="";
                  id.counter=0;
                  code.counter=0;
                  kp.current=0;
                  System.out.println("D");
              }
        }
        ) ;
        displaySettings.setReceiver(
                new IMenuReceiver() {
                    /** Command Action */
                    public void doAction() {
                        frame.setCurrentScreen( settings ) ;
                        id.id="";
                        code.id="";
                        id.counter=0;
                        code.counter=0;
                        kp.current=0;
                        System.out.println("E");
                    }
              }
              ) ;
        frame.setMenuItem ( "A", displayMyCards ) ;
        frame.setMenuItem ( "B", displayPayments ) ;
        frame.setMenuItem ( "C", displayRewards ) ;
        frame.setMenuItem ( "D", doStore ) ;
        frame.setMenuItem ( "E", displaySettings ) ;
    }


    /**
      * Switch to Landscape Mode
      */
    public void landscape() {
        frame.landscape() ;
    }

    /**
     * Switch to Portrait Mode
     */
    public void portrait() {
        frame.portrait() ;
    }

    /**
     * Send In Touch Events
     * @param x X Coord
     * @param y Y Coord
     */
    public void touch(int x, int y) {
        frame.touch(x, y) ;
    }

    /**
     * Display Current Screen
     */
    public void display() {
        frame.display() ;
    }

    /**
     * Execute Menu Bar Command
     * @param c Menu Bar Option (A, B, C, D or E)
     */
    public void execute( String c ) {
        frame.cmd( c ) ;
    }

    /**
     * Navigate to Previous Screen
     */
    public void prev() {
        frame.previousScreen() ;
        
    }

    /**
     * Navigate to Next Screen
     */
    public void next() {
        frame.nextScreen() ;
    }

    /**
     * Get Current Screen Name
     * @return Screen Name
     */
    public String screen() {
        return frame.screen() ;
    }

    /**
     * Get Current Screen Contents
     * @return Current Screen Contents
     */
    public String screenContents() {
        return frame.contents() ;
    }

}
