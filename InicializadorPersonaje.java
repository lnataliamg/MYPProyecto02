import java.util.Scanner;
public class InicializadorPersonaje{
  Scanner s = new Scanner(System.in);
  GestorPersonaje gp = new GestorPersonaje();


	/**
	* Default empty InicializadorJugadores constructor
	*/
	public InicializadorPersonaje() {
		super();
	}

  public Personaje crearPersonajeJugador(){
    Personaje danyal = gp.getPersonaje("Danyal");
    Personaje raymond = gp.getPersonaje("Raymond");
    Personaje nataxa = gp.getPersonaje("Nataxa");
    Personaje osukaru = gp.getPersonaje("Osukaru");
    Personaje personajeCreado = null;
    System.out.println("------------------------Bienvenidos al juego-----------------------");
    System.out.println("----------elige tu personaje o puedes crear el tuyo----------------");
    System.out.println("-------------------------------------");
    System.out.println("|¿Quieres crear tu propio personaje?|");
    System.out.println("|-----------------------------------|");
    System.out.println("| 1. Sí                             |");
    System.out.println("| 2. No                             |");
    System.out.println("-------------------------------------");
    int opcionCrearPersonaje = s.nextInt();
    switch (opcionCrearPersonaje) {
      case 1:
        System.out.println("Debes elegir un personaje base para poder crear el tuyo. Después le puedes modificar lo que quieras");
        mostrarPersonajes();
        int opcionPersonaje = s.nextInt();

        switch (opcionPersonaje) {
          case 1:
          System.out.println("Elegiste a -Danyal-");
          personajeCreado = cambiarCaracteristicasPersonaje(danyal);
          return personajeCreado;
          case 2:
          System.out.println("Elegiste a -Raymond-");
          personajeCreado = cambiarCaracteristicasPersonaje(raymond);
          return personajeCreado;
          case 3:
          System.out.println("Elegiste a -Nataxa-");
          personajeCreado = cambiarCaracteristicasPersonaje(nataxa);
          return personajeCreado;
          case 4:
          System.out.println("Elegiste a -Osukaru-");
          personajeCreado = cambiarCaracteristicasPersonaje(osukaru);
          return personajeCreado;
        }
        break;

      case 2:
      mostrarPersonajes();
      System.out.println("Elige tu personaje");
      int elegirPersonaje = s.nextInt();

      switch (elegirPersonaje) {
        case 1:
        System.out.println("Elegiste a -Danyal-");
        return danyal;

        case 2:
        System.out.println("Elegiste a -Raymond-");

        return raymond;
        case 3:
        System.out.println("Elegiste a -Nataxa-");

        return osukaru;
        case 4:
        System.out.println("Elegiste a -Osukaru-");
        return nataxa;
      }
      break;
    }
    return null;

    }

    public void mostrarPersonajes(){
      System.out.println("Personajes");
      System.out.println("1. Danyal: ");
      System.out.println("    No tiene lentes");
      System.out.println("    No tiene gorra");
      System.out.println("    No tiene maquillaje");
      System.out.println("2. Raymond");
      System.out.println("    No tiene lentes");
      System.out.println("    No tiene gorra");
      System.out.println("    No tiene maquillaje");
      System.out.println("3. Nataxa");
      System.out.println("    No tiene lentes");
      System.out.println("    No tiene gorra");
      System.out.println("    No tiene maquillaje");
      System.out.println("4. Osukaru");
      System.out.println("    Sí tiene lentes");
      System.out.println("    No tiene gorra");
      System.out.println("    No tiene maquillaje");
    }


  public Personaje cambiarCaracteristicasPersonaje(Personaje personajeOriginal){
    Personaje personaje = gp.getClon(personajeOriginal.getNombre());
    System.out.println("Elige el nombre de tu nuevo presonaje");
    System.out.println("Nombre: ");
    s.nextLine();
    String nuevoNombre = s.nextLine();

    personaje.setNombre(nuevoNombre);
    System.out.println("Elige si tu personaje va a tener lentes");
    System.out.println("1. Sí");
    System.out.println("2. No");
    int tieneLentes = s.nextInt();
    if(tieneLentes == 1){
      personaje.setLentes(true);
    }else if(tieneLentes == 2){
      personaje.setLentes(false);
    }

    System.out.println("Elige si tu personaje va a tener maquillaje");
    System.out.println("1. Sí");
    System.out.println("2. No");
    int tieneMaquillaje = s.nextInt();
    if(tieneMaquillaje == 1){
      personaje.setMaquillaje(true);
    }else if(tieneMaquillaje == 2){
      personaje.setMaquillaje(false);
    }

    System.out.println("Elige si tu personaje va a tener gorra");
    System.out.println("1. Sí");
    System.out.println("2. No");
    int tieneGorra = s.nextInt();
    if(tieneGorra == 1){
      personaje.setGorra(true);
    }else if(tieneGorra == 2){
      personaje.setGorra(false);
    }
    return personaje;
  }
}
