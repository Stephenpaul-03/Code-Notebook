t = int(input("Enter Test Case Count: "))
for _ in range(t):
    arr = list(map(int, input("Enter Array Elements (space-separated): ").split()))

    total = arr[0]
    temp_total = arr[0]

    for num in arr[1:]:
        temp_total = max(num, temp_total + num)
        total = max(total, temp_total)

    print(total)
