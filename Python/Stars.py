def drawStars(listy):
    sky = ""

    for i in range(len(listy)):
        sky = ""

        if type(listy[i]) == str:
            for x in range (len(listy[i])):
                sky +=listy[i][0]
            print sky

        else:
            for x in range (listy[i]):
                sky += "*"
            print sky




drawStars([1,"food",4,6,4,"taco",2,"BBQ",12,6,8])