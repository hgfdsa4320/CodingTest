import heapq

a,b=map(int,input().split())
q=[]
count=1
heapq.heappush(q,(a,count))
while True:
    c,count=heapq.heappop(q)
    if c==b:
        print(count)
        break
    elif c>b:
        print(-1)
        break
    count+=1
    heapq.heappush(q,(c*2,count))
    heapq.heappush(q,(c*10+1,count))