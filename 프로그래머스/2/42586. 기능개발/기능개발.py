def solution(progresses, speeds):
    # 매개변수 자체를 큐로 만들어보자
    answer = []
    days = 0
    cnt = 0
    while progresses:
        #print(progresses)
        # 큐가 있는 동안
        # peek해서 확인
        if (progresses[0] + days*speeds[0])>= 100:
            # 100보다 크면 완료
            progresses.pop(0)
            speeds.pop(0)
            cnt +=1
        else:
            # 작으면
            if cnt >0:
                # 기능 완성된 것이 있으면
                answer.append(cnt) 
                cnt =0
            days +=1 # day는 0으로 초기화 되지 않고 계속 흐르는 것!
            # days 흐른 만큼 완성될 수 있는 애들은 위에서 다 cnt+=1 되는 것!
    # 마지막 작업 
    answer.append(cnt)
    return answer