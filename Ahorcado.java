//package Proyecto;

import java.util.Random;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ahorcado extends Minijuego{

    private volatile boolean running = true;
    private volatile boolean paused = false;
    private final Object tiempo = new Object();

    private JFrame frame;
    private JFrame frameWin;
    private JFrame frameGame;
    
    private Random rnd = new Random();
    
    private JPanel panel;
    
    private JLabel labelBase1;
    private JLabel labelBase2;
    
    private JLabel titulo;
    private JButton iniciar;
    
    private JLabel J1;
    private JLabel J2;
    
    private JLabel labelWin;
    private JButton botonOk;
    
    private JTextField tfP1;
    private JTextField tfP2;
    
    private JButton bP1;
    private JButton bP2;
    
    private JLabel bl;
    private JLabel caballosA;
    private JLabel caballosB;
    private JLabel caballosC;
    private JLabel caballosL;
    private JLabel caballosO;
    private JLabel caballosS;
    
    private JLabel dalmatasD;
    private JLabel dalmatasA;
    private JLabel dalmatasL;
    private JLabel dalmatasM;
    private JLabel dalmatasT;
    
    private JLabel garrafonG;
    private JLabel garrafonA;
    private JLabel garrafonR;
    private JLabel garrafonF;
    private JLabel garrafonN;
    
    int n;
    int errP1;
    int errP2;
    
    private JLabel labelPalo1;
    private JLabel labelPalo2;
    private JLabel labelA3;
    private JLabel labelA4;
    private JLabel labelA5;
    private JLabel labelA6;
    private JLabel labelA7;
    private JLabel labelA8;
    private JLabel labelA9;
    private JLabel labelLose;
    
    private JLabel labelA3_2;
    private JLabel labelA4_2;
    private JLabel labelA5_2;
    private JLabel labelA6_2;
    private JLabel labelA7_2;
    private JLabel labelA8_2;
    private JLabel labelA9_2;
    private JLabel labelLose_2;
    
    private String [] words = {"caballos", "dalmatas", "garrafon"};
    private char [] caballoWin = {'c','a','b','l','o','s'};
    private char [] dalmatasWin = {'d','a','l','m','t','s'};
    private char [] garrafonWin = {'g','a','r','f','o','n'};
    
    private char [] aux6 = new char[6];
    
    public Ahorcado(Jugador jugador1, Jugador jugador2){
      super(jugador1, jugador2);
    }

    @Override
    public void ejecutarJuego() {

        try {
        

        frame = new JFrame("Minijuego"); //Se crea Ventana con titulo "Minijuego"
        panel = new JPanel();
      
        frame.setSize(300, 150); //Tamaño venta na x,y
        frame.setLocationRelativeTo(null); //Posicion siempre en el centro
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cerrar alterminar de ejecutar
        frame.setResizable(false);
        frame.setLayout(null); // poner que aparezcan todos los tipos de canvas
        
        panel.setBounds(0, 0, 300, 150);
      
        titulo = new JLabel("Ahorcado");
      
        titulo.setBounds(105,15,400,50);
        titulo.setFont(new Font("ComicSans",Font.BOLD,18));
      
        iniciar = new JButton("Iniciar");
        
        iniciar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                juego();
                frame.setVisible(false);
            }
          
        });
        iniciar.setBounds(90,60,120,30);
        
        frame.add(panel);
        panel.add(titulo);
        frame.add(iniciar);
        
        panel.setBackground(Color.getHSBColor(200, 100, 100));
      
        frame.setVisible(true); // Hace visible la ventana

        synchronized (tiempo) {
                    tiempo.wait();
                }

        } catch (InterruptedException e) {
                e.printStackTrace();
        }
    }
    
    public void juego(){
        
        frameGame = new JFrame(getNombreJuego()); //Se crea Ventana con titulo "Minijuego"
      
        frameGame.setSize(500, 400); //Tamaño venta na x,y
        frameGame.setLocationRelativeTo(null); //Posicion siempre en el centro
        frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cerrar alterminar de ejecutar
        frameGame.setLayout(null); // poner que aparezcan todos los tipos de canvas
        frameGame.setResizable(false);
        frameGame.setForeground(Color.getHSBColor(201, 72, 88));
        
        tfP1 = new JTextField();
        tfP2 = new JTextField();
        
        //Base J1
        labelBase1 = new JLabel();
        labelBase1.setBounds(40,50,100,100);
        
        ImageIcon baseI1 = new ImageIcon("Ahorcado_Base.png");
        Image base1 = baseI1.getImage();
        ImageIcon baseScale1 = new ImageIcon (base1.getScaledInstance(100,100,Image.SCALE_SMOOTH));
        
        labelBase1.setIcon(baseScale1);
        
        //Base J2
        labelBase2 = new JLabel();
        labelBase2.setBounds(320,50,100,100);
        
        labelBase2.setIcon(baseScale1);
        
        //Palo J1
        labelPalo1 = new JLabel();
        labelPalo1.setBounds(40,50,100,100);
        
        ImageIcon paloI1 = new ImageIcon("Ahorcado_Palo.png");
        Image palo1 = paloI1.getImage();
        ImageIcon paloScale1 = new ImageIcon (palo1.getScaledInstance(100,100,Image.SCALE_SMOOTH));
        
        labelPalo1.setIcon(paloScale1);
        
        //Palo J2
        labelPalo2 = new JLabel();
        labelPalo2.setBounds(320,50,100,100);
        
        labelPalo2.setIcon(paloScale1);
        
        //A3_1
        labelA3 = new JLabel();
        labelA3.setBounds(40,50,100,100);
        
        ImageIcon IA3 = new ImageIcon("Ahorcado3.png");
        Image A3 = IA3.getImage();
        ImageIcon SA3 = new ImageIcon (A3.getScaledInstance(100,100,Image.SCALE_SMOOTH));
        
        labelA3.setIcon(SA3);
        
        //A3_2
        labelA3_2 = new JLabel();
        labelA3_2.setBounds(320,50,100,100);
        
        labelA3_2.setIcon(SA3);
        
        //A4_1
        labelA4 = new JLabel();
        labelA4.setBounds(40,50,100,100);
        
        ImageIcon IA4 = new ImageIcon("Ahorcado4.png");
        Image A4 = IA4.getImage();
        ImageIcon SA4 = new ImageIcon (A4.getScaledInstance(100,100,Image.SCALE_SMOOTH));
        
        labelA4.setIcon(SA4);
        
        //A4_2
        labelA4_2 = new JLabel();
        labelA4_2.setBounds(320,50,100,100);
        
        labelA4_2.setIcon(SA4);
        
        //A5_1
        labelA5 = new JLabel();
        labelA5.setBounds(40,50,100,100);
        
        ImageIcon IA5 = new ImageIcon("Ahorcado5.png");
        Image A5 = IA5.getImage();
        ImageIcon SA5 = new ImageIcon (A5.getScaledInstance(100,100,Image.SCALE_SMOOTH));
        
        labelA5.setIcon(SA5);
        
        //A5_2
        labelA5_2 = new JLabel();
        labelA5_2.setBounds(320,50,100,100);
        
        labelA5_2.setIcon(SA5);
        
        //A6_1
        labelA6 = new JLabel();
        labelA6.setBounds(40,50,100,100);
        
        ImageIcon IA6 = new ImageIcon("Ahorcado6.png");
        Image A6 = IA6.getImage();
        ImageIcon SA6 = new ImageIcon (A6.getScaledInstance(100,100,Image.SCALE_SMOOTH));
        
        labelA6.setIcon(SA6);
        
        //A6_2
        labelA6_2 = new JLabel();
        labelA6_2.setBounds(320,50,100,100);
        
        labelA6_2.setIcon(SA6);
        
        //A7_1
        labelA7 = new JLabel();
        labelA7.setBounds(40,50,100,100);
        
        ImageIcon IA7 = new ImageIcon("Ahorcado7.png");
        Image A7 = IA7.getImage();
        ImageIcon SA7 = new ImageIcon (A7.getScaledInstance(100,100,Image.SCALE_SMOOTH));
        
        labelA7.setIcon(SA7);
        
        //A7_2
        labelA7_2 = new JLabel();
        labelA7_2.setBounds(320,50,100,100);
        
        labelA7_2.setIcon(SA7);
        
        //A8_1
        labelA8 = new JLabel();
        labelA8.setBounds(40,50,100,100);
        
        ImageIcon IA8 = new ImageIcon("Ahorcado8.png");
        Image A8 = IA8.getImage();
        ImageIcon SA8 = new ImageIcon (A8.getScaledInstance(100,100,Image.SCALE_SMOOTH));
        
        labelA8.setIcon(SA8);
        
        //A8_2
        labelA8_2 = new JLabel();
        labelA8_2.setBounds(320,50,100,100);
        
        labelA8_2.setIcon(SA8);
        
        //A9_1
        labelA9 = new JLabel();
        labelA9.setBounds(40,50,100,100);
        
        ImageIcon IA9 = new ImageIcon("Ahorcado9.png");
        Image A9 = IA9.getImage();
        ImageIcon SA9 = new ImageIcon (A9.getScaledInstance(100,100,Image.SCALE_SMOOTH));
        
        labelA9.setIcon(SA9);
        
        //A9_2
        labelA9_2 = new JLabel();
        labelA9_2.setBounds(320,50,100,100);
        
        labelA9_2.setIcon(SA9);
        
        //Lose_1
        labelLose = new JLabel();
        labelLose.setBounds(40,50,100,100);
        
        ImageIcon ILose = new ImageIcon("Lose.png");
        Image Lose = ILose.getImage();
        ImageIcon SLose = new ImageIcon (Lose.getScaledInstance(100,100,Image.SCALE_SMOOTH));
        
        labelLose.setIcon(SLose);
        
        //Lose_2
        labelLose_2 = new JLabel();
        labelLose_2.setBounds(320,50,100,100);
        
        labelLose_2.setIcon(SLose);
        
        //BaseLetras
        bl = new JLabel();
        bl.setBounds(80,120,300,100);
        
        ImageIcon Ibl = new ImageIcon("BaseLetras.png");
        Image bli = Ibl.getImage();
        
        bl.setIcon(Ibl);
        
        //caballos C
        caballosC = new JLabel();
        caballosC.setBounds(80,120,300,100);
        
        ImageIcon icC = new ImageIcon("caballoC.png");
        
        caballosC.setIcon(icC);
        
        //caballos A
        caballosA = new JLabel();
        caballosA.setBounds(80,120,300,100);
        
        ImageIcon icA = new ImageIcon("caballoA.png");
        
        caballosA.setIcon(icA);
        
        //caballos B
        caballosB = new JLabel();
        caballosB.setBounds(80,120,300,100);
        
        ImageIcon icB = new ImageIcon("caballoB.png");
        
        caballosB.setIcon(icB);
        
        //caballos L
        caballosL = new JLabel();
        caballosL.setBounds(80,120,300,100);
        
        ImageIcon icL = new ImageIcon("caballoL.png");
        
        caballosL.setIcon(icL);
        
        //caballos O
        caballosO = new JLabel();
        caballosO.setBounds(80,120,300,100);
        
        ImageIcon icO = new ImageIcon("caballoO.png");
        
        caballosO.setIcon(icO);
        
        //caballos S
        caballosS = new JLabel();
        caballosS.setBounds(80,120,300,100);
        
        ImageIcon icS = new ImageIcon("caballoS.png");
        
        caballosS.setIcon(icS);
        
        
        //GARRAFON
        
        //garrafon G
        garrafonG = new JLabel();
        garrafonG.setBounds(80,120,300,100);
        
        ImageIcon igG = new ImageIcon("garrafonG.png");
        
        garrafonG.setIcon(igG);
        
        //dalmata A
        garrafonA = new JLabel();
        garrafonA.setBounds(80,120,300,100);
        
        ImageIcon igA = new ImageIcon("garrafonA.png");
        
        garrafonA.setIcon(igA);
        
        //dalmata L
        garrafonR = new JLabel();
        garrafonR.setBounds(80,120,300,100);
        
        ImageIcon igR = new ImageIcon("garrafonR.png");
        
        garrafonR.setIcon(igR);
        
        //garrafonF
        garrafonF = new JLabel();
        garrafonF.setBounds(80,120,300,100);
        
        ImageIcon iGF = new ImageIcon("garrafonF.png");
        
        garrafonF.setIcon(iGF);
        
        //garrafon N
        garrafonN = new JLabel();
        garrafonN.setBounds(80,120,300,100);
        
        ImageIcon iGN = new ImageIcon("garrafonN.png");
        
        garrafonN.setIcon(iGN);
        
        //DALMATAS
        
        //dalmata D
        dalmatasD = new JLabel();
        dalmatasD.setBounds(80,120,300,100);
        
        ImageIcon idD = new ImageIcon("dalmatasD.png");
        
        dalmatasD.setIcon(idD);
        
        //dalmata A
        dalmatasA = new JLabel();
        dalmatasA.setBounds(80,120,300,100);
        
        ImageIcon idA = new ImageIcon("dalmatasA.png");
        
        dalmatasA.setIcon(idA);
        
        //dalmata L
        dalmatasL = new JLabel();
        dalmatasL.setBounds(80,120,300,100);
        
        ImageIcon idL = new ImageIcon("dalmatasL.png");
        
        dalmatasL.setIcon(idL);
        
        //dalmataM
        dalmatasM = new JLabel();
        dalmatasM.setBounds(80,120,300,100);
        
        ImageIcon idM = new ImageIcon("dalmatasM.png");
        
        dalmatasM.setIcon(idM);
        
        //dalmata T
        dalmatasT = new JLabel();
        dalmatasT.setBounds(80,120,300,100);
        
        ImageIcon idT = new ImageIcon("dalmatasT.png");
        
        dalmatasT.setIcon(idT);
        
        tfP1 = new JTextField();
        tfP2 = new JTextField();
        
        tfP1.setBounds(65,240,100,30);
        tfP2.setBounds(345,240,100,30);
        
        J1 = new JLabel("Jugador 1: "+jugador1.getName());
        J2 = new JLabel("Jugador 2: "+jugador2.getName());
      
        J1.setBounds(40,20,200,50);
        J2.setBounds(320,20,200,50);
      
        J1.setFont(new Font("ComicSans",Font.BOLD,14));
        J2.setFont(new Font("ComicSans",Font.BOLD,14));
        
        bP1 = new JButton("Intentar"+jugador1.getName());
        bP2 = new JButton("Intentar"+jugador2.getName());

        bP1.setBounds(40,280,150,25);
        bP2.setBounds(320,280,150,25);
        
        n = (int)(rnd.nextDouble()*2+0);
        
        onPlay(words[n],n);
                
        frameGame.add(tfP1);
        frameGame.add(tfP2);
        frameGame.add(bP1);
        frameGame.add(bP2);

        frameGame.add(labelBase1);
        frameGame.add(labelBase2);

        frameGame.add(J1);
        frameGame.add(J2);
        frameGame.add(bl);
        
        frameGame.setVisible(true);
    }
    
    public void ganador(Jugador J){
        frameWin = new JFrame("Ganador"); //Frame para Ventana nueva
        
        frameWin.setSize(200, 110); //tamaño ventana
        frameWin.setLocationRelativeTo(null); //siempre en centro
        frameWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cerrar al terminar
        frameWin.setResizable(false);
        frameWin.setLayout(null); // imprimir lo del canvas
        
        labelWin = new JLabel("El ganador es: "+J.getName()); // nuevo texto
        labelWin.setBounds(40,10,500,30); // Posicion x,y - Tamaño x,y
        
        botonOk = new JButton("Aceptar"); // nuevo boton con titulo aceptar
        botonOk.setBounds(45,40,100,30); // Posicion x,y - Tamaño x,y
        
        botonOk.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frameWin.setVisible(false);
                frameWin.dispose();
                
                frame.setVisible(false);
                frame.dispose();
                
                frameGame.setVisible(false);
                frameGame.dispose();

                synchronized (tiempo) {
                  tiempo.notify();
                }

                jugador1.setState(jugador1.getEnTurno());
                jugador2.setState(jugador2.getEnTurno());
            }
            
        });//Accion del Boton
        
        J.setOskis(J.getOskis()+5);
        
        System.out.println(""+jugador1.getName()+" "+jugador1.getOskis() + " tiene esos oskis\n");
        System.out.println(""+jugador2.getName()+" "+jugador2.getOskis() + " tiene esos oskis\n");
        
        for (int i = 0; i < aux6.length; i++) {
            aux6[i] = '#';
        }
        
        frameWin.add(labelWin); //agregar texto al canvas
        frameWin.add(botonOk); //agregar boton al canvas
      
        frameWin.setVisible(true); // hacer que el frame se vea
    }

    @Override
    public String getNombreJuego() {
        return "Ahorcado";
    }
    
    public void actionPerformed(ActionEvent arg0) {
        
    }

    private void onPlay(String word,int n) {
        if(n == 0){
            bP1.addActionListener(new ActionListener(){
               
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if (word.equalsIgnoreCase(tfP1.getText())) {
                        frameGame.add(caballosA);
                        frameGame.add(caballosC);
                        frameGame.add(caballosB);
                        frameGame.add(caballosL);
                        frameGame.add(caballosO);
                        frameGame.add(caballosS);

                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        ganador(jugador1);
                        System.out.println("La palabra es/fue "+word);
                        
                    }else if("a".equalsIgnoreCase(tfP1.getText())){
                        frameGame.add(caballosA);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'a'){
                                break;
                            }else{
                                aux6[1] = 'a';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != caballoWin[j]){
                                break;
                            }else if(j == aux6.length-1){
                                ganador(jugador1);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("b".equalsIgnoreCase(tfP1.getText())){
                        frameGame.add(caballosB);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'b'){
                                break;
                            }else{
                                aux6[2] = 'b';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != caballoWin[j]){
                                break;
                            }else if((j == aux6.length-1)){
                                ganador(jugador1);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("c".equalsIgnoreCase(tfP1.getText())){
                        frameGame.add(caballosC);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'c'){
                                break;
                            }else{
                                aux6[0] = 'c';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != caballoWin[j]){
                                break;
                            }else if((j == aux6.length-1)){
                                ganador(jugador1);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("l".equalsIgnoreCase(tfP1.getText())){
                        frameGame.add(caballosL);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'l'){
                                break;
                            }else{
                                aux6[3] = 'l';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != caballoWin[j]){
                                break;
                            }else if((j == aux6.length-1)){
                                ganador(jugador1);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("o".equalsIgnoreCase(tfP1.getText())){
                        frameGame.add(caballosO);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'o'){
                                break;
                            }else{
                                aux6[4] = 'o';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != caballoWin[j]){
                                break;
                            }else if((j == aux6.length-1)){
                                ganador(jugador1);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("s".equalsIgnoreCase(tfP1.getText())){
                        frameGame.add(caballosS);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 's'){
                                break;
                            }else{
                                aux6[5] = 's';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != caballoWin[j]){
                                break;
                            }else if((j == aux6.length-1)){
                                ganador(jugador1);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                    }else{
                        errP1++;
                    }
                
                    switch (errP1) {
                        case 1:
                            frameGame.add(labelPalo1);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 2:
                            frameGame.add(labelA3);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 3:
                            frameGame.add(labelA4);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 4:
                            frameGame.add(labelA5);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 5:
                            frameGame.add(labelA6);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 6:
                            frameGame.add(labelA7);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 7:
                            frameGame.add(labelA8);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 8:
                            frameGame.add(labelA9);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 9:
                            frameGame.add(labelLose);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            ganador(jugador2);
                                System.out.println("La palabra es/fue "+word);
                            break;
                        default:
                            break;
                    }
                
                }
            });
            
            bP2.addActionListener(new ActionListener(){
                
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if (word.equalsIgnoreCase(tfP2.getText())) {
                        frameGame.add(caballosA);
                        frameGame.add(caballosC);
                        frameGame.add(caballosB);
                        frameGame.add(caballosL);
                        frameGame.add(caballosO);
                        frameGame.add(caballosS);

                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        ganador(jugador2);
                        System.out.println("La palabra es/fue "+word);
                        
                    }else if("a".equalsIgnoreCase(tfP2.getText())){
                        frameGame.add(caballosA);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'a'){
                                break;
                            }else{
                                aux6[1] = 'a';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != caballoWin[j]){
                                break;
                            }else if((aux6[j] == caballoWin[j]) && (j == aux6.length-1)){
                                ganador(jugador2);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("b".equalsIgnoreCase(tfP2.getText())){
                        frameGame.add(caballosB);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'b'){
                                break;
                            }else{
                                aux6[2] = 'b';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != caballoWin[j]){
                                break;
                            }else if((aux6[j] == caballoWin[j]) && (j == aux6.length-1)){
                                ganador(jugador2);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("c".equalsIgnoreCase(tfP2.getText())){
                        frameGame.add(caballosC);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'c'){
                                break;
                            }else{
                                aux6[0] = 'c';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != caballoWin[j]){
                                break;
                            }else if((aux6[j] == caballoWin[j]) && (j == aux6.length-1)){
                                ganador(jugador2);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("l".equalsIgnoreCase(tfP2.getText())){
                        frameGame.add(caballosL);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'l'){
                                break;
                            }else{
                                aux6[3] = 'l';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != caballoWin[j]){
                                break;
                            }else if((aux6[j] == caballoWin[j]) && (j == aux6.length-1)){
                                ganador(jugador2);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("o".equalsIgnoreCase(tfP2.getText())){
                        frameGame.add(caballosO);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'o'){
                                break;
                            }else{
                                aux6[4] = 'o';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != caballoWin[j]){
                                break;
                            }else if((aux6[j] == caballoWin[j]) && (j == aux6.length-1)){
                                ganador(jugador2);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("s".equalsIgnoreCase(tfP2.getText())){
                        frameGame.add(caballosS);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 's'){
                                break;
                            }else{
                                aux6[5] = 's';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != caballoWin[j]){
                                break;
                            }else if((aux6[j] == caballoWin[j]) && (j == aux6.length-1)){
                                System.out.println("son iguales");
                                ganador(jugador2);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                    }else{
                        errP2++;
                    }
                
                    switch (errP2) {
                        case 1:
                            frameGame.add(labelPalo2);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 2:
                            frameGame.add(labelA3_2);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 3:
                            frameGame.add(labelA4_2);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 4:
                            frameGame.add(labelA5_2);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 5:
                            frameGame.add(labelA6_2);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 6:
                            frameGame.add(labelA7_2);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 7:
                            frameGame.add(labelA8_2);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 8:
                            frameGame.add(labelA9_2);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 9:
                            frameGame.add(labelLose_2);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            ganador(jugador1);
                                System.out.println("La palabra es/fue "+word);
                            break;
                        default:
                            break;
                    }
                
                }
            });
        }
        
        //Dalmatas
        if (n == 1){
            
            bP1.addActionListener(new ActionListener(){
               
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if (word.equalsIgnoreCase(tfP1.getText())) {
                        frameGame.add(dalmatasA);
                        frameGame.add(dalmatasL);
                        frameGame.add(dalmatasD);
                        frameGame.add(dalmatasM);
                        frameGame.add(dalmatasT);
                        frameGame.add(caballosS);

                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        ganador(jugador1);
                        System.out.println("La palabra es/fue "+word);
                        
                    }else if("a".equalsIgnoreCase(tfP1.getText())){
                        frameGame.add(dalmatasA);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'a'){
                                break;
                            }else{
                                aux6[1] = 'a';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != dalmatasWin[j]){
                                break;
                            }else if(j == aux6.length-1){
                                ganador(jugador1);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("l".equalsIgnoreCase(tfP1.getText())){
                        frameGame.add(dalmatasL);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'l'){
                                break;
                            }else{
                                aux6[2] = 'l';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != dalmatasWin[j]){
                                break;
                            }else if((j == aux6.length-1)){
                                ganador(jugador1);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("d".equalsIgnoreCase(tfP1.getText())){
                        frameGame.add(dalmatasD);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'd'){
                                break;
                            }else{
                                aux6[0] = 'd';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != dalmatasWin[j]){
                                break;
                            }else if((j == aux6.length-1)){
                                ganador(jugador1);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("m".equalsIgnoreCase(tfP1.getText())){
                        frameGame.add(dalmatasM);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'm'){
                                break;
                            }else{
                                aux6[3] = 'm';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != dalmatasWin[j]){
                                break;
                            }else if((j == aux6.length-1)){
                                ganador(jugador1);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("t".equalsIgnoreCase(tfP1.getText())){
                        frameGame.add(dalmatasT);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 't'){
                                break;
                            }else{
                                aux6[4] = 't';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != dalmatasWin[j]){
                                break;
                            }else if((j == aux6.length-1)){
                                ganador(jugador1);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("s".equalsIgnoreCase(tfP1.getText())){
                        frameGame.add(caballosS);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 's'){
                                break;
                            }else{
                                aux6[5] = 's';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != dalmatasWin[j]){
                                break;
                            }else if((j == aux6.length-1)){
                                System.out.println("son iguales");
                                ganador(jugador1);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                    }else{
                        errP1++;
                    }
                
                    switch (errP1) {
                        case 1:
                            frameGame.add(labelPalo1);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 2:
                            frameGame.add(labelA3);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 3:
                            frameGame.add(labelA4);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 4:
                            frameGame.add(labelA5);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 5:
                            frameGame.add(labelA6);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 6:
                            frameGame.add(labelA7);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 7:
                            frameGame.add(labelA8);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 8:
                            frameGame.add(labelA9);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 9:
                            frameGame.add(labelLose);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            ganador(jugador2);
                                System.out.println("La palabra es/fue "+word);
                            break;
                        default:
                            break;
                    }
                
                }
            });
            
            bP2.addActionListener(new ActionListener(){
                
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if (word.equalsIgnoreCase(tfP2.getText())) {
                        frameGame.add(dalmatasA);
                        frameGame.add(dalmatasL);
                        frameGame.add(dalmatasD);
                        frameGame.add(dalmatasM);
                        frameGame.add(dalmatasT);
                        frameGame.add(caballosS);

                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        ganador(jugador2);
                        System.out.println("La palabra es/fue "+word);
                        
                    }else if("a".equalsIgnoreCase(tfP2.getText())){
                        frameGame.add(dalmatasA);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'a'){
                                break;
                            }else{
                                aux6[1] = 'a';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != dalmatasWin[j]){
                                break;
                            }else if((aux6[j] == dalmatasWin[j]) && (j == aux6.length-1)){
                                ganador(jugador2);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("l".equalsIgnoreCase(tfP2.getText())){
                        frameGame.add(dalmatasL);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'l'){
                                break;
                            }else{
                                aux6[2] = 'l';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != dalmatasWin[j]){
                                break;
                            }else if((aux6[j] == dalmatasWin[j]) && (j == aux6.length-1)){
                                ganador(jugador2);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("d".equalsIgnoreCase(tfP2.getText())){
                        frameGame.add(dalmatasD);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'd'){
                                break;
                            }else{
                                aux6[0] = 'd';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != dalmatasWin[j]){
                                break;
                            }else if((aux6[j] == dalmatasWin[j]) && (j == aux6.length-1)){
                                ganador(jugador2);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("m".equalsIgnoreCase(tfP2.getText())){
                        frameGame.add(dalmatasM);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'm'){
                                break;
                            }else{
                                aux6[3] = 'm';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != dalmatasWin[j]){
                                break;
                            }else if((aux6[j] == dalmatasWin[j]) && (j == aux6.length-1)){
                                ganador(jugador2);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("t".equalsIgnoreCase(tfP2.getText())){
                        frameGame.add(dalmatasT);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 't'){
                                break;
                            }else{
                                aux6[4] = 't';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != dalmatasWin[j]){
                                break;
                            }else if((aux6[j] == dalmatasWin[j]) && (j == aux6.length-1)){
                                ganador(jugador2);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("s".equalsIgnoreCase(tfP2.getText())){
                        frameGame.add(caballosS);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 's'){
                                break;
                            }else{
                                aux6[5] = 's';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != dalmatasWin[j]){
                                break;
                            }else if((aux6[j] == dalmatasWin[j]) && (j == aux6.length-1)){
                                ganador(jugador2);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else{
                        errP2++;
                    }
                
                    switch (errP2) {
                        case 1:
                            frameGame.add(labelPalo2);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 2:
                            frameGame.add(labelA3_2);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 3:
                            frameGame.add(labelA4_2);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 4:
                            frameGame.add(labelA5_2);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 5:
                            frameGame.add(labelA6_2);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 6:
                            frameGame.add(labelA7_2);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 7:
                            frameGame.add(labelA8_2);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 8:
                            frameGame.add(labelA9_2);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 9:
                            frameGame.add(labelLose_2);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            ganador(jugador1);
                                System.out.println("La palabra es/fue "+word);
                            break;
                        default:
                            break;
                    }
                
                }
            });
            
        }
        
        if (n == 2){
            bP1.addActionListener(new ActionListener(){
               
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if (word.equalsIgnoreCase(tfP1.getText())) {
                        frameGame.add(garrafonG);
                        frameGame.add(garrafonA);
                        frameGame.add(garrafonR);
                        frameGame.add(garrafonF);
                        frameGame.add(garrafonN);
                        frameGame.add(caballosO);

                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        ganador(jugador1);
                        System.out.println("La palabra es/fue "+word);
                        
                    }else if("g".equalsIgnoreCase(tfP1.getText())){
                        frameGame.add(garrafonG);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'g'){
                                break;
                            }else{
                                aux6[0] = 'g';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != garrafonWin[j]){
                                break;
                            }else if(j == aux6.length-1){
                                ganador(jugador1);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("a".equalsIgnoreCase(tfP1.getText())){
                        frameGame.add(garrafonA);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'a'){
                                break;
                            }else{
                                aux6[1] = 'a';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != garrafonWin[j]){
                                break;
                            }else if((j == aux6.length-1)){
                                ganador(jugador1);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("r".equalsIgnoreCase(tfP1.getText())){
                        frameGame.add(garrafonR);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'r'){
                                break;
                            }else{
                                aux6[2] = 'r';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != garrafonWin[j]){
                                break;
                            }else if((j == aux6.length-1)){
                                ganador(jugador1);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("f".equalsIgnoreCase(tfP1.getText())){
                        frameGame.add(garrafonF);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'f'){
                                break;
                            }else{
                                aux6[3] = 'f';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != garrafonWin[j]){
                                break;
                            }else if((j == aux6.length-1)){
                                ganador(jugador1);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("o".equalsIgnoreCase(tfP1.getText())){
                        frameGame.add(caballosO);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'o'){
                                break;
                            }else{
                                aux6[4] = 'o';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != garrafonWin[j]){
                                break;
                            }else if((j == aux6.length-1)){
                                ganador(jugador1);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("n".equalsIgnoreCase(tfP1.getText())){
                        frameGame.add(garrafonN);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'n'){
                                break;
                            }else{
                                aux6[5] = 'n';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != garrafonWin[j]){
                                break;
                            }else if((j == aux6.length-1)){
                                ganador(jugador1);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                    }else{
                        errP1++;
                    }
                
                    switch (errP1) {
                        case 1:
                            frameGame.add(labelPalo1);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 2:
                            frameGame.add(labelA3);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 3:
                            frameGame.add(labelA4);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 4:
                            frameGame.add(labelA5);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 5:
                            frameGame.add(labelA6);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 6:
                            frameGame.add(labelA7);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 7:
                            frameGame.add(labelA8);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 8:
                            frameGame.add(labelA9);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 9:
                            frameGame.add(labelLose);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            ganador(jugador2);
                                System.out.println("La palabra es/fue "+word);
                            break;
                        default:
                            break;
                    }
                
                }
            });
            
            bP2.addActionListener(new ActionListener(){
                
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if (word.equalsIgnoreCase(tfP2.getText())) {
                        frameGame.add(garrafonG);
                        frameGame.add(garrafonA);
                        frameGame.add(garrafonR);
                        frameGame.add(garrafonF);
                        frameGame.add(garrafonN);
                        frameGame.add(caballosO);

                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        ganador(jugador2);
                        System.out.println("La palabra es/fue "+word);
                        
                    }else if("g".equalsIgnoreCase(tfP2.getText())){
                        frameGame.add(garrafonG);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'g'){
                                break;
                            }else{
                                aux6[0] = 'g';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != garrafonWin[j]){
                                break;
                            }else if((aux6[j] == garrafonWin[j]) && (j == aux6.length-1)){
                                ganador(jugador2);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("a".equalsIgnoreCase(tfP2.getText())){
                        frameGame.add(garrafonA);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'a'){
                                break;
                            }else{
                                aux6[1] = 'a';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != garrafonWin[j]){
                                break;
                            }else if((aux6[j] == garrafonWin[j]) && (j == aux6.length-1)){
                                ganador(jugador2);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("r".equalsIgnoreCase(tfP2.getText())){
                        frameGame.add(garrafonR);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'r'){
                                break;
                            }else{
                                aux6[2] = 'r';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != garrafonWin[j]){
                                break;
                            }else if((aux6[j] == garrafonWin[j]) && (j == aux6.length-1)){
                                ganador(jugador2);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("f".equalsIgnoreCase(tfP2.getText())){
                        frameGame.add(garrafonF);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'f'){
                                break;
                            }else{
                                aux6[3] = 'f';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != garrafonWin[j]){
                                break;
                            }else if((aux6[j] == garrafonWin[j]) && (j == aux6.length-1)){
                                ganador(jugador2);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("o".equalsIgnoreCase(tfP2.getText())){
                        frameGame.add(caballosO);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'o'){
                                break;
                            }else{
                                aux6[4] = 'o';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != garrafonWin[j]){
                                break;
                            }else if((aux6[j] == garrafonWin[j]) && (j == aux6.length-1)){
                                ganador(jugador2);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                        
                    }else if("n".equalsIgnoreCase(tfP2.getText())){
                        frameGame.add(garrafonN);
                        frameGame.setVisible(false);
                        frameGame.setVisible(true);
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[j] == 'n'){
                                break;
                            }else{
                                aux6[5] = 'n';
                            }
                        }
                        
                        for (int j = 0; j < aux6.length; j++) {
                            if(aux6[j] != garrafonWin[j]){
                                break;
                            }else if((aux6[j] == garrafonWin[j]) && (j == aux6.length-1)){
                                ganador(jugador2);
                                System.out.println("La palabra es/fue "+word);
                            }
                        }
                                               
                    }else{
                        errP2++;
                    }
                
                    switch (errP2) {
                        case 1:
                            frameGame.add(labelPalo2);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 2:
                            frameGame.add(labelA3_2);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 3:
                            frameGame.add(labelA4_2);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 4:
                            frameGame.add(labelA5_2);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 5:
                            frameGame.add(labelA6_2);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 6:
                            frameGame.add(labelA7_2);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 7:
                            frameGame.add(labelA8_2);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 8:
                            frameGame.add(labelA9_2);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            break;
                        case 9:
                            frameGame.add(labelLose_2);
                            frameGame.setVisible(false);
                            frameGame.setVisible(true);
                            ganador(jugador1);
                                System.out.println("La palabra es/fue "+word);
                            break;
                        default:
                            break;
                    }
                
                }
            });
        }
    }
}
