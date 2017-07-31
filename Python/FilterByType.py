#Integer
def TestType(thing):
    if isinstance(thing, int):
        if thing >= 100:
            print "That's a big number!"
        if thing < 100:
            print "That's a small number"

    elif isinstance(thing, str):
        if len(thing) >= 50:
            print "Long Sentence"
        if len(thing) < 50:
            print "Short Sentence"
    
    elif isinstance(thing, list):
        if len(thing) >= 10:
            print "Big List!"
        if len(thing) < 10:
            print "Short List"

TestType([1,2,4,"yeah",0])
