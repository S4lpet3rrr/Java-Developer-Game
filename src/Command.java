//package spiel.demo;

import gmbh.kdb.hsw.gdp.domain.GameDevStudio;
/*

 */
@FunctionalInterface
public interface Command {
    Command execute(GameDevStudio studio);
}
