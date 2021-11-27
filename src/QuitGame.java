//package spiel.demo;

import gmbh.kdb.hsw.gdp.domain.GameDevStudio;

/**
 * Command that quits the current game
 */
public class QuitGame implements Command{
    @Override
    public Command execute (GameDevStudio studio){
        System.exit(0);
        return null;
    }
}
