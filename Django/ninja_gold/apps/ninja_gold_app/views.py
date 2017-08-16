from django.shortcuts import render, HttpResponse, redirect
import random
from time import gmtime, strftime
from datetime import datetime

def index(request):

    if 'your_gold' not in request.session:
        request.session['your_gold'] = 0
    if 'activities' not in request.session:
        request.session['activities'] = []

    #
    # request.session['farm'] = 0
    # request.session['cave'] = 0
    # request.session['house'] = 0
    # request.session['casino'] = 0

    return render(request,'ninja_gold_app/index.html')

def process_money(request):
    # colors = {
    # "green" : 'green',
    # "red" : 'red'
    # }

    if request.method == "POST":
        if request.POST['building'] == 'farm':
            request.session['farm'] = random.randrange(10,20)
            request.session['your_gold'] += request.session['farm']
            if request.session['farm'] >= 0:
                str = "Earned {} gold from the {}!({})".format(request.session['farm'], request.POST['building'], strftime('%b %d %Y %I:%M%p'))
                request.session['activities'].append((str,"green"))

        if request.POST['building'] == 'cave':
            request.session['cave'] = random.randrange(5,10)
            request.session['your_gold'] += request.session['cave']
            if request.session['cave'] >= 0:
                str = "Earned {} gold from the {}!({})".format(request.session['cave'], request.POST['building'], strftime('%b %d %Y %I:%M%p'))
                request.session['activities'].append((str,"green"))

        if request.POST['building'] == 'house':
            request.session['house'] = random.randrange(2,5)
            request.session['your_gold'] += request.session['house']
            if request.session['house'] >= 0:
                str = "Earned {} gold from the {}!({})".format(request.session['house'], request.POST['building'], strftime('%b %d %Y %I:%M%p'))
                request.session['activities'].append((str, "green"))


        if request.POST['building'] == 'casino':
            request.session['casino'] = random.randrange(-50,50)
            request.session['your_gold'] += request.session['casino']
            if request.session['casino'] >= 0:
                str = "Earned {} gold from the {}!({})".format(request.session['casino'], request.POST['building'], strftime('%b %d %Y %I:%M%p'))
                request.session['activities'].append((str,"green"))

            if request.session['casino'] <= 0:
                str = "Entered a casino and lost {} golds... Ouch!({})".format(request.session['casino'], strftime('%b %d %Y %I:%M%p'))
                request.session['activities'].append((str,"red"))

    return redirect("/")
