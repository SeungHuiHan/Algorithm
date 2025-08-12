for _ in range(3):
    arr=list(map(int,input().split()))
    a=arr.count(0)
    if a==1:
        print("A")
    elif a==2:
        print("B")
    elif a==3:
        print("C")
    elif a==4:
        print("D")
    else:
        print("E")