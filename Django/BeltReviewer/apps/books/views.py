# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.shortcuts import render, redirect, HttpResponse
from models import *

# Create your views here.

def index(request):     #login/registration page
    if not 'id' in request.session:
        request.session['id'] = 0
    return render(request, "books/index.html")


def books(request):   #content area with all books/reviews
    
    user = User.objects.get(id=request.session['id'])
    books = Book.objects.all()
    reviews = Review.objects.all()
    context = {
        'user': user,
        'books': books,
        'reviews':reviews
    }

    return render(request, "books/books.html", context)


def add(request):  #page for adding new book/review
    
    return render(request, "books/add.html")


def create(request):   #insert route for a new book/review
    
    return redirect("/books")

def register(request):  #insert rout for a new user
    result = User.objects.validate(request.POST)

    if result[0]:
        request.session['id'] =  result[1].id          
        return redirect("/books")
    else:
        for error in result[1]:
            messages.add_message(request, messages.INFO, error)

    return redirect("/")

def login(request):  #login route for users
    result = User.objects.validatelogin(request.POST)

    if result[0]:
        request.session['id'] =  result[1].id        
        return redirect("/books")
    else:
        for error in result[1]:
            messages.add_message(request, messages.INFO, error)
    
    return redirect("/")

def destroy(request, id):       #route for deleting books/reviews
    
    return redirect("/books")


def abook (request, id): #page shows info on an individual review

    return render(request, "books/userbooks.html")

def users (request, id):  #page shows info on an individual user
    
    return render(request, "books/users.html")

def logout(request):   #logout route
    
    return redirect("/")