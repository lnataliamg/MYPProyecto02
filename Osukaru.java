
public class Osukaru extends Personaje{
  public Osukaru(){
  }

  @Override
  public String getFrase(){
    return "¿Que le pasa? ¿Es estupido?";
  }

  @Override
  public String getEstadoAnimo(){
    return ":O";
  }

  @Override
  public Personaje clonar(){
    Osukaru objPersonaje = new Osukaru();
    objPersonaje.setNombre(this.getNombre());
    objPersonaje.setGorra(this.isGorra());
    objPersonaje.setMaquillaje(this.isMaquillaje());
    objPersonaje.setLentes(this.isLentes());
    return objPersonaje;
  }


}
