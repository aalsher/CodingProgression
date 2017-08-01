me = {"name": "Amina", "age": "55", "POB":"Egypt","favorite language":"Python"}
def GetDetails(dict):
    for k, v in me.iteritems():
        print "My", k, "is", v
GetDetails(me) 