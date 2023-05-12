package javafxtrial;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.animation.Animation.INDEFINITE;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Transitions 
    {
        //final static Media media = new Media(Paths.get("src/SoundEffects/correct.mp3").toUri().toString()); 
        final static Label playagain = new Label("Ξεκίνα καινούργια\nπαρτίδα");
    
        public static Label getplayagain()
            {
                return playagain;
            }
        
        static public void showmeaning(Partida currentpartida, boolean Victory)
            {
                Label meaning = new Label();
                String simasia=null;
                
                if(Partida.getmultiplayerstatus()==false)
                    {
                        if(Victory)
                            {
                                if(Partida.gethowhard().equals("Hard"))
                                    {
                                        simasia=Bot.getHardV().get(currentpartida.getlexi().getWord());
                                    }
                                else if(Partida.gethowhard().equals("Impossibru"))
                                    {
                                        simasia=Bot.getImpossibruV().get(currentpartida.getlexi().getWord());
                                    }
                                
                                meaning.setText("Ήξερες ότι η λέξη " + currentpartida.getlexi().getWord() + " αναφέρεται " + simasia + " ;");
                                meaning.setId("meaning");
                                meaning.setMaxHeight(100);
                                meaning.setMaxWidth(700);
                                meaning.setWrapText(true);
                                meaning.setTextAlignment(TextAlignment.CENTER);
                                meaning.setLayoutY(JavaFxTrial.getheight()-0.95*JavaFxTrial.getheight());
                                TranslateX(meaning, 2000, -350.0, JavaFxTrial.getwidth()-0.69*JavaFxTrial.getwidth());
                                currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(meaning);
                            }
                        else
                            {
                                if(Partida.gethowhard().equals("Hard"))
                                    {
                                        simasia=Bot.getHardD().get(currentpartida.getlexi().getWord());
                                    }
                                else if(Partida.gethowhard().equals("Impossibru"))
                                    {
                                        simasia=Bot.getImpossibruD().get(currentpartida.getlexi().getWord());
                                    }
                                
                                meaning.setText(currentpartida.getlexi().getWord() + " είναι " + simasia + ".");
                                meaning.setId("meaning");
                                meaning.setMaxHeight(300);
                                meaning.setMaxWidth(450);
                                meaning.setWrapText(true);
                                meaning.setTextAlignment(TextAlignment.CENTER);
                                meaning.setLayoutY(JavaFxTrial.getheight()-0.50*JavaFxTrial.getheight());
                                TranslateX(meaning, 2000, -350.0, JavaFxTrial.getwidth()-0.54*JavaFxTrial.getwidth());
                                currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(meaning);
                            }
                    }
            }
        
        static public void ParallelTransition(Node node, Transition transition1, Transition transition2)
            {
                ParallelTransition parallel = new ParallelTransition(node, transition1, transition2);
                parallel.play();
            }
        
        static public TranslateTransition TranslateX(Node node, int duration, double fromtargetlocation, double targetlocation)
            {
                TranslateTransition translation = new TranslateTransition(Duration.millis(duration), node);
                translation.setFromX(fromtargetlocation);
                translation.setToX(targetlocation);
                translation.play();
                
                return translation;
            }
        
        static public TranslateTransition TranslateY(Node node, int duration, double fromtargetlocation, double targetlocation)
            {
                TranslateTransition translation = new TranslateTransition(Duration.millis(duration), node);
                translation.setFromY(fromtargetlocation);
                translation.setToY(targetlocation);
                translation.play();
                
                return translation;
            }
        
        static public ScaleTransition Scale(Node node, int duration, double fromtarget, double totarget)
            {
                ScaleTransition scaling = new ScaleTransition(Duration.millis(duration), node);
                scaling.setFromX(fromtarget);
                scaling.setFromY(fromtarget);
                scaling.setToX(totarget);
                scaling.setToY(totarget);
                scaling.play();
                
                return scaling;
            }
        
        static public ScaleTransition ScaleBy(Node node, int duration, Double totarget)
            {
                ScaleTransition scaling = new ScaleTransition(Duration.millis(duration), node);
                scaling.setByX(totarget);
                scaling.setByY(totarget);
                scaling.play();
                
                return scaling;
            }
        
        static public FadeTransition Fade(Node node, int duration, double targetlocation)
            {
                FadeTransition Fade = new FadeTransition(Duration.millis(duration), node);               
                Fade.setToValue(targetlocation);
                Fade.play();
                
                return Fade;
            }
        
        static public void mistaketransition(WordPane currentwordpane, Button mistakebutton)
            {           
                mistakebutton.setId("lathosgramma");
                //Group cross = new Group();
                
                /*Line crossl = new Line();
                    crossl.setStartY(mistakebutton.getLayoutY());
                    crossl.setStartX(mistakebutton.getLayoutX());
                    crossl.setEndY(mistakebutton.getLayoutY() + mistakebutton.getHeight());
                    crossl.setEndX(mistakebutton.getLayoutX() + mistakebutton.getWidth());
                    crossl.setStroke(Color.RED);
                    crossl.setStrokeWidth(5);
                    cross.getChildren().add(crossl);

                Line crossr = new Line();
                    crossr.setStartY(mistakebutton.getLayoutY() + mistakebutton.getHeight());
                    crossr.setStartX(mistakebutton.getLayoutX());
                    crossr.setEndY(mistakebutton.getLayoutY());
                    crossr.setEndX(mistakebutton.getLayoutX() + mistakebutton.getWidth());
                    crossr.setStroke(Color.RED);
                    crossr.setStrokeWidth(5);
                    cross.getChildren().add(crossr);
                    
                currentwordpane.getplayingpane().getChildren().add(cross);*/
                
                RotateTransition rotate = new RotateTransition();
                    rotate.setByAngle(720);
                    rotate.setDuration(Duration.seconds(1.2));
                    rotate.setNode(mistakebutton);
                    
                ParallelTransition seq = new ParallelTransition(ScaleBy(mistakebutton, 1200, 0.6),rotate, Fade(mistakebutton, 1200, 0.0)/*,ScaleBy(cross, 1000, 0.6),Fade(cross, 800, 0.0)*/);
                //SequentialTransition seq = new SequentialTransition(paral, new ParallelTransition(Fade(mistakebutton,1000, 0.0),rotate));
                
                
                //Transition seq = new SequentialTransition(paral);
                //seq.play();
                seq.play();
                seq.setOnFinished(e -> 
                    {
                        currentwordpane.getthispartida().getcurrentletters().transparent(false);
                        mistakebutton.setScaleX(1.0);
                        mistakebutton.setScaleY(1.0);
                        //currentwordpane.getthispartida().getcurrentwordpane().getplayingpane().getChildren().remove(cross);
                        currentwordpane.getthispartida().getcurrentwordpane().getplayingpane().getChildren().remove(mistakebutton);
                    }
                );
                
                mistakebutton.setMouseTransparent(true);
            }
        
        static public void correcttransition(WordPane currentwordpane, Button correctbutton)
            {          
                correctbutton.setId("correctgramma");
                
                /*Group tik = new Group();
                
                Line tikl = new Line();
                    tikl.setStartY(correctbutton.getLayoutY()+correctbutton.getHeight()/2);
                    tikl.setStartX(correctbutton.getLayoutX());
                    tikl.setEndY(correctbutton.getLayoutY() + correctbutton.getHeight());
                    tikl.setEndX(correctbutton.getLayoutX() + correctbutton.getWidth()/2);
                    tikl.setStroke(Color.GREEN);
                    tikl.setStrokeWidth(5);
                    tik.getChildren().add(tikl);

                Line tikr = new Line();
                    tikr.setStartY(correctbutton.getLayoutY() + correctbutton.getHeight());
                    tikr.setStartX(correctbutton.getLayoutX() + correctbutton.getWidth()/2);
                    tikr.setEndY(correctbutton.getLayoutY());
                    tikr.setEndX(correctbutton.getLayoutX() + correctbutton.getWidth());
                    tikr.setStroke(Color.GREEN);
                    tikr.setStrokeWidth(5);
                    tik.getChildren().add(tikr);
                   
                currentwordpane.getplayingpane().getChildren().add(tik);   */ 
                
                ParallelTransition paral = new ParallelTransition(ScaleBy(correctbutton, 1200, 0.5), Fade(correctbutton, 1200, 0.0)/*, Fade(tik, 800, 0.0), ScaleBy(tik,800, 0.6)*/);
                
                paral.play();

                paral.setOnFinished(e -> 
                    {
                        currentwordpane.getthispartida().getcurrentletters().transparent(false);
                        correctbutton.setScaleX(1.0);
                        correctbutton.setScaleY(1.0);
                        //currentwordpane.getthispartida().getcurrentwordpane().getplayingpane().getChildren().remove(tik);
                        currentwordpane.getthispartida().getcurrentwordpane().getplayingpane().getChildren().remove(correctbutton);
                    }
                );
                correctbutton.setMouseTransparent(true); 
            }
        
        private static void Victoryanimations(Partida currentpartida)
            {
                StaticChecks.setscores();
                //System.out.println(StaticChecks.getMeaning());
                
                Image prize = new Image("styles/Images/Prize.png");
                    ImageView prizeview = new ImageView(prize);
                Image lgl = new Image("styles/Images/LeftGoldLeaf.png");
                    ImageView lglview = new ImageView(lgl);
                Image rgl = new Image("styles/Images/RightGoldLeaf.png");
                    ImageView rglview = new ImageView(rgl);
                
                prizeview.setLayoutX(JavaFxTrial.getwidth()-JavaFxTrial.getwidth()*0.70);
                prizeview.setLayoutY(JavaFxTrial.getheight()-JavaFxTrial.getheight()*0.9);
                
                Fade(currentpartida.getcurrentwordpane().getprospathies(),1000,0.0);
                
                for (Button grammata1 : currentpartida.getcurrentletters().getgrammata()) 
                    {
                        Fade(grammata1,1000,0.0);
                    }

                for(int o=0;o<currentpartida.getlexi().getlinessize();o++)
                    {
                        Fade(currentpartida.getlexi().getlines().get(o),1000,0.0);
                    }

                for(int t=0;t<currentpartida.getlexi().getlettertextsize();t++)
                    {
                        Fade(currentpartida.getlexi().getlettertexts().get(t),1000,0.0);
                    }

                
                for(int b=0;b<currentpartida.getcurrentparts().getkremalapartssize();b++)
                    {
                        Fade(currentpartida.getcurrentparts().getkremalaparts(b),1000,0.0);

                    }

                for(int b=0;b<currentpartida.getcurrentparts().getbodypartssize();b++)
                    {
                        if (currentpartida.getcurrentwordpane().getplayingpane().getChildren().contains(currentpartida.getcurrentparts().getbodyparts(b))) 
                            {
                                Fade(currentpartida.getcurrentparts().getbodyparts(b),1000,0.0);
                            }
                    }
                
                if (currentpartida.getcurrentwordpane().getplayingpane().getChildren().contains(currentpartida.getcurrentparts().gethead()))
                        {
                                Fade(currentpartida.getcurrentparts().gethead(),1000,0.0);
                                
                        }
                
                prizeview.setOpacity(0);
                lglview.setOpacity(0);
                rglview.setOpacity(0);
                Fade(Paiktis.getPaiktes().get(1).getNameLabel(),1000,0.0);
                Fade(prizeview,4000,100.0);
                Fade(lglview,4000,100.0);
                Fade(rglview,4000,100.0);
                Fade(currentpartida.getcurrentwordpane().getcgwl(),5000,100.0);
                
                TranslateTransition lgltt = new TranslateTransition(Duration.millis(4000), lglview);
                lgltt.setFromX(prizeview.getLayoutX()-700);
                lgltt.setToX(prizeview.getLayoutX()+70);
                
                TranslateTransition rgltt = new TranslateTransition(Duration.millis(4000), rglview);
                rgltt.setFromX(prizeview.getLayoutX()+1125);
                rgltt.setToX(prizeview.getLayoutX()+350);
                
                Scale(prizeview, 4000, 1.0, 0.35);
                ParallelTransition lglparallel = new ParallelTransition(Scale(lglview, 4000, 1.0, 0.7),lgltt);
                ParallelTransition rglparallel = new ParallelTransition(Scale(rglview, 4000, 1.0, 0.7),rgltt);

                for (Button grammata1 : currentpartida.getcurrentletters().getgrammata()) 
                    {
                        currentpartida.getcurrentwordpane().getplayingpane().getChildren().remove(grammata1);
                    }
                
                currentpartida.getcurrentwordpane().getcgwl().setOpacity(0.0);
                currentpartida.getcurrentwordpane().getcgwl().setText(currentpartida.getlexi().getWord());
                currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(prizeview);
                currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(lglview);
                currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(rglview);
                lglview.setLayoutY(prizeview.getLayoutY()+190);
                rglview.setLayoutY(prizeview.getLayoutY()+190);
                lglparallel.play();
                rglparallel.play();
                //JavaFxTrial.addrestartbutton(stage, playingpane, welcomescene);
                //System.out.println("Το σκόρ είναι : " + StaticChecks.getPaiktis1().getScore() + " - " + StaticChecks.getPaiktis2().getScore());
            }

        static public void Victory(Stage stage, Partida currentpartida)
            {
                StaticMethods.addhomebutton(stage, currentpartida, false);
                Label telospartida = new Label("Τέλος Παρτίδας");
                telospartida.setId("Done");
                currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(telospartida);
                
                        playagain.setId("playagain");
                        playagain.setOpacity(0);
                        playagain.setLayoutX(StaticMethods.gethomedonebutton().getLayoutX()+120);
                        playagain.setLayoutY(StaticMethods.gethomedonebutton().getLayoutY()+10);
                        currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(playagain);
                        ParallelTransition firstplay = new ParallelTransition(Transitions.Fade(playagain, 800, 100.0), Transitions.ScaleBy(playagain, 800, 0.2));
                        SequentialTransition playagains = new SequentialTransition (firstplay, Transitions.ScaleBy(playagain, 800, -0.2));
                        playagains.setCycleCount(INDEFINITE);
                        playagains.play();
                        
                if(Partida.getmultiplayerstatus()==false)
                    {
                        if(Partida.gethowhard().equals("Hard") || Partida.gethowhard().equals("Impossibru"))
                            {
                                Label Congratulations = new Label("Συγχαρητήρια");
                                Congratulations.setId("Congratulations");
                                Congratulations.applyCss();
                                Congratulations.setLayoutX(JavaFxTrial.getwidth()-JavaFxTrial.getwidth()*0.35);
                                Congratulations.setLayoutY(JavaFxTrial.getheight()-JavaFxTrial.getheight()*0.49);
                                currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(Congratulations);
                                Scale(Congratulations, 5000, 0.0, 4.0);
                                telospartida.setLayoutX(JavaFxTrial.getwidth()-JavaFxTrial.getwidth()*0.80);
                                telospartida.setLayoutY(JavaFxTrial.getheight()-JavaFxTrial.getheight()*0.50);
                                Scale(telospartida, 5000, 0.0, 2.0);
                                Victoryanimations(currentpartida);
                                showmeaning(currentpartida, true);
                            }
                        else
                            {
                                Label Congratulations = new Label("Συγχαρητήρια");
                                Congratulations.setId("Congratulations");
                                Congratulations.applyCss();
                                telospartida.setLayoutX(JavaFxTrial.getwidth()-JavaFxTrial.getwidth()*0.80);
                                telospartida.setLayoutY(JavaFxTrial.getheight()-JavaFxTrial.getheight()*0.50);
                                Congratulations.setLayoutX(JavaFxTrial.getwidth()-JavaFxTrial.getwidth()*0.35);
                                Congratulations.setLayoutY(JavaFxTrial.getheight()-JavaFxTrial.getheight()*0.50);
                                currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(Congratulations);
                                Scale(Congratulations, 5000, 0.0, 4.0);
                                Scale(telospartida, 5000, 0.0, 2.0);
                                Victoryanimations(currentpartida);
                            }                        
                    }
                else
                    {
                        Victoryanimations(currentpartida);
                        Label Congratulations = new Label("Συγχαρητήρια \n" +  currentpartida.getwinner().getOnoma());
                        Congratulations.setId("Congratulations");
                        Congratulations.applyCss();
                        telospartida.setLayoutX(JavaFxTrial.getwidth()-JavaFxTrial.getwidth()*0.80);
                        telospartida.setLayoutY(JavaFxTrial.getheight()-JavaFxTrial.getheight()*0.50);
                        Congratulations.setLayoutX(JavaFxTrial.getwidth()-JavaFxTrial.getwidth()*0.35);
                        Congratulations.setLayoutY(JavaFxTrial.getheight()-JavaFxTrial.getheight()*0.50);
                        currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(Congratulations);
                        Scale(Congratulations, 5000, 0.0, 3.0);
                        Scale(telospartida, 5000, 0.0, 2.0);
                        currentpartida.getcurrentwordpane().getplayingpane().getChildren().remove(currentpartida.getcurrentwordpane().getcgwl());
                    }
            }

        static public void Defeat(Stage stage, WordPane currentwordpane)
            {
                StaticMethods.addhomebutton(stage, currentwordpane.getthispartida(), false);
                StaticChecks.setscores();
                singleplayerdefeat(currentwordpane);

                        playagain.setId("playagain");
                        playagain.setOpacity(0);
                        playagain.setLayoutX(StaticMethods.gethomedonebutton().getLayoutX()+120);
                        playagain.setLayoutY(StaticMethods.gethomedonebutton().getLayoutY()+10);
                        currentwordpane.getplayingpane().getChildren().add(playagain);
                        ParallelTransition firstplay = new ParallelTransition(Transitions.Fade(playagain, 800, 100.0), Transitions.ScaleBy(playagain, 800, 0.2));
                        SequentialTransition playagains = new SequentialTransition (firstplay, Transitions.ScaleBy(playagain, 800, -0.2));
                        playagains.setCycleCount(INDEFINITE);
                        playagains.play();
                        
                 for (Button gramma : currentwordpane.getthispartida().getcurrentletters().getgrammata()) 
                     {
                         Fade(gramma, 1000, 0.0);
                     }

                 for(int o=0;o<currentwordpane.getthispartida().getlexi().getlinessize();o++)
                     {
                         Fade(currentwordpane.getthispartida().getlexi().getlines().get(o), 1000, 0.0);
                     }

                 for(int o=0;o<currentwordpane.getthispartida().getlexi().getlettertextsize();o++)
                     {
                         Fade(currentwordpane.getthispartida().getlexi().getlettertexts().get(o), 1000, 0.0);
                     }
                 
                 currentwordpane.getcgwl().setLayoutY(330);
                 currentwordpane.getcgwl().setOpacity(0.0);
                 currentwordpane.getcgwl().setText("Κέρδισε : " + Paiktis.getPaiktes().get(0).getOnoma());

                 Fade(currentwordpane.getcgwl(), 5000, 100);
                 
            }
        
        public static void nextpartida(Stage stage, Partida currentpartida)
            {   
                Text zero = new Text();
                for (Node i : currentpartida.getcurrentwordpane().getplayingpane().getChildren())
                    {
                        Fade(i, 2000, 0.0);
                    } 
                
                FadeTransition fade = new FadeTransition();
                    fade.setNode(zero);
                    fade.setDuration(Duration.seconds(2));
                    fade.setFromValue(100.0);
                    fade.setToValue(0.0);
                    fade.play();
                    
                fade.play();

                fade.setOnFinished(e -> 
                    {
                        try 
                            {
                                Partida.neapartida(stage);
                            } 
                        catch (IOException ex) 
                            {
                                Logger.getLogger(Transitions.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    }
                );
            }
        
        private static void singleplayerdefeat(WordPane currentwordpane)
            {
                Circle head=currentwordpane.getthispartida().getcurrentparts().gethead();
                Group kremasmenos = new Group();
                ParallelTransition sequence;
                
                Label waslookingfor = new Label();
                waslookingfor.setId("waslookingfor");
                waslookingfor.setMaxHeight(100);
                waslookingfor.setMaxWidth(550);
                waslookingfor.setWrapText(true);
                waslookingfor.setTextAlignment(TextAlignment.CENTER);
                waslookingfor.setText("Η λέξη που έψαχνες ήταν\n" + currentwordpane.getthispartida().getlexi().getWord());
                currentwordpane.getplayingpane().getChildren().add(waslookingfor);
                        
                for (Line i : currentwordpane.getthispartida().getcurrentparts().getkremalapartsarray())
                    {
                        kremasmenos.getChildren().add(i);
                    }
                
                kremasmenos.getChildren().add(currentwordpane.getthispartida().getcurrentparts().gethead());
                
                for(Line i : currentwordpane.getthispartida().getcurrentparts().getbodypartsarray())
                    {
                        kremasmenos.getChildren().add(i);
                    }
                currentwordpane.getplayingpane().getChildren().add(kremasmenos);
                
                if(Partida.gethowhard().equals("Easy"))
                    {
                        waslookingfor.setLayoutX(JavaFxTrial.getwidth()-0.55*JavaFxTrial.getwidth());
                        waslookingfor.setLayoutY(JavaFxTrial.getheight()-0.55*JavaFxTrial.getheight());
                        waslookingfor.setOpacity(0.0);
                        Fade(waslookingfor, 2500, 100.0); 
                        sequence = new ParallelTransition(ScaleBy(kremasmenos, 2000, 0.1), TranslateX(kremasmenos, 2000, kremasmenos.getLayoutX(), 450));
                        sequence.play();
                    }
                else if(Partida.gethowhard().equals("Hard") || Partida.gethowhard().equals("Impossibru"))
                    {
                        showmeaning(currentwordpane.getthispartida(), false);
                        waslookingfor.setLayoutX(JavaFxTrial.getwidth()-0.55*JavaFxTrial.getwidth());
                        waslookingfor.setLayoutY(JavaFxTrial.getheight()-0.70*JavaFxTrial.getheight());
                        waslookingfor.setOpacity(0.0);
                        Fade(waslookingfor, 2500, 100.0);
                        sequence = new ParallelTransition(ScaleBy(kremasmenos, 2000, 0.1), TranslateX(kremasmenos, 2000, kremasmenos.getLayoutX(), 450));
                        sequence.play();
                    }

            }
        
        public static void lastpartida(Stage stage, Partida currentpartida)
            {   
                for (Node i : currentpartida.getcurrentwordpane().getplayingpane().getChildren())
                {
                    Fade(i, 500, 0.0);
                } 
                
                Label last = new Label("Τελευταία Παρτίδα");
                last.setStyle("-fx-text-fill: white;");
                   currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(last);
                   last.setLayoutX(1800-1800*0.52);
                   last.setLayoutY(800-800*0.55);


                ParallelTransition all = new ParallelTransition(Fade(last, 6000, 0.0), Scale(last, 6000, 10.0, 0.0));
                all.play();

                all.setOnFinished(e -> 
                    {
                        try 
                            {
                                Partida.neapartida(stage);
                            } 
                        catch (IOException ex) 
                            {
                                Logger.getLogger(Transitions.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    }
                );
            }
    }