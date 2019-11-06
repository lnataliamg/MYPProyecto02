
public class Nataxa extends Personaje{
  public Nataxa(){
    System.out.println("creado exitosamente");
  }

  @Override
  public String getFrase(){
    return "Eres bueno, pero yo soy mejor.";
  }

  @Override
  public String getEstadoAnimo(){
    return "¬_¬";
  }

  @Override
  public Personaje clonar(){
    Nataxa objPersonaje = new Nataxa();
    objPersonaje.setNombre(this.getNombre());
    objPersonaje.setGorra(this.isGorra());
    objPersonaje.setMaquillaje(this.isMaquillaje());
    objPersonaje.setLentes(this.isLentes());
    System.out.println("éxito");
    return objPersonaje;
  }


}
