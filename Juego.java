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
      System.out.println("eñ nombre del jug1 " + personaje2.getNombre() + "...");

      System.out.println("eñ nombre del jug222222 " + personaje2.getNombre()+ "...");


      int tipoMapa = inJuego.obtenerTipoMapa();
      int cuantosTurnosSon = inJuego.elegirNumTurnos();
        switch (cuantosTurnosSon) {
          case 1:
            cuantosTurnosSon = 5;
          break;
          case 2:
            cuantosTurnosSon = 10;
          break;
          case 3:
            cuantosTurnosSon = 15;
          break;
        }

      IMapa mapa = generadorMapa.crearMapa(tipoMapa);

      int contadorRondas = 1;

      System.out.println("El juego comenzará. El jugador 1 siempre empieza");
      EnTurno enTurno = new EnTurno();
      jugador1.setState(enTurno);
      jugador2.setState(enTurno);
      do {
        System.out.println("-------------------Comenzamos la ronda"+ contadorRondas+ "---------------------");
        System.out.println("------------..-Es turno del jugador 1--..------------");
        jugador1.setTurno(true);
        jugador1.tirarDado(jugador1);
        System.out.println("El juagdor1 va a avanzar " + jugador1.getAvanceActual());
        jugador1.mover(mapa);
        System.out.println("El jugador1 después de tirar está en la casilla " + jugador1.getPosicionActual());
        //sí avanza
        int m = jugador1.getOskis();
        jugador1.recogerRecompensa(mapa);
        if (m == jugador1.getOskis()) {
          System.out.println("El numero de oskis del jugador2 son "+jugador1.getOskis());
        }else{
          System.out.println("El numero de oskis del jugador2 paso de "+m+" a "+jugador1.getOskis());
        }
        System.out.println("Ahora el jugador1 tiene los siguentes dados:");

        for(int i = 0; i<jugador1.getDados().size();i++){
          System.out.println(jugador1.getDados().toString());
        }

        jugador1.setTurno(false);
        System.out.println("-----------Turno jugador 2-------------------");
        jugador2.setTurno(true);

        jugador2.tirarDado(jugador2);
        System.out.println("El jugador2 esta en " + jugador2.getPosicionActual());
        System.out.println("El juagdor2 va a avanzar " + jugador2.getAvanceActual());
        jugador2.mover(mapa);
        System.out.println("El jugador2 avanzó hasta la casilla" + jugador2.getPosicionActual());
        int n = jugador2.getOskis();
        jugador2.recogerRecompensa(mapa);

        if (n == jugador2.getOskis()) {
          System.out.println("El numero de oskis del jugador2 son "+jugador2.getOskis());
        }else{
          System.out.println("El numero de oskis del jugador2 paso de "+n+" a "+jugador2.getOskis());
        }
        System.out.println("Ahora el jugador2 tiene los siguentes dados:");
         jugador1.getDados();

        for(int i = 0; i<jugador1.getDados().size();i++){
          System.out.println(jugador1.getDados().toString());
        }
        jugador1.jugarMinijuego(contadorRondas, jugador2);
        jugador1.jugarMinijuego(contadorRondas, jugador2);

        contadorRondas++;
      } while (contadorRondas < cuantosTurnosSon+1);

      try{ 
        Thread.sleep(5000); 
      }catch(InterruptedException e) { 
        System.out.println("Thread Interrupted"); 
      }

      System.out.println("El juego finalizó :DDDDDDDDDDDDD");
      System.out.println("El ganador es: ");
      Jugador ganador = inJuego.elegirGanador(jugador1, jugador2);
      System.out.println("Felicidades, " + ganador.getName() + " has ganado la partida");
      ganador.festejar();
  }

  public static void main(String[] args) {
    Juego juego = new Juego();
    juego.iniciarJuego();
  }

}
