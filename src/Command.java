import gmbh.kdb.hsw.gdp.domain.GameDevStudio;

/**
 * implementation des interface
 */
@FunctionalInterface
public interface Command {
    Command execute(GameDevStudio studio);
}
