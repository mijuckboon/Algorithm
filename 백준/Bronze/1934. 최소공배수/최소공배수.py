import math
stdin = open(0)
input_alter = lambda: stdin.readline().rstrip()

num_tc = int(input_alter())

for j in range(num_tc):
    a,b = map(int,input_alter().split())
    lcm = a*b//math.gcd(a,b)
    print(lcm)