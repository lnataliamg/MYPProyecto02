public class Kangreburguer extends CDecorator{
  private ObjC obj;

  public Kangreburguer (ObjC obj){
    this.obj = obj;
  }

  @Override
  public String description(){
    return obj.description() + ", Kangreburguer 7.7";
  }

  @Override
  public int value(){
    return obj.value() + 12;
  }
}
