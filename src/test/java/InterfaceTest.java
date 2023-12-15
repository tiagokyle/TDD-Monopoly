import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.io.IOException;

@ExtendWith(ApplicationExtension.class)
public class InterfaceTest {
    Pane mainRoot;
    Stage mainStage;
    Object controller;

    @Start
    public void start(Stage stage) throws IOException {
        this.mainStage = stage;
        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("C:\\Users\\matthew.santiago\\Documents\\TDDMonopoly\\TDD-Monopoly\\src\\main\\resources\\com\\example\\tddmonopoly\\game-view.fxml"));
        this.mainRoot = loader.load();
        this.controller = loader.getController();
        stage.setScene(new Scene(mainRoot));
        stage.show();
    }

    @Test
    public void testMessageAppearsWhenDiceRoll(FxRobot robot){
        robot.clickOn(".diceButton");

        Assertions.assertEquals("You rolled: ",robot.lookup(".diceResult").queryText().getText());
    }
}
