#Find and Replace
words = "It's thanksgiving day. It's my birthday,too!"
print words.find('day')
print words.replace('day', 'month')
print "----------"

#Min and Max
x = [2,54,-2,7,12,98]
print min(x)
print max(x)
print "----------"

#First and Last
y = ["hello",2,54,-2,7,12,98,"world"]
print y[0], y[len(y)-1]
z = [y[0], y[len(y)-1]]
print z
print "----------"

#New List
q = [19,2,54,-2,7,12,98,32,10,-3,6]
q.sort()
print q

first_list = q[:len(q)/2] # optional first parameter of slice defaults to zero
second_list = q[len(q)/2:] # optional second parameter of slice defaults to the list's length
print "first list", first_list
print "second_list", second_list
second_list.insert(0,first_list)
print second_list


