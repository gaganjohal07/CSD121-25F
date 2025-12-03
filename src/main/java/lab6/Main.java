package lab6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    private Label textLabel;
    private Slider sizeSlider;
    private boolean isBlue = false;

    @Override
    public void start(Stage stage) {

        textLabel = new Label("Resize Me!");
        textLabel.setFont(new Font(20));
        textLabel.setTextFill(Color.BLACK);

        sizeSlider = new Slider(10, 60, 20);
        sizeSlider.setShowTickLabels(true);

        Button applySizeButton = new Button("Apply Size");
        applySizeButton.setOnAction(this::applySize);

        Button changeColorButton = new Button("Change Color");
        changeColorButton.setOnAction(this::changeColor);

        VBox root = new VBox(15, textLabel, sizeSlider, applySizeButton, changeColorButton);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300, 250);
        stage.setScene(scene);
        stage.setTitle("Font Size & Color Changer");
        stage.show();
    }

    private void applySize(ActionEvent event) {
        double newSize = sizeSlider.getValue();
        textLabel.setFont(new Font(newSize));
    }

    private void changeColor(ActionEvent event) {
        if (isBlue) {
            textLabel.setTextFill(Color.BLACK);
            isBlue = false;
        } else {
            textLabel.setTextFill(Color.BLUE);
            isBlue = true;
        }
    }

}
