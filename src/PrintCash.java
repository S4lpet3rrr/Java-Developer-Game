import gmbh.kdb.hsw.gdp.domain.GameDevStudio;

public class PrintCash implements Command{

    Command command = new DisplayMainMenu();
    
    /**
     * gibt den aktuellen kontostand aus, return mainmenu
     */
    @Override
    public Command execute(GameDevStudio studio){
        System.out.println("Current Balance = " + studio.getCash());
        return new DisplayMainMenu();
    }
}