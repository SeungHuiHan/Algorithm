while True:
    try:
        line = input()
        a, b = map(int, line.split())
        print(a + b)
    except EOFError:
        break