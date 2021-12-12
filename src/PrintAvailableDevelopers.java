import gmbh.kdb.hsw.gdp.domain.GameDevStudio;
import gmbh.kdb.hsw.gdp.Game;
import gmbh.kdb.hsw.gdp.domain.Application;
import gmbh.kdb.hsw.gdp.domain.Developer;
import gmbh.kdb.hsw.gdp.domain.Money;
import java.util.List;

public class PrintAvailableDevelopers implements Command {
    @Override
    public Command execute(GameDevStudio studio){
        System.out.println("Available Developers");
        List<Application> apps = studio.getApplications();
        for(int i = 0 ; i < apps.size() ; i++){
            Application app = apps.get(i);
            System.out.println(app.toString());
            Money remainCash = studio.getCash().subtract(app.getHireAgentFee()).subtract(app.getHireBonus());
            System.out.println("Cash remaining: " + remainCash);
            //int remainDays = studio.getCash()
            System.out.println("");
            /**
             * In Arbeit
             */
        }

        return new DisplayMainMenu();
    }
    
    

}
