public class Moviendose implements State{
  public void tirarDado(Jugador jugador){
    if(jugador.getTurno()){
      System.out.println("El jugador ya ha tirado");
    }else{
      System.out.println("No es turno de este jugador");
    }
  }
  public void jugarMinijuego(){
    System.out.println("No se puede jugar");
  }
  public void mover(IMapa mapa, Jugador jugador){
    if(jugador.getTurno()){
      jugador.mover(mapa,jugador.getAvanceActual());
      jugador.setState(jugador.getLlegandoCasilla());
    }else{
      System.out.println("No es turno de este jugador");
    }
  }

  public void recogerRecompensa(IMapa mapa, Jugador jugador){
    System.out.println("No se ha llegado a ninguna casilla");
  }
}
