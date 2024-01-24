public class App4 {

    static int NUM_CLIENTES = 50;
    static int NUM_FILAS = 25;
    static int NUM_COLUMNAS = 2;
    static int[][] sillas = new int[NUM_FILAS][NUM_COLUMNAS];
    static Cliente[] clientes = new Cliente[NUM_CLIENTES];

    public static void main(String arg[]) {
        for (int i = 1; i <= NUM_CLIENTES; i++) {
            clientes[i] = new Cliente(i);
            new Thread(clientes[i]).start();
        }

        

    }

    public static synchronized boolean asignarAsiento(int f, int c, int id){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Asiento a reservar"+ f + ", " + c);
        if(sillas[f][c] == 0){
            sillas[f][c] = id;
            System.out.println("Asiento asignado");
            return true;
        }else{
            System.out.println("Asiento ocupado");
            return false;
        }
    }

    public static synchronized void imprimir(){
        for (int i = 0; i < NUM_COLUMNAS; i++) {
            for (int j = 0; j < NUM_FILAS; j++) {
                System.out.print(sillas[j][i] + " ");        
                
            }

            System.out.println();
        }
        System.out.println();
    }

}
