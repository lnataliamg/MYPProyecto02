import java.util.Random;
public class DadoSimple implements IDado{
  public int calcularNumero(){
    Random rand = new Random();
    return rand.nextInt((6-1)+1)+1;
  }
  public int tipoDado(){
    return 0;
  }
}
