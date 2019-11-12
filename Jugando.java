public class Jugando implements State{
  public void tirarDado(Jugador jugador){
      System.out.println("No se puede tirar, los jugadores juegan");
  }
  public void jugarMinijuego(){
    System.out.println("Jugadores jugando");
    
  }
  public void mover(IMapa mapa, Jugador jugador){
    System.out.println("No se puede mover, los jugadores juegan");
  }
  public void recogerRecompensa(IMapa mapa, Jugador jugador){
    System.out.println("No se puede mover, los jugadores juegan");
  }
}
