class Bike(object):
    def __init__(self,price, max_speed, miles=0):
        self.price = price
        self.max_speed = max_speed
        self.miles = miles
        
    def displayinfo(self):
        print self.price
        print self.max_speed
        print self.miles
        return self

    def ride(self):
        print "Riding"
        self.miles += 10
        return self
    
    def reverse(self):
        print "Reversing"
        #prevent negatives
        if self.miles > 0:
            self.miles -= 5
        else:
            self.miles = 0
        return self

bike1 = (Bike("200", "25mph"))
# bike2 = (Bike("150", "25mph"))
# bike3 = (Bike("4000", "50mph"))
# bike1.ride().ride().ride().reverse().displayinfo()
# bike1.ride().ride().reverse().reverse().displayinfo()
bike1.reverse().reverse().reverse().displayinfo()
