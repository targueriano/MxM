
public class MxM_Java {

    /**
     * @param args the command line arguments
     */
    static long tempoInicio = System.currentTimeMillis();
    static final int SIZE = 1500;
    static float[][] A = new float[SIZE][SIZE];
    static float[][] B = new float[SIZE][SIZE];
    static float[][] C = new float[SIZE][SIZE];

    public static void main(String[] args) {
        // TODO code application logic here

        inicializa_matriz();
        multiplica_matriz();
        System.out.println("Tempo total = " + (System.currentTimeMillis() - tempoInicio) + " milisegundos");

    }

    static void inicializa_matriz() {
        int i, j;
        for (i = 0; i < SIZE; i++) {
            for (j = 0; j < SIZE; j++) {
                A[i][j] = 3 * i + j;
                B[i][j] = i + 3 * j;
                C[i][j] = 0;
            }
        }
    }

    static void multiplica_matriz() {
        int i, j, k;
        for (i = 0; i < SIZE; i++) {
            for (k = 0; k < SIZE; k++) {
                for (j = 0; j < SIZE; j++) {
                    C[i][j] = C[i][j] + A[i][k] * B[k][j];
                }
            }
        }
    }

}
