# w, h, p, q, t를 입력받음
w, h = map(int, input().split())
p, q = map(int, input().split())
t = int(input())

# p가 움직이는 횟수는 t를 2w로 나눈 나머지
p_move_cnt = t % (2 * w)
# q가 움직이는 횟수는 t를 2h로 나눈 나머지
q_move_cnt = t % (2 * h)

# t시간 후 p의 위치를 계산
np = p_move_cnt + p
if np <= w:
    p = np
elif w < np and np <= 2 * w:
    p = 2 * w - np
else:
    p = np - 2 * w

# t시간 후 q의 위치를 계산
nq = q_move_cnt + q
if nq <= h:
    q = nq
elif h < nq and nq <= 2 * h:
    q = 2 * h - nq
else:
    q = nq - 2 * h

print(p, q) # 결과 출력
