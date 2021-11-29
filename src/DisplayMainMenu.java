import gmbh.kdb.hsw.gdp.domain.GameDevStudio;

public class DisplayMainMenu implements Command{

    @Override
    public Command execute(GameDevStudio studio){
        System.out.println(
            """
            ---------------------------------------------
            Main menu
            
            2   Results
            1   Pass
            0   Quit
            ---------------------------------------------
            """
        );

        var input = Input.nextLine();

        switch (input){
            case "0","Quit":
                return new QuitGame();
            case "1","Pass":
                return null;
            /*case "2","Results":
                return Handler();*/
        }
        System.out.println("""
        
        wrong input dude
                            """);
        return this;
    }

}
