import gmbh.kdb.hsw.gdp.domain.GameDevStudio;

public class PrintDevelopers implements Command{

    Command command = new SubMenu();
    @Override
    public Command execute(GameDevStudio studio){
        System.out.printf("Developers= %s \n,",
                studio.getOffices().get(0).getDevelopers());
        return null;
    }

}