def profit_checker(arr):
    min_price = arr[0]
    max_profit = 0
    for price in arr[1:]:
        min_price = min(min_price, price)
        max_profit = max(max_profit, price - min_price)
    return max_profit

def main():
    t = int(input())
    for _ in range(t):
        arr = list(map(int, input().split()))
        print(profit_checker(arr))

if __name__ == "__main__":
    main()
