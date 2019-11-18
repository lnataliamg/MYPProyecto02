public class PanueloUsado extends CDecorator{
  private ObjC obj;

  public PanueloUsado (ObjC obj){
    this.obj = obj;
  }

  @Override
  public String description(){
    return obj.description() + ", Pañuelo Usado :)";
  }

  @Override
  public int value(){
    return obj.value() + 6;
  }
}
