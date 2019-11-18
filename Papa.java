public class Papa extends CDecorator{
  private ObjC obj;

  public Papa (ObjC obj){
    this.obj = obj;
  }

  @Override
  public String description(){
    return obj.description() + ", Papa :B";
  }

  @Override
  public int value(){
    return obj.value() + 8;
  }
}
