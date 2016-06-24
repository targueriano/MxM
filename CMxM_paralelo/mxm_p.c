/*
 * mxm_p.c
 *
 *  Created on: Jun 17, 2016
 *      Author: targueriano
 */
/*
 * mxm_p.c
 *
 *  Created on: Jun 17, 2016
 *      Author: targueriano
 */

#include <stdio.h>
#include <math.h>
#include <omp.h>


#define SIZE 5000
int size;
float A[SIZE][SIZE];
float B[SIZE][SIZE];
float C[SIZE][SIZE];


int main(int argc, char *argv[]) {



	int i, j, k;
	size = SIZE;

	if(argc > 1)
		size=atoi(argv[1]);

	#pragma omp parallel shared(A, B, C, size) private(i,j, k) num_threads(8)
	{
		#pragma omp for
		for (i = 0; i < size; i++) {
			for (j = 0; j < size; j++) {
				A[i][j] = 3 * i + j;
				B[i][j] = i + 3 * j;
				C[i][j] = 0.0;
			}
		}

		#pragma omp for
		for (i = 0; i < size; i++) {
			for (k = 0; k < size; k++) {
				for (j = 0; j < size; j++) {
					C[i][j] = C[i][j] + A[i][k] * B[k][j];
				}
			}
		}

	}
	printf("\nordem = (%d)\n",SIZE);
	return 0;
}


