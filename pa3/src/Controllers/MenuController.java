package Controllers;

import Models.Game;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.util.ArrayList;

public class MenuController {

    @FXML private ChoiceBox<String> playerChoiceBox;

    @FXML private ChoiceBox<String> timerChoiceBox;

    @FXML
    Button startGameButton;

    MainController mainController;


    int numberOfPlayers;

    int timerValue;


    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void initGameViewController() {
        this.mainController.gameViewController.injectMenuController(this);
    }
    /**
     * Event handler for when the start button has been clicked
     */
    @FXML
    public void startButtonClicked(Event e) {
        // initialize the data for the Game object that will be used by the GameController
        initGameData();
        // initialize the TurnOrderViewController with the number of players so that it can roll the correct amount of
        //      dice
        // switch active tab to the TurnOrderView tab
        this.mainController.selectTurnOrderTab();
        this.mainController.closeMenuTab();
        // initialize the TurnOrderController with the number of players in the game


        // Select the game tab
        //this.mainController.tabPane.getSelectionModel().select(this.mainController.gameTab);
        // Transfer controller ownership to the GameController
        // call the game tab page controller's init function
//        this.gameTabPageController = new GameController(this.game);
//        gameTabPageController.init();

    }



    /*
     * This initializes the Game object for use by the game controller
     */
    private void initGameData() {

        // Grab the value of the selected player choice box input
        String playerChoiceBoxValue = playerChoiceBox.getValue();
        // split the value into a string part and a digit part
        String[] playerSplit = playerChoiceBoxValue.split("\\s");
        this.numberOfPlayers = Integer.parseInt(playerSplit[0]);
        /* Used for debugging purposes
        System.out.println("Number of Players Selected: " + this.numberOfPlayers);
        */
        // Grab the value of the selected timer choice box input
        String timerChoiceBoxValue = timerChoiceBox.getValue();
        // split the value into a string part and a digit part
        String[] timerSplit = timerChoiceBoxValue.split("\\s");
        this.timerValue = Integer.parseInt(timerSplit[0]);
        /* Used for debugging purposes
        System.out.println("Game timer length Selected: " + this.timerValue);
        */
    }

}
