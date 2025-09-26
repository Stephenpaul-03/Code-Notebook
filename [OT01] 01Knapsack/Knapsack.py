def knapSack(W, wt, val, n):
    if n == 0 or W == 0:
        return 0

    if wt[n - 1] > W:
        return knapSack(W, wt, val, n - 1)
    else:
        return max(
            knapSack(W, wt, val, n - 1),
            val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1)
        )

n = int(input("Enter the number of items: "))
profit = list(map(int, input("Enter the profits of items (space-separated): ").split()))
weight = list(map(int, input("Enter the weights of items (space-separated): ").split()))
W = int(input("Enter the maximum capacity of the knapsack: "))

print("Maximum profit:", knapSack(W, weight, profit, n))
