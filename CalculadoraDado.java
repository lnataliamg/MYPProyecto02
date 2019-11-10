public class CalculadoraDado{
  private IDado strategy;
  public CalculadoraDado(IDado strategy){
    this.strategy = strategy;
  }

  public int calcularDado(){
    return strategy.calcularNumero();
  }

}
