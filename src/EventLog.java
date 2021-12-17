import gmbh.kdb.hsw.gdp.Game;
import gmbh.kdb.hsw.gdp.domain.GameDevStudio;

/**
 * ausgabe des eventlogs
 */
public class EventLog implements Command{


    Command command = new SubMenu();

    /**
     * ausgabe des eventlogs
     * @param studio
     * @return SubMenu
     */
    public Command execute(GameDevStudio studio){
        System.out.printf("EventLog= %s \n",
                Game.get().getEventLog());
        return new SubMenu();

    }
}