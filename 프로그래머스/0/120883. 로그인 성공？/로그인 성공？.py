def solution(id_pw, db):
    database = dict(db)
    pw = database.setdefault(id_pw[0], "fail")
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