n,k=map(int,input().split())

arr=list(int(input()) for _ in range(n))

INF = 10**9
dp=[INF]*(k+1)

dp[0]=0

for i in arr:
    for j in range(i,k+1):
        dp[j]=min(dp[j],dp[j-i]+1)
            
            

if dp[k]==INF:
    print(-1)
else:
    print(dp[k])