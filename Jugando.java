public class Jugando implements State{
  public void tirarDado(Jugador jugador){
      System.out.println("No se puede tirar, los jugadores juegan");
  }
  
  public void jugarMinijuego(int n, Jugador jugador1, Jugador jugador2){
    if(n%5==0){
    System.out.println("Jugadores jugando");
    GestorMinijuegos gestorMinijuegos = new GestorMinijuegos();
    Minijuego game = new PPoT(jugador1, jugador2);
    //para agregar un minijuego sería
    // game1 = new NameGame(jugador1, jugador2)
    Minijuego game1 = new Ahorcado(jugador1, jugador2);
    Minijuego game2 = new ChooseGame(jugador1, jugador2);
    gestorMinijuegos.addMinijuego(game);
    gestorMinijuegos.addMinijuego(game1);
    gestorMinijuegos.addMinijuego(game2);
    Minijuego elegido = gestorMinijuegos.elegirMinijuego();
    System.out.println(elegido.getNombreJuego());
    elegido.ejecutarJuego();


  }else{
    jugador1.setState(jugador1.getEnTurno());
    jugador2.setState(jugador2.getEnTurno());

  }


  }
  public void mover(IMapa mapa, Jugador jugador){
    System.out.println("No se puede mover, los jugadores juegan");
  }
  public void recogerRecompensa(IMapa mapa, Jugador jugador){
    System.out.println("No se puede mover, los jugadores juegan");
  }
}
