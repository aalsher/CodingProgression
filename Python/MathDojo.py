#Part I
#create a python class called MathDojo
class MathDojo(object):
    def __init__(self, num1=0):
        self.num1 = num1

#methods: add and subtract, take at least 1 parameter
    def add(self,*num):
        self.num1 += sum(num)
        return self

    def subtract(self,*num):
        self.num1 -= sum(num)
        return self
    
    def result(self):
        print "Result:" + str(type(num))
        return self
#create new instance called md : MathDojo().add(2).add(2, 5).subtract(3, 2).result
md = MathDojo().add(2).add(2, 5).subtract(3, 2).num1
print md

#Part II
#modify MathDojo to take at least one integer(s) and/or list(s) as params
#with any number of values passed into the list

#create a python class called MathDojo
class MathDojo(object):
    def __init__(self, result=0):
        self.result = result

#methods: add and subtract, take at least 1 parameter
    def add(self,*num):
        for x in num:
            if type(x) is list or type(x) is tuple:
                self.result += sum(x)

            else:
                self.result += x
        return self

    def subtract(self,*num):
        for x in num:
            if type(x) is list or type(x) is tuple:
                self.result -= sum(x)
            else:
                self.result -= x
        return self
    
    def result(self):
        print "Result:" + self.result
        return self

md = MathDojo().add([1],3,4).add([3, 5, 7, 8], [2, 4.3, 1.25]).subtract(2, [2,3], [1.1, 2.3]).result
print md