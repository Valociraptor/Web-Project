class Hospital(object):

    def __init__ (self, name, capacity):
        self.name = name
        self.capacity = capacity
        self.patientlist = []
        self.totalpatients = 0
        self.roomnum = 0
        self.info()

    def info(self):
        print "****____Hospital Name: {}____****".format(self.name)
        print "Total number of patients: {}".format(self.totalpatients)
        print "Capacity: {}".format(self.capacity)
        print "\n"
        print "__List of Patients__"
        for i in range (len(self.patientlist)):
            print "Name: {}".format(self.patientlist[i]['name'])
            print "ID#: {}".format(self.patientlist[i]['idnum'])
            print "Allergies: {}".format(self.patientlist[i]['allergies'])
            print "Room Number: {}\n".format(self.patientlist[i]['roomnum'])
        print "\n"
        return self

    def admit(self, name, allergies):
        if self.totalpatients < self.capacity:
            newpatient = Patient(name, allergies, self.roomnum)
            self.totalpatients +=1
            self.roomnum +=1
            self.patientlist.append({"idnum":self.roomnum, "name":name, "allergies":allergies, "roomnum":self.roomnum})
        else:
            print "This hospital is at capacity\n"
        return self
    
    def discharge(self, idnum):
         self.totalpatients -=1
         print "Discharged patient {}!\n".format(self.patientlist[idnum]["name"])
         self.patientlist.pop(idnum-1)
         return self
   

class Patient(object):
    idnum = 0
    def __init__(self, name, allergies, roomnum):
        self.idnum = Patient.idnum
        self.name = name
        self.allergies = allergies
        self.roomnum = roomnum
        Patient.idnum +=1
        self.mo()

    def mo(self):
        print "***Admitted Patient Name and ID: {} ID# {}***".format(self.name, self.idnum)
        print "Allergies: {}".format(self.allergies)
        print "Room Number:{}\n".format(self.roomnum)
        return self


Hospital1 = Hospital("Our Mother of Instantaneous Death", 10)

Hospital1.admit("Jack", "bees").admit("John", "milk").admit("Jim", "strawberries").admit("Jayme", "none").admit("Julie", "none").admit("Jessica", "peanuts").admit("Jethrow", "wasps").admit("Blat", "tarps")

Hospital1.discharge(1).discharge(1).discharge(1).info()

Hospital1.admit("Bert", "none").admit("Betty", "cashews").admit("Beth", "beer").admit("Boris", "beans").admit("Boswell", "foil").admit("Barney", "celery").admit("Bishop", "cats").admit("Balthazaar", "seeds").info()
