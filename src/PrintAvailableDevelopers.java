import gmbh.kdb.hsw.gdp.domain.GameDevStudio;
import gmbh.kdb.hsw.gdp.domain.Application;
import gmbh.kdb.hsw.gdp.domain.Developer;
import gmbh.kdb.hsw.gdp.domain.Money;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

/**
 * ausgabe der verfuegbaren entwickler
 */
public class PrintAvailableDevelopers implements Command {
    /**
     * ausgabe der verfügbaren entwickler
     * steuerung durch inputfunktion (auswahl der entwickler)
     * @param studio
     * @return DisplayMainMenu
     */
    @Override
    public Command execute(GameDevStudio studio){
        System.out.println("Available Developers");
        List<Application> apps = new ArrayList<>(studio.getApplications());

        for(int i = 0 ; i < apps.size() ; i++){
            Application app = apps.get(i);

            /**
             * gibt die application aus
             */
            System.out.println(i+1 + " " + PrintDevelopers.devAusgabe(app.getDeveloper()) + "\nAgent Fee: " + app.getHireAgentFee() + "\nHire Bonus: " + app.getHireBonus());

            /**
             * ausgabe des verbleibenden geldes
             */
            Money remainCash = studio.getCash().subtract(app.getHireAgentFee()).subtract(app.getHireBonus());
            
            List<Developer> devs = studio.getOffices().get(0).getDevelopers();

            /**
             * get kosten des offices dieser runde
             */
            BigDecimal costPerR = studio.getOffices().get(0).getLease().getValue();
            
            /**
             * get kosten der developer dieser runde
             */
            for(int x = 0; x < devs.size() ; x++){
                costPerR = costPerR.add(devs.get(x).getSalary().getValue());
            }

            /**
             * get kosten des einzustellenden developers
             */
            costPerR = costPerR.add(app.getDeveloper().getSalary().getValue());
            
            System.out.println("Cash remaining: " + remainCash);
            System.out.println("Days till bankrupt: " + remainCash.getValue().divide(costPerR, MathContext.DECIMAL32).intValue());
        }
        /**
         * aktion basierend auf userinput, filtert falsche eingaben, return mainmenu
         */
        int input = (int) (Integer.valueOf(Input.nextLine()));
        if(input != 0 && input < apps.size()+1){
            studio.acceptApplication(apps.get(input-1), studio.getOffices().get(0));
            apps.remove(input-1);
            studio.setApplications(apps);
        }
        return new DisplayMainMenu();
    }
    
    

}
