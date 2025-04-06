def solution(cipher, code):
    result = []
    for i in range(code-1, len(cipher), code):
        result.append(cipher[i])
    return ''.join(result)