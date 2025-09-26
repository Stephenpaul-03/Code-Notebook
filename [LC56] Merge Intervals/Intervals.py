def merge_intervals(intervals):
    intervals.sort(key=lambda x: x[0])
    merged = []
    for interval in intervals:
        if not merged or merged[-1][1] < interval[0]:
            merged.append(interval)
        else:
            merged[-1][1] = max(merged[-1][1], interval[1])
    return merged

t = int(input("Enter Test Case Count: "))
for _ in range(t):
    input_str = input("Enter intervals (space-separated, e.g. [1,3] [2,6]): ")
    intervals = []
    parts = input_str.split()
    for part in parts:
        part_clean = part.strip('[]')
        start, end = map(int, part_clean.split(','))
        intervals.append([start, end])

    merged = merge_intervals(intervals)
    print("Merged intervals:", ' '.join(f"[{start},{end}]" for start, end in merged))
