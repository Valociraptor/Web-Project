
test_list = ['hello','world','my','name','is','Anna']
new_list = []
for i in range(0, len(test_list)):

    if test_list[i].find('o') != -1:
        new_list.append(test_list[i])

print new_list


