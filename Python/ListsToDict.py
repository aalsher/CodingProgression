name = ["Anna", "Eli", "Pariece", "Brendan", "Amy", "Shane", "Oscar"]
favorite_animal = ["horse", "cat", "spider", "giraffe", "ticks", "dolphins", "llamas"]

def make_dict(arr1, arr2):
    if len(arr1) == len(arr2):
        newdict = zip(arr1,arr2)
    if len(arr1) > len(arr2):
        newdict = zip(arr1, arr2)
    if len(arr1) < len(arr2):
        newdict = zip(arr2, arr1)

    print newdict

#   new_dict = dict(zip(name[0::2], favorite_animal[1::2]))
  

make_dict(name, favorite_animal)