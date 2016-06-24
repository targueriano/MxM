package mxm_java_paralelo;

import jomp.runtime.*;

public class MxM_Java_Paralelo2 {

    static long tempoInicio = System.currentTimeMillis();
    static final int SIZE = 500;
    static float[][] A = new float[SIZE][SIZE];
    static float[][] B = new float[SIZE][SIZE];
    static float[][] C = new float[SIZE][SIZE];

    public static void main(String[] args) {

        int i, j, k, n;
        int size = SIZE;
        OMP.setNumThreads(1);

// OMP PARALLEL BLOCK BEGINS
        {
            __omp_Class0 __omp_Object0 = new __omp_Class0();
            // shared variables
            __omp_Object0.size = size;
            __omp_Object0.args = args;
            // firstprivate variables
            try {
                jomp.runtime.OMP.doParallel(__omp_Object0);
            } catch (Throwable __omp_exception) {
                System.err.println("OMP Warning: Illegal thread exception ignored!");
                System.err.println(__omp_exception);
            }
            // reduction variables
            // shared variables
            size = __omp_Object0.size;
            n = __omp_Object0.n;
            args = __omp_Object0.args;
        }
// OMP PARALLEL BLOCK ENDS

        System.out.println("Tempo total = " + (System.currentTimeMillis() - tempoInicio) + " milisegundos");

    }

// OMP PARALLEL REGION INNER CLASS DEFINITION BEGINS
    private static class __omp_Class0 extends jomp.runtime.BusyTask {
        // shared variables

        int size;
        int n;
        String[] args;
        // firstprivate variables
        // variables to hold results of reduction

