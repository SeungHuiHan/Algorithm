N=int(input())
arr=[list(map(str,input().split())) for _ in range(N)]
arr.sort(key=lambda x:(-int(x[1]),int(x[2]),-int(x[3]),x[0]))

lines=[]
for name in arr:
    lines.append(name[0]+"\n")
answer=''.join(lines)
print(answer)