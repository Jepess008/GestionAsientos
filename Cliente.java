public class Cliente implements Runnable {

    private int id;

    public Cliente(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        boolean disponible = false;
        do {
            disponible = App4.asignarAsiento((int) (Math.random() * 25 ), (int) (Math.random() * 2),id);
        } while (disponible == false);

        App4.imprimir();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
