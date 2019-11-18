import java.util.Iterator;

public class IteratorMapaAgua implements Iterator{
  Casilla[] casillas;
  int posicion = 0;

  public IteratorMapaAgua(Casilla [] casillas){
    this.casillas = casillas;
  }

  @Override
  public Object next(){
    Casilla casillaRecorrida  = casillas[posicion];
    posicion++;
    return casillaRecorrida;
  }
  
  @Override
  public boolean hasNext(){
    if(posicion >= casillas.length || casillas[posicion] == null){
      return false;
    }else{
      return true;
    }

  }
}
