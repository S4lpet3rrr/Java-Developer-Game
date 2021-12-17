import gmbh.kdb.hsw.gdp.domain.GameDevStudio;
import gmbh.kdb.hsw.gdp.domain.Developer;
import java.util.List;

public class PrintDevelopers implements Command{

    Command command = new SubMenu();

    /**
     * anzahl developer ausgeben und zuweisen
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
     * gibt developer mit ihren eigenschaften aus, je nach dem ob sie an einem projekt arbeiten, wenn nicht return null
     */
    public static String devAusgabe(Developer dev){
        if(dev.getWorkingOn() == null) {
            return("Name: " + dev.getName().getName() + 
                            "\t| Skills:   Coding: " + dev.getSkills().getCoding() + "\t Research: " + dev.getSkills().getResearch() + 
                            "\t Testing: " + dev.getSkills().getTesting() + "\t Design: " + dev.getSkills().getDesign() +
                            "\t| Salary: " + dev.getSalary() +
                            "\t| Working on: " + dev.getWorkingOn());
        }
        else {
            return("Name: " + dev.getName().getName() + 
                                "\t| Skills:   Coding: " + dev.getSkills().getCoding() + "\t Research: " + dev.getSkills().getResearch() + 
                                "\t Testing: " + dev.getSkills().getTesting() + "\t Design: " + dev.getSkills().getDesign() +
                                "\t| Salary: " + dev.getSalary() +
                                "\t| Working on: " + dev.getWorkingOn().getName().getName());
        }
    }
}