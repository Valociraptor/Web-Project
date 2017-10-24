def makeDict(l1,l2):
    
    Dicty = zip(l1,l2)
    return dict(Dicty)
    # or........

    # Dicty = {}
    # for i in range(0,len(l1),1):
    #     Dicty[l1[i]] = l2[i]
    # return Dicty


print makeDict(["Anna", "Eli", "Pariece", "Brendan", "Amy", "Shane", "Oscar"], ["horse", "cat", "spider", "giraffe", "ticks", "dolphins", "llamas"])