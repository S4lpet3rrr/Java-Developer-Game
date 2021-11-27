
import gmbh.kdb.hsw.gdp.Game;

public class Main {

    public static void main(String[] args) {

        var g = Game.create(s -> {
            Command command = new DisplayMainMenu();

            do{
                // System.out.println(">>>Execute Command");
                command = command.execute(s);
            }while(null != command);
            /*
            do { //1 - 3 mal
            1. Text einlesen
            2. Aktion bestimmen
            3. Ausführen
            }while ()
             */
            return true;
        });

        g.start();
    }
}
