class Car(object):
    def __init__(self, price, speed, fuel, mileage, tax=0):
        self.price = price
        self.speed = speed
        self.fuel = fuel
        self.mileage = mileage
        self.calctax()

    def displayall(self):
        print "Price:", str(self.price)
        print "Speed:", self.speed
        print "Fuel:", self.fuel
        print "Mileage:", self.mileage
        print "Tax:", self.tax
        return self

    def calctax(self):
        if self.price > 10000:
            self.tax = 0.15
        else:
            self.tax = 0.12
        return self

car1 = (Car(10000, "160mph","Full", "45mpg"))
car2 = (Car(5000, "70mph","Not Full", "105mpg"))
car3 = (Car(6500, "89mph","Kind of Full", "50mpg"))
car4 = (Car(20000, "60mph","Full", "45mpg"))
car5 = (Car(9000, "30mph","Full", "45mpg"))       
car6 = (Car(700000, "400mph","Full", "45mpg"))

car1.displayall()
car2.displayall()
car3.displayall()
car4.displayall()
car5.displayall()
car6.displayall()
