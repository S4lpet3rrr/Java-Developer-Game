import gmbh.kdb.hsw.gdp.domain.GameDevStudio;
import gmbh.kdb.hsw.gdp.domain.Developer;
import java.util.List;

/**
 * ausgabe der angestellten entwickler
 */
public class PrintDevelopers implements Command{

    Command command = new SubMenu();

    /**
     * ausgabe der angestellten entwickler
     * @param studio
     * @return SubMenu
     */
    @Override
    public Command execute(GameDevStudio studio){
        List<Developer> devs = studio.getOffices().get(0).getDevelopers();
        System.out.println();
        for(int i = 0; i < devs.size() ; i++){
            Developer dev = devs.get(i);
            System.out.println(devAusgabe(dev));
        }
        return new SubMenu();
    }

    /**
     * ausgabe eines objektes vom typ developer als formatierter string
     * @param dev
     * @return String
     */
    public static String devAusgabe(Developer dev){
        String output = "Name: " + dev.getName().getName() +
                "\t| Skills:   Coding: " + dev.getSkills().getCoding() + "\t Research: " + dev.getSkills().getResearch() +
                "\t Testing: " + dev.getSkills().getTesting() + "\t Design: " + dev.getSkills().getDesign() +
                "\t| Salary: " + dev.getSalary();

        if(dev.getWorkingOn() == null) {
            output += "\t| Working on: " + dev.getWorkingOn();
        }
        else {
            output += "\t| Working on: " + dev.getWorkingOn().getName().getName();
        }
        return output;
    }
}