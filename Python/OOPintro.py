class User(object):
    def __init__(self, name, email):
    # set some instance variables. just like any variable we can call these anything
        self.name = name
        self.email = email
        self.logged = False
    def login(self):
        self.logged = True
        print self.name + " is logged in."
        return self

Val = User("Val", "val@val.com")
Shroot = User("Shr00t", "shroot@shroot.com")

print Val.email, Val.name, Shroot.email, Shroot.name