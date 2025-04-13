import sys

input = sys.stdin.readline
#
class Student:
    def __init__(self, name, kr, en, math):
        self.name = name
        self.kr = int(kr)
        self.en = int(en)
        self.math = int(math)

    def __repr_(self):
        return f"{self.name}({self.kr}, {self.en}, {self.math})"


#
n = int(input())

students = []
for _ in range(n):
    name, kr, en, math = input().split()
    students.append(Student(name, kr, en, math))

students.sort(key = lambda x: (-x.kr, x.en, -x.math, x.name))

result =[]
for s in students:
    result.append(s.name)

print('\n'.join(result))
