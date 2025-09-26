def sprial_matrix(matrix):
    top, bottom = 0, len(matrix) - 1
    left, right = 0, len(matrix[0]) - 1

    while top <= bottom and left <= right:
        for i in range(left, right + 1):
            print(matrix[top][i], end=" ")
        top += 1

        for i in range(top, bottom + 1):
            print(matrix[i][right], end=" ")
        right -= 1

        if top <= bottom:
            for i in range(right, left - 1, -1):
                print(matrix[bottom][i], end=" ")
            bottom -= 1

        if left <= right:
            for i in range(bottom, top - 1, -1):
                print(matrix[i][left], end=" ")
            left += 1
    print()


t = int(input().strip())
for _ in range(t):
    matrix = []
    while True:
        line = input().strip()
        if not line:
            break
        matrix.append(list(map(int, line.split())))
    sprial_matrix(matrix)
