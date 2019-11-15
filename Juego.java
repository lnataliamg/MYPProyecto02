public class Juego{

  public void iniciarJuego(){
      System.out.println("RaDON!");
      InicializadorPersonaje inPersonaje = new InicializadorPersonaje();
      InicializadorJugador inJugador = new InicializadorJugador();
      InicializadorJuego inJuego = new InicializadorJuego();
      GeneradorMapa generadorMapa = new GeneradorMapa();

      String nombre1 = inJugador.preguntarNombreJugador();
      Personaje personaje1 = inPersonaje.crearPersonajeJugador();
      Jugador jugador1 = inJugador.crearJugador(nombre1, personaje1);
      jugador1.setTurno(true);
      //Jugador 2
      System.out.println("Bienvenido jugador 2");
      String nombre2 = inJugador.preguntarNombreJugador();
      Personaje personaje2 = inPersonaje.crearPersonajeJugador();
      Jugador jugador2 = inJugador.crearJugador(nombre2, personaje2);
      jugador2.setTurno(false);

      int tipoMapa = inJuego.obtenerTipoMapa();
      int cuantosTurnosSon = inJuego.elegirNumTurnos();
      IMapa mapa = generadorMapa.crearMapa(tipoMapa);

      int contadorRondas = 1;

      System.out.println("El juego comenzará. El jugador 1 siempre empieza");
      EnTurno enTurno = new EnTurno();
      jugador1.setState(enTurno);
      do {
        jugador1.setTurno(true);
        System.out.println(contadorRondas);
        jugador1.tirarDado(contadorRondas, jugador1);
        jugador1.mover(mapa);
        jugador1.recogerRecompensa(mapa);


        jugador2.setTurno(true);
        jugador2.tirarDado(contadorRondas, jugador2);
        jugador2.mover(mapa);
        jugador2.recogerRecompensa(mapa);
        contadorRondas++;
        System.out.println(contadorRondas);
      } while (contadorRondas < cuantosTurnosSon);

  }

  public static void main(String[] args) {
    Juego juego = new Juego();
    juego.iniciarJuego();
  }

}
