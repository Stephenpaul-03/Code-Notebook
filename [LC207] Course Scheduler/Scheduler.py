class pair:
    def __init__(self, first, second):
        self.first = first
        self.second = second

def define(tasks, pre):
    graph = []
    for i in range(tasks):
        graph.append([])

    for p in pre:
        graph[p.second].append(p.first)

    return graph

def dfs(graph, node, onpath, visited):
    if visited[node]:
        return False
    onpath[node] = visited[node] = True
    for neigh in graph[node]:
        if (onpath[neigh] or dfs(graph, neigh, onpath, visited)):
            return True
    return False

def finish(task, pre):
    graph = define(task, pre)
    onpath = [False] * task
    visited = [False] * task
    for i in range(task):
        if (not visited[i] and dfs(graph, i, onpath, visited)):
            return False
    return True

t = int(input())
for _ in range(t):
    numTasks = int(input())
    numPrerequisites = int(input())
    prerequisites = []
    for _ in range(numPrerequisites):
        first, second = map(int, input().split())
        prerequisites.append(pair(first, second))
    
    if finish(numTasks, prerequisites):
        print("YES")
    else:
        print("NO")
