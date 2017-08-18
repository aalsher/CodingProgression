from django.shortcuts import render, HttpResponse, redirect
from django.utils.crypto import get_random_string
from django.contrib import messages
from models import *

def index(request):

    return render(request,'login_registration_app/index.html')

def register(request):
    results = Users.objects.basic_validator(request.POST)
    if results[0]: #no errors
        request.session['user_id']= results[1].id
        return redirect('/success')
    else:
        print results[1]
        for key, val in results[1].iteritems():
            print key, val
            messages.error(request, val)
        return redirect("/lr")

def login(request):
    results = Users.objects.validate_login(request.POST)
    if results[0]:
        #login was successful
        request.session['user_id'] = results[1].id
        return redirect("/success")
    else:
        #login not successful
        return redirect("/lr")
