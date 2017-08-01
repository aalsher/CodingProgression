#Star Part I

def StarsPartI(list1):
    for element in list1:
        temp = ''
        for things in range(0,element):
            temp += str("*")
        print temp
StarsPartI([4, 6, 1, 3, 5, 7, 25])

#Star Part II
def StarsPartI(list1):
    for element in range (0,(len(list1))):
        if type(list1[element]) is int:
            tempint = ''           
            for x in range(0,(list1[element])):
                tempint += str("*")
            print tempint
        if type(list1[element]) is str:
            tempstr = ''        
            for x in range(0,(len(list1[element]))):
                tempstr += (list1[element][0])
            print tempstr.lower()
        
StarsPartI([4, "Tom", 1, "Michael", 5, 7, "Jimmy Smith"])
