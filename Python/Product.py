class Product(object):
    def __init__(self, price, itemname, weight, brand, cost, tax, status = "For Sale"):
        self.price = price
        self.itemname = itemname
        self.weight = weight
        self.brand = brand
        self.cost = cost
        self.tax = tax
        self.status = status
        self.returnitem()
        self.addtax()
        self.sell()
        
    def sell(self):
        if self.status == "For Sale":
            self.status = "Sold"
        return self
    
    def returnitem(self):
        if self.status == "Defective":
            self.price = 0

        if self.status == "Returned Like New":
            self.status = "For Sale"

        if self.status == "Returned in opened box":
            self.price = round(self.price - (self.price * 0.2))
        return self

    def addtax(self):
        self.tax = round((self.price * self.tax) + self.price, 2)
        return self
    
    def displayinfo(self):
        print "Price:", str(self.price)
        print "Item Name:", self.itemname
        print "Weight:", self.weight
        print "Brand:", self.brand
        print "Cost:", self.cost
        print "Status:", self.status
        print "Tax:", str(self.tax)
        return self

product1 = (Product(30000, "Expensive thing", "56kgs", "ExpensiveBrand", 300, 0.5,"Returned in opened box"))
product2 = (Product(500, "Expensive thing", "56kgs", "ExpensiveBrand", 300, 0.5,"Returned Like New"))
product3 = (Product(500, "Expensive thing", "56kgs", "ExpensiveBrand", 300, 0.5,"Defective"))
product4 = (Product(500, "Expensive thing", "56kgs", "ExpensiveBrand", 300, 0.5))

product1.displayinfo()
product2.displayinfo()
product3.displayinfo()
product4.displayinfo()

