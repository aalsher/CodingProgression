# #Part I
students = [
    {'first_name':  'Michael', 'last_name' : 'Jordan'},
    {'first_name' : 'John', 'last_name' : 'Rosales'},
    {'first_name' : 'Mark', 'last_name' : 'Guillen'},
    {'first_name' : 'KB', 'last_name' : 'Tonel'}
]
def PrintNames(r):
    for i in range(0,(len(r))):
        print '{} {}'.format(r[i]['first_name'], r[i]['last_name'])

PrintNames(students)

#Part II
users = {
    'Students': [
    {'first_name':  'Michael', 'last_name' : 'Jordan'},
    {'first_name' : 'John', 'last_name' : 'Rosales'},
    {'first_name' : 'Mark', 'last_name' : 'Guillen'},
    {'first_name' : 'KB', 'last_name' : 'Tonel'}
  ],
 'Instructors': [
    {'first_name' : 'Michael', 'last_name' : 'Choi'},
    {'first_name' : 'Martin', 'last_name' : 'Puryear'}
  ]
 }

def PrintNames(r):
    print 'Students'
    for i in range(0,(len(r['Students']))):
        linenum = i +1
        charnum = len(r['Students'][i]['first_name'] + r['Students'][i]['last_name'])
        names = '{} {}'.format(r['Students'][i]['first_name'], r['Students'][i]['last_name'])
        print linenum, "-", names.upper(), "-", charnum       
    print 'Instructors'
    for i in range(0,(len(r['Instructors']))):
        linenum = i + 1
        charnum = len(r['Instructors'][i]['first_name'] + r['Instructors'][i]['last_name'])
        names = '{} {}'.format(r['Instructors'][i]['first_name'], r['Instructors'][i]['last_name'])
        print linenum, "-", names.upper() , "-", charnum       

PrintNames(users)

