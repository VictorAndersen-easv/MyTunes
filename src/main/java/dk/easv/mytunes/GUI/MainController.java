package dk.easv.mytunes.GUI;

import dk.easv.mytunes.DAL.db.DBConnector;
import dk.easv.mytunes.GUI.Model.MusicModel;
import javafx.fxml.Initializable;

import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class MainController implements Initializable{

    private MusicModel musicModel;




    public MainController()  {

        try {
            musicModel = new MusicModel();
        } catch (Exception e) {
            displayError(e);
            e.printStackTrace();
        }
    }

    private void displayError(Exception e) {
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }



}