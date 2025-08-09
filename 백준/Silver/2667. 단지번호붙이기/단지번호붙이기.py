from collections import deque

N=int(input())
maps=[list(map(int, input().strip())) for _ in range(N)]
arr=[]

visited = [[False]*N for _ in range(N)]
dx=[0,0,-1,1]
dy=[-1,1,0,0]


def bfs(x,y):
    queue = deque([(x, y)])
    visited[x][y]=True
    count=1
    
    while queue:
        cx, cy= queue.popleft()
        for i in range(4):
            nx=cx+dx[i]
            ny=cy+dy[i]
            
            
            if 0<=nx<N and 0<=ny<N:
                
                if not visited[nx][ny] and maps[nx][ny]==1:
                    visited[nx][ny] = True
                    queue.append((nx, ny))
                    count+=1
                    
    return count


for i in range(N):
    for j in range(N):
        if not visited[i][j] and maps[i][j]==1:
            arr.append(bfs(i,j))
            
arr.sort()

print(len(arr))
for home in arr:
    print(home)
    