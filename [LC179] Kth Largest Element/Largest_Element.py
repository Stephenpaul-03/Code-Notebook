import heapq

def element_finder(arr, n):
    heap = []
    for num in arr:
        heapq.heappush(heap, -num) 
        if len(heap) > n:
            heapq.heappop(heap)
    return -heap[0]  


t = int(input())
for _ in range(t):
    arr = list(map(int, input().split()))
    n = int(input())
    print(element_finder(arr, n))
