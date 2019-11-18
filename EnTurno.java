import java.util.ArrayList;
import java.util.Scanner;
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

public class EnTurno implements State{
  Scanner sc = new Scanner(System.in);
    private JLabel titulo;
    private JButton tDado;
    private Object tiempo;
    private JFrame frameWin;
    private JLabel labelWin;
    private JButton botonOk;

    @Override
    public void tirarDado(Jugador jugador){
//    if(n %5 != 0){

      int cantidad=0;
      ArrayList<IDado> dadosJugador = jugador.getDados(); //obtenemos los dados que tiene el jugador actualmente
      CalculadoraDado calculadoraDado = null; //obtenemos el objeto de Strategy
      if(jugador.getTurno()){
        System.out.println("Elegir el dado que tienes, tienes los siguientes dados");
        for (int i = 0; i<dadosJugador.size(); i++) {
          System.out.println(i + ".-tipo de dado: " + dadosJugador.get(i).tipoDado());
        }

        int dadoElegir = -1;

        while(dadoElegir > dadosJugador.size() || dadoElegir < 0){
          
            dadoElegir = sc.nextInt(); //eliges el dado
            
            if(dadoElegir > dadosJugador.size() || dadoElegir < 0){
              System.out.println("No tienes ese dado, vuelve a elegir");
            }else{
              break;
            }
          
        }

        cantidad = jugador.tirarDado(dadoElegir+1,  dadosJugador.get(dadoElegir).tipoDado()); //el jugador va a tirar el dado
        resultado(cantidad);
        jugador.setAvanceActual(cantidad); //guardamos la cantidad que va a avanzar el jugador
        //Vamos a eliminar el dado especial que uso el jugador, el normal se quedara
        if(dadosJugador.get(dadoElegir).tipoDado()!=1 ){
          dadosJugador.remove(dadoElegir);
        }
        jugador.setDados(dadosJugador); //guardamos los dados del jugador, ya sea que haya usado simple o no
        jugador.setState(jugador.getMoviendose());
      }else{
        System.out.println("No es el turno del jugador");
      }
/*    }else{
      System.out.println("Es momento de jugar un JUEGOASDOADSÑFLSÑFASK");
      jugador.setState(jugador.getJugando());
    }*/
  }
  
    public void resultado(int n){
        frameWin = new JFrame("Resultado"); //Frame para Ventana nueva
        
        frameWin.setSize(200, 110); //tamaño ventana
        frameWin.setLocationRelativeTo(null); //siempre en centro
        frameWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cerrar al terminar
        frameWin.setLayout(null); // imprimir lo del canvas
        
        labelWin = new JLabel("El dado cayó en: "+n); // nuevo texto
        labelWin.setBounds(40,10,500,30); // Posicion x,y - Tamaño x,y
        
        botonOk = new JButton("Aceptar"); // nuevo boton con titulo aceptar
        botonOk.setBounds(45,40,100,30); // Posicion x,y - Tamaño x,y
        
        botonOk.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frameWin.setVisible(false);
                frameWin.dispose();
            }
            
        });//Accion del Boton
        
        frameWin.add(labelWin); //agregar texto al canvas
        frameWin.add(botonOk); //agregar boton al canvas
        
        try{ 
            Thread.sleep(1000); 
        } catch(InterruptedException e ) { 
            System.out.println("Thread Interrupted"); 
        }
      
        frameWin.setVisible(true); // hacer que el frame se vea
    }

  public void jugarMinijuego(int n, Jugador j1, Jugador j2){
    if(n%5 == 0){
      System.out.println("Es momento de jugar un minijuego");
      j1.setState(j1.getJugando());
    }
  }

  public void mover(IMapa mapa, Jugador jugador){
    System.out.println("No ha tirado");
  }

  public void recogerRecompensa(IMapa mapa, Jugador jugador){
    System.out.println("No se ha tirado");
  }




}
