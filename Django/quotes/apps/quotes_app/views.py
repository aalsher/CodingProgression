from django.shortcuts import render, HttpResponse, redirect
from django.utils.crypto import get_random_string
from django.contrib import messages
import datetime
from models import *

def index(request):
    print "at home page"
    return render(request,'quotes_app/index.html')

def register(request):
    print "I am at the register page"
    results = Users.objects.basic_validator(request.POST)
    if results[0]: #no errors
        request.session['user_id']= results[1].id
        print "I am registered"
        return redirect("main/")
    else:
        print results[1]
        for key, val in results[1].iteritems():
            print key, val
            messages.error(request, val)
        return redirect("main/")

    results2 = Users.objects.date_of_birth_validator(request.POST)
    if results2[0]: #no errors
        request.session['user_id']= results2[1].id
        print "I am registered"
        return redirect("main/")
    else:
        print results2[1]
        for key, val in results2[1].iteritems():
            print key, val
            messages.error(request, val)
        return redirect("main/")

def login(request):
    results = Users.objects.validate_login(request.POST)
    if results[0]:
        #login was successful
        request.session['user_id'] = results[1].id
        user_id = request.session['user_id']
        print "logged in"
        return redirect("quotes/")
    else:
        #login not successful
        return redirect("main/")

def logout(request):
    del request.session['user_id']
    del request.session['count']
    return redirect ("main/")

def quotes(request):

    user_favorited_quotes = set(Users.objects.get(id= request.session['user_id']).favorited_quotes.all())

    print user_favorited_quotes

    all_quotes = set(Quotes.objects.all())
    print all_quotes

    all_quotes.difference_update(user_favorited_quotes)

    print all_quotes


    context = {
            "user": Users.objects.get(id=request.session['user_id']),
            "userfavorites" : Users.objects.get(id=request.session['user_id']).favorited_quotes.all(),
            "quotes": all_quotes,
}

    return render(request,'quotes_app/quotes.html', context)

def add_quote_post(request):
    # Quote validations
    results = Quotes.objects.quotes_validator(request.POST)
    if results[0]:
        #quotes validation successful

        print "got new trip"

        user = Users.objects.get(id = request.session['user_id'])

        print user

        quote = Quotes.objects.create(quoted_by = request.POST['quoted_by'], message = request.POST['message'], quote_uploader= user)

        print quote
        return redirect("/quotes/")

    else:
        #added quotes not successful
        print results[1]
        for key, val in results[1].iteritems():
            print key, val
            messages.error(request, val)
        return redirect("/quotes/")

def view_user(request, id):

    context = {"user" : Users.objects.get(id = id),
               "uploaded_quotes" : Users.objects.get(id = id).uploaded_quotes.all(),
               "count": Users.objects.get(id=id).uploaded_quotes.all().count()
    }

    return render(request,'quotes_app/view_user.html', context)


def favorite_quote(request, id):
    print "want to favorite a quote"

    quote = Quotes.objects.get(id=id)
    print quote

    user = Users.objects.get(id = request.session['user_id'])
    print user

    quote.favorited_user.add(user)

    print quote.favorited_user.all()

    return redirect("/quotes")

def favorite_quote_delete(request,id):
    print "want to delete a quote from favorites"

    quotes = Quotes.objects.all()

    user = Users.objects.get(id = request.session['user_id'])

    favorited_quote = Users.objects.get(id = request.session['user_id']).favorited_quotes.get(id=id)

    user.favorited_quotes.remove(favorited_quote)

    print user.favorited_quotes

    return redirect("/quotes")
