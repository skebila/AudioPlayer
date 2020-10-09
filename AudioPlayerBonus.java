package Player;

import java.io.File;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AudioPlayerBonus extends Application{
    @Override
    public void start(Stage stage){
        stage.setTitle("🎵Mini MP3 Player");
        
        File song = new File("./src/media/Kalimba.mp3");
        String url = song.toURI().toString();
        Media media = new Media(url);
        MediaPlayer player = new MediaPlayer(media);
        MediaView mv = new MediaView(player);
        
        File song1 = new File("./src/media/blueberry.mp3");
        String url1 = song1.toURI().toString();
        Media media1 = new Media(url1);
        MediaPlayer player1 = new MediaPlayer(media1);
        MediaView mv1 = new MediaView(player1);
        
        Slider volume = new Slider();
        volume.setMin(0);
        volume.setMax(100); 
        volume.setPrefWidth(140);
        volume.setPrefHeight(30);
        volume.setValue(player.getVolume()*0);
        volume.valueProperty().addListener((Observable observable) -> {
            player.setVolume(volume.getValue() / 100);
        });
        volume.setValue(player1.getVolume()*30);
        volume.valueProperty().addListener((Observable observable) -> {
            player1.setVolume(volume.getValue() / 100);
        });
        
        
        FlowPane rootPane = new FlowPane();
        FlowPane box1 = new FlowPane();
        FlowPane box2 = new FlowPane();
        FlowPane text = new FlowPane();
        Text vol = new Text("Volume");
        vol.setStyle("-fx-font-size:17px;");
        
        Label description = new Label("Type in blueberry or Karimba");
        TextField mediaName = new TextField();
        mediaName.setMaxWidth(390);
        description.setFont(Font.font(20));
        
        
        text.getChildren().addAll(description, mediaName);
        rootPane.getChildren().add(text);
        text.setStyle("-fx-background-color:white;");
        text.setAlignment(Pos.TOP_CENTER);
        text.setHgap(5);
        text.setMinHeight(70);
        mediaName.setStyle("-fx-font-size:30px;");
        
        Button play = new Button("Play");
        Button pause = new Button("Pause");
        Button reStart = new Button("Restart");
        play.setPrefWidth(60);
        play.setPrefHeight(40);
        pause.setPrefWidth(60);
        pause.setPrefHeight(40);
        reStart.setPrefWidth(60);
        reStart.setPrefHeight(40);
        
        play.setOnAction((javafx.event.ActionEvent event) -> {
            if(mediaName.getText().equalsIgnoreCase("Karimba")){
                player1.stop();
                player.play();
            
            }else if(mediaName.getText().equalsIgnoreCase("Blueberry")){
                player.stop();
                player1.play();
            }
        });
        
        pause.setOnAction((javafx.event.ActionEvent e) -> {
                player1.pause();
                player.pause();
        });
   
        
        reStart.setOnAction((javafx.event.ActionEvent event) -> {
            if(mediaName.getText().equalsIgnoreCase("Karimba")){
                //player1.setMute(true);
                player.stop();
                player.play();
                
            }else if(mediaName.getText().equalsIgnoreCase("Blueberry")){
                //player.setMute(true);
                player1.stop();
                player1.play();
            }
        });
        
        
        rootPane.setAlignment(Pos.BOTTOM_CENTER);
        
        box1.getChildren().addAll(vol, volume);
        box1.setAlignment(Pos.BOTTOM_RIGHT);
        box1.setPrefWidth(200);
        box1.setStyle("-fx-background-color:lightgrey;");
        
        box2.getChildren().add(play);
        box2.getChildren().add(pause);
        box2.getChildren().add(reStart);
        box2.setAlignment(Pos.BOTTOM_LEFT);
        box2.setPrefWidth(200);
        box2.setHgap(5);
        box2.setStyle("-fx-background-color: lightgrey");
        
        
        rootPane.getChildren().add(box2);
        rootPane.getChildren().add(box1);
        rootPane.getChildren().addAll(mv, mv1);
        Scene scene = new Scene(rootPane, 400, 150);
        
        stage.setScene(scene);
        stage.show();
        }

    public static void main(String[] args) {
        launch(args);
        }
    }
