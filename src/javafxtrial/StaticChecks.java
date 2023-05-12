package javafxtrial;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static javafxtrial.Handlers.addanimation;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import static javax.swing.JOptionPane.showMessageDialog;

public class StaticChecks 
    {
        private static Paiktis paiktis1;
        private static Paiktis paiktis2;
        private static final Label score1 = new Label();
        private static final Label name1 = new Label();
        private static final Label score2 = new Label();
        private static final Label name2 = new Label();
        private static String Meaning=null;
        
        public static void addgrammatahandlers(Stage Stage, Partida currentpartida)
            {
                for(Button i : currentpartida.getcurrentletters().getgrammata())
                    {
                        addanimation(i);
                        i.addEventHandler
                            (MouseEvent.MOUSE_CLICKED, (var event) ->
                                {
                                    try 
                                        {
                                            currentpartida.getcurrentletters().transparent(true);
                                            checkletter(i, Stage, currentpartida);
                                        } 
                                    catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) 
                                        {
                                            Logger.getLogger(StaticChecks.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                }
                            );
                    }
            }
        
        public static void setscores()
            {
                score1.setText(paiktis1.getScore() + "");
                score2.setText(paiktis2.getScore() + "");
            }
        
        public static void setnames()
            {
                name1.setText(paiktis1.getOnoma());
                name2.setText(paiktis2.getOnoma());
            }
        public static String getMeaning()
            {
                return Meaning;
            }
        
        public static Paiktis comparescores()
            {
                if(paiktis1.getScore()>paiktis2.getScore())
                    {
                        return paiktis1;
                    }
                else
                    {
                        return paiktis2;
                    }
            }
        public static Paiktis getPaiktis1()
            {
                return paiktis1;
            }
        
        public static Paiktis getPaiktis2()
            {
                return paiktis2;
            }
        
        public static void setPaiktis1(Paiktis paiktis)
            {
                paiktis1=paiktis;
            }
        
        public static void setPaiktis2(Paiktis paiktis)
            {
                paiktis2=paiktis;
            }
        
        private static void transitnodes(Partida currentpartida)
            {
                if(Partida.getmultiplayerstatus()==true)
                    {
                        setscores();
                        setnames();
                        name1.setOpacity(100.0);
                        name2.setOpacity(100.0);
                        score1.setOpacity(100.0);
                        score2.setOpacity(100.0);

                        name1.setId("names");
                        score1.setId("scores");
                        Transitions.TranslateX(score1, 2000, JavaFxTrial.getwidth()+250, JavaFxTrial.getwidth()-10*JavaFxTrial.getwidth()/100);
                        Transitions.TranslateX(name1, 2000, JavaFxTrial.getwidth()+250, (JavaFxTrial.getwidth()-10*JavaFxTrial.getwidth()/100)-45);
                        score1.setLayoutY(JavaFxTrial.getheight()-60*JavaFxTrial.getheight()/100);
                        name1.setLayoutY(score1.getLayoutY()-50);
                        currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(score1);
                        currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(name1);

                        score2.setId("scores");
                        name2.setId("names");
                        Transitions.TranslateX(score2, 2000, JavaFxTrial.getwidth()+250, JavaFxTrial.getwidth()-10*JavaFxTrial.getwidth()/100);
                        Transitions.TranslateX(name2, 2000, JavaFxTrial.getwidth()+250, (JavaFxTrial.getwidth()-10*JavaFxTrial.getwidth()/100)-45);
                        score2.setLayoutY(JavaFxTrial.getheight()-40*JavaFxTrial.getheight()/100);
                        name2.setLayoutY(score2.getLayoutY()-50);
                        currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(score2);
                        currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(name2);

                        currentpartida.getcurrentwordpane().getcgwl().setText("Παίζει : " + Paiktis.getpaiktis2().getOnoma());
                        currentpartida.getcurrentwordpane().getcgwl().setLayoutX(JavaFxTrial.getwidth()-70*JavaFxTrial.getwidth()/100);
                        currentpartida.getcurrentparts().addkremala();  

                        currentpartida.getcurrentwordpane().getprospathies().setId("prospathies");
                        Transitions.TranslateX(currentpartida.getcurrentwordpane().getprospathies(), 2000, JavaFxTrial.getwidth()+250, 1600);
                        currentpartida.getcurrentwordpane().getprospathies().setLayoutY(100);
                        currentpartida.getcurrentwordpane().getprospathies().setText(""+currentpartida.gettries());
                        currentpartida.getcurrentwordpane().getplayingpane().getChildren().remove(currentpartida.getcurrentwordpane().getwordf());
                        currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(currentpartida.getcurrentwordpane().getprospathies());
                    }
                else
                    {
                        setscores();
                        setnames();
                        name1.setOpacity(100.0);
                        name2.setOpacity(100.0);
                        score1.setOpacity(100.0);
                        score2.setOpacity(100.0);

                        name1.setId("names");
                        score1.setId("scores");
                        Transitions.TranslateX(score1, 2000, JavaFxTrial.getwidth()+250, JavaFxTrial.getwidth()-10*JavaFxTrial.getwidth()/100);
                        Transitions.TranslateX(name1, 2000, JavaFxTrial.getwidth()+250, (JavaFxTrial.getwidth()-11.5*JavaFxTrial.getwidth()/100)-45);
                        score1.setLayoutY(JavaFxTrial.getheight()-60*JavaFxTrial.getheight()/100);
                        name1.setLayoutY(score1.getLayoutY()-50);
                        currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(score1);
                        currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(name1);

                        score2.setId("scores");
                        name2.setId("names");
                        Transitions.TranslateX(score2, 2000, JavaFxTrial.getwidth()+250, JavaFxTrial.getwidth()-10*JavaFxTrial.getwidth()/100);
                        Transitions.TranslateX(name2, 2000, JavaFxTrial.getwidth()+250, (JavaFxTrial.getwidth()-8*JavaFxTrial.getwidth()/100)-45);
                        score2.setLayoutY(JavaFxTrial.getheight()-40*JavaFxTrial.getheight()/100);
                        name2.setLayoutY(score2.getLayoutY()-50);
                        currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(score2);
                        currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(name2);

                        currentpartida.getcurrentwordpane().getcgwl().setText("Παίζει : " + Paiktis.getpaiktis2().getOnoma());
                        currentpartida.getcurrentwordpane().getcgwl().setLayoutX(JavaFxTrial.getwidth()-70*JavaFxTrial.getwidth()/100);
                        currentpartida.getcurrentparts().addkremala();

                        currentpartida.getcurrentwordpane().getprospathies().setId("prospathies");
                        Transitions.TranslateX(currentpartida.getcurrentwordpane().getprospathies(), 2000, JavaFxTrial.getwidth()+250, 1600);
                        currentpartida.getcurrentwordpane().getprospathies().setLayoutY(100);
                        currentpartida.getcurrentwordpane().getprospathies().setText(""+currentpartida.gettries());
                        currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(currentpartida.getcurrentwordpane().getprospathies());
                    }
            }

        public static void checknullword(Stage stage, Button Ekkinisi, Partida currentpartida)
            {
                String checkedstring;
                
                if (currentpartida.getcurrentwordpane().getwordf().getText().isEmpty()==false)
                    {
                        if(currentpartida.getcurrentwordpane().getwordf().getText().length()<3)
                            {
                                showMessageDialog(null, "Η λέξη δεν μπορεί να είναι μικρότερη από 3 χαρακτήρες");
                            }
                        else
                            {
                                Pattern english = Pattern.compile("[A-Za-z]");
                                Matcher englishm = english.matcher(currentpartida.getcurrentwordpane().getwordf().getText());
                                boolean englisexist = englishm.find();
                                
                                if(englisexist)
                                    {
                                        showMessageDialog(null, "Η λέξη δεν μπορεί να περιέχει αγγλικούς χαρακτήρες");
                                    }
                                else
                                    {
                                        Pattern digits = Pattern.compile("[0-9]");
                                        Matcher digitsm = digits.matcher(currentpartida.getcurrentwordpane().getwordf().getText());
                                        boolean digitsexist = digitsm.find();

                                        if(digitsexist)
                                            {
                                                showMessageDialog(null, "Η λέξη δεν μπορεί να περιέχει αριθμούς");
                                            }
                                        else
                                            {
                                                Pattern specials = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
                                                Matcher specialssm = specials.matcher(currentpartida.getcurrentwordpane().getwordf().getText());
                                                boolean specialsexist = specialssm.find();

                                                if(specialsexist)
                                                    {
                                                        showMessageDialog(null, "Η λέξη δεν μπορεί να περιέχει ειδικούς χαρακτήρες");
                                                    }
                                                else
                                                    {
                                                        Pattern tonoi = Pattern.compile("[άύίόέώήΆΎΊΌΈΏΉ]");
                                                        Matcher tonoim = tonoi.matcher(currentpartida.getcurrentwordpane().getwordf().getText());
                                                        boolean tonoiexist = tonoim.find();
                                                        
                                                        if(tonoiexist)
                                                            {
                                                                showMessageDialog(null, "Η λέξη δεν μπορεί να περιέχει τονισμένους χαρακτήρες");
                                                            }
                                                        else
                                                            {
                                                                checkedstring=currentpartida.getcurrentwordpane().getwordf().getText();
                                                                currentpartida.setlexi(checkedstring);
                                                                currentpartida.getlexi().pinakessetup();
                                                                currentpartida.getlexi().setlines();
                                                                addgrammatahandlers(stage, currentpartida);
                                                                transitnodes(currentpartida);
                                                                currentpartida.getlexi().addlettertexts(currentpartida.getcurrentwordpane().getplayingpane());
                                                                currentpartida.getcurrentwordpane().getplayingpane().getChildren().remove(Ekkinisi);
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
                else
                    {
                        showMessageDialog(null, "Για να ξεκινήσεις το παιχνίδι, πρέπει να δώσεις μία λέξη");
                    }
            }
        

        public static void proccessword(Stage stage, Partida currentpartida) throws IOException
            {
                String checkedstring;
                    checkedstring=getrandomword(currentpartida.getdifficulty());
                    currentpartida.setlexi(checkedstring);
                    currentpartida.getlexi().pinakessetup();
                    currentpartida.getlexi().setlines();
                    addgrammatahandlers(stage, currentpartida);
                    currentpartida.getlexi().addlettertexts(currentpartida.getcurrentwordpane().getplayingpane());
                    //System.out.println("Checked String = " +  checkedstring);
                    transitnodes(currentpartida);
            }
        
        private static void letterstatus(Button button,Partida currentpartida) throws UnsupportedAudioFileException, IOException, LineUnavailableException
            {
                int m=0;
                
                for(int o=0;o<currentpartida.getlexi().getletterssize();o++)
                    {
                        if(button.getText().equals(currentpartida.getlexi().getletters().get(o))==false)
                            {
                                m=m+1;
                                currentpartida.getlexi().setmistakebutton(button);
                                currentpartida.getlexi().setcorrectbutton(null);
                            }
                        else if(button.getText().equals(currentpartida.getlexi().getletters().get(o))==true)
                            {
                                currentpartida.getlexi().getlettertexts().get(o).setText(button.getText());
                                Transitions.Scale(currentpartida.getlexi().getlettertexts().get(o), 400, 0, 1.0);
                                currentpartida.getlexi().getletters().set(o, null);
                                currentpartida.getlexi().setmistakebutton(null);
                                currentpartida.getlexi().setcorrectbutton(button);
                                Transitions.correcttransition(currentpartida.getcurrentwordpane(),currentpartida.getlexi().getcorrectbutton());
                                //currentwordpane.getplayingpane().getChildren().remove(button);
                            }
                        else if(Character.isWhitespace(currentpartida.getlexi().getWord().charAt(o))==true)
                            {
                                currentpartida.getlexi().getlettertexts().get(o).setText(button.getText());
                                currentpartida.getlexi().getletters().set(o, null);
                            }
                    }

                if(m==currentpartida.getlexi().getletters().size())
                    {
                        currentpartida.getcurrentparts().addbodyparts();
                        currentpartida.reducetries(currentpartida.getcurrentwordpane());
                        //System.out.println(currentpartida.gettries());
                        Transitions.mistaketransition(currentpartida.getcurrentwordpane(),currentpartida.getlexi().getmistakebutton());
                        currentpartida.getcurrentwordpane().getprospathies().setText(""+currentpartida.gettries());
                        //currentwordpane.getplayingpane().getChildren().remove(button);
                    }
            }
        
        public static void checkletter(Button button, Stage stage, Partida currentpartida) throws IOException, UnsupportedAudioFileException, LineUnavailableException
            {   
                boolean gameover=false;
                
                int c=0;
                letterstatus(button, currentpartida);
                
                for(int o=0;o<currentpartida.getlexi().getletters().size();o++)
                    {
                        if(currentpartida.getlexi().getletters().get(o)==null)
                        {
                            c=c+1;
                        }
                    }
                
                int athroisma = currentpartida.getlexi().getspaces()+c;

                    gameover=checkpartidastatus(stage, athroisma, currentpartida);
                
                if(gameover==true)
                    {
                        if(Partida.getmultiplayerstatus())
                            {
                                Transitions.Victory(stage, currentpartida);
                            }
                        else
                            {
                                if(currentpartida.victory())
                                    {
                                        Transitions.Victory(stage, currentpartida);
                                    }
                                else
                                    {
                                        Transitions.Defeat(stage, currentpartida.getcurrentwordpane());
                                    }
                            }
                    }
            }

        private static Boolean checkpartidastatus(Stage stage, int athroisma, Partida currentpartida) throws IOException
            {
                boolean gameover=false;
                        if(athroisma==currentpartida.getlexi().getletters().size())
                            {
                                Paiktis.getPaiktes().get(1).scoreplusone();
                                currentpartida.setscores();
                                currentpartida.countscore();
                                currentpartida.printscore();
                                Paiktis.swappaixtes();

                                if(currentpartida.getscore1()==Partida.getnumberofpartides() || currentpartida.getscore2()==Partida.getnumberofpartides())
                                    {

                                        gameover=true;
                                    }
                                else
                                    {
                                        if(paiktis1.getScore()+paiktis2.getScore()==4)
                                            {
                                                Transitions.lastpartida(stage, currentpartida);
                                            }
                                        else    
                                            {
                                                Transitions.nextpartida(stage, currentpartida);
                                                gameover=false;
                                            }
                                    }  
                            }
                        else if(currentpartida.gettries()==0 && athroisma!=currentpartida.getlexi().getletters().size() )
                            {
                                Paiktis.getPaiktes().get(0).scoreplusone();
                                currentpartida.setscores();
                                currentpartida.countscore();
                                currentpartida.printscore();
                                Paiktis.swappaixtes();

                                if(currentpartida.getscore1()==Partida.getnumberofpartides() || currentpartida.getscore2()==Partida.getnumberofpartides())
                                    {
                                       gameover=true;
                                    }
                                else
                                    {
                                        if(paiktis1.getScore()+paiktis2.getScore()==4)
                                            {
                                                Transitions.lastpartida(stage, currentpartida);
                                            }
                                        else
                                            {
                                                Transitions.nextpartida(stage, currentpartida);
                                                gameover=false;
                                            }
                                    }
                            }
                return gameover;
            }
        
        public static String getrandomword(String Difficulty) throws FileNotFoundException, IOException
            {   
                switch (Difficulty) 
                    {
                        case "Easy" -> 
                            {
                                Path path = Paths.get("src/Words/Easy.txt");
                                String[] Words= Files.readString(path, StandardCharsets.UTF_8).split("_");
                                int line=0;
                                Random random = new Random();
                                line=Math.abs(random.nextInt(24));
                                return Words[line];
                            }

                        case "Hard" -> 
                            {
                                Path pathw = Paths.get("src/Words/Hard.txt");
                                String[] Words= Files.readString(pathw, StandardCharsets.UTF_8).split("_");
                                int line=0;
                                Random random = new Random();
                                line=Math.abs(random.nextInt(24));
                                return Words[line];
                            }

                        default -> 
                        {
                            Path pathw = Paths.get("src/Words/Impossibru.txt");
                            String[] Words = Files.readString(pathw, StandardCharsets.UTF_8).split("_");  
                            int line=0;
                            Random random = new Random();
                            line=Math.abs(random.nextInt(24));
                            return Words[line];
                        }
                    }
            }
    }