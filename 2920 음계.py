# 숫자 8개를 입력받아 리스트에 넣음
data = list(map(int, input().split()))
# 1로 시작하는 경우
if data[0] == 1:
    # 오름차순으로 정렬되어 있다면
    if data == sorted(data):
        print('ascending')
    # 정렬되어 있지 않다면
    else:
        print('mixed')
# 8로 시작하는 경우
elif data[0] == 8:
    # 내림차순으로 정렬되어 있다면
    if data == sorted(data, reverse=True):
        print('descending')
    # 정렬되어 있지 않다면
    else:
        print('mixed')
# 1 또는 8로 시작하지 않는 경우
else:
    print('mixed')
