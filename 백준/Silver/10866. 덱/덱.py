from collections import deque
import sys

N=int(sys.stdin.readline())
dq=deque()
for _ in range(N):
    a=sys.stdin.readline().split()
    
    if a[0]=="push_front":
        dq.appendleft(int(a[1]))
    elif a[0]=="push_back":
        dq.append(int(a[1]))
    elif a[0]=="pop_front":
        print(dq.popleft() if len(dq)!=0 else -1)
    elif a[0]=="pop_back":
        print(dq.pop() if len(dq)!=0 else -1)
    elif a[0]=="size":
        print(len(dq))
    elif a[0]=="empty":
        print(1 if len(dq)==0 else 0)
    elif a[0]=="front":
        print(dq[0] if len(dq)!=0 else -1)
    elif a[0]=="back":
        print(dq[-1] if len(dq)!=0 else -1)
    