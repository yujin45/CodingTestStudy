import sys

input = sys.stdin.readline

def count_unique_substrings(s):
    unique_substrings = set()
    n = len(s)
    
    for i in range(n):
        for j in range(i+1, n+1):
            unique_substrings.add(s[i:j])
    
    return len(unique_substrings)

if __name__ == "__main__":
    s = input().strip()
    print(count_unique_substrings(s))