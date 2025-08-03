a,b=map(int,input().split(' '))

c=min(a,b)

while not((a%c==0) and (b%c==0)):
    c-=1

print(c)
print(c*(a//c)*(b//c))