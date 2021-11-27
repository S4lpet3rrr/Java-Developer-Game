//package spiel.demo;

import gmbh.kdb.hsw.gdp.domain.GameDevStudio;

public class DisplayMainMenu implements Command{

    @Override
    public Command execute(GameDevStudio studio){
        System.out.println(
                """
                    Main menu
                    
                    
                    1   Pass
                    0   Quit
                    """
        );

        var input = Input.nextLine();

        switch (input){
            case "0":
                return new QuitGame();
            case "1":
                return null;
        }
        System.out.println("m(🤦‍♂️");
        return this;
    }

}
