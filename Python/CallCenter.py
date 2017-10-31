
class Call(object):
    queue = 0
    calls = []
    def __init__(self, id, name, pnumber, time, reason):
        self.id = id
        self.name = name
        self.pnumber = pnumber
        self.time = time
        self.reason = reason
        self.display()
        Call.queue += 1
        Call.calls += [self.id]
        print Call.calls

    
    def display(self):
        print "___Call ID#: {}___".format(self.id)
        print "Caller Name: {}".format(self.name)
        print "Phone Number: {}".format(self.pnumber)
        print "Timestamp: {}".format(self.time)
        print "Reason For Call: {}".format(self.reason)
        print "\n"
        return self

class CallCenter(object):

    def __init__(self):
        self.calls = Call.calls
        self.queuesize = self.get_queuesize()

    def get_queuesize(self):
        return len(self.calls)
    
    def add(self, id, name, pnumber, time, reason):
        #self.calls.append(newcallid)
        newcall = Call(id, name, pnumber, time, reason)
        Call.queue += 1
    
    def info(self):
        print self.calls

    def remove(self, callid):
        self.calls.remove(callid)
        print self.calls



firstcall= Call(23423, "Chawesome", 4801234567, "12:05:07 PM", "House is on fire")
secondcall = Call(23424, "Brad", 4808974567, "12:06:17 PM", "Bees in my hair")



Amazon = CallCenter()

print Amazon.get_queuesize()
Amazon.add(23425, "Keelay", 4802224567, "12:08:52 PM", "Lost Duckling")
Amazon.add()
Amazon.add()

print Amazon.get_queuesize()
Amazon.remove(23425)

print Call.queue