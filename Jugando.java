public class Jugando implements State{
  public void tirarDado(int n, Jugador jugador){
      System.out.println("No se puede tirar, los jugadores juegan");
  }
  public void jugarMinijuego(int n, Jugador jugador1, Jugador jugador2){
    System.out.println("Jugadores jugando");
    GestorMinijuegos gestorMinijuegos = new GestorMinijuegos();
    Minijuego game = new PPoT(jugador1, jugador2);
    //para agregar un minijuego sería
    // game1 = new NameGame(jugador1, jugador2)
    gestorMinijuegos.addMinijuego(game);
    Minijuego elegido = gestorMinijuegos.elegirMinijuego();
    elegido.ejecutarJuego();
    jugador1.setState(jugador1.getEnTurno());

  }
  public void mover(IMapa mapa, Jugador jugador){
    System.out.println("No se puede mover, los jugadores juegan");
  }
  public void recogerRecompensa(IMapa mapa, Jugador jugador){
    System.out.println("No se puede mover, los jugadores juegan");
  }
}
