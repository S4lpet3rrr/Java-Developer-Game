import gmbh.kdb.hsw.gdp.domain.GameDevStudio;

/**
 * ausgabe des main menues
 */
public class DisplayMainMenu implements Command{
    int Rundenzahl;

    /**
     * ausgabe des main menues
     * moegliche cases 0-5
     * 0 - runde beenden
     * 1 - naechste runde
     * 2 - ausgabe des geldes
     * 3 - oeffnet submenue
     * 4 - ausgabe der freien entwickler
     * 5 - augabe moeglicher projekte
     * @param studio
     * @return Command
     */
    @Override
    public Command execute(GameDevStudio studio){
        System.out.println(
                """
                    -------------------------------------
                    Main menu
                    
                   
                    1   Pass
                    2   Cash
                    3   Submenu
                    4   Available Developers
                    5   Available Projects
                    0   Quit
                    -------------------------------------
                    """
        );

        var input = Input.nextLine();
/**
 * auswahlkriterien für menüpunkte (abhängig von userinput)
 */
        switch (input){
            case "0", "Quit", "quit", "QUIT":
                System.out.println("Closing game, noob");
                return new QuitGame();
            case "1", "Pass", "pass", "PASS":
                System.out.println("Next Round");
                return null;
            case "2", "cash", "CASH", "Cash":
                System.out.println();
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