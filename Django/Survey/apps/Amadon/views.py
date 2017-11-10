# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.shortcuts import render, redirect, HttpResponse
from products import productlist

# Create your views here.

def index(request):
    request.session['thischarge'] = 0.0
    context = {
        "productlist" : productlist
    }
    if not 'totalcharge' in request.session:
        request.session['totalcharge'] = 0.0

    return render(request, "amadon/index.html", context)

def checkout(request):
    
    
    
    return render(request, "amadon/checkout.html")

def purchase(request, item_id):
    for item in productlist:
        if item['productid']==int(item_id):
            request.session['thischarge'] = item['price']*float(request.POST['quantity'])
            
    print request.session['thischarge']
    request.session['totalcharge'] += request.session['thischarge']
    

    print request.session['totalcharge']
    
    return redirect("/amadon/checkout/")
