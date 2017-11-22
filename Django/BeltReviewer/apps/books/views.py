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

    if request.session['id'] != 0:
    
        user = User.objects.get(id=request.session['id'])
        
        books = Book.objects.all()
        
        reviews = Review.objects.all().order_by('-created_at')[:3]
        
        context = {
            'user': user,
            'books': books,
            'reviews':reviews
        }

        return render(request, "books/books.html", context)
    
    return redirect("/")


def add(request):  #page for adding new book/review

    books = Book.objects.all()
    context = {
        'books':books
    }
    
    return render(request, "books/add.html", context)


def create(request):   #insert route for a new book/review

    result = Book.objects.validate(request.POST)

    if result[0]:
        return redirect("/books")
    else:
        for error in result[1]:
            messages.add_message(request, messages.INFO, error)
    
    return redirect("/add")

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
    rev = Review.objects.get(id=id)
    rev.delete()
    
    return redirect("/books")


def abook (request, id): #page shows info on an individual review
    bid = int(id)
    reviews = Review.objects.filter(bookid=bid)
    book = Book.objects.get(id=bid)
    context = {
        'book':book,
        'reviews':reviews
    }

    return render(request, "books/userbooks.html", context)

def newreview (request):
    bookid = request.POST['bookid']
    result = Review.objects.makereview(request.POST)

    return redirect("/books/"+bookid)


def users (request, id):  #page shows info on an individual user

    user = User.objects.get(id=id)
    reviews = Review.objects.filter(userid=user)
    count = Review.objects.filter(userid=user).count()
    context = {
        'user':user,
        'reviews':reviews,
        'count': count 
    }
    
    return render(request, "books/users.html", context)

def logout(request):   #logout route

    request.session['id'] =0
    
    return redirect("/")