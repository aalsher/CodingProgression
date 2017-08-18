from django.shortcuts import render, HttpResponse, redirect
from django.utils.crypto import get_random_string
from django.contrib import messages
from models import *

def index(request):

    return render(request,'success_app/success.html')
