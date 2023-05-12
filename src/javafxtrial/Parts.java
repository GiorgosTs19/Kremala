package javafxtrial;

import java.util.ArrayList;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

        
public class Parts 
    {
        private final ArrayList<Line> bodyparts; //Πίνακας θέσεων κομματιών ανθρώπου        
        private final ArrayList<Line> kremalaparts; //Πίνακας θέσεων κομματιών κρεμαλας
        private final Circle head;
        private final Partida currentpartida;
        
        public Parts(Partida partida)
            {
                currentpartida=partida;
                bodyparts=new ArrayList<>();
                kremalaparts=new ArrayList<>();
                head = new Circle();
            }
        
        public Circle gethead()
            {
                return head;
            }
        
        public void cleararraylists()
            {
                for(int i=0;i<bodyparts.size();i++)
                    {
                        bodyparts.remove(i);
                    }
                for(int i=0;i<kremalaparts.size();i++)
                    {
                        kremalaparts.remove(i);
                    }
            }
        
        public void removehead(Pane pane)
            {
                pane.getChildren().remove(head);
            }
        
        public Line getkremalaparts(int t)
            {
                return kremalaparts.get(t);
            }
        
        public double getkremalapartssize()
            {
                return kremalaparts.size();
            }
        
        public double getbodypartssize()
            {
                return bodyparts.size();
            }
        
        public Line getbodyparts(int c)
            {
                return bodyparts.get(c);
            }
        
        public ArrayList<Line> getbodypartsarray()
            {
                return bodyparts;
            }
        
        public ArrayList<Line> getkremalapartsarray()
            {
                return kremalaparts;
            }
        
        public  void addbodyparts()
            {
                //Κεφάλι
                    head.setCenterX(kremalaparts.get(8).getEndX()); //160
                    head.setCenterY(kremalaparts.get(8).getEndY()+30); //310
                    head.setRadius(20);
                    head.setFill(javafx.scene.paint.Color.TRANSPARENT);
                    head.setStroke(Color.WHITE);

                //Σώμα
                   Line body = new Line();
                        body.setStartX(head.getCenterX()); //160
                        body.setStartY(head.getCenterY()+head.getRadius()+10); //340
                        body.setEndX(body.getStartX());
                        body.setEndY(body.getStartY()+110);
                        body.setStroke(Color.WHITE);
                        bodyparts.add(body);
                    
                //Δεξί Χέρι
                   Line rh = new Line();
                        rh.setStartX(body.getStartX()+10); //170
                        rh.setStartY(body.getStartY()+20);
                        rh.setEndX(body.getStartX()+40);
                        rh.setEndY(body.getStartY()+60);
                        rh.setStroke(Color.WHITE);
                        bodyparts.add(rh);
                    
                //Αριστερό Χέρι
                   Line lh = new Line();
                        lh.setStartX(body.getStartX()-10); //150
                        lh.setStartY(body.getStartY()+20);
                        lh.setEndX(body.getStartX()-40);
                        lh.setEndY(body.getStartY()+60);
                        lh.setStroke(Color.WHITE);
                        bodyparts.add(lh);
                
                //Δεξί Πόδι
                   Line rf = new Line();
                        rf.setStartX(body.getStartX()+10);//170
                        rf.setStartY(body.getEndY()+10);//460
                        rf.setEndX(body.getStartX()+40);//200
                        rf.setEndY(body.getEndY()+50);//500
                        rf.setStroke(Color.WHITE);
                        bodyparts.add(rf);


                //Αριστερό Πόδι
                   Line lf = new Line();
                        lf.setStartX(body.getStartX()-10);//150
                        lf.setStartY(body.getEndY()+10);//460
                        lf.setEndX(body.getStartX()-40);//120
                        lf.setEndY(body.getEndY()+50);//500
                        lf.setStroke(Color.WHITE);
                        bodyparts.add(lf);
                    
                    ScaleTransition st = new ScaleTransition(Duration.millis(150));
                    st.setFromX(2.0);
                    st.setFromY(2.0);
                    st.setToX(1.0);
                    st.setToY(1.0);


                switch (currentpartida.gettries())
                    {
                        case 6 ->                             
                            {
                                currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(head);
                                st.setNode(head);
                                st.play();
                            }

                        case 5 ->                             
                            {
                                currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(body);
                                st.setNode(body);
                                st.play();
                            }

                        case 4 ->                             
                            {
                                currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(lh);
                                st.setNode(lh);
                                st.play();
                            }

                        case 3 ->                             
                            {
                                currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(rh);
                                st.setNode(rh);
                                st.play();
                            }

                        case 2 ->                             
                            {
                                currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(lf);
                                st.setNode(lf);
                                st.play();
                            }

                        case 1 ->                             
                            {
                                currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(rf);
                                st.setNode(rf);
                                st.play();
                            }
                    }
            }

        public void addkremala()
            {
                //Κρεμάλα Κάθετο Ξύλο
                    Line h = new Line();
                    h.setStartX(70);
                    h.setStartY(200);
                    h.setEndX(70);
                    h.setEndY(550);
                    h.setStroke(Color.BROWN);
                    currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(h);
                    kremalaparts.add(h);

                //Κρεμάλα Κάθετο Ξύλο
                    Line h3 = new Line();
                    h3.setStartX(45);
                    h3.setStartY(200);
                    h3.setEndX(70);
                    h3.setEndY(200);
                    h3.setStroke(Color.BROWN);
                    currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(h3);
                    kremalaparts.add(h3);

                //Κρεμάλα Κάθετο Ξύλο
                    Line h4 = new Line();
                    h4.setStartX(45);
                    h4.setStartY(550);
                    h4.setEndX(70);
                    h4.setEndY(550);
                    h4.setStroke(Color.BROWN);
                    currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(h4);
                    kremalaparts.add(h4);

                //Κρεμάλα Κάθετο Ξύλο
                    Line h2 = new Line();
                    h2.setStartX(45);
                    h2.setStartY(200);
                    h2.setEndX(45);
                    h2.setEndY(550);
                    h2.setStroke(Color.BROWN);
                    currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(h2);
                    kremalaparts.add(h2);

                //Κρεμάλα Οριζόντιο Ξύλο
                    Line h11 = new Line();
                    h11.setStartX(80);
                    h11.setStartY(200);
                    h11.setEndX(195);
                    h11.setEndY(200);
                    h11.setStroke(Color.BROWN);
                    currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(h11);
                    kremalaparts.add(h11);

                //Κρεμάλα Οριζόντιο Ξύλο
                    Line h12 = new Line();
                    h12.setStartX(80);
                    h12.setStartY(225);
                    h12.setEndX(195);
                    h12.setEndY(225);
                    h12.setStroke(Color.BROWN);
                    currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(h12);
                    kremalaparts.add(h12);

                //Κρεμάλα Οριζόντιο Ξύλο
                    Line h13 = new Line();
                    h13.setStartX(80);
                    h13.setStartY(200);
                    h13.setEndX(80);
                    h13.setEndY(225);
                    h13.setStroke(Color.BROWN);
                    currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(h13);
                    kremalaparts.add(h13);

                //Κρεμάλα Οριζόντιο Ξύλο
                    Line h14 = new Line();
                    h14.setStartX(195);
                    h14.setStartY(200);
                    h14.setEndX(195);
                    h14.setEndY(225);
                    h14.setStroke(Color.BROWN);
                    currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(h14);
                    kremalaparts.add(h14);

                //Σχοινί
                    Line rope = new Line();
                    rope.setStartX(160);
                    rope.setStartY(235);
                    rope.setEndX(160);
                    rope.setEndY(280);
                    rope.setStroke(Color.BROWN);
                    currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(rope);
                    kremalaparts.add(rope);
                    
                    
                    
                    
                    kremalaparts.forEach(i -> 
                        {
                            if(i.equals(rope))
                                {
                                    ScaleTransition st = new ScaleTransition(Duration.millis(1200));
                                    st.setNode(i);
                                    st.setFromX(0);
                                    st.setFromY(0);
                                    st.setToX(1.0);
                                    st.setToY(1.0);
                                    st.play();

                                    RotateTransition exitrotatelone = new RotateTransition();
                                    exitrotatelone.setAxis(Rotate.Z_AXIS);
                                    exitrotatelone.setFromAngle(0);
                                    exitrotatelone.setToAngle(15);
                                    exitrotatelone.setAutoReverse(true);
                                    exitrotatelone.setDuration(Duration.millis(250));
                                    exitrotatelone.setNode(i);

                                    RotateTransition exitrotater = new RotateTransition();
                                    exitrotater.setAxis(Rotate.Z_AXIS);
                                    exitrotater.setFromAngle(15);
                                    exitrotater.setToAngle(-15);
                                    exitrotater.setAutoReverse(true);
                                    exitrotater.setDuration(Duration.millis(250));
                                    exitrotater.setNode(i);

                                    RotateTransition exitrotateltwo = new RotateTransition();
                                    exitrotateltwo.setAxis(Rotate.Z_AXIS);
                                    exitrotateltwo.setFromAngle(-15);
                                    exitrotateltwo.setToAngle(0);
                                    exitrotateltwo.setByAngle(15);
                                    exitrotateltwo.setAutoReverse(true);
                                    exitrotateltwo.setDuration(Duration.millis(250));
                                    exitrotateltwo.setNode(i);

                                    SequentialTransition seqT = new SequentialTransition (i, st, exitrotatelone, exitrotater, exitrotateltwo);
                                    seqT.play();
                                }
                            else
                                {
                                    ScaleTransition st = new ScaleTransition(Duration.millis(1200));
                                    st.setNode(i);
                                    st.setFromX(0);
                                    st.setFromY(0);
                                    st.setToX(1.0);
                                    st.setToY(1.0);
                                    st.play();
                                }
                        }
                    ); 
            }
    }