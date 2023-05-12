package javafxtrial;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class  JavaFxTrial extends Application 
    {
        private static double stageheight;
        private static double stagewidth;
        private final static Pane welcome = new Pane(); //welcomePane
        private final static Scene welcomescene = new Scene (welcome); //welcomeScene
        private static final Pane playerselectionpane=new Pane(); //PlayerSelectionPane
        private static final Scene playerselectionscene = new Scene(playerselectionpane); //PlayerSelectionScene

    public static double getwidth()
        {
            return stagewidth;
        }
    
    public static double getheight()
        {
            return stageheight;
        }
    
    public static Pane getwelcomepane()
        {
            return welcome;
        }

    public static Pane getplayerselectionpane()
        {
            return playerselectionpane;
        }

    public static Scene getplayerselectionscene()
        {
            return playerselectionscene;
        }
        
    public static Scene getwelcomescene()
        {
            return welcomescene;
        }
    public static void main(String[] args) 
        {  
            launch(args);
        }
    private void InitializeGame(Stage Stage) throws IOException
        {
            //Παράθυρο Παιχνιδιού
                Stage.setTitle("Κρεμάλα");
                Image kremala = new Image("styles/Images/gallows.png");
                Stage.getIcons().add(kremala); 
                Stage.resizableProperty().setValue(false);
                Stage.setWidth(1800); 
                Stage.setHeight(800);
                stagewidth=Stage.getWidth();
                stageheight=Stage.getHeight();
                Bot.loadEasy();
                Bot.loadHard();
                Bot.loadImpossibru();
                Stage.setScene(welcomescene); //Εμφάνιση welcomeScreen κατά την εκκίνηση του προγράμματος
            //Παράθυρο Παιχνιδιού

            //Stylesheets
                welcomescene.getStylesheets().add("styles/JavaFxTrial.css");
            //Stylesheets   

            //StaticMethods
                StaticMethods.welcomesetup(welcomescene, welcome, Stage);
                StaticMethods.addexitbutton(Stage, welcome);
                playerselectionscene.getStylesheets().add("styles/JavaFxTrial.css");
                playerselectionpane.getStylesheets().add("styles/JavaFxTrial.css");
                playerselectionpane.setId("playerselectionpane");    
            //StaticMethods

            //Listenters, Event Hanlders
                Handlers.addexithandler();
                Handlers.addplayhandler(Stage, welcome);
            //Listenters, Event Hanlders

            Stage.show();
        }

    @Override
        public void start(Stage Stage) throws Exception 
            {
                InitializeGame(Stage);
            }
    }