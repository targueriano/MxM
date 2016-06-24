"""
Uso do multiprocessing para execucao paralela
"""
import multiprocessing
    
#import multiprocessing as mp
from random import randint
import numpy as np
from multiprocessing import Process
SIZE = 2000


def multiplica(args,A,B):
    #multiplica
    if args[0] == 1:
        C = np.dot(A,B)
    else:
        C2 = np.dot(A,B) 
               

if __name__ == "__main__":
    A = [[randint(0,9) for x in range(SIZE)] for y in range(SIZE)] 
    B = [[randint(0,9) for x in range(SIZE)] for y in range(SIZE)]
    
    C = [[0 for x in range(SIZE)] for y in range(SIZE)]
    
    p = Process(target=multiplica, args=([1,2], A,B,))
    p.start()
    p.join()
    #pool = multiprocessing.Pool(processes=8)
    #r = pool.map(multiplica,[int(1),int(2),int(3),int(4),int(5),int(6),int(7),int(8)])
        #multiplica(C)
    
    print "ordem (%d)"%SIZE


