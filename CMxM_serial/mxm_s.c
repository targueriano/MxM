/*
 * mmatrizes.c
 *
 *  Created on: Jun 17, 2016
 *      Author: targueriano
 */

#include <stdio.h>
#include <math.h>

#define SIZE 1000
float A[SIZE][SIZE];
float B[SIZE][SIZE];
float C[SIZE][SIZE];

void inicializa_matriz() {
	int i, j;
	for (i = 0; i < SIZE; i++) {
		for (j = 0; j < SIZE; j++) {
			A[i][j] = 3 * i + j;
			B[i][j] = i + 3 * j;
			C[i][j] = 0.0;
		}
	}
}
void multiplica_matriz() {
	int i, j, k;
	for (i = 0; i < SIZE; i++) {
		for (k = 0; k < SIZE; k++) {
			for (j = 0; j < SIZE; j++) {
				C[i][j] = C[i][j] + A[i][k] * B[k][j];
			}
		}
	}
}

void main() {
	inicializa_matriz();
	multiplica_matriz();
	printf("\nordem = (%d)\n",SIZE);
}
