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
from random import randint
import numpy as np

SIZE = 2000


class MxM_serial:
	def __init__(self,A,B,C):
		self.A = A
		self.B = B 
		self.C = C
		
	def multiplica_matriz(self):
		A = self.A
		B = self.B
		C = self.C
		for i in range(2):
			C = np.dot(A,B)
		return C

if __name__ == "__main__":
	A = [[randint(0,9) for x in range(SIZE)] for y in range(SIZE)] 
	B = [[randint(0,9) for x in range(SIZE)] for y in range(SIZE)]
	C = [[0 for x in range(SIZE)] for y in range(SIZE)]
	mxm = MxM_serial(A,B,C)
	#mxm.inicializa_matriz()
	C = mxm.multiplica_matriz()
	#print C
	print "ordem (%d)" %SIZE
	
