import gmbh.kdb.hsw.gdp.domain.GameDevStudio;

public class DisplayMainMenu implements Command{
    int Rundenzahl;

    //String input = Input.nextLine();


    @Override
    public Command execute(GameDevStudio studio){
        System.out.println(
                """
                    -------------------------------------
                    Main menu
                    
                   
                    1   Pass
                    2   Cash
                    3   Submenu
                    0   Quit
                    -------------------------------------
                    """
        );


        var input = Input.nextLine();

        switch (input){
            case "0", "Quit", "quit", "QUIT":
                System.out.println("Closing game, noob");
                return new QuitGame();
            case "1", "Pass", "pass", "PASS":
                System.out.println("Next Round");
                return null;
            case "2", "cash", "CASH", "Cash":
                System.out.println("Cash is shown");
                return new PrintCash();
            case "3", "submenu", "Submenu", "SUBMENU":
                System.out.println("Opening Submenu...");
                return new SubMenu();
            case "4", "list available devs", "List available Devs", "LIST AVAILABLE DEVS":
                System.out.println("The available devs: ");
                return new PrintAvailableDevelopers();
            case "5", "list available projects", "List available Projects", "LIST AVAILABLE PROJECTS":
                System.out.println("The available projects: ");
                return new PrintAvailableProjects();
        }
        System.out.println("""
                wrong input dude
                            """);
        return this;
    }

}