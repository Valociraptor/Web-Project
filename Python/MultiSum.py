#All odd numbers
for i in range(1, 50, 2):
    print i

#All multiples of 5
for x in range(5, 50, 5):
    print x

#Sum list
a = [1, 2, 5, 10, 255, 3]
sum = 0
for i in a:
    sum +=  i
    print sum

#Average
a = [1, 2, 5, 10, 255, 3]
avg = 0

for i in a:
    avg +=i
avg = avg/len(a)
print avg
        

