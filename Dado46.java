import java.util.Random;
public class Dado46 implements IDado{
  public int calcularNumero(){
    Random rand = new Random();
    return rand.nextInt((6-4)+1)+4;
  }
  public int tipoDado(){
    return 0;
  }



}
