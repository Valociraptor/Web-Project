import random



def coinToss():
    heads = 0
    tails = 0
    for i in range(1,2001,1):
        randvar = random.random()
        randvar = round(randvar)

        if randvar == 0:
            tails += 1
            print "Attempt #", i, ": Throwing a coin..... It's TAILS!  Got",tails, "tails and", heads, "heads so far!" 
        else:
            heads += 1
            print "Attempt #", i, ": Throwing a coin..... It's HEADS!  Got",tails, "tails and", heads, "heads so far!"
    print "The percentage of tails was ultimately", tails/2000.00, "%"

coinToss()