t = int(input("Enter Test Case Count: "))
for _ in range(t):
    arr = list(map(int, input("Enter Array Elements (space-separated): ").split()))

    max_product = arr[0]
    min_product = arr[0]
    total = arr[0]

    for i in range(1, len(arr)):
        if arr[i] == 0:
            max_product = 1
            min_product = 1
            continue

        if arr[i] < 0:
            max_product, min_product = min_product, max_product

        max_product = max(arr[i], max_product * arr[i])
        min_product = min(arr[i], min_product * arr[i])

        total = max(total, max_product)

    print(total)
