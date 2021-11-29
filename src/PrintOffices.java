import gmbh.kdb.hsw.gdp.domain.GameDevStudio;

public class PrintOffices implements Command{

    @Override
    public Command execute(GameDevStudio studio) {
        System.out.printf("Name= %s \n,",
        studio.getOffices().get(0).getName().getName());
        return null;
    }
    
}