        public void go(int __omp_me) throws Throwable {
            // firstprivate variables + init
            // private variables
            int i;
            int j;
            int k;
            // reduction variables, init to default
            // OMP USER CODE BEGINS

            {
                { // OMP FOR BLOCK BEGINS
                    // copy of firstprivate variables, initialized
                    // copy of lastprivate variables
                    // variables to hold result of reduction
                    boolean amLast = false;
                    {
                        // firstprivate variables + init
                        // [last]private variables
                        // reduction variables + init to default
                        // -------------------------------------
                        jomp.runtime.LoopData __omp_WholeData2 = new jomp.runtime.LoopData();
                        jomp.runtime.LoopData __omp_ChunkData1 = new jomp.runtime.LoopData();
                        __omp_WholeData2.start = (long) (0);
                        __omp_WholeData2.stop = (long) (size);
                        __omp_WholeData2.step = (long) (1);
                        jomp.runtime.OMP.setChunkStatic(__omp_WholeData2);
                        while (!__omp_ChunkData1.isLast && jomp.runtime.OMP.getLoopStatic(__omp_me, __omp_WholeData2, __omp_ChunkData1)) {
                            for (;;) {
                                if (__omp_WholeData2.step > 0) {
                                    if (__omp_ChunkData1.stop > __omp_WholeData2.stop) {
                                        __omp_ChunkData1.stop = __omp_WholeData2.stop;
                                    }
                                    if (__omp_ChunkData1.start >= __omp_WholeData2.stop) {
                                        break;
                                    }
                                } else {
                                    if (__omp_ChunkData1.stop < __omp_WholeData2.stop) {
                                        __omp_ChunkData1.stop = __omp_WholeData2.stop;
                                    }
                                    if (__omp_ChunkData1.start > __omp_WholeData2.stop) {
                                        break;
                                    }
                                }
                                for (i = (int) __omp_ChunkData1.start; i < __omp_ChunkData1.stop; i += __omp_ChunkData1.step) {
                                    // OMP USER CODE BEGINS
                                    {
                                        for (j = 0; j < size; j++) {
                                            A[i][j] = 3 * i + j;
                                            B[i][j] = i + 3 * j;
                                            C[i][j] = 0;
                                        }
                                    }
                                    // OMP USER CODE ENDS
                                    if (i == (__omp_WholeData2.stop - 1)) {
                                        amLast = true;
                                    }
                                } // of for 
                                if (__omp_ChunkData1.startStep == 0) {
                                    break;
                                }
                                __omp_ChunkData1.start += __omp_ChunkData1.startStep;
                                __omp_ChunkData1.stop += __omp_ChunkData1.startStep;
                            } // of for(;;)
                        } // of while
                        // call reducer
                        jomp.runtime.OMP.doBarrier(__omp_me);
                        // copy lastprivate variables out
                        if (amLast) {
                        }
                    }
                    // set global from lastprivate variables
                    if (amLast) {
                    }
                    // set global from reduction variables
                    if (jomp.runtime.OMP.getThreadNum(__omp_me) == 0) {
                    }
                } // OMP FOR BLOCK ENDS

                { // OMP FOR BLOCK BEGINS
                    // copy of firstprivate variables, initialized
                    // copy of lastprivate variables
                    // variables to hold result of reduction
                    boolean amLast = false;
                    {
                        // firstprivate variables + init
                        // [last]private variables
                        // reduction variables + init to default
                        // -------------------------------------
                        jomp.runtime.LoopData __omp_WholeData5 = new jomp.runtime.LoopData();
                        jomp.runtime.LoopData __omp_ChunkData4 = new jomp.runtime.LoopData();
                        __omp_WholeData5.start = (long) (0);
                        __omp_WholeData5.stop = (long) (size);
                        __omp_WholeData5.step = (long) (1);
                        jomp.runtime.OMP.setChunkStatic(__omp_WholeData5);
                        while (!__omp_ChunkData4.isLast && jomp.runtime.OMP.getLoopStatic(__omp_me, __omp_WholeData5, __omp_ChunkData4)) {
                            for (;;) {
                                if (__omp_WholeData5.step > 0) {
                                    if (__omp_ChunkData4.stop > __omp_WholeData5.stop) {
                                        __omp_ChunkData4.stop = __omp_WholeData5.stop;
                                    }
                                    if (__omp_ChunkData4.start >= __omp_WholeData5.stop) {
                                        break;
                                    }
                                } else {
                                    if (__omp_ChunkData4.stop < __omp_WholeData5.stop) {
                                        __omp_ChunkData4.stop = __omp_WholeData5.stop;
                                    }
                                    if (__omp_ChunkData4.start > __omp_WholeData5.stop) {
                                        break;
                                    }
                                }
                                for (i = (int) __omp_ChunkData4.start; i < __omp_ChunkData4.stop; i += __omp_ChunkData4.step) {
                                    // OMP USER CODE BEGINS
                                    {
                                        for (k = 0; k < size; k++) {
                                            for (j = 0; j < size; j++) {
                                                C[i][j] = C[i][j] + A[i][k] * B[k][j];
                                            }
                                        }
                                    }
                                    // OMP USER CODE ENDS
                                    if (i == (__omp_WholeData5.stop - 1)) {
                                        amLast = true;
                                    }
                                } // of for 
                                if (__omp_ChunkData4.startStep == 0) {
                                    break;
                                }
                                __omp_ChunkData4.start += __omp_ChunkData4.startStep;
                                __omp_ChunkData4.stop += __omp_ChunkData4.startStep;
                            } // of for(;;)
                        } // of while
                        // call reducer
                        jomp.runtime.OMP.doBarrier(__omp_me);
                        // copy lastprivate variables out
                        if (amLast) {
                        }
                    }
                    // set global from lastprivate variables
                    if (amLast) {
                    }
                    // set global from reduction variables
                    if (jomp.runtime.OMP.getThreadNum(__omp_me) == 0) {
                    }
                } // OMP FOR BLOCK ENDS

            }
            // OMP USER CODE ENDS
            // call reducer
            // output to _rd_ copy
            if (jomp.runtime.OMP.getThreadNum(__omp_me) == 0) {
            }
        }
    }
// OMP PARALLEL REGION INNER CLASS DEFINITION ENDS

}
