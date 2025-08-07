n=int(input())
maps=[list(input()) for _ in range(n)]

def cal(maps,n):
    max_count=0
    
    for i in range(n):
        count=1
        for j in range(1,n):
            if maps[i][j]==maps[i][j-1]:
                count+=1
            else:
                count=1
            max_count=max(max_count,count)
        
    for j in range(n):
        count=1
        for i in range(1,n):
            if maps[i][j]==maps[i-1][j]:
                count+=1
            else:
                count=1
            max_count=max(max_count,count)
    
    return max_count

answer=0

for i in range(n):
    for j in range(n):
        if i+1<n: #아래쪽
            temp=maps[i][j]
            maps[i][j]=maps[i+1][j]
            maps[i+1][j]=temp
            
            answer=max(answer,cal(maps,n))
            
            temp=maps[i][j]
            maps[i][j]=maps[i+1][j]
            maps[i+1][j]=temp
            
        if j+1<n: #오른쪽
            temp=maps[i][j]
            maps[i][j]=maps[i][j+1]
            maps[i][j+1]=temp
            
            answer=max(answer,cal(maps,n))
            
            temp=maps[i][j]
            maps[i][j]=maps[i][j+1]
            maps[i][j+1]=temp
            
print(answer)