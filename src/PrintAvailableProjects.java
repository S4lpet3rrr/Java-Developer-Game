import gmbh.kdb.hsw.gdp.domain.GameDevStudio;
import gmbh.kdb.hsw.gdp.domain.Project;
import gmbh.kdb.hsw.gdp.domain.ProjectBoard;
import gmbh.kdb.hsw.gdp.domain.Skillset;
import gmbh.kdb.hsw.gdp.domain.Developer;

import java.util.ArrayList;
import java.util.List;

public class PrintAvailableProjects implements Command {
    /**
     * ausgabe der verfügbaren projekte
     * steuerung durch inputfunktion (auswahl der projekte)
     * automatische zuordnung des best geeigneten entwicklers
     * @param studio
     * @return DisplayMainMenu
     */
    @Override
    public Command execute(GameDevStudio studio){
        List<Project> projs = new ArrayList<>(studio.getProjectBoard().get());
        List<Developer> devs = studio.getOffices().get(0).getDevelopers();
        List<Integer> bestDevs = new ArrayList<>();
        
        /**
         * gibt available projects aus
         */
        for(int i = 0; i < projs.size() ; i++){
            Project proj = projs.get(i);
            System.out.println("Project Number: " + (i+1) + "\nProject Name: "
                + proj.getName().getName() + "\nRequired Skillset: " + proj.getEffort().getCoding() + proj.getEffort().getResearch() 
                + proj.getEffort().getTesting() + proj.getEffort().getDesign() +
                "\nPossible Reward: " + proj.getReward() + "\nCustomer Name: " + proj.getCustomer().getName() + "\n");
           
            List<Integer> maxDay = new ArrayList<>();
            
            /**
             * fallunterscheidungen, je nach rückgabewert der skills, wie lange ein projekt braucht bis fertigstellung
             */
            for(int x = 0 ; x < devs.size() ; x++){
                Developer dev = devs.get(x);
                
                Skillset pEff = proj.getEffort();
                Skillset devS = dev.getSkills();
                List<Integer> days = new ArrayList<>();

                days.add(effTage(pEff.getCoding(),devS.getCoding()));
                days.add(effTage(pEff.getDesign(),devS.getDesign()));
                days.add(effTage(pEff.getResearch(),devS.getResearch()));
                days.add(effTage(pEff.getTesting(),devS.getTesting()));

                int effDays = 0;
                for(int y = 0 ; y < 4 ; y++){
                    if(effDays < days.get(y)){
                        effDays = days.get(y);
                    }
                }
                maxDay.add(effDays);
            }

            /**
             * checked kürzeste zeit für projekt mit bestem dev
             */
            int shortestT = maxDay.get(0);
            int bestDev = 0;
            for(int z = 1 ; z < devs.size() ; z++){
                if(shortestT > maxDay.get(z)){
                    shortestT = maxDay.get(z);
                    bestDev = z;
                }
            }
            bestDevs.add(bestDev);
            System.out.println(bestDev+1 + " Developer " + PrintDevelopers.devAusgabe(devs.get(bestDev)));
            System.out.println("Within " + shortestT + " days" + "\n" );
        }
        /**
         * aktion basierend auf userinput, filtert falsche eingaben, return mainmenu
         */
        int input = (int) (Integer.valueOf(Input.nextLine()));
        if(input != 0 && input < projs.size()+1){
            List<Developer> chosenDevs = new ArrayList<>();
            chosenDevs.add(devs.get(bestDevs.get(input-1)));
            studio.acceptProject(projs.get(input-1), chosenDevs);

            projs.remove(input-1);
            studio.setProjectBoard(new ProjectBoard(projs));
        }
        return new DisplayMainMenu();
    }

    /**
     * ausgabe der anzahl an tage die für das erfüllen eines efforts benötigt wird
     * @param eSkill (effort skillset)
     * @param dSkill (developer skillset)
     * @return int
     */
    public int effTage(int eSkill, int dSkill){
        if(eSkill != 0 && dSkill != 0){
            return((int) (Math.ceil((double)eSkill / (double)dSkill)));
        }else if(eSkill != 0 && dSkill == 0){
            return(9999);
        }else{
            return(0);
        }
    }
    
}
