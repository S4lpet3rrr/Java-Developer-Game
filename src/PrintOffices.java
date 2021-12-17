import gmbh.kdb.hsw.gdp.domain.GameDevStudio;

/**
 * ausgabe des bueros
 */
public class PrintOffices implements Command{
    Command command = new DisplayMainMenu();

    /**
     * ausgabe des bueros
     * @param studio
     * @return SubMenu
     */
    @Override
    public Command execute(GameDevStudio studio) {
        System.out.printf("Office= %s \n",
                studio.getOffices().get(0).getName().getName());
        return new SubMenu();
    }
}
