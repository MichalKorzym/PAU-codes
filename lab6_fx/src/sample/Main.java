package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.GUI.AdminGUI;

import java.io.*;
import java.util.ArrayList;
import java.util.List;




public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("User GUI");
        primaryStage.setScene(new Scene(root, 800 ,600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

        try {
            new AdminGUI();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

/*
public class Main{

   public static void main(String[] args) throws IOException, ClassNotFoundException {
       new AdminGUI().setVisible(true);


       System.out.println("Write CSV file:");
       CsvFileWriter.writeCsvFile();
       CsvFileWriter.writeStationContainerCSV();
       System.out.println("\nRead CSV file:");
       CsvFileReader.readCsvFile();
       CsvFileReader.readStationContainerCSV();




   }
   */



