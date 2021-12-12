import gmbh.kdb.hsw.gdp.domain.GameDevStudio;
import gmbh.kdb.hsw.gdp.domain.Application;
import gmbh.kdb.hsw.gdp.domain.Developer;
import java.util.List;

public class PrintAvailableDevelopers implements Command {
    @Override
    public Command execute(GameDevStudio studio){
        System.out.println("Available Developers");
        List<Application> apps = studio.getApplications();
        for(int i = 0 ; i < apps.size() ; i++){
            System.out.println(apps.get(i).toString());
        }
        return new DisplayMainMenu();
    }
    
    

}
