a,b = map(int,input().split())

def get_gcd(nat1,nat2):
    while nat1!= 0 and nat2!= 0:
        if nat1 < nat2:
            nat1, nat2 = nat2, nat1
        if nat1 % nat2 != 0:
            nat1 = nat1 % nat2
        if nat1 % nat2 == 0:
            break
    return nat2

lcm = a*b//get_gcd(a,b)
print(lcm)