import math


def backtracking(sum,index):
    global maxI, minI
    
    if(index==len(arr)):
        maxI=max(maxI,sum)
        minI=min(minI,sum)
        return
    
    for i in range(4):
        if operators[i] >0:
            operators[i]-=1
            nextSum=calculate(sum,i,arr[index])
            backtracking(nextSum,index+1 )
            operators[i]+=1
    
def calculate (a,op,b):
    if op==0:
        return a+b
    elif op==1:
        return a-b
    elif op==2:
        return a*b
    elif op==3:
        if a * b < 0:
            return -(-a // b)
        else:
            return a // b
     
    
n=int(input())

arr=list(map(int, input().split()))
operators=list(map(int, input().split()))

maxI = -math.inf
minI = math.inf
    
backtracking(arr[0],1)    

print(maxI)
print(minI)