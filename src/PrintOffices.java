import gmbh.kdb.hsw.gdp.domain.GameDevStudio;
import gmbh.kdb.hsw.gdp.domain.Office;

public class PrintOffices implements Command{

    Office office1 = new Office(null, null);
    
    
    @Override
    public Command execute(GameDevStudio studio) {
        System.out.println("Offices:");
        return null;
    }
    
}