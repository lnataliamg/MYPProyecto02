import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class EnTurno implements State{
  Scanner sc = new Scanner(System.in);
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

        cantidad = jugador.tirarDado(dadoElegir+1); //el jugador va a tirar el dado
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
