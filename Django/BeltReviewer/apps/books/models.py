# -*- coding: utf-8 -*-
from __future__ import unicode_literals
from django.contrib.messages import error
from django.shortcuts import render, redirect, HttpResponse
from django.contrib import messages
from django.db import models
import re
import bcrypt

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9\.\+_-]+@[a-zA-Z0-9\._-]+\.[a-zA-Z]*$')

# Create your models here.

class UserManager(models.Manager):
    def validate(self, POST):
        errors = []


        try:
            new_user = User.objects.get(email = POST['email'])
        except:
        
            if len(POST['name']) < 1:
                errors.append('Put a name in ya dummy')
            if len(POST['alias']) < 1:
                errors.append('Pick an alias dum dum')
            if not re.match(EMAIL_REGEX, POST['email']):
                errors.append("Don't play coy, you know how emails work")
            if len(POST['password']) < 8:
                errors.append("Password. 8 characters. At least.")
            if POST['password'] != POST['cpassword']:
                errors.append("Passwords need to match bruh")
            if len(errors) > 0:
                return (False, errors)

            else:
                
                new_user = User.objects.create(
                    name = POST['name'],
                    alias = POST['alias'],
                    email = POST['email'],
                    password =  bcrypt.hashpw(POST['password'].encode(), bcrypt.gensalt())
                )

                
                return (True, new_user)

        errors.append("This user already exists!")
        return (False, errors)
        
    def validatelogin(self, POST):
        errors = []
        try: 
            user = User.objects.get(email = POST['email']) 

            if not bcrypt.checkpw(POST['password'].encode(), user.password.encode()):
                errors.append("The password you have entered is incorrect")
                return (False, errors)
            else:
                return (True, user)
        
        except:
            errors.append("The email you entered doesn't match anything in our database!")
        return (False, errors)

class BookManager(models.Manager):
    def validate(self, POST):
        errors = []
        if len(POST['author']) > 0:
            finalauthor = POST['author']
        else:
            finalauthor = POST['existingauthor']

        try:
            new_book = Book.objects.get(title = POST['title'])
        except:
            new_book = Book.objects.create(
                title = POST['title'],
                author = finalauthor
            )
           

            new_review = Review.objects.create(
                review = POST['review'],
                rating = POST['rating'],
                userid = User.objects.get(id=POST['userid']),
                bookid = new_book
            )
        
            return (True, new_book)
        errors.append("This book already exists in the database!")
        return (False, errors)



class ReviewManager(models.Manager):
    def makereview(self, POST):
        new_review = Review.objects.create(
            review = POST['review'],
            rating = POST['rating'],
            userid = User.objects.get(id=POST['userid']),
            bookid = Book.objects.get(id=POST['bookid'])
        )    
        return(new_review)



#User table
class User(models.Model):
    
    name = models.CharField(max_length=255)
    email = models.CharField(max_length=255)
    alias = models.CharField(max_length=255)
    password = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    objects = UserManager()
    

    def __str__(self):
        return self.name

#Book Table
class Book(models.Model):
    title = models.CharField(max_length=255)
    author = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    objects = BookManager()

    def __str__(self):
        return self.title

#Review/Rating Table

class Review(models.Model):
    review = models.TextField()
    rating = models.IntegerField()
    userid = models.ForeignKey(User, related_name="userreviews")
    bookid = models.ForeignKey(Book, related_name="bookreviews")
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    objects = ReviewManager()

    def __str__(self):
        return self.rating