import java.util.Iterator;
public interface IMapa{
  public Casilla [] getCasillasBonO(int n);
  public Casilla [] getCasillasBonD(int n);
  public Casilla [] getCasillasCast(int n);
  public Iterator createIterator();
  public void addCasilla(Casilla casilla);
  public Casilla getCasilla(int n);
}
