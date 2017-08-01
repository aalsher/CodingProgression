def FindChars(list1,char):
    letters = set(char)
    for element in list1:
        if letters & set(element):
            print element
            
FindChars(['hello','world','my','name','is','Anna'],'o')

        
        