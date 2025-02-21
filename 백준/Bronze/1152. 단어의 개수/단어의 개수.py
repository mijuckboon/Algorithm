stdin = input().strip()
words = stdin.count(' ')+1
if not stdin: words = 0
print(words)