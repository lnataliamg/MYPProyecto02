import java.util.ArrayList;
import java.util.Random;
public class GestorMinijuegos{
  private ArrayList minijuegos;

	/**
	* Default GestorMinijuegos constructor
	*/
	public GestorMinijuegos() {
		minijuegos = new ArrayList<Minijuego>();
	}

	/**
	* Returns value of minijuegos
	* @return
	*/
	public ArrayList getMinijuegos() {
		return minijuegos;
	}

	/**
	* Sets new value of minijuegos
	* @param
	*/
	public void setMinijuegos(ArrayList minijuegos) {
		this.minijuegos = minijuegos;


	}

  public void addMinijuego(Minijuego minijuego){
    minijuegos.add(minijuego);
  }

  public Minijuego elegirMinijuego(){
    Random random = new Random();
    int cantidadMinijuegos = minijuegos.size()-1  ;
    int juegoAlAzar = random.nextInt( (cantidadMinijuegos-0) +1)+0;
    Minijuego minijuegoSeleccionado = (Minijuego) minijuegos.get(juegoAlAzar);
    return minijuegoSeleccionado;
  }
}
