package javafxtrial;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import static javafxtrial.Transitions.Fade;

public class Handlers 
    {   
        static private final Button Play = new Button("Παίξε");
        
        static public Button getPlay()
            {
                return Play;
            }
        static public void addplayhandler(Stage Stage, Pane welcome)
            {
                
                Play.setId("Play");
                StaticMethods.playsetup(welcome);
                
                
                //Μετάβαση στην Σελίδα Επιλογής Παιχτών
                        Play.addEventHandler
                            (
                                MouseEvent.MOUSE_CLICKED, event ->  
                                    {
                                        Stage.setScene(JavaFxTrial.getwelcomescene());
                                        addgamekind(Stage, welcome);
                                        StaticMethods.removeplay(welcome);
                                    }
                            );
                        addanimation(Play);
             //Μετάβαση στην Σελίδα Επιλογής Παιχτών 
            }
        
        public static void addanimation(Button Button)
            {
                Button.addEventHandler
                    (
                        MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() 
                            {
                                @Override
                                public void handle(MouseEvent e) 
                                    {
                                      Transitions.Scale(Button, 200, 1.0, 1.2);
                                    }
                            }
                    );

                Button.addEventHandler
                    (
                        MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() 
                            {
                                @Override
                                public void handle(MouseEvent e) 
                                    {
                                      Transitions.Scale(Button, 200,1.2, 1.0);
                                    }
                            }
                    );
              
            }
        private static void addgamekind(Stage Stage, Pane welcome)
            {
                Text choosekind = new Text("Επιλέξτε είδος παιχνιδιού");
                Button SinglePlayer = new Button("Εναντίον Υπολογιστή");
                Button MultiPlayer = new Button("2-Παίκτες");
                SinglePlayer.setId("SinglePlayer");
                MultiPlayer.setId("MultiPlayer");
                choosekind.setId("choosekind");
                //MultiPlayer.setLayoutX(JavaFxTrial.getwidth()-55*JavaFxTrial.getwidth()/100);
                MultiPlayer.setLayoutY(JavaFxTrial.getheight()-55*JavaFxTrial.getheight()/100);
                //SinglePlayer.setLayoutX(JavaFxTrial.getwidth()-59*JavaFxTrial.getwidth()/100);
                SinglePlayer.setLayoutY(JavaFxTrial.getheight()-40*JavaFxTrial.getheight()/100);
                choosekind.setLayoutX(JavaFxTrial.getwidth()-71*JavaFxTrial.getwidth()/100);
                choosekind.setLayoutY(JavaFxTrial.getheight()-63*JavaFxTrial.getheight()/100);
                welcome.getChildren().add(SinglePlayer);
                welcome.getChildren().add(MultiPlayer);
                welcome.getChildren().add(choosekind);
                
                Transitions.TranslateX(SinglePlayer, 500, -400.0, JavaFxTrial.getwidth()-59*JavaFxTrial.getwidth()/100);
                SinglePlayer.addEventHandler
                            (
                                    MouseEvent.MOUSE_CLICKED, event ->  
                                {
                                    singleplayer(Stage, welcome);
                                    removekinds(welcome, SinglePlayer, MultiPlayer,choosekind);
                                    
                                }
                            );
                
                addanimation(SinglePlayer);
                
                Transitions.TranslateX(MultiPlayer, 500, JavaFxTrial.getwidth()+400,JavaFxTrial.getwidth()-55*JavaFxTrial.getwidth()/100 );
                
                MultiPlayer.addEventHandler
                            (
                                    MouseEvent.MOUSE_CLICKED, event ->  
                                {
                                    multiplayer(Stage, welcome);
                                    removekinds(welcome, SinglePlayer, MultiPlayer, choosekind);
                                    
                                }
                            );
                
                addanimation(MultiPlayer);
                
            }
        
        private static void singleplayer(Stage Stage, Pane welcome)
            {
                settupslider(Stage, welcome);
            }
        
        private static void settupslider(Stage Stage, Pane welcome)
            {
                final Button Continue = new Button("Συνέχεια");
                Continue.setId("Continue");
                
                String[] ids = new String[] 
                    {
                        "Easy", "Hard", "Impossibru"
                    };
                
                String[] difs = new String[] 
                    {
                        "Εύκολο", "Δύσκολο", "Impossibru"
                    };
                
                Label difflabel = new Label("Εύκολο");
                Text choosedif = new Text("Επιλέξτε Δυσκολία");
                Slider difficulty = new Slider();
                choosedif.setId("choosediff");
                difflabel.setId("difflabel");
                difficulty.setId("difficulty");
                difficulty.setMin(0);
                difficulty.setMax(2);
                difficulty.setValue(0);
                difficulty.setShowTickLabels(true);
                difficulty.setShowTickMarks(true);
                difficulty.setMajorTickUnit(1);
                difficulty.setMinorTickCount(0);
                difficulty.setSnapToTicks(true);
                difficulty.setBlockIncrement(1);
                welcome.getChildren().add(difficulty);
                welcome.getChildren().add(difflabel);
                welcome.getChildren().add(choosedif);
                welcome.getChildren().add(Continue);
                
                difficulty.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> 
                    {
                        int value = (int) Math.round(new_val.doubleValue());
                        difficulty.setValue(value);
                        difflabel.setText(difs[value]);
                        difflabel.setId(ids[value]);
                        difflabel.applyCss();
                    });
                
                difficulty.setLayoutX(JavaFxTrial.getwidth()-70*JavaFxTrial.getwidth()/100);
                difficulty.setLayoutY(JavaFxTrial.getheight()-64*JavaFxTrial.getheight()/100);
                difflabel.setLayoutX(JavaFxTrial.getwidth()-45*JavaFxTrial.getwidth()/100);
                difflabel.setLayoutY(JavaFxTrial.getheight()-55*JavaFxTrial.getheight()/100);
                choosedif.setLayoutX(JavaFxTrial.getwidth()-70*JavaFxTrial.getwidth()/100);
                choosedif.setLayoutY(JavaFxTrial.getheight()-63*JavaFxTrial.getheight()/100);
                Continue.setLayoutX(JavaFxTrial.getwidth()-65*JavaFxTrial.getwidth()/100);
                Continue.setLayoutY(JavaFxTrial.getheight()-40*JavaFxTrial.getheight()/100);
                
                Continue.addEventHandler
                            (
                                    MouseEvent.MOUSE_CLICKED, event ->  
                                        {
                                            int value = (int) Math.round(difficulty.getValue());
                                            Partida.sethowhard(ids[value]);
                                            Partida.setmultiplayerstatus(false);
                                            try 
                                                {
                                                    Partida.neapartida(Stage);
                                                }
                                            catch (IOException ex) 
                                                {
                                                    Logger.getLogger(Handlers.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                            
                                        }
                            );
                
                Continue.hoverProperty().addListener
                            (
                                event ->  
                                    {
                                        SequentialTransition seqT = new SequentialTransition (Transitions.Scale(Continue, 200, 1.0, 1.2), Transitions.Scale(Continue, 200,1.2, 1.0));
                                            seqT.play();

                                    }
                            );
                

            }
        
        private static void multiplayer(Stage Stage, Pane welcome)
            {
                Partida.setmultiplayerstatus(Boolean.TRUE);
                final Button Sinexeia = new Button("Συνέχεια");
                final Button three = new Button("3");
                final Button one = new Button("1");
                final Text howmany = new Text("Στις πόσες νίκες θέλετε να παίξετε;");
                    howmany.setId("howmany");
                    one.setId("one");
                    three.setId("three");
                    Sinexeia.setId("Sinexeia");
                        welcome.getChildren().add(one);
                        welcome.getChildren().add(three);
                        welcome.getChildren().add(howmany);
                            howmany.setLayoutX(JavaFxTrial.getwidth()-76*JavaFxTrial.getwidth()/100);
                            howmany.setLayoutY(JavaFxTrial.getheight()-68*JavaFxTrial.getheight()/100);
                            one.setLayoutX(JavaFxTrial.getwidth()-70*JavaFxTrial.getwidth()/100);
                            one.setLayoutY(JavaFxTrial.getheight()-55*JavaFxTrial.getheight()/100);
                            three.setLayoutX(JavaFxTrial.getwidth()-40.5*JavaFxTrial.getwidth()/100);
                            three.setLayoutY(JavaFxTrial.getheight()-55*JavaFxTrial.getheight()/100);
                            addonehandler(one, Stage, welcome, Sinexeia);
                            addthreehandler(three, Stage, welcome, Sinexeia);
            }
        
        static public void playersset(Stage Stage, Pane welcome, Button Sinexeia)
            {
                Stage.setScene(JavaFxTrial.getplayerselectionscene());
                StaticMethods.removeexitbutton(welcome);
                StaticMethods.addexitbutton(Stage, JavaFxTrial.getplayerselectionpane());
                JavaFxTrial.getplayerselectionpane().getChildren().add(Sinexeia);
                Sinexeia.setLayoutX(JavaFxTrial.getwidth()-60.5*JavaFxTrial.getwidth()/100);
                Sinexeia.setLayoutY(JavaFxTrial.getheight()-47*JavaFxTrial.getheight()/100);
                Paiktis.addPlayerTextfields(Stage, Sinexeia);
            }
        
        private static void addonehandler(Button one, Stage Stage, Pane welcome, Button Sinexeia)
            {
                one.addEventHandler
                            (
                                MouseEvent.MOUSE_CLICKED, event ->  
                                    {
                                        Partida.setnumberofpartides(1);
                                        playersset(Stage, welcome, Sinexeia);
                                    }
                            );
                
                addanimation(one);
                
            }
        
        private static void addthreehandler(Button three,Stage Stage, Pane welcome, Button Sinexeia)
            {
                three.addEventHandler
                            (
                                MouseEvent.MOUSE_CLICKED, event ->  
                                    {
                                        Partida.setnumberofpartides(3);
                                        playersset(Stage, welcome, Sinexeia);
                                    }
                            );
                
                addanimation(three);

            }
        
        static public void addexithandler()
            {

                //Μετάβαση στην Σελίδα Επιλογής Παιχτών
                        StaticMethods.getexitbutton().addEventHandler
                            (
                                MouseEvent.MOUSE_CLICKED, event ->  
                                    {
                                        Alert alert = new Alert(AlertType.CONFIRMATION);
                                            alert.setTitle("ΕΞΟΔΟΣ");
                                            alert.setHeaderText("Το παιχνίδι θα τερματιστεί.");
                                            alert.setContentText("Έιστε σίγουροι;");

                                        Optional<ButtonType> result = alert.showAndWait();
                                        if (result.get() == ButtonType.OK)
                                            {
                                               Stage stage = (Stage) StaticMethods.getexitbutton().getScene().getWindow();
                                               stage.close(); 
                                            }
                                    }
                            );
                    //Μετάβαση στην Σελίδα Επιλογής Παιχτών 
            }
        
        static public void addhomehandler(Stage stage, Partida currentpartida, Boolean live, Button button)
            {
                if(live)
                    {
                        Label one = new Label();
                        FadeTransition zero = new FadeTransition(Duration.millis(2500),one);
                        TranslateTransition translate = Transitions.TranslateY(Play, 1500, -300, JavaFxTrial.getheight()-64*JavaFxTrial.getheight()/100);
                        SequentialTransition first = new SequentialTransition(zero, translate);
                        addanimation(StaticMethods.gethomelivebutton());

                        button.addEventHandler
                            (
                                MouseEvent.MOUSE_CLICKED, (MouseEvent event1) -> 
                                    {
                                        
                                        Alert alert = new Alert(AlertType.CONFIRMATION);
                                            alert.setTitle("Επιστροφή στην αρχική σελίδα");
                                            alert.setHeaderText("Η τρέχουσα παρτίδα θα τερματιστεί.");
                                            alert.setContentText("Έιστε σίγουροι;");

                                            Optional<ButtonType> result = alert.showAndWait();
                                            if (result.get() == ButtonType.OK)
                                                { 
                                                    currentpartida.getcurrentwordpane().getplayingpane().getChildren().remove(StaticMethods.gethomedonebutton());
                                                    currentpartida.getcurrentwordpane().getplayingpane().getChildren().remove(StaticMethods.gethomelivebutton());
                                                    currentpartida.getcurrentwordpane().getplayingpane().getChildren().remove(Play);
                                                    first.play();
                                                    currentpartida.getcurrentwordpane().getplayingpane().getChildren().forEach
                                                        (
                                                            i -> 
                                                                {
                                                                    Transitions.Fade(i, 1200, 0.0);
                                                                }
                                                        );

                                                    JavaFxTrial.getwelcomepane().getChildren().clear();
                                                    JavaFxTrial.getplayerselectionpane().getChildren().clear();
                                                    Paiktis.resetcount();
                                                    Paiktis.clearPaiktes();
                                                    currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(Play);
                                                }
                                    }
                            );
                    }
                else
                    {
                        Label one = new Label();
                        FadeTransition zero = new FadeTransition(Duration.millis(2500),one);
                        TranslateTransition translate = Transitions.TranslateY(Play, 1500, -300, JavaFxTrial.getheight()-64*JavaFxTrial.getheight()/100);
                        SequentialTransition first = new SequentialTransition(zero, translate);
                        StaticMethods.gethomedonebutton().setMouseTransparent(false);
                        addanimation(StaticMethods.gethomedonebutton());

                        button.addEventHandler
                            (
                                MouseEvent.MOUSE_CLICKED, (MouseEvent event1) -> 
                                    {
                                        currentpartida.getcurrentwordpane().getplayingpane().getChildren().remove(StaticMethods.gethomedonebutton());
                                        currentpartida.getcurrentwordpane().getplayingpane().getChildren().remove(StaticMethods.gethomelivebutton());
                                        currentpartida.getcurrentwordpane().getplayingpane().getChildren().remove(Play);
                                        first.play();
                                        currentpartida.getcurrentwordpane().getplayingpane().getChildren().forEach
                                            (
                                                i -> 
                                                    {
                                                        Transitions.Fade(i, 1200, 0.0);
                                                    }
                                            );

                                        JavaFxTrial.getwelcomepane().getChildren().clear();
                                        JavaFxTrial.getplayerselectionpane().getChildren().clear();
                                        Paiktis.resetcount();
                                        Paiktis.clearPaiktes();
                                        currentpartida.getcurrentwordpane().getplayingpane().getChildren().remove(Transitions.getplayagain());
                                        currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(Play);
                                                
                                    }
                            );
                    } 
            }
        
        
        static public void addhomepagehandler(Stage stage, Button homepage)
            {
                homepage.addEventHandler
                    (
                        MouseEvent.MOUSE_CLICKED, (var event) ->
                            {
                                stage.setScene(JavaFxTrial.getwelcomescene());
                            }
                    );
              
                addanimation(homepage);
            }
        
        static private void removekinds(Pane welcome, Button single, Button multi, Text kind)
            {
                welcome.getChildren().remove(single);
                welcome.getChildren().remove(multi);
                welcome.getChildren().remove(kind);
            }
    }