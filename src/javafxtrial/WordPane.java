package javafxtrial;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static javafxtrial.Handlers.addanimation;

public class WordPane
    {
        private final Pane playingpane; //PlayingPane
        private final Scene playingpanescene;
        private final PasswordField wordf;
        private final Label prospathies;
        private final Text cgwl = new Text();
        private final Partida thispartida;
        
        public WordPane(Partida partida)
            {
                
                this.playingpane = new Pane();
                this.playingpanescene = new Scene(playingpane);
                this.wordf = new PasswordField();
                this.prospathies = new Label();
                this.playingpanescene.getStylesheets().add("styles/JavaFxTrial.css");
                this.playingpane.getStylesheets().add("styles/JavaFxTrial.css");
                this.wordf.setId("wordf");
                this.playingpane.setId("playingpane");
                this.thispartida=partida;
            }
        
        public  Pane getplayingpane()
            {
                return this.playingpane;
            }
        public Partida getthispartida()
            {
                return this.thispartida;
            }
        public Text getcgwl()
            {
                return this.cgwl;
            }
        
        public  Scene getplayingpanescene()
            {
                return this.playingpanescene;
            }
        
        public PasswordField getwordf()
            {
                return wordf;
            }
        
        public Label getprospathies()
            {
                return prospathies;
            }
        
        public void wordfsetup()
            {
                    this.wordf.setPromptText("Εισάγετε Λέξη");
                    this.wordf.setLayoutX(JavaFxTrial.getwidth()-71*JavaFxTrial.getwidth()/100);
                    this.wordf.setLayoutY(JavaFxTrial.getheight()-72*JavaFxTrial.getheight()/100);
                    this.wordf.setPrefWidth(750);
                    this.wordf.setPrefHeight(150);
                    this.wordf.setOpacity(0.0);
                    Transitions.Fade(wordf, 1200, 100.0);
                    this.playingpane.getChildren().add(this.wordf);
            }
        
        public static void finalsetup(Stage Stage, Partida currentpartida)
            {   
                Button Ekkinisi = new Button("Εκκίνηση");
                Ekkinisi.setId("Ekkinisi");
                StaticMethods.addexitbutton(Stage,currentpartida.getcurrentwordpane().playingpane);
                currentpartida.getcurrentwordpane().cgwl.setText("Δίνει λέξη : " + Paiktis.getpaiktis1().getOnoma());
                currentpartida.getcurrentwordpane().cgwl.setId("cgwl");
                Transitions.TranslateY(currentpartida.getcurrentwordpane().cgwl, 1200, -150, JavaFxTrial.getheight()-88*JavaFxTrial.getheight()/100);
                currentpartida.getcurrentwordpane().playingpane.getChildren().add(currentpartida.getcurrentwordpane().cgwl);
                currentpartida.getcurrentwordpane().cgwl.setLayoutX(JavaFxTrial.getwidth()-75*JavaFxTrial.getwidth()/100);
                Ekkinisi.setOpacity(0.0);
                Transitions.Fade(Ekkinisi, 1200, 100.0);
                currentpartida.getcurrentwordpane().playingpane.getChildren().add(Ekkinisi);
                Ekkinisi.setLayoutX(JavaFxTrial.getwidth()-63*JavaFxTrial.getwidth()/100);
                Ekkinisi.setLayoutY(JavaFxTrial.getheight()-45*JavaFxTrial.getheight()/100);
                addanimation(Ekkinisi);
                Ekkinisi.addEventHandler
                    (
                        MouseEvent.MOUSE_CLICKED, event ->
                            {   
                                //System.out.println("Η λέξη είναι (Ekkinisi): " + currentpartida.getlexi().getWord());
                                StaticChecks.checknullword(Stage, Ekkinisi, currentpartida);
                                StaticMethods.addhomebutton(Stage, currentpartida, true);   
                            }
                    );
            } 
    }