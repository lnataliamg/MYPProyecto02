import java.util.Scanner;
public class InicializadorJuego{
  Scanner sc = new Scanner(System.in);
  public InicializadorJuego(){}

  public int obtenerTipoMapa(){
    System.out.println("Bienvenido al juego");
    System.out.println("Estas son las reglas.......");
    System.out.println("¿Qué mapa quieres jugar?");
    System.out.println("1. Nieve (mapa largo)");
    System.out.println("2. Fuego (mapa medio)");
    System.out.println("3. Agua (mapa corto)");
    int opcionMapa = sc.nextInt();
    return opcionMapa;
  }

  public Jugador elegirGanador(Jugador j1, Jugador j2){
    if(j1.getOskis() > j2.getOskis()){
      System.out.println("jugador 1 ha ganado");
      return j1;
    }else if(j2.getOskis() > j1.getOskis()){
      System.out.println("jugador 2 ha ganado");
      return j2;
    }else if(j1.getOskis() >= j2.getOskis()){
      System.out.println("Los dos jugadores han empatado. Ambos han ganado");
      return null;
    }
    return null;
  }

  public int elegirNumTurnos(){
    System.out.println("¿Cuántos turnos quieres que tenga tu juego?");
    System.out.println("1. 5");
    System.out.println("2. 10");
    System.out.println("3. 15");
    int opcionTurno = sc.nextInt();
    return opcionTurno;
  }
}
