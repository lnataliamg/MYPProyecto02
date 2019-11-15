import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PPoT extends Minijuego{
    
    private JFrame frame;
    private JFrame frameWin;
    
    private JButton botonOk;

    private JButton piedra1;
    private JButton piedra2;
    
    private JButton papel1;
    private JButton papel2;
    
    private JButton tijeras1;
    private JButton tijeras2;
    
    private JLabel label1;
    private JLabel labelWin;
    
    private JTextField textfield1;
    
    //Personaje p1;
    //Personaje p2;

    //int ganador;
    //int turnoP1;
    //int turnoP2;
    public PPoT(Jugador jugador1, Jugador jugador2){
      super(jugador1, jugador2);
      frame = new JFrame("Minijuego"); //Se crea Ventana con titulo "Minijuego"
      
      frame.setSize(400, 300); //Tamaño venta na x,y
      frame.setLocationRelativeTo(null); //Posicion siempre en el centro
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cerrar alterminar de ejecutar
      frame.setLayout(null); // poner que aparezcan todos los tipos de canvas
      
      frame.setVisible(true); // HAce visible la ventana
    }
    
    public String getNombreJuego(){
      return "Piedra, papel o tijera";
    }

    public void ganador(String s){
        frameWin = new JFrame("Ganador"); //Frame para Ventana nueva
        
        frameWin.setSize(200, 110); //tamaño ventana
        frameWin.setLocationRelativeTo(null); //siempre en centro
        frameWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cerrar al terminar
        frameWin.setLayout(null); // imprimir lo del canvas
        
        labelWin = new JLabel("El ganador es: "+s); // nuevo texto
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
            }
            
        });//Accion del Boton
        
        frameWin.add(labelWin); //agregar texto al canvas
        frameWin.add(botonOk); //agregar boton al canvas
      
        frameWin.setVisible(true); // hacer que el frame se vea
    }

    public void ejecutarJuego(){
        System.out.println("!Hora de Minijuego¡");
        System.out.println("!Turno De jugar¡\n!Piedra, Papel o Tijeras¡");
        System.out.println("El mejor de 3 rondas\nReglas");
        System.out.println("Ingrese el numero correspondiente a lo que desea tirar.");
        System.out.println("1. Piedra\n2. Papel\n3. Tijeras");

        int turnoP1;
        int turnoP2;
        int ganador = 0;
        int winsP1 = 0;
        int winsP2 = 0;
        int n;

        Scanner sc = new Scanner(System.in);

        do{
            if(ganador == 3){
                System.out.println("Empate, Tiren de nuevo");
            }


            System.out.println("Ronda 1");

            System.out.println("Turno del Jugador 1: "+jugador1.getName()+" \nIngresa el numero:");
            turnoP1 = sc.nextInt();

            System.out.println("Turno del Jugador 2: "+jugador2.getName()+" \nIngresa el numero:");
            turnoP2 = sc.nextInt();

            if((turnoP1 == 1 || turnoP1 == 2 || turnoP1 == 3) && (turnoP2 == 1 || turnoP2 == 2 || turnoP2 == 3)){

                switch(turnoP1){
                    case 1: //Piedra
                        switch(turnoP2){
                            case 1: //Piedra
                                ganador = 3; //Donde 3 es empate
                            break;

                            case 2: //Papel
                                ganador = 2; //Donde 2 es que ganó P2
                            break;

                            case 3: //Tijeras
                                ganador = 1; //Donde 1 es que ganó P1
                            break;
                            
                            default:
                                System.out.println("Valor no encontrado");
                            break;
                        }
                    break;

                    case 2: //Papel
                        switch(turnoP2){
                            case 1: //Piedra
                                ganador = 1; //Donde 1 es que ganó P1
                            break;

                            case 2: //Papel
                                ganador = 3; //Donde 3 es empate
                            break;

                            case 3: //Tijeras
                                ganador = 2; //Donde 2 es que ganó P2
                            break;
                            
                            default:
                                System.out.println("Valor no encontrado");
                            break;
                        }
                    break;

                    case 3: //Tijeras
                        switch(turnoP2){
                            case 1: //Piedra
                                ganador = 2; //Donde 2 es que ganó P2
                            break;

                            case 2: //Papel
                                ganador = 1; //Donde 1 es que ganó P1
                            break;

                            case 3: //Tijeras
                                ganador = 3; //Donde 3 es empate
                            break;
                            
                            default:
                                System.out.println("Valor no encontrado");
                            break;
                        }
                    break;
                    default:
                        System.out.println("Valor no encontrado");
                    break;
                }

                if (ganador == 1)
                    winsP1++;

                if (ganador == 2)
                    winsP2++;
            }else{
                System.out.println("Valor no válido");
            }

        }while (ganador != 1 && ganador != 2 );


        if(winsP1 > winsP2){
            System.out.println("¡Ganador "+jugador1.getName()+"!");
            ganador(jugador1.getName()); //metodo que lanza ventatna con el ganador
            n = jugador1.getOskis();
            n+=5;
            jugador1.setOskis(n);
        }

        if(winsP2 > winsP1){
            System.out.println("¡Ganador "+jugador2.getName()+"!");
            ganador(jugador2.getName()); //metodo que lanza ventatna con el ganador
            n = jugador2.getOskis();
            n+=5;
            jugador2.setOskis(n);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        /*if (ae.getSource() == botonOk) {
            frameWin.setVisible(false);
            frameWin.dispose();
        }*/
    }
}
