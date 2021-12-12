import gmbh.kdb.hsw.gdp.domain.GameDevStudio;
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
            Money remainCash = studio.getCash().subtract(app.getHireAgentFee());
            System.out.println("Remain" + remainCash);
        }

        return new DisplayMainMenu();
    }
    
    

}
