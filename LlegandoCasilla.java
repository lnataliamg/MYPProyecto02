public class LlegandoCasilla implements State{
  public void tirarDado(int n, Jugador jugador){
    if(jugador.getTurno()){
      System.out.println("El jugador ya ha tirado");
    }else{
      System.out.println("No es turno de este jugador");
    }
  }
  public void jugarMinijuego(int n, Jugador j1, Jugador j2){
    System.out.println("No se puede jugar");
  }
  public void mover(IMapa mapa, Jugador jugador){
    if(jugador.getTurno()){
      System.out.println("El jugador ya se ha movido");
    }else{
      System.out.println("No es turno de este jugador");
    }
  }
  public void recogerRecompensa(IMapa mapa, Jugador jugador){
    if(jugador.getTurno()){
      int posicionActual = jugador.getPosicionActual();
      Casilla casillaActual = mapa.getCasilla(posicionActual);
      System.out.println("aqui si");
      if(casillaActual.isBonoOski()){
      
        jugador.setOskis(jugador.getOskis()+ casillaActual.getNumeroBonosOs());
      }else if(casillaActual.isBonoDado()){
        jugador.addDado(casillaActual.getTypeDado());
      }else if(casillaActual.isCastigo()){
        jugador.setOskis(jugador.getOskis() - casillaActual.getTypeNumeroCastigo());
      }
    }else{
      System.out.println("No es turno de este jugador");
    }
    jugador.setTurno(false);
    jugador.setState(jugador.getEnTurno());
  }
}
