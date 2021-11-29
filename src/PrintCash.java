import gmbh.kdb.hsw.gdp.domain.GameDevStudio;

public class PrintCash implements Command{

    Command command = new DisplayMainMenu();
    @Override
    public Command execute(GameDevStudio studio){
        System.out.printf("Cash= %s \n,",
                studio.getCash());
        return null;
    }
}