"""
 * pymxm_s.py
 *
 *  Created on: Jun 17, 2016
 *      Author: targueriano
 */
/*
 * pymxm_s.py
 *
 *  Created on: Jun 17, 2016
 *      Author: targueriano
 """
from cython.parallel import parallel, prange
from libc.stdlib cimport abort, malloc, free
cimport openmp


cdef int i, j, k


cdef float A[2000][2000]  
cdef float B[2000][2000] 
cdef float C[2000][2000] 


with nogil, parallel(num_threads=8):
    #inicia MATRIZ
    for i in prange(2000,schedule='static'):
        for j in range(2000):
            A[i][j] = 3 * i + j
            B[i][j] = i + 3 * j
            C[i][j] = 0.0
    
    #multiplica
    for i in prange(2000, schedule='static'):
        for k in range(2000):
            for j in range(2000):
                C[i][j] = C[i][j] + A[i][k] * B[k][j]
                

print "ordem (%d)"%2000


