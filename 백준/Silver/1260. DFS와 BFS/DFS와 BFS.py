from collections import deque
import sys

N,M,V=map(int,sys.stdin.readline().split())

def dfs(start):
    visited[start]=True
    result.append(start)
    
    for next in maps[start]:
        if not visited[next]:
            dfs(next)

def bfs(start):
    dq=deque()
    dq.append(start)
    visited[start]=True
    
    while dq:
        current=dq.popleft()
        result.append(current)
        
        for next in maps[current]:
            if not visited[next]:
                visited[next]=True
                dq.append(next)
        

    
maps=[[] for _ in range(N+1)]
for _ in range(M):
    a,b=map(int,sys.stdin.readline().split())
    maps[a].append(b)
    maps[b].append(a)
    
for i in range(N+1):
    maps[i].sort()
    
visited=[False]*(N+1) #방문
result=[]

dfs(V)
print(*result)

visited=[False]*(N+1)
result=[]
bfs(V)
print(*result)