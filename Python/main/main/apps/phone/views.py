from __future__ import unicode_literals
from django.shortcuts import render, redirect, HttpResponse
from django.contrib import messages
from models import *

def index(request):
    return render(request, "phone/index.html")

def land_here(request):  #login/registration page

    return render(request,"phone/land_here.html")

def register(request):  #insert rout for a new user

    return redirect('/home')

def login(request):  #login route for existing users
    result = User.objects.login(request.POST)
    request.session['user_id'] = result[1].id
    if result[0]:
        return redirect('/home')
    else:
        for error in result[1]:
            messages.add_message(request, messages.INFO, error)
        return redirect('/')

def home(request):  #route for adding a new phone tool to profile page

    return render(request,'phone/home.html')