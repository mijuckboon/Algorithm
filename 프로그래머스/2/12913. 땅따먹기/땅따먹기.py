def solution(land):
    dp = land[0][:]
    for row in land[1:]:
        tmp = [0] * 4
        for i in range(4):
            tmp[i] = max(dp[(i + 1) % 4], dp[(i + 2) % 4], dp[(i + 3) % 4]) + row[i]
        dp = tmp
    return max(dp)