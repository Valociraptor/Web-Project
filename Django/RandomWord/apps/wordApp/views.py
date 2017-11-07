# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.shortcuts import render, HttpResponse, redirect
from django.utils.crypto import get_random_string


# Create your views here.
def index(request):
    if not 'counter' in request.session:
        request.session['counter'] = 1
    context = {
        'randword':get_random_string(length=8)
    }

    request.session['counter'] += 1
    return render(request, "wordApp/index.html", context)

def reset(request):
    request.session['counter'] = 0

    return redirect("/")