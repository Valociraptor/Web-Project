def randomGrade():
    for i in range(0,10,1):   
        import random
        randvar = random.randint(50, 100)

        if randvar >= 60 and randvar <= 69:
            grade = "D"
        elif randvar >= 70 and randvar <= 79:
            grade = "C"
        elif randvar >= 80 and randvar <= 89:
            grade = "B"
        elif randvar >= 90 and randvar <= 100:
            grade = "A" 
        else:
            grade = "LOL YOU FAILED!"
        print "Score:",randvar,"; and your grade is: ",grade                   


randomGrade()
