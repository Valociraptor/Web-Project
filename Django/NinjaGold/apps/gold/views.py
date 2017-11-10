# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.shortcuts import render, redirect
import random
from time import gmtime, strftime
# Create your views here.

def index(request):
    request.session['gold'] = 0
    if not 'totalgold' in request.session:
        request.session['totalgold'] = 0

    if not 'activities' in request.session:        
        request.session['activities'] = [
            "I just woke up at {}".format(strftime("%Y-%m-%d %H:%M %p", gmtime()))
        ]

    return render(request, 'gold/index.html')

def process_money(request):
    
    if request.POST['building'] == 'farm':
        request.session['gold'] += random.randint(1,5)
        request.session['totalgold'] += request.session['gold']
        request.session['activities'].append("You just found {} gold at {}".format(request.session['gold'],strftime("%Y-%m-%d %H:%M %p", gmtime())))

    if request.POST['building'] == 'cave':
        request.session['gold'] += random.randint(10,20)
        request.session['totalgold'] += request.session['gold']
        request.session['activities'].append("You just found {} gold at {}".format(request.session['gold'],strftime("%Y-%m-%d %H:%M %p", gmtime())))

    if request.POST['building'] == 'house':
        request.session['gold'] += random.randint(50,100)
        request.session['totalgold'] += request.session['gold']
        request.session['activities'].append("You just found {} gold at {}".format(request.session['gold'],strftime("%Y-%m-%d %H:%M %p", gmtime())))

    if request.POST['building'] == 'casino':
        gamble = random.randint(0,1)
        if gamble == 1:
            request.session['gold'] = 1000
        else:
            request.session['gold'] = -1000
        request.session['totalgold'] += request.session['gold']
        request.session['activities'].append("You just found {} gold at {}".format(request.session['gold'],strftime("%Y-%m-%d %H:%M %p", gmtime())))

    return redirect('/')

def clear(request):
    request.session['totalgold'] = 0
    request.session['activities'] = []

    return redirect ('/')