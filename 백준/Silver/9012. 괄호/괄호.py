T=int(input())

for _ in range(T):
    arr=input()
    stack=[]
    is_valid = True
    
    for ch in arr:
        if ch=='(':
            stack.append(ch)
        else: # ')'
            if not stack:
                is_valid = False
                break  # 현재 테스트 케이스는 더 이상 볼 필요 없음
            
           
            if stack[-1]=='(':
                stack.pop()

        
    if is_valid and not stack:
        print("YES")
    else:
        print("NO")