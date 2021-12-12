import gmbh.kdb.hsw.gdp.domain.GameDevStudio;
import gmbh.kdb.hsw.gdp.domain.Project;
import gmbh.kdb.hsw.gdp.domain.Developer;
import java.util.List;

public class PrintAvailableProjects implements Command {
    @Override
    public Command execute(GameDevStudio studio){
        List<Project> projs = studio.getProjectBoard().get();
        System.out.println("Projects");
        for(int i = 0; i < projs.size() ; i++){
            Project proj = projs.get(i);
            System.out.println(proj.toString());
        }
        return new DisplayMainMenu();
    }
    
    
}
