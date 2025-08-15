import sys,heapq
heap=[]
N=int(sys.stdin.readline())

for i in range(N):
    x=int(sys.stdin.readline())*-1
    
    if x==0:
        if len(heap)==0:
            print(0)
        else:
            print(heapq.heappop(heap)*-1)
    else:
        heapq.heappush(heap,x)