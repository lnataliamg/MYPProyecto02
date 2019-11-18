import java.util.Random;
public class Dado68 implements IDado{
  public int calcularNumero(){
    Random rand = new Random();
    return rand.nextInt((8-6)+1)+6;
  }
  public int tipoDado(){
    return 3;
  }


}
