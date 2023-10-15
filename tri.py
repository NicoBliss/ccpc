import sys

permList = [0]*15
permList[0] = 3
def perms(n):
    next = 3*permList[n-1] + 2
    for i in range(0, n-1):
        next += 2*permList[i]
    permList[n] = next

for i in range(1, 15):
    perms(i)

while (i := int(input())) != -1:
    if i%2 == 1:
        print("0")
    elif i == 0:
        print("0")
    else:
        print(permList[int(i/2-1)])