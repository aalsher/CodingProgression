from django.shortcuts import render, HttpResponse, redirect
# the index function is called when root is visited
def index(request):
    response = "Placeholder to later display all the lists of blogs"
    return HttpResponse(response)

def new(request):
    response = "Placeholder to display a new form to create a new blog"
    return HttpResponse(response)

def create(request):
    return redirect("/blogs")

def show(request, blogid):
    print blogid
    return HttpResponse("Placeholder to display blog" + " " + blogid)

def edit(request, blogid):
    print blogid
    return HttpResponse("Placeholder to edit" +" " + blogid)

def destroy(request, blogid):
    return redirect("/blogs")
