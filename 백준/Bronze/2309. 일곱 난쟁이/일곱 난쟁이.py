def fake(i,j):
    sum=0;
    for k in range(9):
        if k==i or k==j:
            continue
        sum+=arr[k]
    
    return sum==100

    
arr=[]
for _ in range(9):
    arr.append(int(input()))

result=[]
for i in range(8):
    for j in range(i+1,9):
        if fake(i,j):
            for k in range (9):
                if k==i or k==j:
                    continue
                result.append(arr[k])
            result.sort()
            for x in result:
                print(x)
            exit()
                

    
    


