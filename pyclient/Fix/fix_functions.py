def bt(recommend_val):
    # print("建议大于", recommend_val)
    return "建议>="+recommend_val+"\n"


def lt(recommend_val):
    # print("建议小于", recommend_val)
    return "建议<="+recommend_val+"\n"


def eq(recommend_val):
    if recommend_val == '1':
        # print("建议设置为enabled")
        return "建议设置为enabled(输入1)\n"
    else:
        # print("建议设置为disabled")
        return "建议设置为disabled(输入0)\n"


def between(recommend_val):
    print(recommend_val)
    left, right = recommend_val.split(",")
    left = left[1:]
    right = right[1:-1]
    # print("建议设置在区间：["+str(left)+", "+str(right)+"]")
    return "建议设置在区间：["+str(left)+", "+str(right)+"]\n"


def default(recommend_val):
    # print("无建议值")
    return "无建议值\n"
