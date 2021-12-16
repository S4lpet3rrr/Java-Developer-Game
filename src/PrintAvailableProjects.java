import gmbh.kdb.hsw.gdp.domain.GameDevStudio;
import gmbh.kdb.hsw.gdp.domain.Project;
import gmbh.kdb.hsw.gdp.domain.ProjectBoard;
import gmbh.kdb.hsw.gdp.domain.Skillset;
import gmbh.kdb.hsw.gdp.domain.Developer;

import java.util.ArrayList;
import java.util.List;

public class PrintAvailableProjects implements Command {
    @Override
    public Command execute(GameDevStudio studio){
        List<Project> projs = new ArrayList<>(studio.getProjectBoard().get());
        List<Developer> devs = studio.getOffices().get(0).getDevelopers();
        List<Integer> bestDevs = new ArrayList<>();
        
        //System.out.println("Projects");
        for(int i = 0; i < projs.size() ; i++){
            Project proj = projs.get(i);
            System.out.println("Project Number: " + (i+1) + "\nProject Name: "
                + proj.getName().getName() + "\nRequired Skillset: " + proj.getEffort() + 
                "\nPossible Reward: " + proj.getReward() + "\nCustomer Name: " + proj.getCustomer().getName() + "\n");
           
            List<Integer> maxDay = new ArrayList<>();
            
            for(int x = 0 ; x < devs.size() ; x++){
                Developer dev = devs.get(x);
                //System.out.println(x+1 + " " + dev.toString());
                
                Skillset pEff = proj.getEffort();
                Skillset devS = dev.getSkills();
                List<Integer> days = new ArrayList<>();
                
                if(pEff.getCoding() != 0 && devS.getCoding() != 0){
                    days.add((int) (Math.ceil((double)pEff.getCoding() / (double)devS.getCoding())));
                }else if(pEff.getCoding() != 0 && devS.getCoding() == 0){
                    days.add(9999);
                }else{
                    days.add(0);
                }

                if(pEff.getDesign() != 0 && devS.getDesign() != 0){
                    days.add((int) (Math.ceil((double)pEff.getDesign() / (double)devS.getDesign())));
                }else if(pEff.getDesign() != 0 && devS.getDesign() == 0){
                    days.add(9999);
                }else{
                    days.add(0);
                }
                //Fallunterscheidung 
                if(pEff.getResearch() != 0 && devS.getResearch() != 0){
                    days.add((int) (Math.ceil((double)pEff.getResearch() / (double)devS.getResearch())));
                }else if(pEff.getResearch() != 0 && devS.getResearch() == 0){
                    days.add(9999);
                }else{
                    days.add(0);
                }

                if(pEff.getTesting() != 0 && devS.getTesting() != 0){
                    days.add((int) (Math.ceil((double)pEff.getTesting() / (double)devS.getTesting())));
                }else if(pEff.getTesting() != 0 && devS.getTesting() == 0){
                    days.add(9999);
                }else{
                    days.add(0);
                }

                int effDays = 0;
                for(int y = 0 ; y < 4 ; y++){
                    if(effDays < days.get(y)){
                        effDays = days.get(y);
                    }
                }
                maxDay.add(effDays);
                //System.out.println(effDays + " Days");
            }

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
        //Hier
        int input = (int) (Integer.valueOf(Input.nextLine()));
        if(input != 0){
            List<Developer> chosenDevs = new ArrayList<>();
            chosenDevs.add(devs.get(bestDevs.get(input-1)));
            studio.acceptProject(projs.get(input-1), chosenDevs);

            projs.remove(input-1);
            studio.setProjectBoard(new ProjectBoard(projs));
        }
        return new DisplayMainMenu();
    }
    
    
}
