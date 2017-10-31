class bike(object):
    def __init__(self, name, price, max_speed, miles):
        self.name = name
        self.price = price
        self.max_speed = max_speed
        self.miles = 0
        if self.miles < 0:
            self.miles = 0
    
    def displayInfo(self):
        print "****Bike:", self.name, "****    ", "Price:", self.price,"|", "Max Speed:", self.max_speed,"|", "Miles:", self.miles
        return self

    def ride(self):
        self.miles +=10
        print "RIIIIIDING", self.name, "bike!"
        return self
    
    def reverse(self):
        self.miles -=5
        print self.name, "BACK IT UP, BACK IT UP!"
        if self.miles < 0:
            self.miles = 0
        return self

def bikeStats(bike):
    print "****Bike:", bike.name, "****    ", "Price:", bike.price,"|", "Max Speed:", bike.max_speed,"|", "Miles:", bike.miles
    

ShinyRed = bike("Shiny Red Flyer",100.00, "20mph", 0)
bike.displayInfo(ShinyRed)

NeonBlue = bike("Blue Meanie",150.00, "25mph", 0)
bike.displayInfo(NeonBlue)

DarkBlack = bike("The Eviscerator",300.00, "40mph", 20)
bike.displayInfo(DarkBlack)

bike.ride(ShinyRed).ride().ride().reverse().displayInfo()
bike.ride(NeonBlue).ride().reverse().reverse().displayInfo()
bike.reverse(DarkBlack).reverse().reverse().displayInfo()
