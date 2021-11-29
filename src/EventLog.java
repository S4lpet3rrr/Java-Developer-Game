import gmbh.kdb.hsw.gdp.Game;
import gmbh.kdb.hsw.gdp.domain.GameDevStudio;

public class EventLog implements Command{

    Command command = new SubMenu();

    public Command execute(GameDevStudio studio){
        System.out.printf("EventLog= %s \n,",
                Game.get().getEventLog());
        return new SubMenu();

    }
}