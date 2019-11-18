import java.util.Hashtable;
public class GestorPersonaje{
  private Hashtable hPersonajes = new Hashtable();

  public GestorPersonaje(){
    Personaje nataxa = new Nataxa();
    nataxa.setNombre("Nataxa");
    nataxa.setMaquillaje(false);
    nataxa.setGorra(false);
    nataxa.setLentes(false);
    this.addPersonaje(nataxa.getNombre(), nataxa);

    Personaje osukaru = new Osukaru();
    osukaru.setNombre("Osukaru");
    osukaru.setMaquillaje(false);
    osukaru.setGorra(false);
    osukaru.setLentes(true);
    this.addPersonaje(osukaru.getNombre(), osukaru);

    Personaje raymond = new Raymond();
    raymond.setNombre("Raymond");
    raymond.setMaquillaje(false);
    raymond.setGorra(false);
    raymond.setLentes(false);
    this.addPersonaje(raymond.getNombre(), raymond);

    Personaje danyal = new Danyal();
    danyal.setNombre("Danyal");
    danyal.setMaquillaje(false);
    danyal.setGorra(false);
    danyal.setLentes(false);
    this.addPersonaje(danyal.getNombre(), danyal);

  }

  public void addPersonaje(String nombre, Personaje objPersonaje){
    this.hPersonajes.put(nombre, objPersonaje);
  }

  public Personaje  getPersonaje(String nombre){
    Personaje objPersonaje = (Personaje) hPersonajes.get(nombre);
    return objPersonaje;
  }

  public Personaje getClon(String nombre){
    Personaje objPersonaje = null;
    if(nombre.equals("Nataxa")){
      objPersonaje = (Nataxa) hPersonajes.get(nombre);
    }else if(nombre.equals("Danyal")){
      objPersonaje = (Danyal) hPersonajes.get(nombre);
    }else if(nombre.equals("Osukaru")){
      objPersonaje = (Osukaru) hPersonajes.get(nombre);
    }else if(nombre.equals("Raymond")){
      objPersonaje = (Raymond) hPersonajes.get(nombre);
    }
    try {
      return (Personaje)(objPersonaje.clonar());
    }catch (CloneNotSupportedException e) {
      System.out.println("No se pudo clonar el personaje");
      return null;
    }
  }
}
