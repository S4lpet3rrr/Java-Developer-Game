import gmbh.kdb.hsw.gdp.Game;

/**
 * GDP Praktikum Testat 1,2 und 3.
 * @author D.Bender, H.Motz, J.Sieker, M.Berberich
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {

        var g = Game.create(s -> {
            Command command = new DisplayMainMenu();

            System.out.printf("%s Cash = %s   Day = %s\n",
                s.getName().getName(),
                s.getCash(),
                Game.get().getDay().getNumber());
/**
 *  PLATZHALTER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 */
                do{
                    command = command.execute(s);
                }while(null != command);
            return true;
        });

        g.start();
    }
}
