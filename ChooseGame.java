import java.util.ArrayList;
import java.util.Scanner;

public class ChooseGame extends Minijuego{

  protected ObjC op1;
  protected ObjC op2;

  protected Boolean flag;
  
  protected int i;
  
    public ChooseGame(Jugador jugador1, Jugador jugador2){
        super(jugador1, jugador2);
        this.op1 = new Canasta();
        this.op2 = new Canasta();

        this.flag = false;
    }

  public void oneChoise(){
    ArrayList<Integer> opciones = new ArrayList<Integer>();
    for(int i = 0; i < 3; i++){
      int rand = (int) (Math.random()*6);
      switch(rand){
        case 1:
            System.out.println("1.- Centavo");
            opciones.add(1);
        break;
        case 2:
          System.out.println("2.- Papa");
          opciones.add(2);
        break;
        case 3:
          System.out.println("3.- Pañuelo usado");
          opciones.add(3);
        break;
        case 4:
          System.out.println("4.- Kangreburguer");
          opciones.add(4);
        break;
        case 5:
          System.out.println("5.- KitPlanea su Propia Fiesta :V");
          opciones.add(5);
        break;
        default:
          System.out.println("6.- Mani");
          opciones.add(6);
        break;
      }
    }
    Scanner sc = new Scanner(System.in);
    Boolean f = false;

    while(!f){
      try{
        int election = sc.nextInt();
        if(opciones.contains(election)){
          ObjC aux = new Canasta();

          if (flag == false){
            switch(election){
              case 1:
                  //System.out.println("1.- Centavo");
                  aux = new Centavo(this.op1);
              break;
              case 2:
                //System.out.println("2.- Papa");
                aux = new Papa(this.op1);
              break;
              case 3:
                //System.out.println("3.- Pañuelo usado");
                aux = new PanueloUsado(this.op1);
              break;
              case 4:
                //System.out.println("4.- Kangreburguer");
                aux = new Kangreburguer(this.op1);
              break;
              case 5:
                //System.out.println("5.- KitPlanea su Propia Fiesta :V");
                aux = new KitPSPF(this.op1);
              break;
              default:
                //System.out.println("6.- Mani");
                aux = new Mani(this.op1);
              break;
            }
            this.op1 = aux;
          }else{
            switch(election){
              case 1:
                  //System.out.println("1.- Centavo");
                  aux = new Centavo(this.op2);
              break;
              case 2:
                //System.out.println("2.- Papa");
                aux = new Papa(this.op2);
              break;
              case 3:
                //System.out.println("3.- Pañuelo usado");
                aux = new PanueloUsado(this.op2);
              break;
              case 4:
                //System.out.println("4.- Kangreburguer");
                aux = new Kangreburguer(this.op2);
              break;
              case 5:
                //System.out.println("5.- KitPlanea su Propia Fiesta :V");
                aux = new KitPSPF(this.op2);
              break;
              default:
                //System.out.println("6.- Mani");
                aux = new Mani(this.op2);
              break;
            }
            this.op2 = aux;
          }
          f = true;
          this.flag = !(this.flag);
        }

      }catch(Exception e){

      }
    }
  }

  public void winner(){
    System.out.println("SCORES...");
    System.out.println(jugador1.getName()+": " + op1.value()+" "+op1.description());
    System.out.println(jugador2.getName()+": " + op2.value()+" "+op2.description()+"\n");
      
    if(op1.value() > op2.value()){
      System.out.println(jugador1.getName() + " WIN");
      jugador1.setOskis(jugador1.getOskis()+5);
      System.out.println(""+jugador1.getName()+" "+jugador1.getOskis() + " tiene esos oskis\n");
      System.out.println(""+jugador2.getName()+" "+jugador2.getOskis() + " tiene esos oskis\n");

    }else{
      System.out.println(jugador2.getName() + " WIN");
      jugador2.setOskis(jugador2.getOskis()+5);
      System.out.println(""+jugador1.getName()+" "+jugador1.getOskis() + " tiene esos oskis\n");
      System.out.println(""+jugador2.getName()+" "+jugador2.getOskis() + " tiene esos oskis\n");
    }
  }

    @Override
    public void ejecutarJuego() {
        System.out.println("Juego a 3 rondas");
        while(i < 3){
            System.out.println("Turno " + jugador1.getName());
            oneChoise();
            System.out.println("Turno " + jugador2.getName());
            oneChoise();
            i++;
        }
        winner();
    }

    @Override
    public String getNombreJuego() {
        return "Canasta";
    }


}
