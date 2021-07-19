# 테스트 케이스의 수를 입력받음
t = int(input())

for _ in range(t):
    # 사료의 양 n을 입력받고, 첫 날 먹었던 식사의 양을 입력받아 리스트에 넣음
    n = int(input())
    data = list(map(int, input().split()))

    # 날짜 초기화
    day = 1
    # 첫 날 식사의 양
    required_amount = sum(data)

    while True:
        # 사료의 양이 식사의 양보다 적을 경우 반복 종료
        if n < required_amount:
            break
        # 사료의 양이 충분했을 경우 날짜 수 증가
        day += 1
        # 다음 날 식사의 양 = 첫 날 식사의 양 * 4
        required_amount *= 4

    print(day) #결과 출력
