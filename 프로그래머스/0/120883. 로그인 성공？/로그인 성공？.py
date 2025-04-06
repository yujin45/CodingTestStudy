def solution(id_pw, db):
    
    user = {}
    for key, value in db:
        user[key] = value
    
    if id_pw[0] in user:
        if user[id_pw[0]] == id_pw[1]:
            return "login"
        else:
            return "wrong pw"
    else:
        return "fail"
    