package sample;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.FocusListener;
import java.io.IOException;
import java.lang.annotation.Target;
import java.net.URL;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.*;


public class Controller implements Initializable {


    ObservableList<String> startingStations= FXCollections.observableArrayList("Kielce","Krakow","Warszawa","Nowy Sacz","Wroclaw",
            "Radomsko","Sopot","Sosnowiec","Katowice","Gdansk");

    ObservableList<String> finalStations= FXCollections.observableArrayList("Kielce","Krakow","Warszawa","Nowy Sacz","Wroclaw",
            "Radomsko","Sopot","Sosnowiec","Katowice","Gdansk");
    ObservableList<String> hours=FXCollections.observableArrayList("5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","any hour");


    @FXML
     String SelectStationStart(ActionEvent event)
    {
        String start=startStationsBoxID.getSelectionModel().getSelectedItem().toString();
    return start;

    }
    @FXML
     String SelectStationEnd(ActionEvent event)
    {
        String end= endStationsBoxID.getSelectionModel().getSelectedItem().toString();
        return end;

    }
    @FXML
            String SelectHour(ActionEvent event)
    {
        return hoursChoiceBoxID.getSelectionModel().getSelectedItem().toString();
    }








@FXML
     void displayStations(ActionEvent event)
    {

        String start=SelectStationStart(event);
        String end=SelectStationEnd(event);
        String hour= (SelectHour(event));


        if(hour.equals("any hour"))
        {


            for(Train index: trains) {
                if (index.getStartStation().equals(start) && index.getEndStation().equals(end))
                    matchingTrains.add(index);

            }
        }else {


            for (Train index : trains) {
                if (index.getStartStation().equals(start) && index.getEndStation().equals(end) && (index.getDepartureHour()) >= Integer.parseInt(hour))
                    matchingTrains.add(index);

            }
        }


    tableView.getItems().clear();
        tableView.refresh();
     tableView.getItems().addAll(matchingTrains);





    }
    @FXML
    void setBuyTicket(ActionEvent event)
    {
        Train t=tableView.getSelectionModel().getSelectedItem();
        ObservableList<Train> newTrains=FXCollections.observableArrayList();
        dataManager.writeDataFX(newTrains);
        int seats=t.getSeats_amount();
        seats=seats-1;
        if(seats>=0) {
            tableView.getSelectionModel().getSelectedItem().setSeats_amount(seats);
            tableView.refresh();
            for(Train index:newTrains)
                if(index.getName().equals(tableView.getSelectionModel().getSelectedItem().getName()))
                    index.setSeats_amount(seats);
                dataManager.saveTSlist(newTrains);
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"THE TICKET HAS BEEN BOUGHT PRIZE: "+tableView.getSelectionModel().getSelectedItem().getTicketPrize());
            alert.showAndWait();
        }else
        {
            Alert alertError= new Alert(Alert.AlertType.ERROR,"NO TICKETS!!");
            alertError.showAndWait();
        }

    }

    public void setValues(
            )
    {
        tableView.setItems(trains);
    }
    public static State convert(String state)
    {
        if(state.equals("NEW"))
            return(State.NEW);
        else if(state.equals("PASSED"))
            return(State.PASSED);
        else if(state.equals("LATE"))
            return (State.LATE);
        else
            return(State.BROKEN);

    }
    @FXML
    String setTf(ActionEvent event)
    {
        return tf.getText();
    }


    @FXML
    void setShowInfo(ActionEvent event)
    {
        String s= setTf(event);


        ObservableList<Train> actual= tableView.getItems();
        for(Train index:actual)
            if(index.getName().equals(s)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "TRAIN INFO:" + " " + index.getName() + " " + index.getCondition() + " " + index.getStartStation() + " " + index.getEndStation());
                alert.showAndWait();
            }


    }



    @FXML
    private ComboBox startStationsBoxID;
    @FXML
    private ComboBox endStationsBoxID;
    @FXML
    private ComboBox hoursChoiceBoxID;
    @FXML
    private TableView<Train> tableView;
    @FXML
    private TableColumn<Train,String> firstColumn;
    @FXML
    private TableColumn<Train,String> secondColumn;
    @FXML
    private TableColumn<Train,Integer> thirdColumn;
    @FXML
    private TableColumn<Train,String>  fourthColumn;
    @FXML
    private Label lID;
    @FXML
    private TableColumn<Train,String> fifthColumn;
    @FXML
    private TableColumn<Train,String> sixthColumn;
    @FXML
    private  TableColumn<Train,Integer> seventhColumn;
    @FXML
    private Button displayButton;
    @FXML
    private Button buyTicket;
    @FXML
    private Tooltip tooltip= new Tooltip();
    @FXML
    private TextField tf= new TextField();
    @FXML
    private Button showInfo=new Button();
    TrainStationContainer trainStationContainerFX= new TrainStationContainer(new HashMap<String,TrainStation>());
    ObservableList<Train> matchingTrains=FXCollections.observableArrayList();
    DataManager dataManager= new DataManager();
    ObservableList<Train> trains=FXCollections.observableArrayList();
    List<Train> trainList= new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startStationsBoxID.setItems(startingStations);
        endStationsBoxID.setItems(finalStations);
        hoursChoiceBoxID.setItems(hours);
/*
        trainList.add(t1);
        trainList.add(t2);
        trainList.add(t3);
        trainList.add(t4);
        trainList.add(t5);
        trainList.add(t6);
        trainList.add(t7);
        trainList.add(t8);
        trainList.add(t9);
        trainList.add(t10);

 */
       // dataManager.saveTSlist(trainList);

            dataManager.writeDataFX(trains);

        firstColumn.setCellValueFactory(new PropertyValueFactory<Train,String>("name"));
        secondColumn.setCellValueFactory(new PropertyValueFactory<Train, String>("arrivalTime"));
        thirdColumn.setCellValueFactory(new PropertyValueFactory<Train,Integer>("seats_amount"));
        fourthColumn.setCellValueFactory(new PropertyValueFactory<Train,String>("departureTime"));
        fifthColumn.setCellValueFactory(new PropertyValueFactory<Train,String>("startStation"));
        sixthColumn.setCellValueFactory(new PropertyValueFactory<Train,String>("endStation"));
        seventhColumn.setCellValueFactory(new PropertyValueFactory<Train,Integer>("ticketPrize"));

        //setValues();
        Calendar calendar = Calendar.getInstance();

        tooltip.setText(String.valueOf(calendar.getTime()));
        tableView.setTooltip(tooltip);
        tableView.refresh();



    }
}
