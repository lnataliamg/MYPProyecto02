import java.util.ArrayList;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String [] args) {
        // TODO code application logic here
    System.out.println("Creamos los gestores");
    GestorPersonaje gp = new GestorPersonaje();
    System.out.println("Obtenemos a los persones originaeles");
    Personaje nataxa = gp.getPersonaje("Nataxa");
    System.out.println("-----------------------------------");
    System.out.println("Personaje 1  se llama " + nataxa.getNombre());
    nataxa.festejarTemplate();
    System.out.println("-----Creamos un clon de Nataxa----");
      Personaje nuevoPersonaje = gp.getClon("Nataxa");
      nuevoPersonaje.setNombre("hola");
      nuevoPersonaje.setNombre("sisi");
      nuevoPersonaje.setLentes(true);
      if(nuevoPersonaje.isLentes()){
        System.out.println("El nuevo personaje tiene lentes tiene lentes");
      }
      System.out.println("El nuevo personaje festeja como Nataxa");
      nuevoPersonaje.festejarTemplate();
      System.out.println("Vamos a crear un mapa de nieve");

    System.out.println("Obtenemos a los persones originaeles");
    Personaje osukaru = gp.getPersonaje("Osukaru");
    System.out.println("-----------------------------------");
    System.out.println("Personaje 2  se llama " + osukaru.getNombre());
    nataxa.festejarTemplate();
    System.out.println("-----Creamos un clon de Osukaru----");
      Personaje nuevoPersonaje2 = gp.getClon("Osukaru");
      nuevoPersonaje2.setNombre("Que hay");
      nuevoPersonaje2.setNombre("Joshi");
      nuevoPersonaje2.setLentes(true);
      if(nuevoPersonaje2.isLentes()){
        System.out.println("El nuevo personaje tiene lentes tiene lentes");
      }
      System.out.println("El nuevo personaje festeja como Osukaru");
      nuevoPersonaje2.festejarTemplate();
      System.out.println("Vamos a crear un mapa de nieve");

      CreadorMapa creador= new CreadorMapa();


      IMapa mapaFuego = creador.crearMapa(2);
      mapaFuego.addCasilla(new Casilla(1,false,0,false,0,false,0));
      mapaFuego.addCasilla(new Casilla(2,false,0,false,0,false,0));
      mapaFuego.addCasilla(new Casilla(3,false,0,true,2,false,0));
      mapaFuego.addCasilla(new Casilla(4,false,0,true,2,false,0));
      mapaFuego.addCasilla(new Casilla(5,false,0,false,0,true,1));
      mapaFuego.addCasilla(new Casilla(6,false,0,false,0,true,1));
      mapaFuego.addCasilla(new Casilla(7,true,1,false,0,false,0));

      mapaFuego.addCasilla(new Casilla(8,true,1,true,2,false,0));
      mapaFuego.addCasilla(new Casilla(9,true,1,true,2,false,0));
      mapaFuego.addCasilla(new Casilla(10,true,1,true,2,false,0));
      mapaFuego.addCasilla(new Casilla(11,true,1,true,2,false,0));
      Casilla[] casillasBonoO = new Casilla[1];
      Casilla[] casillasBonoD = new Casilla[2];
      Casilla[] casillasCastigo = new Casilla[2];
      casillasCastigo = mapaFuego.getCasillasCast(2);

      for(int i = 0; i<casillasCastigo.length; i++){
        System.out.println("esta es castigo" +casillasCastigo[i].toString());
      }

      IDado dadosimple = new DadoSimple();
      ArrayList<IDado> array = new ArrayList<IDado>();
      array.add(dadosimple);

      Jugador jugador = new Jugador(0, array, "Llo", nuevoPersonaje);
      jugador.setPosicionActual(1);
      jugador.setTurno(true);
      jugador.setState(new EnTurno());
      jugador.tirarDado();
      System.out.println(jugador.getAvanceActual());
      System.out.println(jugador.getPosicionActual());

      Jugador jugador2 = new Jugador(0, array, "Oski", nuevoPersonaje2);
      jugador2.setPosicionActual(1);
      jugador2.setTurno(true);
      jugador2.setState(new EnTurno());
      jugador2.tirarDado();
      System.out.println(jugador.getAvanceActual());
      System.out.println(jugador.getPosicionActual());
      jugador.mover(mapaFuego);
      System.out.println(jugador.getPosicionActual());
      jugador.recogerRecompensa(mapaFuego);
      System.out.println("\n"+jugador.getOskis() + " tiene esos oskis\n");


      GestorMinijuegos gestorMinijuegos = new GestorMinijuegos();
      Minijuego game = new PPoT(jugador, jugador2);
      gestorMinijuegos.addMinijuego(game);
      Minijuego elegido = gestorMinijuegos.elegirMinijuego();


      elegido.ejecutarJuego();
      System.out.println(""+jugador.getName()+" "+jugador.getOskis() + " tiene esos oskis\n");
      System.out.println(""+jugador2.getName()+" "+jugador2.getOskis() + " tiene esos oskis\n");
    }



}
