# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.shortcuts import render, redirect, HttpResponse
from models import *

# Create your views here.

def index(request):     #login/registration page
    if not 'id' in request.session:
        request.session['id'] = 0

    return render(request, "quotes/index.html")

def register(request):  #insert rout for a new user
    result = User.objects.validate(request.POST)

    if result[0]:
        request.session['id'] =  result[1].id          
        return redirect("/quotes")
    else:
        for error in result[1]:
            messages.add_message(request, messages.INFO, error)

    return redirect("/main")

def login(request):  #login route for users
    result = User.objects.validatelogin(request.POST)

    if result[0]:
        request.session['id'] =  result[1].id        
        return redirect("/quotes")
    else:
        for error in result[1]:
            messages.add_message(request, messages.INFO, error)
    
    return redirect("/main")


def quotes(request):
    
    if request.session['id'] != 0:
        
        id = request.session['id']
        
        quotes = Quote.objects.exclude(faved_by=id)
        user = User.objects.get(id=id)
        favorites = Quote.objects.filter(faved_by=id)
        context = {
            'user':user,
            'quotes':quotes,
            'favorites':favorites
        }

        return render(request, 'quotes/quotes.html', context) #displays quotes submitted and list of users' favorites

    return redirect("/main")


def create(request):
    result = Quote.objects.validate(request.POST)
    if result[0]:
        return redirect("/quotes")
    else:
        for error in result[1]:
            messages.add_message(request, messages.INFO, error)

    return redirect("/quotes") #submits a new quote to db

def favorite(request): #route adds a favorite to users' list of favorites and removes it from the general list

    result = Quote.objects.favorite(request.POST)

    return redirect("/quotes")

def users(request, id): #displays individual user info and their list of submitted quotes

    
    user = User.objects.get(id=id)
    quotes = Quote.objects.filter(uploader=id)
    count = Quote.objects.filter(uploader=id).count()

    context = {
        'user':user,
        'quotes':quotes,
        'count':count
    }

    return render(request, 'quotes/users.html', context)


def removefav(request): #removes a quote from the favs list and moves it back to the general list
    result = Quote.objects.unfavorite(request.POST)
    
    return redirect("/quotes")


def logout(request):   #logout route

    request.session['id'] =0
    
    return redirect("/main")
    
    



