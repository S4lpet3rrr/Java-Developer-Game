import gmbh.kdb.hsw.gdp.domain.GameDevStudio;
/*
implementierung vom interface
 */
@FunctionalInterface
public interface Command {
    Command execute(GameDevStudio studio);
}
