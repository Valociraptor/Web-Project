class Product(object):
    def __init__(self, name, price, weight, brand, cost):
        self.name = name
        self.price = price
        self.weight = weight
        self.brand = brand
        self.cost = cost
        self.salestatus = "New, For Sale"
        self.tax = 8
        self.returnReason = "This item has no return history"
        self.displayInfo()
    
    def sold(self):
        self.salestatus = "Sold!"
        return self
    
    def addTax(self, tax):
        if tax < 1:
            self.tax = tax
            print "Sales tax rate is now {}%".format(self.tax*100)
        else:
            print "Please enter tax amount as a decimal!"
        return self
    
    def returns(self, returnReason):
        if returnReason == "Defective":
            self.price  = 0.0
            self.salestatus = "Returned, not for sale!"
            self.returnReason = returnReason
        elif returnReason == "In Box, Like New":    
            self.salestatus = "Used, For Sale"
            self.returnReason = returnReason
            self.price *= .8
        elif returnReason == "Other":
            self.salestatus = "Returned, not for sale!"
            self.returnReason = returnReason
        else:
            print "You did not enter a valid return reason.  Valid return reasons are 'Defective', 'In Box, Like New', and 'Other'.  Please try again!"
        return self

    def displayInfo(self):
        print "----------", self.name,"----------"
        print "Price: ${}".format(self.price)
        print "Weight:", self.weight
        print "Brand:", self.brand
        print "Cost: ${}".format(self.cost)
        print "Sale Status:", self.salestatus
        print "Return Reason:", self.returnReason
        print "Tax Rate: {}%".format(self.tax)
        print "\n"
        return self




HandGrenade = Product("Hand Grenade", 5.00, "1lb", "Sparky Time", 1.50)
Chainsaw = Product("Chainsaw", 95.00, "6lbs", "Fluffy Hugs", 21.00)
Tiger = Product("Tiger", 5000.00, "300lbs", "Bear", 500.00)


Tiger.returns("Defective").displayInfo()
Tiger.addTax(.15).displayInfo()
Tiger.sold().displayInfo()

