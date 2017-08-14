from django.shortcuts import render, HttpResponse, redirect
# the index function is called when root is visited
def index(request):
    response="Placeholder to later display all the lists of users"
    return HttpResponse(response)

def register(request):
    response = "Placeholder for users to create a new record"
    return HttpResponse(response)

def login(request):
    response = "Placeholder for users to login"
    return HttpResponse(response)
