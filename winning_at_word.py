letterMap = {"a":0, "b":1, "c":2, "d":3, "e":4, "f":5, "g":6, "h":7, "i":8, "j":9, "k":10, "l":11, "m":12, "n":13, "o":14, "p":15, "q":16, "r":17, "s":18, "t":19, "u":20, "v":21, "w":22, "x":23, "y":24, "z":25}

def bitIfy(word):
    word = word.strip()
    a = 0
    for i in range(0, len(word)):
        a = a | (1<<letterMap[word[i]])
    return a

def doesNotContainMap(letters):
    a = ~0
    for i in letters:
        a = a ^ (1<<letterMap[i])
    return a

def clean(wordList, letters, mustLetter):
    filterNum = doesNotContainMap(letters)
    mustNum = 1<<letterMap[mustLetter]
    numList = []
    for i in range(0, len(wordList)):
        numList.append(bitIfy(wordList[i]))
    
    cleanList = []
    for i in range(0, len(numList)):
        if (numList[i] & mustNum == mustNum) and (numList[i] & filterNum == 0) and (len(wordList[i]) >= 5):
            cleanList.append(wordList[i])
    
    return cleanList

with open("dictionary.txt", "r") as wordlist:
    words = wordlist.readlines()


print(clean(words, ["t", "c", "i", "y", "a", "n", "r"], "y"))
