maxPeople=0
train=0
for _ in range(10):
    a,b=map(int,input().split(' '))
    train-=a
    train+=b
    maxPeople=max(maxPeople,train)

print(maxPeople)