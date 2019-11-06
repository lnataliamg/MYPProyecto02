
public abstract class Personaje implements Cloneable{
  protected boolean gorra;
  protected boolean lentes;
  protected boolean maquillaje;
  protected String nombre;


	/**
	* Returns value of gorra
	* @return
	*/
	public boolean isGorra() {
		return gorra;
	}

	/**
	* Sets new value of gorra
	* @param
	*/
	public void setGorra(boolean gorra) {
		this.gorra = gorra;
	}

	/**
	* Returns value of lentes
	* @return
	*/
	public boolean isLentes() {
		return lentes;
	}

	/**
	* Sets new value of lentes
	* @param
	*/
	public void setLentes(boolean lentes) {
		this.lentes = lentes;
	}

	/**
	* Returns value of maquillaje
	* @return
	*/
	public boolean isMaquillaje() {
		return maquillaje;
	}

	/**
	* Sets new value of maquillaje
	* @param
	*/
	public void setMaquillaje(boolean maquillaje) {
		this.maquillaje = maquillaje;
	}

	/**
	* Sets new value of nombre
	* @param
	*/
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

  public String getNombre(){
    return nombre;
  }

  public Personaje clonar() throws CloneNotSupportedException{
    System.out.println("éxito");
    return (Personaje) this.clone();
  }

  public void festejarTemplate(){
    System.out.println(getNombre());
    System.out.println(getFrase());
    System.out.println(getEstadoAnimo());
  }
  public abstract String getFrase();
  public abstract String getEstadoAnimo();
}
