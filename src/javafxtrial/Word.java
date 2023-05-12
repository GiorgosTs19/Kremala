package javafxtrial;

import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Word 
    {
        private String Word;
        private int Length;
        private final ArrayList<Character> WordChars;
        private Button mistakebutton = new Button();
        private Button correctbutton = new Button();
        private int spaces;
        private final ArrayList<String> letters;
        private final ArrayList<Text> lettertexts; //Πίνακας θέσεων γραμμάτων
        private final ArrayList<Double> lettersXs; //Πίνακας θέσεων γραμμών γραμμάτων (XStart)
        private final ArrayList<Double> lettersYs; //Πίνακας θέσεων γραμμών γραμμάτων (YStart)
        private final ArrayList<Double> lettersXe; //Πίνακας θέσεων γραμμών γραμμάτων (XEnd)
        private final ArrayList<Line> lines; //Πίνακας θέσεων γραμμών γραμμάτων (XEnd)
        private final Partida thispartida;
        private final WordPane thiswordpane;
        
        public Word(Partida partida)
            {
                Word=null;
                WordChars=new ArrayList<>();
                letters = new ArrayList<>();
                lettertexts = new ArrayList<>();
                lettersXs = new ArrayList<>();
                lettersYs = new ArrayList<>();
                lettersXe = new ArrayList<>();
                spaces=0;
                lines = new ArrayList<>();
                thispartida=partida;
                thiswordpane=partida.getcurrentwordpane();
            }
        
        public void initialize(String checkedstring)
            {
                Word=checkedstring.toUpperCase();
                Length=checkedstring.length();
                
                for (int i=0;i<Length;i++)
                    {
                        WordChars.add(Word.charAt(i));
                    }
            }

        /*public void cleararraylists()
            {
                for(int i=0;i<lettersXe.size();i++)
                    {
                        lettersXe.remove(i);
                    }
                for(int i=0;i<lettersYs.size();i++)
                    {
                        lettersYs.remove(i);
                    }
                for(int i=0;i<lettersXs.size();i++)
                    {
                        lettersXs.remove(i);
                    }
                for(int i=0;i<lettertexts.size();i++)
                    {
                        lettertexts.remove(i);
                    }
                for(int i=0;i<letters.size();i++)
                    {
                        letters.remove(i);
                    }
                /*for(int i=0;i<lines.size();i++)
                    {
                        lines.remove(i);
                    }
            }*/
        
        public String getWord()
            {
                return this.Word;
            }
        
        public void setlines()
            {
                for(int i=0;i<letters.size();i++)
                    {
                       if(letters.get(i).equals(" "))
                            {
                                spaces=spaces+1;  
                            } 
                    }

                for(int i=0;i<lines.size();i++)
                    {
                        lines.get(i).setId("lines");
                        lines.get(i).applyCss();
                        if(Character.isWhitespace(letters.get(i).charAt(0)))
                            {
                                thiswordpane.getplayingpane().getChildren().add(lines.get(i));
                                thiswordpane.getplayingpane().getChildren().remove(lines.get(i));
                            } 
                        else
                            {
                                thiswordpane.getplayingpane().getChildren().add(lines.get(i));
                                Transitions.Scale(correctbutton, 2000, 0.0, 1);
                            }  
                    }
            }
        
        public void dixegrammata()
            {
                for(int i=0;i<letters.size();i++)
                    {
                        System.out.println(i +  " " + " " + letters.get(i));
                    }
            }
        public void dixexaraktires()
            {
                for(int i=0;i<WordChars.size();i++)
                    {
                        System.out.println(i +  " " + " " + WordChars.get(i));
                    }
            }
        
        public void addlettertexts(Pane pane)
            {
                for(int i=0;i<lettertexts.size();i++)
                    {
                        pane.getChildren().add(lettertexts.get(i));
                    }
            }
        
        public int getspaces()
            {
                return spaces;
            }
            
        public int getlettertextsize()
            {
                return lettertexts.size();
            }
        
        public int getletterssize()
            {
                return letters.size();
            }
        
        public ArrayList<Double> getlettersXs()
            {
                return lettersXs;
            }
        
        public ArrayList<Text> getlettertexts()
            {
                return lettertexts;
            }
        
        public ArrayList<Double> getlettersYs()
            {
                return lettersYs;
            }
        
        public ArrayList<Double> getlettersXe()
            {
                return lettersXe;
            }
        
        public ArrayList<String> getletters()
            {
                return letters;
            }
        
        public int getLength()
            {
                return this.Length;
            }
        
        public int getlettersYssize()
            {
                return lettersYs.size();
            }
        
        public int getlettersXesize()
            {
                return lettersXe.size();
            }
        public int getlettersXssize()
            {
                return lettersXs.size();
            }
        
        public int getlinessize()
            {
                return lines.size();
            }
        
        public ArrayList<Line> getlines()
            {
                return lines;
            }
        
        public Button getmistakebutton()
            {
                return mistakebutton;
            }
        
        public Button getcorrectbutton()
            {
                return correctbutton;
            }
        
        public void setcorrectbutton(Button button)
            {
                correctbutton=button;
            }
        
        public void setmistakebutton(Button button)
            {
                mistakebutton=button;
            }
        
        public void pinakessetup()
            {
                double S=JavaFxTrial.getwidth()-JavaFxTrial.getwidth()*0.175;
                double letterY = (57*(JavaFxTrial.getheight())-18200)/80;                 
                double height = (5*(JavaFxTrial.getheight())-1400)/8;
                double l=(S-600)/(2*getLength()-1);
                double x=(S+150)/2-352.5;
                double fs=S/(2*Length-1);
                double xl;
                double yl;
                
                thispartida.getcurrentletters().setGrammata(thispartida, S, letterY);
                
                for(int i=0;i<getLength();i++)
                    {
                        getlines().add(new Line(x,height,x+l,height));
                        getlettersXs().add(x);
                        getlettersYs().add(height);
                        getlettersXe().add(x+l);
                        x=x+2*l;
                        getletters().add(Character.toString(getWord().charAt(i)));
                        //System.out.println(getletters().get(i));
                    }
                
                if(Length<4)
                    {
                        for(int i=0;i<letters.size();i++)
                            {   
                                Font letterf = new Font(fs/2);

                                switch (letters.get(i)) 
                                    {
                                        case "Ι" -> 
                                            {
                                                xl=lettersXs.get(i);
                                                yl=lettersYs.get(i);
                                                lettertexts.add(new Text());
                                                lettertexts.get(i).setLayoutX(xl+fs/5);
                                                lettertexts.get(i).setLayoutY(yl-20);
                                                lettertexts.get(i).setFont(letterf);
                                            }
                                        case "Γ", "Υ" -> 
                                            {
                                                xl=lettersXs.get(i);
                                                yl=lettersYs.get(i);
                                                lettertexts.add(new Text());
                                                lettertexts.get(i).setLayoutX(xl+fs/8);
                                                lettertexts.get(i).setLayoutY(yl-20);
                                                lettertexts.get(i).setFont(letterf);
                                            }
                                        case "Β", "Σ", "Τ" -> 
                                            {
                                                xl=lettersXs.get(i);
                                                yl=lettersYs.get(i);
                                                lettertexts.add(new Text());
                                                lettertexts.get(i).setLayoutX(xl+fs/9);
                                                lettertexts.get(i).setLayoutY(yl-20);
                                                lettertexts.get(i).setFont(letterf);
                                            }
                                        case "Α" ,"Ε" -> 
                                            {
                                                xl=lettersXs.get(i);
                                                yl=lettersYs.get(i);
                                                lettertexts.add(new Text());
                                                lettertexts.get(i).setLayoutX(xl+fs/18);
                                                lettertexts.get(i).setLayoutY(yl-20);
                                                lettertexts.get(i).setFont(letterf);
                                            }
                                        case "M"-> 
                                            {
                                                xl=lettersXs.get(i);
                                                yl=lettersYs.get(i);
                                                lettertexts.add(new Text());
                                                lettertexts.get(i).setLayoutX(xl+fs/27);
                                                lettertexts.get(i).setLayoutY(yl-20);
                                                lettertexts.get(i).setFont(letterf);
                                            }
                                        default -> 
                                            {
                                                    xl=lettersXs.get(i);
                                                    yl=lettersYs.get(i);
                                                    lettertexts.add(new Text());
                                                    lettertexts.get(i).setLayoutX(xl+fs/22);
                                                    lettertexts.get(i).setLayoutY(yl-20);
                                                    lettertexts.get(i).setFont(letterf);
                                            }
                                    }
                            }
                    }
                else
                    {
                        for(int i=0;i<letters.size();i++)
                        {   
                            Font letterf = new Font(fs/1.4);

                            switch (letters.get(i)) 
                                {
                                    case "Ι" -> 
                                        {
                                            xl=lettersXs.get(i);
                                            yl=lettersYs.get(i);
                                            lettertexts.add(new Text());
                                            lettertexts.get(i).setLayoutX(xl+fs/5);
                                            lettertexts.get(i).setLayoutY(yl-20);
                                            lettertexts.get(i).setFont(letterf);
                                        }
                                    case "Γ", "Υ", "Τ" -> 
                                        {
                                            xl=lettersXs.get(i);
                                            yl=lettersYs.get(i);
                                            lettertexts.add(new Text());
                                            lettertexts.get(i).setLayoutX(xl+fs/8);
                                            lettertexts.get(i).setLayoutY(yl-20);
                                            lettertexts.get(i).setFont(letterf);
                                        }
                                    case "Β", "Σ" -> 
                                        {
                                            xl=lettersXs.get(i);
                                            yl=lettersYs.get(i);
                                            lettertexts.add(new Text());
                                            lettertexts.get(i).setLayoutX(xl+fs/9);
                                            lettertexts.get(i).setLayoutY(yl-20);
                                            lettertexts.get(i).setFont(letterf);
                                        }
                                    case "Α", "Η" ,"Ε"-> 
                                        {
                                            xl=lettersXs.get(i);
                                            yl=lettersYs.get(i);
                                            lettertexts.add(new Text());
                                            lettertexts.get(i).setLayoutX(xl+fs/18);
                                            lettertexts.get(i).setLayoutY(yl-20);
                                            lettertexts.get(i).setFont(letterf);
                                        }
                                    case "M"-> 
                                        {
                                            xl=lettersXs.get(i);
                                            yl=lettersYs.get(i);
                                            lettertexts.add(new Text());
                                            lettertexts.get(i).setLayoutX(xl+fs/27);
                                            lettertexts.get(i).setLayoutY(yl-20);
                                            lettertexts.get(i).setFont(letterf);
                                        }
                                    default -> 
                                        {
                                            xl=lettersXs.get(i);
                                            yl=lettersYs.get(i);
                                            lettertexts.add(new Text());
                                            lettertexts.get(i).setLayoutX(xl+fs/22);
                                            lettertexts.get(i).setLayoutY(yl-20);
                                            lettertexts.get(i).setFont(letterf);
                                        }
                                }   
                        }
                    }           
            }
    }