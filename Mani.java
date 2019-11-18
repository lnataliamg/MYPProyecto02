public class Mani extends CDecorator{
  private ObjC obj;

  public Mani (ObjC obj){
    this.obj = obj;
  }

  @Override
  public String description(){
    return obj.description() + ", Mani :V";
  }

  @Override
  public int value(){
    return obj.value() + 4;
  }
}
