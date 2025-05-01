def solution(citations):
    citations.sort(reverse = True)
    h_index = citations[0]
    for i, c in enumerate(citations):
        if c >= (i+1):
            h_index = (i+1)
    
    return h_index