num = int(input())
def factorial(n):
    mul = n
    fac = 1
    while mul > 1:
        fac *= mul
        mul -= 1
    return fac
print(factorial(num))