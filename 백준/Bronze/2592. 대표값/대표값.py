from collections import Counter
arr=[]
for _ in range(10):
    arr.append(int(input()))
    
val=Counter(arr).most_common()

print(sum(arr)//10)
print(val[0][0])