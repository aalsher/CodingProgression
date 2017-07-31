#Integer
def CompareArrays(list_one, list_two):
    if len(list_one) != len(list_two):
        print "The lists are not the same"
        return
    same=""
    diff=""
    for element in range(0,len(list_one)):
        if list_one[element] != list_two[element]:
            diff= "The lists are not the same"
            print diff
            return
        else:
            same= "The lists are the same"
    print same
    

CompareArrays(['celery','carrots','bread','milk'], ['celery','carrots','bread','cream'])
