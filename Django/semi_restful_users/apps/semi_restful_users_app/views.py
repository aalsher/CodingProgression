from django.shortcuts import render, HttpResponse, redirect
from django.utils.crypto import get_random_string
from django.contrib import messages
from models import *

def index(request):
    user = {"users" : Users.objects.all()}

    return render(request,'semi_restful_users_app/index.html', user)

# GET
def create_user_get(request):
    return render(request,'semi_restful_users_app/users_new.html')
#POST
def create_user_post(request):
    if request.method == "POST":
        errors= Users.objects.basic_validator(request.POST)
        if len(errors):
            print errors
            for tag, error in errors.iteritems():
                messages.error(request, error, extra_tags=tag)
            return redirect("/users/new")
        else:
            print 'no errors'
            u = Users.objects.create(first_name = request.POST['first_name'], last_name = request.POST['last_name'], email = request.POST['email'])
            return redirect('/users/'+ str(u.id))

def edit_user_get(request,id):
    context = {"users" : Users.objects.get(id = id)}
    return render(request,'semi_restful_users_app/users_edit.html',context)

def edit_user_post(request,id):
    errors= Users.objects.basic_validator(request.POST)
    if len(errors):
        print 'bye'
        for tag, error in errors.iteritems():
            messages.error(request, error, extra_tags=tag)
        return redirect("/users/edit/" +id)
    else:
        print 'hi'
        user = Users.objects.get(id = id)
        user.first_name = request.POST['first_name']
        user.last_name = request.POST['last_name']
        user.email = request.POST['email']
        user.save()

        return redirect('/users/'+id)

def user(request, id):
    if request.method == "GET":
        context = {"users" : Users.objects.get(id = id)}
        print user
        return render(request,'semi_restful_users_app/user.html', context)
    else:
        errors= Users.objects.basic_validator(request.POST)
        if len(errors):
            for tag, error in errors.iteritems():
                messages.error(request, error, extra_tags=tag)

        return redirect("/users/"+u.id)

def destroy(request,id):
    d = Users.objects.get(id = id)
    d.delete()
    return redirect("/users")
