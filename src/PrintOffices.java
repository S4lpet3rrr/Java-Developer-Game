<<<<<<< Updated upstream
import gmbh.kdb.hsw.gdp.domain.GameDevStudio;
=======
import gmbh.kdb.hsw.gdp.domain.*;
import gmbh.kdb.hsw.gdp.Game;
>>>>>>> Stashed changes

public class PrintOffices implements Command{
    Command command = new DisplayMainMenu();

    @Override
    public Command execute(GameDevStudio studio) {
<<<<<<< Updated upstream
        System.out.printf("Name= %s \n,",
        studio.getOffices().get(0).getName().getName());
=======
        System.out.printf("Office= %s \n,",
                studio.getOffices().get(0).getName().getName());
>>>>>>> Stashed changes
        return null;
    }
}
