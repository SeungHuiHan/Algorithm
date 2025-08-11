n=int(input())
maps=[list(map(int,input().split())) for _ in range(n)]

dp = [[[0] * 3 for _ in range(n)] for _ in range(n)]

dp[0][1][0]=1

for r in range(n):
    for c in range(n):
        if maps[r][c]==1: 
            continue
        
        #가로로 도착
        if c-1>=0 and maps[r][c-1]==0:
            dp[r][c][0]+=dp[r][c-1][0]+dp[r][c-1][2]
        #세로로 도착
        if r-1>=0 and maps[r-1][c]==0:
            dp[r][c][1]+=dp[r-1][c][1]+dp[r-1][c][2]
        #대각선으로 도착
        if r-1>=0 and c-1>=0 and maps[r-1][c-1]==0 and maps[r][c-1]==0 and maps[r-1][c]==0 :
            dp[r][c][2]+=dp[r-1][c-1][0]+dp[r-1][c-1][1]+dp[r-1][c-1][2]
        
print(sum(dp[n-1][n-1]))