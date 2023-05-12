package javafxtrial;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static javafxtrial.Handlers.addanimation;
import static javax.swing.JOptionPane.showMessageDialog;


public class Paiktis 
    {
        private final String Onoma;
        private int Score;
        private boolean Playing;
        private final Label NameLabel;
        private final static ArrayList<Paiktis> Paiktes = new ArrayList<>();
        private static int  count=0;
        private static Paiktis paiktis1;
        private static Paiktis paiktis2;
        
        public Paiktis(String onoma)
            {
                count=count+1;
                Onoma=onoma;
                this.NameLabel = new Label();
                this.Score=0;
                if(count==1)
                    {
                        paiktis1=this;
                        StaticChecks.setPaiktis1(paiktis1);
                    }
                else if(count==2)
                    {
                        paiktis2=this;
                        StaticChecks.setPaiktis2(paiktis2);
                    }
                
            }
        public static void resetcount()
            {
                count=0;
            }
        
        public static void swappaixtes()
            {
                if(Paiktes.get(0)==paiktis1 && Paiktes.get(1)==paiktis2)
                    {
                        Paiktes.set(0, paiktis2);
                        Paiktes.set(1, paiktis1);
                        paiktis1=Paiktes.get(0);
                        paiktis2=Paiktes.get(1);
                    }
                else if (Paiktes.get(0)==paiktis2 && Paiktes.get(1)==paiktis1)
                    {
                        Paiktes.set(0, paiktis1);
                        Paiktes.set(1, paiktis2);
                        paiktis1=Paiktes.get(0);
                        paiktis2=Paiktes.get(1);
                    }
            }
        public int getScore()
            {
                return this.Score;
            }
        
        public static void clearPaiktes()
            {
                Paiktes.clear();
            }

        
        public void scoreplusone()
            {
                this.Score=this.Score+1;
            }
        public String getOnoma()
            {
                return this.Onoma;
            }
        
        public Label getNameLabel()
            {
                return this.NameLabel;
            }
        
        public static Paiktis getpaiktis1()
            {
                return paiktis1;
            }
        
        public static Paiktis getpaiktis2()
            {
                return paiktis2;
            }
        
        public boolean getplaying()
            {
                return this.Playing;
            }
        static public ArrayList<Paiktis> getPaiktes()
            {
                return Paiktes;
            }
        

        static public Boolean checknullnames(TextField pf1, TextField pf2, Stage Stage)
            {
                Boolean playersok=false;
                
                if (pf1.getText().isEmpty() || pf2.getText().isEmpty())
                    {
                        showMessageDialog(null, "Πρέπει να δώσεις όνομα και στους δύο παίκτες");
                        playersok=false;
                    }
                
                else
                    {
                        Paiktis player1 = new Paiktis(pf1.getText());
                        player1.NameLabel.setText(pf1.getText());
                        Paiktes.add(player1);
                        //System.out.println("Player 1 ok");
                        Paiktis player2 = new Paiktis(pf2.getText());
                        player2.NameLabel.setText(pf2.getText());
                        Paiktes.add(player2);
                        //System.out.println("Player 2 ok");
                        playersok=true;
                    }
                return playersok;
            }
        
        static public void addPlayerTextfields(Stage Stage, Button Sinexeia)
            {    
                
                //TextField για Όνομα Παίχτη 1
                TextField pf1 = new TextField();
                    pf1.setId("playerf1");
                    pf1.setPromptText("Παίκτης 1");
                    JavaFxTrial.getplayerselectionpane().getChildren().add(pf1);
                    pf1.setLayoutX(JavaFxTrial.getwidth()-77*JavaFxTrial.getwidth()/100);
                    pf1.setLayoutY(JavaFxTrial.getheight()-60*JavaFxTrial.getheight()/100);
                    pf1.setPrefWidth(300);
                //TextField για Όνομα Παίχτη 1 
                
                //TextField για Όνομα Παίχτη 2
                TextField pf2 = new TextField();
                    pf2.setId("playerf2");
                    pf2.setPromptText("Παίκτης 2");
                    JavaFxTrial.getplayerselectionpane().getChildren().add(pf2);
                    pf2.setLayoutX(JavaFxTrial.getwidth()-39.5*JavaFxTrial.getwidth()/100);
                    pf2.setLayoutY(JavaFxTrial.getheight()-60*JavaFxTrial.getheight()/100);
                    pf2.setPrefWidth(300);
                    
                //TextField για Όνομα Παίχτη 2
                
                Text player1 = new Text("Παίχτης 1");
                Text player2 = new Text("Παίχτης 2");
                    player1.setId("player1");
                    player2.setId("player2");

                //Text Παίχτης 1 
                    JavaFxTrial.getplayerselectionpane().getChildren().add(player1);
                        player1.setLayoutX(pf1.getLayoutX()+30);
                        player1.setLayoutY(pf1.getLayoutY()-50);
                //Text Παίχτης 1

                //Text Παίχτης 2 
                    JavaFxTrial.getplayerselectionpane().getChildren().add(player2);
                        player2.setLayoutX(pf2.getLayoutX()+30);
                        player2.setLayoutY(pf2.getLayoutY()-50);
                
                addanimation(Sinexeia);
                Sinexeia.addEventHandler
                    (
                        MouseEvent.MOUSE_CLICKED, event ->  
                            {
                                Boolean ok=false;
                                ok=checknullnames(pf1, pf2, Stage);
                                if(ok==true)
                                    {
                                        try 
                                        {
                                            Partida.neapartida(Stage);
                                        } 
                                    catch (IOException ex) 
                                        {
                                            Logger.getLogger(Paiktis.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    } 
                            }
                    );
                //Δημιουργία Label με τα ονόματα των παιχτών  
            }   
    }