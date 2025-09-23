def solution(land):
    dp = land[0][:]
    for row in land[1:]:
        tmp = [0] * 4
        for i in range(4):
            tmp[i] = max(dp[j] for j in range(4) if j != i) + row[i]
        dp = tmp
    return max(dp)