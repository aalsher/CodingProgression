from django.shortcuts import render, HttpResponse, redirect
from django.utils.crypto import get_random_string
from time import gmtime, strftime
from datetime import datetime

def index(request):

    if 'messages' not in request.session:
        request.session['messages'] = []
    return render(request,'session_words_app/index.html')

def add_word(request):

    if request.method == "POST":
        request.session['add_word'] = request.POST['add_word']
        request.session['colorchoice'] = request.POST['colorchoice']
        if 'bigfont'not in request.POST:
            request.session['bigfont']= 6
        else:
            request.session['bigfont']= 24

    new_word = {
        "word" : request.session['add_word'],
        "datetime": " - added at" + strftime('%b %d %Y %I:%M%p'),
        "color" : request.session['colorchoice'],
        "bigfont" : request.session['bigfont']
    }

    request.session['messages'].append(new_word)
    print new_word
    return redirect("/result")

def result(request):
    return render(request, 'session_words_app/index.html')

def clear(request):
    del request.session['messages']
    return redirect("/")
