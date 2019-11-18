import java.awt.Color;
import java.util.Iterator;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Jugador{
  private int oskis;
  private ArrayList dados;
  private String name;
  private Personaje personaje;
  private int posicionActual;
  private boolean esSuTurno;
  private int avanceActual;

  State state;
  State enTurno;
  State moviendose;
  State llegandoCasilla;
  State jugando;
  
    private final Object tiempo = new Object();
    private JFrame frame;
    private JPanel panel;
    private JLabel titulo;
    private JButton aceptar;
    
    private JLabel Oscar;
    private JLabel Daniel;
    private JLabel Natalia;
    private JLabel Ramon;
    
    private JLabel lentes;
    private JLabel gorra;
    private JLabel maquillaje;
    private JButton tDado;
    private JLabel dado;
    private JLabel dado46;
    private JLabel dado68;
    private JFrame frameWin;
    private JLabel labelWin;
    private JButton botonOk;
	/**
	* Default empty Jugador constructor
	*/
	public Jugador() {
		super();
	}

	/**
	* Default Jugador constructor
            * @param oskis
            * @param dados
            * @param name
            * @param personaje
	*/
	public Jugador(int oskis, ArrayList dados, String name, Personaje personaje) {
		super();
		this.oskis = oskis;
		this.dados = dados;
		this.name = name;
		this.personaje = personaje;
                this.enTurno = new EnTurno();
                this.moviendose = new Moviendose();
                this.llegandoCasilla = new LlegandoCasilla();
                this.jugando = new Jugando();
	}

  public void addDado(int tipoDado){
    IDado dadoNuevo = null;
    switch (tipoDado) {
      case 2:
        dados.add(new Dado46());
      break;
      case 3:
        dados.add(new Dado68());
      break;
    }
  }

  public void setAvanceActual(int avanceActual){
    this.avanceActual = avanceActual;
  }

  public int getAvanceActual(){
    return this.avanceActual;
  }


  public void setTurno(boolean turno){
    this.esSuTurno = turno;
  }

  public boolean getTurno(){
    return this.esSuTurno;
  }
  public void setPosicionActual(int n){
    this.posicionActual = n;
  }

  public int getPosicionActual(){
    return this.posicionActual;
  }
	/**
	* Returns value of oskis
	* @return
	*/
	public int getOskis() {
		return oskis;
	}

	/**
	* Sets new value of oskis
        * @param oskis
	*/
	public void setOskis(int oskis) {
		this.oskis = oskis;
	}

	/**
	* Returns value of dados
	* @return
	*/
	public ArrayList getDados() {
		return dados;
	}

	/**
	* Sets new value of dados
        * @param dados
	*/
	public void setDados(ArrayList dados) {
		this.dados = dados;
	}

	/**
	* Returns value of name
	* @return
	*/
	public String getName() {
		return name;
	}

	/**
	* Sets new value of name
	* @param
	*/
	public void setName(String name) {
		this.name = name;
	}

	/**
	* Returns value of Personaje
	* @return
	*/
	public Personaje getPersonaje() {
		return personaje;
	}

	/**
	* Sets new value of Personaje
	* @param
	*/
	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

    public int tirarDado(int tipoDado, int a){
      CalculadoraDado calculadoraDado = null;
      int numCasillas = 0;
      switch(tipoDado){
        case 1:
          calculadoraDado = new CalculadoraDado(new DadoSimple());
          numCasillas = calculadoraDado.calcularDado();
          mostrarDado(a);
          break;
        case 2:
          calculadoraDado = new CalculadoraDado(new Dado46());
          numCasillas = calculadoraDado.calcularDado();
          mostrarDado(a);
          break;
        case 3:
          calculadoraDado = new CalculadoraDado(new Dado68());
          numCasillas = calculadoraDado.calcularDado();
          mostrarDado(a);
          break;
      }

      return numCasillas;
    }
    
    public void mostrarDado(int tipoDado){
        try {
            
            frame = new JFrame("Tirando Dado"); //Se crea Ventana con titulo "Minijuego"
            
            switch(tipoDado){
            case 1:
                titulo = new JLabel("Dado");
                frame.setSize(300, 350); //Tamaño venta na x,y
                System.out.println("DadoSimple "+tipoDado);
            break;
            case 2:
                titulo = new JLabel("Dado 4 - 6");
                frame.setSize(550, 530); //Tamaño venta na x,y
            break;
            case 3:
                titulo = new JLabel("Dado 6 - 8");
                frame.setSize(420, 490); //Tamaño venta na x,y
            break;
            default:
                System.out.println("Dado incorecto: Error");
            break;
        }

        

        
        frame.setLocationRelativeTo(null); //Posicion siempre en el centro
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cerrar alterminar de ejecutar
        //frame.setResizable(false);
        frame.setLayout(null); // poner que aparezcan todos los tipos de canvas
      
        dado = new JLabel();
        dado46 = new JLabel();
        dado68 = new JLabel();
      
        ImageIcon DS = new ImageIcon("dado.gif");
        ImageIcon D46 = new ImageIcon("dado46.gif");
        ImageIcon D68 = new ImageIcon("dado68.gif");
        
        dado.setBounds(35, 60, 227, 218);
        dado.setIcon(DS);
        
        dado46.setBounds(25, 60, 500, 390);
        dado46.setIcon(D46);
        
        dado68.setBounds(20, 60, 339, 339);
        dado68.setIcon(D68);
        
        titulo.setBounds(105,15,400,50);
        titulo.setFont(new Font("ComicSans",Font.BOLD,18));
      
        tDado = new JButton("Tirar Dado");
        
        tDado.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                frame.setVisible(false);
                frame.dispose();
                
                synchronized (tiempo) {
                  tiempo.notify();
                }
                
            }
          
        });
        
        switch(tipoDado){
            case 1:
                tDado.setBounds(90,278,120,30);
                frame.add(dado);
                System.out.println("Tu dado es Simple");
            break;
            case 2:
                tDado.setBounds(190,450,120,30);
                frame.add(dado46);
                System.out.println("Tu dado es Super46");
            break;
            case 3:
                tDado.setBounds(90,410,120,30);
                frame.add(dado68);
                System.out.println("Tu dado es Ultra68");
            break;
            default:
                System.out.println("Dado incorecto: Error");
            break;
        }
        
        frame.add(titulo);
        frame.add(tDado);
      
        frame.setVisible(true); // Hace visible la ventana

        synchronized (tiempo) {
            tiempo.wait();
        }

        } catch (InterruptedException e) {
                e.printStackTrace();
        }
    }

    public void mover(IMapa mapa, int n){
      Iterator iterator = mapa.createIterator();
      boolean isCasillaActual = false;
      while(iterator.hasNext()){
        int i = 0;
        Casilla casilla = (Casilla)iterator.next();
        if(this.getPosicionActual() == casilla.getNumeroCasilla()){
          int tempPosicionActual = this.getPosicionActual();
          do {
            if(iterator.hasNext()){
              tempPosicionActual++;
              this.setPosicionActual(tempPosicionActual);
              casilla = (Casilla)iterator.next();
            }else if(!iterator.hasNext()){
              iterator = mapa.createIterator();
              this.setPosicionActual(1);
              tempPosicionActual =1 ;
              casilla = (Casilla)iterator.next();
            }
            i++;
          } while (i<n);
          break;
        }
      }
    }

    public void festejar(){
      personaje.festejarTemplate();
    }

    public void tirarDado(Jugador jugador){
      state.tirarDado(this);
    }

    public void jugarMinijuego(int n, Jugador jugador2){
      state.jugarMinijuego( n, this, jugador2);
    }

    public void mover(IMapa mapa){
      state.mover(mapa, this);
    }

    public void recogerRecompensa(IMapa mapa){
      state.recogerRecompensa(mapa, this);
    }

    public State getEnTurno(){
      return enTurno;
    }

    public State getJugando(){
      return jugando;
    }

    public State getLlegandoCasilla(){
      return llegandoCasilla;
    }

    public State getMoviendose(){
      return moviendose;
    }

    public void setState(State state){
      this.state = state;
    }    
    
    public void mostrarPersonaje(Personaje p){
        
        try {
        
        frame = new JFrame("Jugador: "+getName()); //Se crea Ventana con titulo "Minijuego"
      
        frame.setSize(300, 300); //Tamaño venta na x,y
        frame.setLocationRelativeTo(null); //Posicion siempre en el centro
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cerrar alterminar de ejecutar
        frame.setResizable(false);
        frame.setLayout(null); // poner que aparezcan todos los tipos de canvas
      
        titulo = new JLabel("Personaje: "+p.getNombre());
      
        titulo.setBounds(60,5,400,50);
        titulo.setFont(new Font("ComicSans",Font.BOLD,18));
      
        aceptar = new JButton("Aceptar");
        
        aceptar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                frame.setVisible(false);
                frame.dispose();
                
                synchronized (tiempo) {
                    tiempo.notify();
                }
            }
          
        });
        aceptar.setBounds(90,230,120,30);
        
        // Daniel
        Daniel = new JLabel();
        Daniel.setBounds(50,40,200,200);
        ImageIcon Dan = new ImageIcon("Dany.png");
        Daniel.setIcon(Dan);
        
        // Daniel
        Natalia = new JLabel();
        Natalia.setBounds(50,40,200,200);
        ImageIcon Nat = new ImageIcon("Nati.png");
        Natalia.setIcon(Nat);
        
        // Ramon
        Ramon = new JLabel();
        Ramon.setBounds(50,40,200,200);
        ImageIcon Ram = new ImageIcon("Ramon.png");
        Ramon.setIcon(Ram);
        
        // Oscar
        Oscar = new JLabel();
        Oscar.setBounds(50,40,200,200);
        ImageIcon Osc = new ImageIcon("Oscar.png");
        Oscar.setIcon(Osc);
        
        // lentes
        lentes = new JLabel();
        lentes.setBounds(50,40,200,200);
        ImageIcon len = new ImageIcon("Anteojos.png");
        lentes.setIcon(len);
        
        // gorra
        gorra = new JLabel();
        gorra.setBounds(50,40,200,200);
        ImageIcon gor = new ImageIcon("gorra.png");
        gorra.setIcon(gor);
        
        // maquillaje
        maquillaje = new JLabel();
        maquillaje.setBounds(50,40,200,200);
        ImageIcon maq = new ImageIcon("Maquillaje.png");
        maquillaje.setIcon(maq);
        
        if (p.isLentes()) {
                frame.add(lentes);
                frame.setVisible(true);
                System.out.println("lentes");
        } 
        
        if (p.isMaquillaje()){
                frame.add(maquillaje);
                frame.setVisible(true);
                System.out.println("maquillaje");
        }
                
        if (p.isGorra()) {
                frame.add(gorra);
                frame.setVisible(true);
                System.out.println("gorra");
        }
        
        if (p.getNombre().equalsIgnoreCase("Danyal")) {
            frame.add(Daniel);
        } else if (p.getNombre().equalsIgnoreCase("Nataxa")) {
            frame.add(Natalia);
        } else if (p.getNombre().equalsIgnoreCase("Osukaru")) {
            frame.add(Oscar);
        } else if (p.getNombre().equalsIgnoreCase("Raymond")) {
            frame.add(Ramon);
        }
        
            switch (p.getTypePersonaje()) {
                case 1:
                    frame.add(Daniel);
                    System.out.println("Daniel");
                    break;
                case 2:
                    frame.add(Ramon);
                    System.out.println("Ramon");
                    break;
                case 3:
                    frame.add(Natalia);
                    System.out.println("Natalia");
                    break;
                case 4:
                    frame.add(Oscar);
                    System.out.println("Oscar");
                    break;
                default:
                    break;
            }
        
        frame.add(titulo);
        frame.add(aceptar);
      
        frame.setVisible(true); // Hace visible la ventana

        synchronized (tiempo) {
                    tiempo.wait();
                }

        } catch (InterruptedException e) {
                e.printStackTrace();
        }

    }
}
