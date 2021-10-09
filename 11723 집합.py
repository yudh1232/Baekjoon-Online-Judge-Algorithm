import sys
input = sys.stdin.readline

# set 선언
s = set()

# m을 입력받음
m = int(input())

# m만큼 반복
for _ in range(m):
    # 문자열을 입력받음
    string = input()

    # 명령이 all일 경우
    if string[0:3] == 'all':
        # s를 1~20 set과 합집합시켜 업데이트 함
        s.update({'1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20'})
    # 명령이 empty일 경우
    elif string[0] == 'e':
        # set을 비움
        s.clear()
    # 명령이 all과 empty가 아닐 때
    else:
        # 명령과 숫자를 분리
        c, n = string.split()
        # 명령이 add일 경우
        if c == 'add':
            # s에 n을 넣음
            s.add(n)
        # 명령이 remove일 경우
        elif c == 'remove':
            # s에서 n을 뺌(n이 없을때는 무시)
            s.discard(n)
        # 명령이 check일 경우
        elif c == 'check':
            # n이 s에 있다면 1출력
            if n in s:
                print(1)
            # n이 s에 없다면 -1출력
            else:
                print(0)
        # 명령이 toggle일 경우
        elif c == 'toggle':
            # n이 s에 있다면 제거
            if n in s:
                s.remove(n)
            # n이 s에 없다면 넣음
            else:
                s.add(n)
