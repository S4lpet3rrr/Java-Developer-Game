import gmbh.kdb.hsw.gdp.domain.GameDevStudio;

/**
 * command, der das aktuelle spiel beendet 
 */
public class QuitGame implements Command{
    @Override
    public Command execute (GameDevStudio studio){
        System.exit(0);
        return null;
    }
}
