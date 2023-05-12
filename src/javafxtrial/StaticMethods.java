package javafxtrial;

import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import static javafxtrial.Handlers.addanimation;


public class StaticMethods 
    {
        private final static Button exit = new Button();
        private static Button homelive;
        private static Button homedone;
        
                    
        static public void showrules(Stage stage, Scene welcomescene)  
            {
                StackPane odigies = new StackPane();
                Scene odigiesscene = new Scene(odigies);   
                    odigies.setId("odigies");
                    stage.setScene(odigiesscene);
                Text gamerules = new Text
                                        (
                                            "ΟΔΗΓΙΕΣ ΠΑΙXΝΙΔΙΟΥ\n" +
                                            "\n" +
                                            "Η λέξη πρέπει να αποτελείται απο τουλάχιστον ΤΡΙΑ (3) ΕΛΛΗΝΙΚΑ γράμματα.\n" +
                                            "\n" +
                                            "Δεν επιτρέπονται τα ειδικά σύμβολα και οι αριθμοί.\n" +
                                            "\n" +
                                            "Ο παίκτης που μαντεύει την λέξη, εχει δικαίωμα να κάνει μέχρι και ΕΞΙ (6) λάθος μαντεψιές.\n" +
                                            "\n" +
                                            "Καλή διασκέδαση!"
                                        );
                    gamerules.setId("gamerules");
                    odigies.getStylesheets().add("styles/JavaFxTrial.css");
                    odigies.getChildren().add(gamerules);

                Button homepage = new Button ("<- Πίσω");
                    homepage.setId("homepage");
                    odigies.getChildren().add(homepage);
                    odigies.setAlignment(homepage, Pos.BOTTOM_LEFT);
                    odigies.setMargin(homepage, new Insets(20,20,20,25));
                    Handlers.addhomepagehandler(stage, homepage);
                
             }
        
        static public void welcomesetup(Scene welcomescene, Pane welcome, Stage Stage)
                {
                    Button instructions = new Button("Κανόνες");
                        instructions.setId("instructions");
                        welcome.setId("welcome");
                        welcome.getChildren().add(instructions);
                        instructions.setLayoutX(35);
                        instructions.setLayoutY(660);
                    addanimation(instructions);
                    instructions.addEventHandler
                        (
                                MouseEvent.MOUSE_CLICKED, event ->  
                            {
                                showrules(Stage, welcomescene);
                            }
                        );
                }
        
        static public void addexitbutton(Stage Stage, Pane pane)
            {
                Image exitimage = new Image("styles/Images/exit.png");
                ImageView exitimageview = new ImageView(exitimage);
                    exitimageview.setId("exitimage");
                    exitimageview.setFitHeight(100);
                    exitimageview.setFitWidth(100);
                    exitimageview.setPreserveRatio(true);
                    exit.setGraphic(exitimageview);
                    exit.setLayoutX(Stage.getWidth()-165);
                    exit.setLayoutY(Stage.getHeight()-165);
                    exit.setId("exit");
                    pane.getChildren().add(exit);
                
                    exit.hoverProperty().addListener
                        (
                            event ->  
                                {
                                    RotateTransition exitrotatelone = new RotateTransition();
                                        exitrotatelone.setAxis(Rotate.Z_AXIS);
                                        exitrotatelone.setFromAngle(0);
                                        exitrotatelone.setToAngle(15);
                                        exitrotatelone.setAutoReverse(true);
                                        exitrotatelone.setDuration(Duration.millis(250));
                                        exitrotatelone.setNode(exit);

                                    RotateTransition exitrotater = new RotateTransition();
                                        exitrotater.setAxis(Rotate.Z_AXIS);
                                        exitrotater.setFromAngle(15);
                                        exitrotater.setToAngle(-15);
                                        exitrotater.setAutoReverse(true);
                                        exitrotater.setDuration(Duration.millis(250));
                                        exitrotater.setNode(exit);

                                    RotateTransition exitrotateltwo = new RotateTransition();
                                        exitrotateltwo.setAxis(Rotate.Z_AXIS);
                                        exitrotateltwo.setFromAngle(-15);
                                        exitrotateltwo.setToAngle(0);
                                        exitrotateltwo.setByAngle(15);
                                        exitrotateltwo.setAutoReverse(true);
                                        exitrotateltwo.setDuration(Duration.millis(250));
                                        exitrotateltwo.setNode(exit);

                                    SequentialTransition seqT = new SequentialTransition (exit, exitrotatelone, exitrotater, exitrotateltwo);
                                        seqT.play();

                                }
                        );


            }
        
            static public void addhomebutton(Stage Stage, Partida currentpartida, Boolean live)
                {
                    
                    
                    if(live)
                        {
                            homelive = new Button();
                            Handlers.addhomehandler(Stage, currentpartida, live, homelive);
                            Transitions.Fade(homelive, 5000, 100.0);
                            Image homeliveimage = new Image("styles/Images/HomeButton.png");
                            ImageView homeliveimageview = new ImageView(homeliveimage);
                                homeliveimageview.setId("exitimage");
                                homeliveimageview.setFitHeight(75);
                                homeliveimageview.setFitWidth(75);
                                homeliveimageview.setPreserveRatio(true);
                                homelive.setGraphic(homeliveimageview);
                                homelive.setLayoutX(30);
                                homelive.setLayoutY(Stage.getHeight()-150);
                                homelive.setId("exit");
                                currentpartida.getcurrentwordpane().getplayingpane().getChildren().remove(homedone);
                                currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(homelive);
                                
                        }
                    else
                        {
                            
                            homedone = new Button();
                            Handlers.addhomehandler(Stage, currentpartida, live, homedone);
                            Transitions.Fade(homedone, 5000, 100.0);
                            Image homedoneimage = new Image("styles/Images/HomeButton.png");
                            ImageView homedoneimageview = new ImageView(homedoneimage);
                                homedoneimageview.setId("exitimage");
                                homedoneimageview.setFitHeight(75);
                                homedoneimageview.setFitWidth(75);
                                homedoneimageview.setPreserveRatio(true);
                                homedone.setGraphic(homedoneimageview);
                                homedone.setLayoutX(30);
                                homedone.setLayoutY(Stage.getHeight()-150);
                                homedone.setId("exit");
                            currentpartida.getcurrentwordpane().getplayingpane().getChildren().remove(homelive);
                            currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(homedone);
                        }
                    
                    
                }
        
        static public void removeexitbutton(Pane pane)
            {
                pane.getChildren().remove(exit);
            }
        
        static public Button getexitbutton()
            {
                return exit;
            }
        
        static public Button gethomelivebutton()
            {
                return homelive;
            }
        
        static public Button gethomedonebutton()
            {
                return homedone;
            }
        
        static public void playsetup(Pane welcome)
            {
                //Κουμπί Play
                    Handlers.getPlay().setLayoutX(JavaFxTrial.getwidth()-64.5*JavaFxTrial.getwidth()/100);
                    welcome.getChildren().add(Handlers.getPlay()); 
                    Transitions.TranslateY(Handlers.getPlay(), 1200, -200, JavaFxTrial.getheight()-64*JavaFxTrial.getheight()/100);
                //Κουμπί Play
            }
        
        static public void removeplay(Pane welcome)
            {
                //Κουμπί Play
                    welcome.getChildren().remove(Handlers.getPlay()); 
                //Κουμπί Play
            }
    }