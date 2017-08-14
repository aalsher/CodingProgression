from django.shortcuts import render, HttpResponse, redirect
# the index function is called when root is visited
def index(request):
    response = "Placeholder to display all the surveys created"
    return HttpResponse(response)

def new(request):
    response = "Placeholder to add a new survey"
    return HttpResponse(response)
