S=int(input())

sum=0
count=0
i=1
while sum+i<=S:
    sum+=i
    i+=1
    count+=1
    
print(count)