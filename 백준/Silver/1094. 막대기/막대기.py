# 백준 막대기
mak = 64
x = int(input())
maks=[64]

while sum(maks)> x:

    maks.sort()
    maks[0] = maks[0]//2 # 가지고 있는 막대 중 길이가 가장 짧은 것을 절반으로 자른다.
    if sum(maks)>=x:
        #print("남아있는 것", len(maks))
        #print(maks, sum(maks))
        pass
    else:
        maks.append(maks[0])


print(len(maks))