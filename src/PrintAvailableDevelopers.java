import gmbh.kdb.hsw.gdp.domain.GameDevStudio;
import gmbh.kdb.hsw.gdp.Game;
import gmbh.kdb.hsw.gdp.domain.Application;
import gmbh.kdb.hsw.gdp.domain.Developer;
import gmbh.kdb.hsw.gdp.domain.Money;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

public class PrintAvailableDevelopers implements Command {
    @Override
    public Command execute(GameDevStudio studio){
        System.out.println("Available Developers");
        List<Application> apps = new ArrayList<>(studio.getApplications());
        for(int i = 0 ; i < apps.size() ; i++){
            Application app = apps.get(i);
            System.out.println(i+1 + " " + app.toString());
            Money remainCash = studio.getCash().subtract(app.getHireAgentFee()).subtract(app.getHireBonus());
           
            List<Developer> devs = studio.getOffices().get(0).getDevelopers();
            BigDecimal costPerR = studio.getOffices().get(0).getLease().getValue();
            for(int x = 0; x < devs.size() ; x++){
                costPerR = costPerR.add(devs.get(x).getSalary().getValue());
            }
            costPerR = costPerR.add(app.getDeveloper().getSalary().getValue());
            
            System.out.println("Cash remaining: " + remainCash);
            System.out.println("Days till bankrupt: " + remainCash.getValue().divide(costPerR, MathContext.DECIMAL32).intValue());
        }
        //Hier
        int input = (int) (Integer.valueOf(Input.nextLine()));
        if(input != 0){
            studio.acceptApplication(apps.get(input-1), studio.getOffices().get(0));
            apps.remove(input-1);
            studio.setApplications(apps);
        }
        return new DisplayMainMenu();
    }
    
    

}
