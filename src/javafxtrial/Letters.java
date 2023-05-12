package javafxtrial;

import javafx.scene.control.Button;
public class Letters 
    {
        final private Button alpha;
        final private Button beta;
        final private Button gamma;
        final private Button delta;
        final private Button epsilon;
        final private Button zeta;
        final private Button eta;
        final private Button theta;
        final private Button iota;
        final private Button kappa;
        final private Button lamda;
        final private Button mi;
        final private Button ni;
        final private Button ksi;
        final private Button omikron;
        final private Button pi;
        final private Button ro;
        final private Button segma;
        final private Button tau;
        final private Button ypsilon;
        final private Button fi;
        final private Button xi;
        final private Button psi;
        final private Button omega;
        final private Button[] grammata;
        final private Partida currentpartida;
        
        
        public Letters(Partida partida)
                {
                    currentpartida=partida;
                    alpha = new Button("Α");
                    beta = new Button("Β");
                    gamma = new Button("Γ");
                    delta = new Button("Δ");
                    epsilon = new Button("Ε");
                    zeta = new Button("Ζ");
                    eta = new Button("Η");
                    theta = new Button("Θ");
                    iota= new Button("Ι");
                    kappa = new Button("Κ");
                    lamda = new Button("Λ");
                    mi = new Button("Μ");
                    ni = new Button("Ν");
                    ksi = new Button("Ξ");
                    omikron = new Button("Ο");
                    pi = new Button("Π");
                    ro = new Button("Ρ");
                    segma = new Button("Σ");
                    tau = new Button("Τ");
                    ypsilon = new Button("Υ");
                    fi = new Button("Φ");
                    xi = new Button("Χ");
                    psi = new Button("Ψ");
                    omega = new Button("Ω");
                    grammata = new Button[]{alpha,beta,gamma,delta,epsilon,zeta,eta,theta,iota,kappa,lamda,mi,ni,ksi,omikron,pi,ro,segma,tau,ypsilon,fi,xi,psi,omega};
                }
        
        public void setGrammata(Partida currentpartida,double S,double ly)
            {
                double buttonstartX=(S+300)/2-222.5;
                double buttonstartY=ly+45;
                
                for (int i=0;i<grammata.length;i++)
                    {
                        if(i==7 || i==15)
                            {
                                currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(grammata[i]);
                                Transitions.Scale(grammata[i], 1000, 0.0, 1.0);
                                grammata[i].setId("gramma");
                                grammata[i].applyCss();
                                grammata[i].setStyle("-fx-background-color: transparent"); //Χρώμα Κουμπιών Γραμμάτων
                                grammata[i].setPrefHeight(45); //Μέγεθος Κουμπιών Γραμμάτων
                                grammata[i].setPrefWidth(45); //Μέγεθος Κουμπιών Γραμμάτων
                                grammata[i].setLayoutX(buttonstartX); //Θέση Κουμπιών Γραμμάτων
                                grammata[i].setLayoutY(buttonstartY); //Θέση Κουμπιών Γραμμάτων
                                //grammata[i].setOpacity(100.0);
                                buttonstartX=(S+300)/2-222.5;
                                buttonstartY=buttonstartY+60;
                            }
                        else
                            {
                                currentpartida.getcurrentwordpane().getplayingpane().getChildren().add(grammata[i]);
                                Transitions.Scale(grammata[i], 1000, 0.0, 1.0);
                                grammata[i].setId("gramma");
                                grammata[i].applyCss();
                                grammata[i].setStyle("-fx-background-color: transparent"); //Χρώμα Κουμπιών Γραμμάτων
                                grammata[i].setPrefHeight(45); //Μέγεθος Κουμπιών Γραμμάτων
                                grammata[i].setPrefWidth(45); //Μέγεθος Κουμπιών Γραμμάτων
                                grammata[i].setLayoutX(buttonstartX); //Θέση Κουμπιών Γραμμάτων
                                grammata[i].setLayoutY(buttonstartY); //Θέση Κουμπιών Γραμμάτων
                                //grammata[i].setOpacity(100.0);
    
                                buttonstartX=buttonstartX+60;
                            }
                    }
            }
        
         public void transparent(Boolean status)
            {
                for (Button grammata1 : grammata) 
                    {
                        grammata1.setMouseTransparent(status);
                    }
            }
                
         public int getgrammatasize()
            {
                return grammata.length;
            }
        
         public Button[] getgrammata()
            {
                return grammata;
            }   
    }