T=int(input())

for _ in range(T):
    n=int(input())
    
    binary=[]
    while n>0:
        binary.append(n%2)
        n=n//2
        
    for i in range(len(binary)):
        if binary[i]!=0:
            print(i,end=" ")
            
    print()