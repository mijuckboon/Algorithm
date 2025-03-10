h,m=map(int,input().split())
t=60*h+m+int(input())
print((t//60)%24, t%60)