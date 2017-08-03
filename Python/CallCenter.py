#track a call every time it comes in
#store calls in a queue as they wait to speak 

#create class Call
class Call(object):
#init method
    def __init__(self,idnum,name,phone,time,reason):
        #attributes: unique id, caller name, caller phone number, time of call, reason for call
        self.idnum = idnum
        self.name = name
        self.phone =phone
        self.time = time
        self.reason = reason
    #methods: display all call attributes
    def displayall(self):
        print self.idnum
        print self.name
        print self.phone
        print self.time
        print self.reason

#create class Callcenter
class CallCenter(object):
    def __init__(self):
        self.calls = []
        self.queuesize = 0
    
    #methods: add adds a new call to the end of the list
    def addcall(self,call):
        self.queuesize += 1
        self.calls.append(call)
        return self

    #remove: removes call from beginning of list (index 0)
    def removecall(self):
        self.queuesize -=1
        self.calls.pop(0)
        return self
    
    def removespeccall(self,phone):
        for x in self.calls:
            if x.phone == phone:
                self.calls -= x
        return self

    #info: prints name and phone number for 
    #each call in queue, length of queue
    def displayinfo(self):
        print self.name
        print self.phone
        print self.queuesize
        return self

call1 = Call( 1, "Rana", "222-222-2222", "12:30", "health inquiry")
call2 = Call( 2, "Mona", "111-111-1111", "09:30", "injury")
call3 = Call( 3, "Adam", "333-333-3333", "4:30", "injury")
call4 = Call( 3, "Adam", "444-444-4444", "5:00", "injury")

Center = CallCenter()
Center.addcall(call1)
Center.addcall(call2)
Center.addcall(call3)
Center.addcall(call4)
Center.removespeccall("111-111-1111")

print Center.calls
for x in Center.calls:
    print x.displayall()
        

    
