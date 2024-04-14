import heapq
import re # 구분자 여러개 쓸 때 정규식 용도

text = "apple|banana,grape.orange"
fruits = re.split(r'[|,]', text)

def solution(operations):
    heap = []
    for op in operations:
        #print(op)   
        if "D 1" in op and heap:
            # 최대값 삭제 
            largest = heapq.nlargest(1, heap)[0] # 얘는 찾아주기만 함
            #print(largest)
            heap.remove(largest) # 그냥 지우면 빵꾸나서 힙 아니고 걍 리스트 되어버리는 듯
            #print(heap)
            heapq.heapify(heap) # 없어도 통과 되긴 했는데 remove 하면 힙 구조 무너진다고는 함
        elif "D -1" in op and heap:
            heapq.heappop(heap)
            #print(heap)
        else:
            num = int(op[2:])
            heapq.heappush(heap, num)
            
            #print(heap)
    if len(heap)>0:
        return [heapq.nlargest(1, heap)[0], heapq.heappop(heap)]
    else:
        return [0, 0]
    
           