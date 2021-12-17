import gmbh.kdb.hsw.gdp.Game;

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
