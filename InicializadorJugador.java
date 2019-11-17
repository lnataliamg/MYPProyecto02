import java.util.ArrayList;
import java.util.Scanner;
public class InicializadorJugador{
  Scanner sc = new Scanner(System.in);
  public InicializadorJugador(){}

  //crea un jugador con estados iniciales para iniciar el juego
  public Jugador crearJugador(String nombreJugador, Personaje personaje){
    ArrayList <IDado> dados = new ArrayList <IDado> ();
    dados.add(new DadoSimple());
    Jugador jugador = new Jugador(0, dados, nombreJugador,personaje);
    jugador.setPosicionActual(1);
    return jugador;
  }

  public String preguntarNombreJugador(){
    System.out.println("--------------Bienvenido al juego-------------------");
    System.out.println("¿cuál es tu nombre?");
    String nombre = sc.nextLine();
    return nombre;
  }
}
