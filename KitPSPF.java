public class KitPSPF extends CDecorator{
  private ObjC obj;

  public KitPSPF (ObjC obj){
    this.obj = obj;
  }

  @Override
  public String description(){
    return obj.description() + ", Kit Planee Su Propia Fiesta B)";
  }

  @Override
  public int value(){
    return obj.value() + 16;
  }
}
