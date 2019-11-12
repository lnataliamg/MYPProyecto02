public class Casilla{
  private int numeroCasilla;
  private  boolean bonoDado;
  private int typeDado; // tipo 1 dado simple tipo 2 dado 4 5 6 tipo 3 dado
  private  boolean bonoOski;
  private int numeroBonoOs;
  private  boolean castigo;
  private int numeroCastigo;

  /**
  * Default Casilla constructor
  */
  public Casilla(int numeroCasilla, boolean bonoOski, int numeroBonoOs, boolean bonoDado, int typeDado, boolean castigo, int numeroCastigo) {
    super();
    this.numeroCasilla = numeroCasilla;
    this.bonoOski = bonoOski;
    this.numeroBonoOs = numeroBonoOs;
    this.bonoDado = bonoDado;
    this.typeDado = typeDado;
    this.castigo = castigo;
    this.numeroCastigo = numeroCastigo;
  }


	/**
	* Default empty Casilla constructor
	*/
	public Casilla() {
    super();
  }

  public void setTypeDado(int typeDado){
    this.typeDado = typeDado;
  }

  public int getTypeDado(){
    return this.typeDado;
  }

  public void setNumeroBonosOskis(int numeroBonoOs){
    this.numeroBonoOs = numeroBonoOs;
  }

  public int getNumeroBonosOs(){
    return this.numeroBonoOs;
  }

  public void setNumeroCastigo(int numeroCastigo){
    this.numeroCastigo = numeroCastigo;
  }

  public int getTypeNumeroCastigo(){
    return this.numeroCastigo;
  }







	/**
	* Returns value of numeroCasilla
	* @return
	*/
	public int getNumeroCasilla() {
		return numeroCasilla;
	}

	/**
	* Sets new value of numeroCasilla
	* @param  casillasBuscadas[i] = casilla;
	*/
	public void setNumeroCasilla(int numeroCasilla) {
		this.numeroCasilla = numeroCasilla;
	}

	/**
	* Returns value of bonoOski
	* @return
	*/
	public boolean isBonoOski() {
		return bonoOski;
	}

	/**
	* Sets new value of bonoOski
	* @param
	*/
	public void setBonoOski(boolean bonoOski) {
		this.bonoOski = bonoOski;
	}

	/**
	* Returns value of bonoDado
	* @return
	*/
	public boolean isBonoDado() {
		return bonoDado;
	}

	/**
	* Sets new value of bonoDado
	* @param
	*/
	public void setBonoDado(boolean bonoDado) {
		this.bonoDado = bonoDado;
	}

	/**
	* Returns value of castigo
	* @return
	*/
	public boolean isCastigo() {
		return castigo;
	}

	/**
	* Sets new value of castigo
	* @param
	*/
	public void setCastigo(boolean castigo) {
		this.castigo = castigo;
	}



	/**
	* Create string representation of Casilla for printing
	* @return
	*/
	@Override
	public String toString() {
		return "Casilla [numeroCasilla=" + numeroCasilla + ", bonoOski=" + bonoOski + ", bonoDado=" + bonoDado + ", castigo=" + castigo + "]";
	}
}
