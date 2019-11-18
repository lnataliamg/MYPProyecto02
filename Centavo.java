public class Centavo extends CDecorator{
  private ObjC obj;

  public Centavo (ObjC obj){
    this.obj = obj;
  }

  @Override
  public String description(){
    return obj.description() + ", Centavo }:{)";
  }

  @Override
  public int value(){
    return obj.value() + 9;
  }
}
