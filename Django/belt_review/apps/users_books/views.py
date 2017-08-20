from django.shortcuts import render, HttpResponse, redirect
from django.utils.crypto import get_random_string
from django.contrib import messages
from models import *

def index(request):
    print "att home page"
    return render(request,'users_books/index.html')

def register(request):
    print "I am here"
    results = Users.objects.basic_validator(request.POST)
    if results[0]: #no errors
        request.session['user_id']= results[1].id
        return redirect('/')
    else:
        print results[1]
        for key, val in results[1].iteritems():
            print key, val
            messages.error(request, val)
        return redirect("/")

def login(request):
    results = Users.objects.validate_login(request.POST)
    if results[0]:
        #login was successful
        request.session['user_id'] = results[1].id
        print "logged in"
        return redirect("/books")
    else:
        #login not successful
        return redirect("/")

def view_user(request, id):
    if request.method == "GET":
        context = {"users" : Users.objects.get(id = id)}
        print context
    return render(request,'users_books/view_user.html', context)

def books(request):
    return render(request,'users_books/books.html')

def add_book_get(request):
    print "to new book page"
    return render(request,'users_books/add_book.html')

def add_book_post(request):
    print "got new book"

    user = Users.objects.get(id = request.session['user_id'])

    print "got user"

    book = Books.objects.create(title = request.POST['title'], author = request.POST['author'])
    print book

    book.uploader_id = request.session['user_id']

    review = Reviews.objects.create(review = request.POST['review'], rating = request.POST['rating'])

    review.user_id = request.session['user_id']

    # review.book_id = Books.objects.get(id)

    print review
    return redirect("/books/" + str(book.id))

def view_book(reqeust, id):

    context = {"book" : Books.objects.get(id = id),
               "review" : Reviews.objects.get(id=id),
    }
    print book
    return render(request,'users_app/view_book.html', context)

def delete_book(request):
    pass
    # d = Users.objects.get(id = id)
    # d.delete()
    # return redirect("/users")

def add_review(request, id):
    print "got new review"
    #somehow needs to know to attach new review to present book
    # book = Book.objects.get(id=id)
    context = {"book" : Books.objects.get(id = id),
               "review" : Reviews.objects.get(id=id),
    }
    review = Reviews.objects.create(review = request.POST['review'], rating = request.POST['rating'], reviewed_book = Books.objects.get(id=id), reviewed_users = request.session['user_id'])
    return redirect("/books/" + str(book.id))

def delete_review(request,id):
    pass
