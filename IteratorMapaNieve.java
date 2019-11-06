import java.util.*;
import java.util.Iterator;
public class IteratorMapaNieve implements Iterator{
  ArrayList batch;
  int posición;
  public IteratorMapaNieve( ArrayList batch){
    this.batch = batch;
  }
  @Override
  public Object next(){
    Object object = batch.get(posición);
    posición++;
    return object;
  }
  @Override
  public boolean hasNext(){
    if(posición>= batch.size()){
      return false;
    }else{
      return true;
    }
  }
}
