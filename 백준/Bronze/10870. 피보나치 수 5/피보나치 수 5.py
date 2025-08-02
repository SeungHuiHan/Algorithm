n=int(input())
arr=[]

if n==0:
    print(0)
else:
    arr=[0,1]
    for i in range(2,n+1):
        arr.append(arr[i-2]+arr[i-1])

        
    print(arr[n])