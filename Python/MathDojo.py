class MathDojo(object):
    def __init__ (self):
        print "You have initialized math"
        self.result = 0
    

    def add(self,*a):
        for i in a:
            if type(i) == list or type(i) == tuple:
                for k in i:
                    self.result += k
            else:
                self.result += i
        return self
    

    def sub(self,*b):
        for i in b:
            if type(i) == list or type(i) == tuple:
                for k in i:
                    self.result -= k
            else:
                self.result -= i
        return self

    def results(self):
        print self.result
        return self
    
instance1 = MathDojo()

instance1.add([1], 3,4).add([3,5,7,8], [2,4.3,1.25]).sub(2, [2,3], [1.1,2.3]).results()
        