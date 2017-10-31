class Animal(object):
    def __init__(self, name, health):
        self.name = name
        self.health = health
        self.displayHealth()

    def walk(self):
        self.health -=1
        return self

    def run(self):
        self.health -=5
        return self
    
    def displayHealth(self):
        print "{}'s health is {}!".format(self.name, self.health)
        return self



class Dog(Animal):
    def __init__(self, name, health): #needs ALL arguments
        super(Dog, self).__init__(name, health)#---- #needs all aruments except self and anything unique to child class, just wnatever needs to go to parent.  First part needs to be (ChildClass, self)
        self.health = 150
    
    def pet(self):
        self.health += 5
        return self

class Dragon(Animal):
    def __init__(self, name, health):
        super(Dragon, self).__init__(name, health)
        self.health = 170
    
    def fly(self):
        self.health -= 10
        return self




ferret = Animal("Ferret", 50)
dog = Dog("Dog", 50)
dragon = Dragon("Dragon", 50)

Animal.displayHealth(ferret)
Dog.displayHealth(dog)
Dragon.displayHealth(dragon)
Dragon.fly(dragon).displayHealth()
Dog.pet(dog).displayHealth()


