# #1)Find and Replace

#Print position of "day"
my_string = "It's Thanksgiving day, It's my birthday,too!"
print my_string.find("day")

# #create a new string where "day" is replaced by "month"

my_new_string = "It's Thanksgiving day, It's my birthday,too!"
print my_new_string.replace("day", " month") 

#2)Min and Max
x = [2,54,-2,7,12,98]
print min(x)
print max(x)

#3)First and Last
x = ["hello",2,54,-2,7,12,98,"world"]
y = x[0]
z = x[-1]
newlist = y + " " + z 
print newlist

#4)New List
#Sort list first
original_list = [19,2,54,-2,7,12,98,32,10,-3,6]
original_list.sort()
#nest lists
first_half = original_list[:len(original_list)/2]
second_half = original_list[len(original_list)/2:]
new_list = [first_half] + second_half
print new_list


