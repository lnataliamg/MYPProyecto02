public abstract class Minijuego {

    protected Jugador jugador1;
    protected Jugador jugador2;

    /**
     * Default empty Minijuego constructor
     */
    public Minijuego() {
        super();
    }

    /**
     * Default Minijuego constructor
     */
    public Minijuego(Jugador jugador1, Jugador jugador2) {
        super();
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    /**
     * Returns value of jugador1
     *
     * @return
     */
    public Jugador getJugador1() {
        return jugador1;
    }

    /**
     * Sets new value of jugador1
     *
     * @param
     */
    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    /**
     * Returns value of jugador2
     *
     * @return
     */
    public Jugador getJugador2() {
        return jugador2;
    }

    /**
     * Sets new value of jugador2
     *
     * @param
     */
    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public abstract void ejecutarJuego();

    public abstract String getNombreJuego();
}
