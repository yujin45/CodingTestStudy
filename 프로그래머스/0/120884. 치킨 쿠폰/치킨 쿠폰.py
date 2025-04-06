def solution(chicken):
    service = 0
    coupon = chicken

    while coupon >= 10:
        new_chicken = coupon // 10      # 서비스 치킨 수
        service += new_chicken
        coupon = new_chicken + (coupon % 10)  # 남은 쿠폰 + 새로 발급된 쿠폰

    return service
