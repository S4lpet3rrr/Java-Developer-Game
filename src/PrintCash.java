import gmbh.kdb.hsw.gdp.domain.GameDevStudio;

/**
 * ausgabe des aktuellen kontostandes
 */
public class PrintCash implements Command{

    Command command = new DisplayMainMenu();

    /**
     * ausgabe des aktuellen kontostandes
     * @param studio
     * @return DisplayMainMenu
     */
    @Override
    public Command execute(GameDevStudio studio){
        System.out.println("Current Balance = " + studio.getCash());
        return new DisplayMainMenu();
    }
}