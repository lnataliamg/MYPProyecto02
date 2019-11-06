
public class Danyal extends Personaje{
  public Danyal(){}

  @Override
  public String getFrase(){
    return "Bazinga.";
  }

  @Override
  public String getEstadoAnimo(){
    return "xD";
  }

  @Override
  public Personaje clonar(){
    Danyal objPersonaje = new Danyal();
    objPersonaje.setNombre(this.getNombre());
    objPersonaje.setGorra(this.isGorra());
    objPersonaje.setMaquillaje(this.isMaquillaje());
    objPersonaje.setLentes(this.isLentes());
    return objPersonaje;
  }


}
