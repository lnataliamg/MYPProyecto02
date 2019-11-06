public class CreadorMapa extends InicializadorMapa{
  public CreadorMapa(){}

  public IMapa crearMapa(int tipo){
    IMapa mapa = null;
    switch (tipo) {
      case nieve:
        mapa = new MapaNieve();
        break;
    }
    return mapa;
  }
}
