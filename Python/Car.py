class car(object):
    def __init__(self, name, price, speed, fuel, mileage):
        self.name = name
        self.price = price
        self.speed = speed
        self.fuel = fuel
        self.mileage = mileage
        self.tax = "12%"
        if self.price > 20000.00:
            self.tax = "15%"
        self.displayInfo()
    
    def displayInfo(self):
        print "****Model:", self.name, "****    "
        print "Price:", self.price
        print "Speed:", self.speed
        print "Fuel Type:", self.fuel
        print "Mileage:", self.mileage
        print "Tax Rate:", self.tax
        print "\n"
        return self

KiaTickles = car("Kia Tickles", 15000.00, "140mph", "Gasoline", 0)
FordFosterchild = car("Ford Foster Child", 25000.00, "155mph", "Gasoline", 0)
ChevyDitchrat = car("Chevy Ditch Rat", 10000.00, "155mph", "Diesel", 50000)
BMW666 = car("BMW 666", 45000.00, "175mph", "Gasoline", 0)
TeslaBurninator = car("Tesla Burninator", 50000.00, "140mph", "Electric", 0)
Tractor = car("John Deer Tractor", 35000.00, "80mph", "Diesel", 75000)