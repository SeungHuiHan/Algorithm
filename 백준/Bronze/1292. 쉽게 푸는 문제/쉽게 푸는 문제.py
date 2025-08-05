a,b=map(int,input().split())

arr=[1]
n=2
for i in range (1,b):
    arr.extend([n]*n)
    n+=1
        
print(sum(arr[a-1:b]))