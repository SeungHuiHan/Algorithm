n=int(input())
arr=list(map(int,input().split()))

result=0
for i in arr:
    if i<2:
        continue
    
    flag=False
    for j in range(2,int(i ** 0.5) + 1):
        if i%j==0:
            flag=True
            break
            
    if not flag:
        result+=1

print(result)
        