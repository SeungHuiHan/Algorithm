from collections import deque
import sys
dq=deque()
N=int(sys.stdin.readline())


for _ in range(N):
    a=sys.stdin.readline().split()
    
    if a[0]=="push":
        dq.append(int(a[1]))
    elif a[0]=="top":
        if len(dq)==0:
            print(-1)
        else:
            print(dq[-1])
    elif a[0]=="size":
        print(len(dq))
    elif a[0]=="empty":
        if len(dq)==0:
            print(1)
        else:
            print(0)
    elif a[0]=="pop":
        if len(dq)==0:
            print(-1)
        else:
            print(dq.pop())
