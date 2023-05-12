package javafxtrial;

import java.io.IOException;
import java.util.ArrayList;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Partida 
    {
        private int tries;
        private int scorep1;
        private int scorep2;
        private Paiktis Paiktis1;
        private Paiktis Paiktis2;
        private final Parts currentparts;
        private String score;
        private String difficulty;
        private final int partidano;
        private final WordPane currentwordpane;
        private final Word lexi;
        private final Letters currentletters;
        private final  ArrayList<Paiktis> Paiktes = new ArrayList<>();
        private static final ArrayList<Partida> Partides = new ArrayList<>();
        private static boolean multiplayerstatus;
        private static String howhard;
        private static int numberofpartides;
        private static int count=0;
        
        static public void neapartida(Stage Stage) throws IOException
            {
                if(multiplayerstatus==true)
                    {
                        Partida neaPartida = new Partida();
                        neaPartida.difficulty=null;
                        neaPartida.currentwordpane.wordfsetup();
                        neaPartida.Paiktis1=Paiktis.getPaiktes().get(0);
                        neaPartida.Paiktis2=Paiktis.getPaiktes().get(1);
                        WordPane.finalsetup(Stage, neaPartida);
                        //System.out.println("\n\nΝέα Παρτίδα " + neaPartida.partidano);
                        Stage.setScene(neaPartida.currentwordpane.getplayingpanescene());
                    }
                else
                    {
                        Partida neaPartida = new Partida();
                        neaPartida.Paiktis1 = new Paiktis("Υπολογιστής");
                        neaPartida.Paiktis2 = new Paiktis("Εσύ");
                        Paiktis.getPaiktes().add(neaPartida.Paiktis1);
                        Paiktis.getPaiktes().add(neaPartida.Paiktis2);
                        numberofpartides=1;
                        neaPartida.difficulty=howhard;
                        //System.out.println("\n\nΝέα Παρτίδα " + neaPartida.partidano);
                        Stage.setScene(neaPartida.currentwordpane.getplayingpanescene());
                        StaticMethods.addhomebutton(Stage, neaPartida, true);
                        StaticMethods.addexitbutton(Stage,neaPartida.currentwordpane.getplayingpane());
                        StaticChecks.proccessword(Stage, neaPartida);  
                    }
                
                //System.out.println(Partides.size());
            }
        
        public Letters getcurrentletters()
            {
                return currentletters;
            }
        
        public Partida()
            {
                if(multiplayerstatus==true)
                    {
                        this.tries=6;
                        count=count+1;
                        this.partidano=count;
                        this.currentwordpane = new WordPane(this);
                        Partides.add(this);
                        lexi=new Word(this);
                        currentletters=new Letters(this);
                        currentparts=new Parts(this);
                    }
                else
                {
                    this.tries=6;
                    count=count+1;
                    this.partidano=count;
                    this.currentwordpane = new WordPane(this);
                    Partides.add(this);
                    lexi=new Word(this);
                    currentletters=new Letters(this);
                    currentparts=new Parts(this);
                }
                
            }
        
        public void setlexi(String checkedstring)
            {
                lexi.initialize(checkedstring);
            }
        
        public String getdifficulty()
            {
                return difficulty;
            }
        
        public Parts getcurrentparts()
            {
                return currentparts;
            }
        
        public static void sethowhard(String how)
            {
                howhard=how;
            }
        
        public static String gethowhard()
            {
                return howhard;
            }
        
        public void setscores()
            {
                scorep1=Paiktis.getpaiktis1().getScore();
                scorep2=Paiktis.getpaiktis2().getScore();
            }
        
        public static ArrayList<Partida> getpartides()
            {
                return Partides;
            }
        
        public static boolean getmultiplayerstatus()
            {
                return multiplayerstatus;
            }
        
        public static void setmultiplayerstatus(Boolean status)
            {
                multiplayerstatus=status;
            }
        public int getscore1()
            {
                return scorep1;
            }
        
        public void printscore()
            {
                System.out.println(this.score);;
            }
        
        public int getscore2()
            {
                return scorep2;
            }
        
        public void countscore()
            {
                for(int i=0; i<Partides.size();i++)
                    {
                        this.score = Partides.get(i).scorep1 + " - " + Partides.get(i).scorep2;
                    }
            }
        public Paiktis getwinner()
            {
                if(Paiktis1.getScore()>Paiktis2.getScore())
                    {
                        return Paiktis1;
                    }
                else
                    {
                        return Paiktis2;
                    }
            }
        
        public boolean victory()
            {
                boolean victory=false;
                
                if(multiplayerstatus==false)
                    {
                        if(scorep1>scorep2)
                            {
                                victory=false;
                            }
                        else
                            {
                                victory=true;
                            }
                    }
                
                return victory;
            }

        public Word getlexi()
            {
                return this.lexi;
            }
        
        
        public  int getpartidano()
            {
                return partidano;
            }
        
        public  ArrayList<Partida> getPartides()
            {
                return Partides;
            }
        
        public static int getnumberofpartides()
            {
                return numberofpartides;
            }
        
        public static void setnumberofpartides(int number)
            {
                numberofpartides=number;
            }
        
        public WordPane getcurrentwordpane()
            {
                return this.currentwordpane;
            }
        
        public int gettries()
            {
                return tries;
            }
        
        public void startsetup()
            {
                //Κουμπί εκκίνησης παιχνιδιού μετά την επιλογή Παιχτών      
                    
                //Κουμπί εκκίνησης παιχνιδιού μετά την επιλογή Παιχτών 
            }
        public  int reducetries(WordPane wordpane)
            {
                tries=tries-1;
                SequentialTransition sequence = new SequentialTransition(Transitions.ScaleBy(currentwordpane.getprospathies(), 200, 0.3),Transitions.ScaleBy(currentwordpane.getprospathies(), 200, -0.3));
                sequence.play();
                
                if(tries<3)
                    {
                        currentwordpane.getprospathies().setStyle("-fx-text-fill:red");
                    }
                
                if(tries==1)
                    {
                        
                        Label last = new Label("Σου απομένει 1 προσπάθεια");
                        last.setId("last");
                        wordpane.getplayingpane().getChildren().add(last);
                        last.setLayoutX(1800-1800*0.55);
                        last.setLayoutY(800-800*0.25);


                        FadeTransition lastft = new FadeTransition();
                             lastft.setToValue(0.0);
                             lastft.setDuration(Duration.seconds(3.0));
                             lastft.setNode(last);

                         ScaleTransition lastst = new ScaleTransition();
                             lastst.setByX(3.5);
                             lastst.setByY(3.5);
                             lastst.setDuration(Duration.seconds(3.0));
                             lastst.setNode(last);

                             ParallelTransition all = new ParallelTransition(lastft,lastst);
                             all.play();

                    }
                return tries;
            }
    }