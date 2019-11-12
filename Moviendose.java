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
    }else{
      System.out.println("No es turno de este jugador");
    }
    jugador.setState(jugador.getLlegandoCasilla());
  }
  public void recogerRecompensa(IMapa mapa, Jugador jugador){
    System.out.println("No se puede mover, los jugadores juegan");
  }
}
