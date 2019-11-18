//clase que crea un mapa con una longitud especifica y sus casillas
public class GeneradorMapa{
  public GeneradorMapa(){}

  public IMapa crearMapa(int tipoMapa){
    CreadorMapa creador = new CreadorMapa();
    IMapa mapa = creador.crearMapa(tipoMapa);

    switch (tipoMapa) {

      case 1:

      mapa.addCasilla(new Casilla(1,true,5,false,0,false,0));
      mapa.addCasilla(new Casilla(2,false,0,false,0,false,0));
      mapa.addCasilla(new Casilla(3,false,0,true,2,false,0));
      mapa.addCasilla(new Casilla(4,false,0,true,2,false,0));
      mapa.addCasilla(new Casilla(5,false,0,true,3,false,0));
      mapa.addCasilla(new Casilla(6,false,0,false,0,true,1));
      mapa.addCasilla(new Casilla(7,true,1,false,0,true,5));
      mapa.addCasilla(new Casilla(8,false,0,false,0,false,0));
      mapa.addCasilla(new Casilla(9,false,0,true,2,false,0));
      mapa.addCasilla(new Casilla(10,true,5,false,0,false,0));
      mapa.addCasilla(new Casilla(11,false,0,false,0,true,10));
      mapa.addCasilla(new Casilla(12,false,0,false,0,false,0));
      mapa.addCasilla(new Casilla(13,false,0,false,0,false,0));
      mapa.addCasilla(new Casilla(14,true,10,false,0,false,0));
      mapa.addCasilla(new Casilla(15,false,0,false,0,true,6));
      break;

      case 2:
      mapa.addCasilla(new Casilla(1,true,5,false,0,false,0));
      mapa.addCasilla(new Casilla(2,true,5,false,0,false,0));
      mapa.addCasilla(new Casilla(3,false,0,true,2,false,0));
      mapa.addCasilla(new Casilla(4,false,0,false,0,false,0));
      mapa.addCasilla(new Casilla(5,false,0,true,3,false,0));
      mapa.addCasilla(new Casilla(6,false,0,false,0,true,5));
      mapa.addCasilla(new Casilla(7,true,6,false,0,false,0));
      mapa.addCasilla(new Casilla(8,false,0,false,0,false,0));
      mapa.addCasilla(new Casilla(9,false,0,true,2,false,0));
      mapa.addCasilla(new Casilla(10,true,5,false,0,false,0));
      mapa.addCasilla(new Casilla(11,true,5,false,0,false,0));
      mapa.addCasilla(new Casilla(12,false,0,false,0,true,10));
      mapa.addCasilla(new Casilla(13,false,0,false,0,false,0));
      mapa.addCasilla(new Casilla(14,true,10,false,0,false,0));
      mapa.addCasilla(new Casilla(15,false,0,false,0,false,0));
      mapa.addCasilla(new Casilla(16,true,5,false,0,false,0));
      mapa.addCasilla(new Casilla(17,true,5,false,0,false,0));
      mapa.addCasilla(new Casilla(18,false,0,false,0,false,0));
      mapa.addCasilla(new Casilla(19,false,0,false,0,false,20));
      mapa.addCasilla(new Casilla(20,true,10,false,0,false,0));
      break;
      case 3:
      mapa.addCasilla(new Casilla(1,true,5,false,0,false,0));
      mapa.addCasilla(new Casilla(2,true,5,false,0,false,0));
      mapa.addCasilla(new Casilla(3,false,0,true,2,false,0));
      mapa.addCasilla(new Casilla(4,false,0,false,0,false,0));
      mapa.addCasilla(new Casilla(5,false,0,true,3,false,0));
      mapa.addCasilla(new Casilla(6,false,0,false,0,true,5));
      mapa.addCasilla(new Casilla(7,true,6,false,0,false,0));
      mapa.addCasilla(new Casilla(8,false,0,false,0,false,0));
      mapa.addCasilla(new Casilla(9,false,0,true,2,false,0));
      mapa.addCasilla(new Casilla(10,true,5,false,0,false,0));
      mapa.addCasilla(new Casilla(11,true,5,false,0,false,0));
      mapa.addCasilla(new Casilla(12,false,0,false,0,true,10));
      mapa.addCasilla(new Casilla(13,false,0,false,0,false,0));
      mapa.addCasilla(new Casilla(14,true,10,false,0,false,0));
      mapa.addCasilla(new Casilla(15,false,0,false,0,false,0));
      mapa.addCasilla(new Casilla(16,true,5,false,0,false,0));
      mapa.addCasilla(new Casilla(17,true,5,false,0,false,0));
      mapa.addCasilla(new Casilla(18,false,0,false,0,false,0));
      mapa.addCasilla(new Casilla(19,false,0,false,0,false,20));
      mapa.addCasilla(new Casilla(20,true,10,false,0,false,0));
      mapa.addCasilla(new Casilla(21,true,5,false,0,false,0));
      mapa.addCasilla(new Casilla(22,false,0,false,0,false,0));
      mapa.addCasilla(new Casilla(23,false,0,true,2,false,0));
      mapa.addCasilla(new Casilla(24,false,0,true,2,false,0));
      mapa.addCasilla(new Casilla(25,false,0,true,3,false,0));
      mapa.addCasilla(new Casilla(26,false,0,false,0,true,1));
      mapa.addCasilla(new Casilla(27,true,1,false,0,true,5));
      mapa.addCasilla(new Casilla(28,false,0,false,0,false,0));
      mapa.addCasilla(new Casilla(29,true,15,false,0,false,0));
      mapa.addCasilla(new Casilla(30,true,15,false,0,false,0));
      break;

    }

    return mapa;
  }
}
