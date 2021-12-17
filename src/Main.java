import gmbh.kdb.hsw.gdp.Game;

/**
 * GDP Praktikum Testat 1,2 und 3.
 * @author D.Bender, H.Motz, J.Sieker, M.Berberich
 * @version 1.0
 */

public class Main {
    /**
     * initiiert das spiel
     * beendet die runde wenn command == null ist
     * @param args
     */
    public static void main(String[] args) {

        var g = Game.create(s -> {
            Command command = new DisplayMainMenu();

            System.out.printf("%s Cash = %s   Day = %s\n",
                s.getName().getName(),
                s.getCash(),
                Game.get().getDay().getNumber());
                /**
                 * führt die methode "execute" aus der klasse command aus
                 * als parameter wird das objekt "s" der klasse gamedevstudio übergeben
                 * der rückgabewert der methode überschreibt den wert der variable command
                 * die schleife wiederholt sich, solange command nicht null ist 
                 */
                do{
                    command = command.execute(s);
                }while(null != command);
            return true;
        });

        g.start();
    }
}
