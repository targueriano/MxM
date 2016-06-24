
public class MxM_Java_Paralelo {

    /**
     * @param args the command line arguments
     */
    static long tempoInicio = System.currentTimeMillis();
    static final int SIZE = 1500;
    static float[][] A = new float[SIZE][SIZE];
    static float[][] B = new float[SIZE][SIZE];
    static float[][] C = new float[SIZE][SIZE];

    public static void main(String[] args) {
        int i, j, k, n;
        int size = SIZE;

        //#pragma omp parallel shared(A, B, C, size) private(i,j, k) num_threads(4)
        {
            //#pragma omp for
            for (i = 0; i < size; i++) {
                for (j = 0; j < size; j++) {
                    A[i][j] = 3 * i + j;
                    B[i][j] = i + 3 * j;
                    C[i][j] = 0;
                }
            }

            //#pragma omp for
            for (i = 0; i < size; i++) {
                for (k = 0; k < size; k++) {
                    for (j = 0; j < size; j++) {
                        C[i][j] = C[i][j] + A[i][k] * B[k][j];
                    }
                }
            }

        }
        System.out.println("Tempo total = " + (System.currentTimeMillis() - tempoInicio) + " milisegundos");

    }
}
