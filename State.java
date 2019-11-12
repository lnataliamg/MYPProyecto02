public interface State{
  public void tirarDado(Jugador jugador);
  public void jugarMinijuego();
  public void mover(IMapa mapa, Jugador jugador);
  public void recogerRecompensa(IMapa mapa, Jugador jugador);
}
