from django.shortcuts import render, HttpResponse, redirect
from django.utils.crypto import get_random_string

def index(request):
    return render(request,'survey_form_app/index.html')

def process(request):
    if 'formsubmissions' in request.session:
        request.session['formsubmissions'] +=1
    else:
        request.session['formsubmissions'] = 0

    if request.method == "POST":
        request.session['name'] = request.POST['name']
        request.session['location'] = request.POST['location']
        request.session['language'] = request.POST['language']
        request.session['comment'] = request.POST['comment']
        return redirect("/result")
    else:
        return redirect("/")

def result(request):
    return render(request, 'survey_form_app/result.html')
