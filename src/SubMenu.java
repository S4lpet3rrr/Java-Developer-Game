import gmbh.kdb.hsw.gdp.domain.GameDevStudio;

public class SubMenu implements Command {

    @Override
    public Command execute(GameDevStudio studio) {
        System.out.println(
                """
                        -------------------------------------
                        Sub Menu
                                            
                                           
                        1   Eventlog
                        2   Office Overview
                        3   Developers
                        4   Main menu
                        0   Quit
                        -------------------------------------
                        """
        );

        var input = Input.nextLine();

        /**
         * auswahlkriterien für menüpunkte (abhängig von userinput)
         */
        switch (input) {
            case "0", "Quit", "quit", "QUIT":
                System.out.println("Closing game, noob");
                return new QuitGame();
            case "1", "Eventlog", "EVENTLOG", "eventlog":
                System.out.println("Eventlog is shown");
                return new EventLog();
            case "2", "office overview", "Office Overview", "Office overview", "office Overview", "OFFICE OVERVIEW":
                System.out.println("Office Adress is shown");
                return new PrintOffices();
            case "3", "Developers", "developers", "DEVELOPERS":
                System.out.println("Developers are shown");
                return new PrintDevelopers();
            case "4", "Main Menu", "main menu", "Main menu", "main Menu", "MAIN MENU":
                System.out.println("returning to main menu...");
                return new DisplayMainMenu();
        }

        return this;
    }
}