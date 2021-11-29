import gmbh.kdb.hsw.gdp.domain.GameDevStudio;

public class PrintOffices implements Command{
    Command command = new DisplayMainMenu();

    @Override
    public Command execute(GameDevStudio studio) {
        System.out.printf("Office= %s \n,",
                studio.getOffices().get(0).getName().getName());
        return null;
    }
}
