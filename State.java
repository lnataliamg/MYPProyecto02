public interface State{
  public void tirarDado(int n, Jugador jugador);
  public void jugarMinijuego(int n, Jugador jugador1, Jugador jugador2);
  public void mover(IMapa mapa, Jugador jugador);
  public void recogerRecompensa(IMapa mapa, Jugador jugador);
  
}
