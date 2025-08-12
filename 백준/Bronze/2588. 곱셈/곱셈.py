A=int(input())
B=int(input())
arr=[int(i) for i in str(B)]
arr.reverse()

for i in arr:
    print(A*i)
    
    
print(A*B)