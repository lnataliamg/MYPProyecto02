
public class Raymond extends Personaje{
  public Raymond(){
  }

  @Override
  public String getFrase(){
    return "Hay una serpiente en mi bota.";
  }

  @Override
  public String getEstadoAnimo(){
    return ":D";
  }

  @Override
  public Personaje clonar(){
    Raymond objPersonaje = new Raymond();
    objPersonaje.setNombre(this.getNombre());
    objPersonaje.setGorra(this.isGorra());
    objPersonaje.setMaquillaje(this.isMaquillaje());
    objPersonaje.setLentes(this.isLentes());
    return objPersonaje;
  }


}
