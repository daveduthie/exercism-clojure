def is_pangram(sentence):
    # Make set of letters in sentence
    seen = set(sentence.lower())

    # Check that we have each letter
    alphabet = set('abcdefghijklmnopqrstuvwxyz')
    for l in alphabet:
        if l not in seen:
            return False
    return True
