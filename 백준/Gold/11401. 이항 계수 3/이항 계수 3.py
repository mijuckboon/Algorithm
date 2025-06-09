universe, choose = map(int,open(0).readline().split())
mod = 1000000007

def mod_inverse(nat,div):
    return pow(nat,div-2,div)

def combination(N,K):
    if K > N//2:
        K = N - K

    num = 1
    den = 1
    for i in range(K):
       num = num*(N-i) % mod
       den = den*(K-i) % mod

    return num*mod_inverse(den,mod) % mod

print(combination(universe,choose))