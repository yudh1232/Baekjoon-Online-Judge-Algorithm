# 스도쿠를 수행하는 함수
def dfs(k):
    # 스도쿠가 끝났는지 나타내는 변수를 전역변수로 선언
    global is_finish

    # 스도쿠가 끝났다면
    if k == zero_count:
        is_finish = True
        return
    
    # x, y의 좌표를 구함
    x, y = zero_xy[k]

    # x, y 좌표에 따라 몇번 사각형에 속하는지 구함
    if x < 3:
        if y < 3:
            square_index = 0
        elif y < 6:
            square_index = 1
        else:
            square_index = 2
    elif x < 6:
        if y < 3:
            square_index = 3
        elif y < 6:
            square_index = 4
        else:
            square_index = 5
    else:
        if y < 3:
            square_index = 6
        elif y < 6:
            square_index = 7
        else:
            square_index = 8

    # 현재 칸에서 가능한 숫자를 구함
    available = {1, 2, 3, 4, 5, 6, 7, 8, 9} - (row_sets[x] | col_sets[y] | square_sets[square_index])

    # 현재 칸에서 가능한 숫자에 대하여
    for next in sorted(list(available)):
        # 만약 스도쿠가 끝났다면 그냥 리턴
        if is_finish:
            return

        # 가능한 숫자를 넣어봄
        row_sets[x].add(next)
        col_sets[y].add(next)
        square_sets[square_index].add(next)
        board[x][y] = next
        
        # 다음 칸으로 이동
        dfs(k + 1)

        # 실패했다면 숫자를 다시 뺌
        row_sets[x].remove(next)
        col_sets[y].remove(next)
        square_sets[square_index].remove(next)


# 보드판
board = [[0] * 9 for _ in range(9)]

# 행, 열, 사각형에 들어있는 숫자를 set으로 관리
row_sets = [set() for _ in range(9)]
col_sets = [set() for _ in range(9)]
square_sets = [set() for _ in range(9)]

# 0의 좌표를 담는 리스트
zero_xy = []
# 0의 개수
zero_count = 0

# 보드판 정보를 입력받음
for i in range(9):
    s = list(input())
    for j in range(9):
        value = int(s[j])
        board[i][j] = value

        # 0인 칸은 좌표를 zero_xy에 넣고, zero_count를 증가시킴
        if value == 0:
            zero_xy.append((i, j))
            zero_count += 1
        # 0이 아닌 칸은
        else:
            # 행, 열, 사각형 set에 숫자를 넣음
            row_sets[i].add(value)
            col_sets[j].add(value)

            if i < 3:
                if j < 3:
                    square_sets[0].add(value)
                elif j < 6:
                    square_sets[1].add(value)
                else:
                    square_sets[2].add(value)
            elif i < 6:
                if j < 3:
                    square_sets[3].add(value)
                elif j < 6:
                    square_sets[4].add(value)
                else:
                    square_sets[5].add(value)
            else:
                if j < 3:
                    square_sets[6].add(value)
                elif j < 6:
                    square_sets[7].add(value)
                else:
                    square_sets[8].add(value)

# 스도쿠가 끝났는지 나타내는 변수
is_finish = False

# 스도쿠 수행
dfs(0)

# 결과 출력
for i in range(9):
    s = ''.join(map(str, board[i]))
    print(s)
