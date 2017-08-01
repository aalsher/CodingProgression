import random
def CoinToss(numoftimes):
    headcount = 0
    tailscount = 0
    for x in range(0,numoftimes):
        random_num = random.random()
        random_num_rounded = round(random_num)

        if random_num_rounded == 1:
            v= "head"
            # headcount += 1
        if random_num_rounded == 0:
            v= "tails"
            # tailscount += 1
        if v is "head":
            headcount += 1
        if v is "tails":
            tailscount += 1

        print "Attempt #",x, ":", "Throwing a coin...", "It's a", v, "!", "...", "Got", headcount, "head(s)", "so far and", tailscount, "tails(s) so far"
        x += 1
CoinToss(5000)

