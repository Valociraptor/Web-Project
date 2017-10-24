listy = ['magical unicorns',19,'hello',98.98,'world']

sum = 0
strang = ""
stryes = False
intyes = False
floatyes = False

for i in listy:    
    if type(i) == str:
        stryes = True
        strang = strang+" "+i
    elif type(i) == int:
        intyes = True
        sum += i
    elif type(i) == float:
        floatyes=True
        sum += i

if stryes == True and intyes == False and floatyes == False:
    print "THIS LIST IS STRANGY"
elif stryes == False and intyes == True and floatyes == False:
    print "THIS LIST IS INTEGERS"
elif stryes == False and intyes == False and floatyes == True:
    print "THIS LIST IS FLOATY"
elif stryes == False and intyes == True and floatyes == True:
    print "THIS LIST IS NUMBERS"
elif stryes == True and intyes == True and floatyes == False:
    print "THIS LIST IS MIXED"
elif stryes == True and intyes == True and floatyes == True:
    print "THIS LIST IS MIXED"
elif stryes == True and intyes == False and floatyes == True:
    print "THIS LIST IS MIXED"


print type(listy[0])
print strang
print sum



