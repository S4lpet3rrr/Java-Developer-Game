import gmbh.kdb.hsw.gdp.domain.GameDevStudio;

/**
 * beendet das spiel
 */
public class QuitGame implements Command{

    /**
     * beendet das spiel
     * @param studio
     * @return null
     */
    @Override
    public Command execute (GameDevStudio studio){
        System.exit(0);
        return null;
    }
}
