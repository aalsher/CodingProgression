# Test for data type
def TypeList(x):
    newstring = ""
    sumofints = 0

    for element in range(0,len(x)):
        first = x[0]
        if type(x[element]) is str:
            newstring += x[element] + " "
        if type(x[element]) is int or type(x[element]) is float:
            sumofints += x[element]         

    if type(first) != type(element):
        print "The list you entered is of mixed type"
    elif type(first) == int and type(element) == int:
        print "The list you entered is of integer type"
    elif type(first) == str and type(element) == str:
        print "The list you entered is of string type" 

    print newstring
    print sumofints
TypeList(['magical unicorns',19,'hello',98.98,'world'])
