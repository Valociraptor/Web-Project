valDict = {
    "Name": "Val the Magnificent",
    "Age": "206 Years old",
    "Birth Country": "*Classified*",
    "Language" : "Esperanto"
}

def whoAmI():
    print "My name is",valDict["Name"]
    print "My age is", valDict["Age"]
    print "I was born in", valDict["Birth Country"]
    print "I speak", valDict["Language"]

whoAmI()

def reinvent(name, age, birthplace, language):
    valDict["Name"] = name
    valDict["Age"] = age
    valDict["Birth Country"] = birthplace
    valDict["Language"] = language

    print "My name is",valDict["Name"]
    print "My age is", valDict["Age"]
    print "I was born in", valDict["Birth Country"]
    print "I speak", valDict["Language"]

reinvent("Doodles", 5, "Topeka", "English")