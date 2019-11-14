import java.util.ArrayList;
import java.util.Scanner;
public class EnTurno implements State{
  Scanner sc = new Scanner(System.in);
  public void tirarDado(Jugador jugador){
    int cantidad=0;
    ArrayList<IDado> dadosJugador = jugador.getDados(); //obtenemos los dados que tiene el jugador actualmente
    CalculadoraDado calculadoraDado = null; //obtenemos el objeto de Strategy
    if(jugador.getTurno()){
      System.out.println("Elegir el dado que tienes, tienes los siguientes dados");
      for (int i = 0; i<dadosJugador.size(); i++) {
        System.out.println(i + ".-tipo de dado: " + dadosJugador.get(i).tipoDado());
      }
      int dadoElegir = sc.nextInt(); //eliges el dado
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
  }

  public void jugarMinijuego(){
    System.out.println("No ha tirado");
  }

  public void mover(IMapa mapa, Jugador jugador){
    System.out.println("No ha tirado");
  }

  public void recogerRecompensa(IMapa mapa, Jugador jugador){
    System.out.println("No se ha tirado");
  }




}
