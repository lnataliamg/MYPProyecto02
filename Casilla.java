public class Casilla{
  private int numeroCasilla;
  private  boolean bonoOski;
  private  boolean bonoDado;
  private  boolean castigo;



	/**
	* Default empty Casilla constructor
	*/
	public Casilla() {
		super();
	}

	/**
	* Default Casilla constructor
	*/
	public Casilla(int numeroCasilla, boolean bonoOski, boolean bonoDado, boolean castigo) {
		super();
		this.numeroCasilla = numeroCasilla;
		this.bonoOski = bonoOski;
		this.bonoDado = bonoDado;
		this.castigo = castigo;
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
	* @param
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
