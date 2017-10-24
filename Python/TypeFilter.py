x = [5,5,5,5,5,5]

print type(x)

if type(x) == int:
    if x >= 100:
        print "That's a big number!"
    else:
        print "That's a small number"

elif type(x) == str:
    if len(x) >= 50:
        print "Long Sentence"
    else:
        print "Short Sentence"

elif type(x) == list:
    if len(x) >= 10:
        print "Big List!"
    else: 
        print "Short List"