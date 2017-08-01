#Odd/Even
def odd_even(first,last):
    for x in range(first,(last+1)):
        if x % 2 == 1:
            numtype = "This is an even number"
        elif x % 2 ==0:
            numtype = "This is an odd number"

        x += 1
        print "Number is", x, ".", numtype
        

odd_even(1, 2000)

#Multiply
def multiply(lst, multiplier):
    newlst = []
    for x in lst:
        y = x * multiplier
        newlst.append(y)
    print newlst
        
multiply([2,4,10,16], 5)

#Hacker Challenge

def multiply(arr, multiplier):
    newarr1 = []
    for x in arr:
        y = x * multiplier
        newarr1.append(y)
    return newarr1

def layered_multiples(arr):
    newarr2 = []
    for element in arr:
        temp = []
        for things in range(0,element):
            temp.append(1)

        # temp will go into newarr2
        newarr2.append(temp)

    return newarr2
    
print layered_multiples(multiply([2,4,5],3))


