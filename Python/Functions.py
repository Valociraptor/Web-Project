#Odd/Even
def oddEven():
    for i in range(1, 2000, 2):
        print i,"- This number is odd"
        print (i+1),"- This number is even"


oddEven()

#Multiply
def multiply(arr, mult):
    newlist = []
    for x in range (0, len(arr), 1):
        newlist.append(arr[x] * mult)
    return newlist
        

result =  multiply([1,2,3,4],10)
print result