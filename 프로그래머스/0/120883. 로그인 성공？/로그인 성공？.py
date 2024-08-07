
def solution(id_pw, db):
    database = dict(db)
    #print(database)
    pw = database.get(id_pw[0], -1) # 키 존재하지 않으면 기본 값 리턴
    if pw == -1:
        return "fail"
    elif pw == id_pw[1]:
        return "login"
    else:
        return "wrong pw"

def solution1(id_pw, db):
    database = dict(db)
    pw = database.setdefault(id_pw[0], "fail") # 없으면 키 삽입 후 디폴트 value 설정
    if pw =="fail":
        return "fail"
    elif pw == id_pw[1]:
        return "login"
    else:
        return "wrong pw"
    
    return "fail"

def solution2(id_pw, db):
    answer = ''
    for id_, pw in db:
        if id_ == id_pw[0]:
            # id 같으면
            if pw == id_pw[1]:
                # pw도 같으면
                return "login"
            else:
                return "wrong pw"
        
    return "fail"