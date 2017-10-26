def is_isogram(string):
    seen = set()
    for i in range(len(string)):
        c = string[i].lower()
        if c.isalpha():
            if c in seen:
                return False
            else:
                seen.add(c)
    return True
