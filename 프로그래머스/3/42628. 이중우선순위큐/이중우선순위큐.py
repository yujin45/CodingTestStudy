import heapq
import re # 구분자 여러개 쓸 때 정규식 용도

text = "apple|banana,grape.orange"
fruits = re.split(r'[|,]', text)

def solution(operations):
    heap = []
    for op in operations:
        print(op)
        if "I " in op:
            # 1. 정규식 써서 하는 방법 []안에 구분자 넣기, filter로 빈문자열 제거하고 리스트로 나옴
            #num = list(filter(None, re.split(r'[I ]', op)))
            #print(num[0])
            
            # 2. replace 후 split 하는 방법 이것도 리스트로 나옴
            num = op.replace("I", " ").split()
            #print(num[0])
            #print(type(num[0]))    #  미친 str이었음 어쩐지 정렬 안되더라
            num = int(num[0])
            
            
            heapq.heappush(heap, num)
            
            #print(heap)
            
        elif "D 1" in op and heap:
            # 최대값 삭제 
            largest = heapq.nlargest(1, heap)[0] # 얘는 찾아주기만 함
            #print(largest)
            heap.remove(largest) # 그냥 지우면 빵꾸나서 힙 아니고 걍 리스트 되어버리는 듯
            #print(heap)
            heapq.heapify(heap)
        elif "D -1" in op and heap:
            heapq.heappop(heap)
            #print(heap)
    if len(heap)>0:
        return [heapq.nlargest(1, heap)[0], heapq.heappop(heap)]
    else:
        return [0, 0]
    
           