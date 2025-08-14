from collections import Counter
s=input().strip().upper()

val=Counter(s).most_common()


print("?" if len(val)>1 and val[0][1]==val[1][1] else val[0][0])
