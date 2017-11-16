/**
 * Author: Jack Brashier
 * Date: 11/15/2017
 * This program is available for downloading / editing / republishing with no restrictions.
 */
import javafx.application.Application;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ScoresFile extends Application {

    public void start(Stage primaryStage) throws FileNotFoundException {
        TextInputDialog fileQuery = new TextInputDialog("/Users/username/Desktop/subfolder/filename.txt");
        fileQuery.setTitle("Find score total and average");
        fileQuery.setHeaderText("Please link the file containing the scores.");
        fileQuery.setContentText("File Path:");
        fileQuery.showAndWait();
        File file = new File(fileQuery.getResult());
        Scanner fileReader = new Scanner(file);
        ArrayList<String> score = new ArrayList<>();
        while(fileReader.hasNext() == true) {
            score.add(fileReader.next());
        }
        fileReader.close();
        double total = 0;
        double average;
        for(int i = 0; i < score.size(); i++) {
            total += Double.parseDouble(score.get(i));
        }
        double realTotal = Math.floor(total * 100) / 100;
        average = Math.floor((total / (score.size())) * 100) / 100;
        Alert displayResults = new Alert(AlertType.INFORMATION);
        displayResults.setTitle("Find score total and average");
        displayResults.setHeaderText("Using the scores in " + fileQuery.getResult() + "...");
        displayResults.setContentText("Score Average: " + Double.toString(average) + "\nScore Total: " + Double.toString(realTotal));
        displayResults.showAndWait();
    }
}
