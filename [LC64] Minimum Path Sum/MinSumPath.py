def helper(i, j, matrix, dp):
    if i == 0 and j == 0:
        return matrix[0][0]
    if i < 0 or j < 0:
        return int(1e9)
    if dp[i][j] != -1:
        return dp[i][j]
    up = matrix[i][j] + helper(i-1, j, matrix, dp)
    left = matrix[i][j] + helper(i, j-1, matrix, dp)
    dp[i][j] = min(up, left)
    return dp[i][j]

def minSumPath(n, m, matrix):
    dp = [[-1 for j in range(m)] for i in range(n)]
    return helper(n-1, m-1, matrix, dp)



t = int(input())
for _ in range(t):
    n = int(input("Enter the number of rows in the matrix: "))
    m = int(input("Enter the number of columns in the matrix: "))
    matrix = []
    print("Enter the matrix row by row:")
    for i in range(n):
        row = list(map(int, input().split()))
        matrix.append(row)
    print("The minimum sum path is:", minSumPath(n, m, matrix))


