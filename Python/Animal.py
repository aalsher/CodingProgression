#Animal Class

class Animal(object):
    #attributes: name, health
    def __init__(self, name, health):
        self.name = name
        self.health = health

    #methods: walk --> decreases health by 1
    def walk(self):
        self.health -= 1
        return self

    #run --> health decreases by 5
    def run(self):
        self.health -= 5
        return self
    
    #display health: print to the terminal the animals health
    def displayhealth(self):
        print self.health
        return self

#create an instance of animal, have it walk three times, run twice, and display health to confirm the health attribute has changed

# animal1 = (Animal("Cheetah", 50))
# animal1.walk().walk().walk().run().run().displayhealth()


#Create Dog Class- inherits everything from Animal
class Dog(Animal):
    def __init__(self,name,health):
        super(Dog,self).__init__(name, health)
        #attributes: default health of 150
        self.health = 150
    #methods: pet --> increases health by 5
    def pet(self):
        self.health += 5
        return self

#Create Dragon Class- inherits everything from Animal
class Dragon(Animal):
    def __init__(self):
        super(Dragon,self).__init__(name,health)
        #Dragon Attributes - default health of 170
        self.health = 170
    #methods: fly --> -= health by 10
    def fly(self):
        self.health -= 10
        return self
    #display health --> calls parent method, prints "I am a Dragon"
    def displayhealth(self):
        displayhealth()
        print display.health, "I am a dragon"
        return self

#have the Dog walk three times, run twice, pet once, and display health
# dog1 = Dog("Milo", 60)
# dog1.walk().walk().walk().run().run().pet().displayhealth()
#confirm dog class cannot fly
# dog1.fly()
# returns the following: "'Dog' object has no attribute 'fly'"

#create a new Animal
class Meerkat(Animal):
    def __init__(self):
        super(Meerkat,self).__init__(name, health)
        #Meerkat Attributes - default health of 5000
        self.health = 5000
    #methods: fly --> -= health by 10
    def forage(self):
        self.health += 50
        return self
    #display health --> calls parent method, displays something awesome
    def displayhealth(self):
        displayhealth()
        print display.health, "I am a Meerkat, I'm better than the Dragon"
        return self
#confirm it cannot call pet() and fly() methods
meerkat1 = Meerkat("Mew", 40)
meerkat1.pet().fly()
# returns the following: "'Meerkat' object has no attribute 'pet'""'Meerkat' object has no attribute 'pet'"
