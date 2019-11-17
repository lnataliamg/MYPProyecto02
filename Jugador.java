import java.util.Iterator;
import java.util.ArrayList;
public class Jugador{
  private int oskis;
  private ArrayList dados;
  private String name;
  private Personaje personaje;
  private int posicionActual;
  private boolean esSuTurno;
  private int avanceActual;

  State state;
  State enTurno;
  State moviendose;
  State llegandoCasilla;
  State jugando;
	/**
	* Default empty Jugador constructor
	*/
	public Jugador() {
		super();
	}

	/**
	* Default Jugador constructor
	*/
	public Jugador(int oskis, ArrayList dados, String name, Personaje personaje) {
		super();
		this.oskis = oskis;
		this.dados = dados;
		this.name = name;
		this.personaje = personaje;
    this.enTurno = new EnTurno();
    this.moviendose = new Moviendose();
    this.llegandoCasilla = new LlegandoCasilla();
    this.jugando = new Jugando();
	}

  public void addDado(int tipoDado){
    IDado dadoNuevo = null;
    switch (tipoDado) {
      case 2:
        dados.add(new Dado46());
      break;
      case 3:
        dados.add(new Dado68());
      break;
    }
  }

  public void setAvanceActual(int avanceActual){
    this.avanceActual = avanceActual;
  }

  public int getAvanceActual(){
    return this.avanceActual;
  }


  public void setTurno(boolean turno){
    this.esSuTurno = turno;
  }

  public boolean getTurno(){
    return this.esSuTurno;
  }
  public void setPosicionActual(int n){
    this.posicionActual = n;
  }

  public int getPosicionActual(){
    return this.posicionActual;
  }
	/**
	* Returns value of oskis
	* @return
	*/
	public int getOskis() {
		return oskis;
	}

	/**
	* Sets new value of oskis
	* @param
	*/
	public void setOskis(int oskis) {
		this.oskis = oskis;
	}

	/**
	* Returns value of dados
	* @return
	*/
	public ArrayList getDados() {
		return dados;
	}

	/**
	* Sets new value of dados
	* @param
	*/
	public void setDados(ArrayList dados) {
		this.dados = dados;
	}

	/**
	* Returns value of name
	* @return
	*/
	public String getName() {
		return name;
	}

	/**
	* Sets new value of name
	* @param
	*/
	public void setName(String name) {
		this.name = name;
	}

	/**
	* Returns value of Personaje
	* @return
	*/
	public Personaje getPersonaje() {
		return personaje;
	}

	/**
	* Sets new value of Personaje
	* @param
	*/
	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

    public int tirarDado(int tipoDado){
      CalculadoraDado calculadoraDado = null;
      int numCasillas = 0;
      switch(tipoDado){
        case 1:
          calculadoraDado = new CalculadoraDado(new DadoSimple());
          numCasillas = calculadoraDado.calcularDado();
          break;
        case 2:
          calculadoraDado = new CalculadoraDado(new Dado46());
          numCasillas = calculadoraDado.calcularDado();
          break;
        case 3:
          calculadoraDado = new CalculadoraDado(new Dado68());
          numCasillas = calculadoraDado.calcularDado();
          break;
      }

      return numCasillas;
    }

    public void mover(IMapa mapa, int n){
      Iterator iterator = mapa.createIterator();
      boolean isCasillaActual = false;
      while(iterator.hasNext()){
        int i = 0;
        Casilla casilla = (Casilla)iterator.next();
        if(this.getPosicionActual() == casilla.getNumeroCasilla()){
          int tempPosicionActual = this.getPosicionActual();
          do {
            if(iterator.hasNext()){
              tempPosicionActual++;
              this.setPosicionActual(tempPosicionActual);
              casilla = (Casilla)iterator.next();
            }else if(!iterator.hasNext()){
              iterator = mapa.createIterator();
              this.setPosicionActual(1);
              tempPosicionActual =1 ;
              casilla = (Casilla)iterator.next();
            }
            i++;
          } while (i<n);
          break;
        }
      }
    }

    public void festejar(){
      personaje.festejarTemplate();
    }

    public void tirarDado(Jugador jugador){
      state.tirarDado(this);
    }

    public void jugarMinijuego(int n, Jugador jugador2){
      state.jugarMinijuego( n, this, jugador2);
    }

    public void mover(IMapa mapa){
      state.mover(mapa, this);
    }

    public void recogerRecompensa(IMapa mapa){
      state.recogerRecompensa(mapa, this);
    }

    public State getEnTurno(){
      return enTurno;
    }

    public State getJugando(){
      return jugando;
    }

    public State getLlegandoCasilla(){
      return llegandoCasilla;
    }

    public State getMoviendose(){
      return moviendose;
    }

    public void setState(State state){
      this.state = state;
    }

}
