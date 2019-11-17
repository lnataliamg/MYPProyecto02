import java.util.Iterator;

public class MapaAgua implements IMapa{
  private Casilla [] casillas;
  int numeroActual = 0;
  int numeroCasillas = 30;

  public MapaAgua(){
    casillas = new Casilla[numeroCasillas];
  }

  public void setNumeroCasillas(int numeroCasillas){
    this.numeroCasillas = numeroCasillas;
  }
  public void addCasilla(Casilla casilla){
    if(numeroActual >= numeroCasillas){
      System.out.println("Ya no se pueden agregar más casillas");
    }else{
      casillas[numeroActual] = casilla;
      numeroActual = numeroActual+1;
    }
  }

  public Iterator createIterator(){
    return new IteratorMapaAgua(this.casillas);
  }

  public Casilla getCasilla(int index){
    Casilla casillaBuscada = null;
    Iterator iterador = createIterator();
    int i = 1;
    while(iterador.hasNext()){
      Casilla casilla1 = (Casilla)iterador.next();
      if(index == i){
        casillaBuscada= casilla1;
      }
      i++;
    }
    return casillaBuscada;
  }


@Override
  public Casilla [] getCasillasBonO(int n){
    Casilla[] casillasBuscadas = new Casilla[n];
    Iterator iterador = createIterator();
    int i = 0;
    while(iterador.hasNext()){
      Casilla casilla = (Casilla)iterador.next();
      if(casilla.isBonoOski()){
        casillasBuscadas[i] = casilla;
        i++;
      }
    }
    return casillasBuscadas;
  }
@Override
  public Casilla [] getCasillasBonD(int n){
    Casilla[] casillasBuscadas = new Casilla[n];
    Iterator iterador = createIterator();
    int i = 0;
    while(iterador.hasNext()){
      Casilla casilla = (Casilla)iterador.next();
      if(casilla.isBonoDado()){
        casillasBuscadas[i] = casilla;
        i++;
      }
    }
    return casillasBuscadas;
  }
  @Override
  public Casilla [] getCasillasCast(int n){
    Casilla[] casillasBuscadas = new Casilla[n];
    Iterator iterador = createIterator();
    int i = 0;
    while(iterador.hasNext()){
      Casilla casilla = (Casilla)iterador.next();
      if(casilla.isCastigo()){
        casillasBuscadas[i] = casilla;
        i++;
      }
    }
    return casillasBuscadas;
  }
  public Casilla[] getCasillas(){
    return casillas;
  }

  public String toString(){
    String str = "";
    Iterator iterador = createIterator();
    while(iterador.hasNext()){
      Casilla casilla = (Casilla)iterador.next();
      str += "Casilla número" + casilla.getNumeroCasilla();
      str += "es bonoOski?" + casilla.isBonoOski();
      str += "es bonoDado?" + casilla.isBonoDado();
      str += "es castigo?" + casilla.isCastigo();
    }
    return str;
  }
}
