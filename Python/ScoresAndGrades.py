import random
random_num = random.randint(60,100)
def ScoresAndGrades(random_num):
    if random_num >= 60 and random_num <= 69:
        grade = "D"
    if random_num >= 70 and random_num <= 79:
        grade = "C"
    if random_num >= 80 and random_num <= 89:
        grade = "B"
    if random_num >= 90 and random_num <= 100:
        grade = "A"
    
    print "Score:", random_num, ";", "Your grade is", grade

ScoresAndGrades(random_num)