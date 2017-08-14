from django.shortcuts import render, HttpResponse, redirect
from time import gmtime, strftime
from datetime import datetime

def index(request):
    # datetime_object = datetime.strptime('Jun 1 2005  1:33PM', '%b %d %Y %I:%M%p')
    context = {
    "date": strftime('%b %d %Y'),
    "time": strftime('%I:%M%p')
    }
    return render(request,'time_display_app/index.html', context)
