N=int(input())
arr=[list(map(str,input().split())) for _ in range(N)]
arr.sort(key=lambda x:(-int(x[1]),int(x[2]),-int(x[3]),x[0]))

for name in arr:
    print(name[0])