import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PPoT extends Minijuego{

    private volatile boolean running = true;
    private volatile boolean paused = false;
    private final Object tiempo = new Object();
    
    private JFrame frame;
    private JFrame frameGame;
    private JFrame frameWin;
    
    private JButton botonOk;
    private JButton iniciar;

    private JButton piedra1;
    private JButton piedra2;
    
    private JButton papel1;
    private JButton papel2;
    
    private JButton tijeras1;
    private JButton tijeras2;
    
    private JLabel titulo;
    private JLabel J1;
    private JLabel J2;
    
    private JLabel labelWin;
    
    private JTextField textfield1;
    private int turnoP1;
    private int turnoP2;
    
    String players;
    
    private int n;
    
    public PPoT(Jugador jugador1, Jugador jugador2){
      super(jugador1, jugador2);
    }
    
    public String getNombreJuego(){
      return "Piedra, papel o tijera";
    }

    public void ganador(Jugador J, String s){
        frameWin = new JFrame("Ganador"); //Frame para Ventana nueva
        
        frameWin.setSize(200, 120); //tamaño ventana
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
        
        System.out.println("El ganador es: "+J.getName());
        
        
        frameWin.add(labelWin); //agregar texto al canvas
        frameWin.add(botonOk); //agregar boton al canvas
      
        frameWin.setVisible(true); // hacer que el frame se vea
    }
    
    public void empate(){
        frameWin = new JFrame("Empate"); //Frame para Ventana nueva
        
        frameWin.setSize(200, 110); //tamaño ventana
        frameWin.setLocationRelativeTo(null); //siempre en centro
        frameWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cerrar al terminar
        frameWin.setLayout(null); // imprimir lo del canvas
        
        labelWin = new JLabel("Empate"); // nuevo texto
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
        
        frameWin.add(labelWin); //agregar texto al canvas
        frameWin.add(botonOk); //agregar boton al canvas
      
        frameWin.setVisible(true); // hacer que el frame se vea
        System.out.println("Empate");
    }

    public void juego(){
      frameGame = new JFrame(getNombreJuego()); //Se crea Ventana con titulo "Minijuego"
      
      frameGame.setSize(500, 250); //Tamaño venta na x,y
      frameGame.setLocationRelativeTo(null); //Posicion siempre en el centro
      frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cerrar alterminar de ejecutar
      frameGame.setResizable(false);
      frameGame.setLayout(null); // poner que aparezcan todos los tipos de canvas
      
      ImageIcon tijeras = new ImageIcon("scissors.png");
      ImageIcon piedra = new ImageIcon("stone.png");
      ImageIcon papel = new ImageIcon("text-document.png");
      
      J1 = new JLabel("Jugador 1: "+jugador1.getName());
      J2 = new JLabel("Jugador 2: "+jugador2.getName());
      
      J1.setBounds(40,20,200,50);
      J2.setBounds(320,20,200,50);
      
      J1.setFont(new Font("ComicSans",Font.BOLD,14));
      J2.setFont(new Font("ComicSans",Font.BOLD,14));
      
      //Boton Piedra1
      piedra1 = new JButton("");
      piedra1.setBounds(20, 80, 70, 70);
      piedra1.setIcon(piedra);
      //Boton Papel1
      papel1 = new JButton("");
      papel1.setBounds(90, 80, 70, 70); 
      papel1.setIcon(papel);
      //Boton Tijeras1
      tijeras1 = new JButton("");
      tijeras1.setBounds(160, 80, 70, 70);
      tijeras1.setIcon(tijeras);
      
      //Boton Piedra2
      piedra2 = new JButton("");
      piedra2.setBounds(270, 80, 70, 70);
      piedra2.setIcon(piedra);
      //Boton Papel2
      papel2 = new JButton("");
      papel2.setBounds(340, 80, 70, 70);
      papel2.setIcon(papel);
      //Boton Tijeras2
      tijeras2 = new JButton("");
      tijeras2.setBounds(410, 80, 70, 70);
      tijeras2.setIcon(tijeras);
      
      piedra1.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent ae) {
              piedra2.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent ae) {
                        empate();
                        System.out.println("Ambos eligieron Piedra");
                        System.out.println(""+jugador1.getName()+" "+jugador1.getOskis() + " tiene esos oskis\n");
                        System.out.println(""+jugador2.getName()+" "+jugador2.getOskis() + " tiene esos oskis\n");
                        
                  }
              });
              
              papel2.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent ae) {
                        players = jugador1.getName()+" eligió Piedra\n"+jugador2.getName()+" eligió Papel\n";
                        ganador(jugador2,players);
                        System.out.println(players);
                        System.out.println(""+jugador1.getName()+" "+jugador1.getOskis() + " tiene esos oskis\n");
                        System.out.println(""+jugador2.getName()+" "+jugador2.getOskis() + " tiene esos oskis\n");
                        
                  }
              });
              
              tijeras2.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent ae) {
                        players = jugador1.getName()+" eligió Piedra\n"+jugador2.getName()+" eligió Tijeras\n";
                        System.out.println(players);
                        ganador(jugador1,players);
                        System.out.println(""+jugador1.getName()+" "+jugador1.getOskis() + " tiene esos oskis\n");
                        System.out.println(""+jugador2.getName()+" "+jugador2.getOskis() + " tiene esos oskis\n");
                  }
              });
          }
          
      });
      
      papel1.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent ae) {
              piedra2.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent ae) {
                        players = jugador1.getName()+" eligió Papel\n"+jugador2.getName()+" eligió Piedra\n";
                        System.out.println(players);
                        ganador(jugador1,players);
                        System.out.println(""+jugador1.getName()+" "+jugador1.getOskis() + " tiene esos oskis\n");
                        System.out.println(""+jugador2.getName()+" "+jugador2.getOskis() + " tiene esos oskis\n");
                  }
              });
              
              papel2.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent ae) {
                        System.out.println("Ambos eligieron Piedra");
                        empate();
                        System.out.println(""+jugador1.getName()+" "+jugador1.getOskis() + " tiene esos oskis\n");
                        System.out.println(""+jugador2.getName()+" "+jugador2.getOskis() + " tiene esos oskis\n");
                  }
              });
              
              tijeras2.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent ae) {
                        players = jugador1.getName()+" eligió Papel\n"+jugador2.getName()+" eligió Tijeras\n";
                        System.out.println(players);
                        ganador(jugador2,players);
                        System.out.println(""+jugador1.getName()+" "+jugador1.getOskis() + " tiene esos oskis\n");
                        System.out.println(""+jugador2.getName()+" "+jugador2.getOskis() + " tiene esos oskis\n");
                  }
              });
          }
          
      });
      
      tijeras1.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent ae) {
              piedra2.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent ae) {
                        players = jugador1.getName()+" eligió Tijeras\n"+jugador2.getName()+" eligió Piedra\n";
                        System.out.println(players);
                        ganador(jugador2,players);
                        System.out.println(""+jugador1.getName()+" "+jugador1.getOskis() + " tiene esos oskis\n");
                        System.out.println(""+jugador2.getName()+" "+jugador2.getOskis() + " tiene esos oskis\n");
                  }
              });
              
              papel2.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent ae) {
                        players = jugador1.getName()+" eligió Tijeras\n"+jugador2.getName()+" eligió Papel\n";
                        System.out.println(players);
                        ganador(jugador1,players);
                        System.out.println(""+jugador1.getName()+" "+jugador1.getOskis() + " tiene esos oskis\n");
                        System.out.println(""+jugador2.getName()+" "+jugador2.getOskis() + " tiene esos oskis\n");
                  }
              });
              
              tijeras2.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent ae) {
                        System.out.println("Ambos eligieron Piedra");
                        empate();
                        System.out.println(""+jugador1.getName()+" "+jugador1.getOskis() + " tiene esos oskis\n");
                        System.out.println(""+jugador2.getName()+" "+jugador2.getOskis() + " tiene esos oskis\n");
                  }
              });
          }
          
      });
      
      frameGame.add(J1);
      frameGame.add(J2);
      frameGame.add(piedra1);
      frameGame.add(papel1);
      frameGame.add(tijeras1);
      frameGame.add(piedra2);
      frameGame.add(papel2);
      frameGame.add(tijeras2);
      
      frameGame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
                
    }

    public void ejecutarJuego() {

        try {
                

        frame = new JFrame("Minijuego"); //Se crea Ventana con titulo "Minijuego"
      
        frame.setSize(300, 150); //Tamaño venta na x,y
        frame.setLocationRelativeTo(null); //Posicion siempre en el centro
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cerrar alterminar de ejecutar
        frame.setResizable(false);
        frame.setLayout(null); // poner que aparezcan todos los tipos de canvas
      
        titulo = new JLabel("Piedra, Papel o Tijeras");
      
        titulo.setBounds(35,5,400,50);
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
        //piedra1.setIcon(piedra);
      
        frame.add(titulo);
        frame.add(iniciar);
      
        frame.setVisible(true); // Hace visible la ventana
        
        synchronized (tiempo) {
                    tiempo.wait();
                }
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
    }
}
