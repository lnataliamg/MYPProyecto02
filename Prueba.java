public class Prueba{
  public static void main(String[] args) {
    System.out.println("Creamos los gestores");
    GestorPersonaje gp = new GestorPersonaje();
    System.out.println("Obtenemos a los persones originaeles");
    Personaje nataxa = gp.getPersonaje("Nataxa");
    System.out.println("-----------------------------------");
    System.out.println("Personaje 1  se llama" + nataxa.getNombre());
    nataxa.festejarTemplate();
    System.out.println("-----Creamos un clon de Nataxa----");
      Personaje nuevoPersonaje = gp.getClon("Nataxa");
      nuevoPersonaje.setNombre("hola");
      nuevoPersonaje.setNombre("sisi");
      nuevoPersonaje.setLentes(true);
      if(nuevoPersonaje.isLentes()){
        System.out.println("tiene lentes");
      }
      nuevoPersonaje.festejarTemplate();
      System.out.println("Vamos a crear un mapa de nieve");
      CreadorMapa creador= new CreadorMapa();
      IMapa mapaNieve = creador.crearMapa(1);
      mapaNieve.addCasilla(new Casilla(1,false,true,false));
      mapaNieve.addCasilla(new Casilla(2,false,false,false));
      mapaNieve.addCasilla(new Casilla(3,false,false,false));
      mapaNieve.addCasilla(new Casilla(4,false,true,false));
      System.out.println(mapaNieve.toString());

      IMapa mapaFuego = creador.crearMapa(2);
      mapaFuego.addCasilla(new Casilla(1,false,false,false));
      mapaFuego.addCasilla(new Casilla(2,false,false,false));
      mapaFuego.addCasilla(new Casilla(3,false,true,false));
      mapaFuego.addCasilla(new Casilla(4,false,true,false));
      mapaFuego.addCasilla(new Casilla(5,false,false,true));
      mapaFuego.addCasilla(new Casilla(6,false,false,true));
      mapaFuego.addCasilla(new Casilla(7,true,false,false));
      mapaFuego.addCasilla(new Casilla(8,true,true,false));
      Casilla[] casillasBonoO = new Casilla[1];
      System.out.println("si crea esto");
      Casilla[] casillasBonoD = new Casilla[2];
        System.out.println("si crea esto");
      Casilla[] casillasCastigo = new Casilla[2];
        System.out.println("si crea esto");
      casillasBonoO = mapaFuego.getCasillasBonO(1);
        System.out.println("si crea estsssso");
      for(int i = 0; i<casillasBonoO.length; i++){
        System.out.println("esta es bnoOO" +casillasBonoO[i].toString());
      }


      CalculadoraDado calculadoraDado = new CalculadoraDado(new DadoSimple());
      System.out.println(calculadoraDado.calcularDado());
      calculadoraDado = new CalculadoraDado(new Dado68());
      System.out.println(calculadoraDado.calcularDado());
      calculadoraDado = new CalculadoraDado(new Dado46());
      System.out.println(calculadoraDado.calcularDado());

  }


}
