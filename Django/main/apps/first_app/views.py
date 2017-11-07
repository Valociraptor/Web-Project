# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.shortcuts import render, HttpResponse, redirect

# Create your views here.

def index(request):
    response = "YO WHAT UP"
    return HttpResponse(response)


def test(request):
    response = "TEEEESTY BOOO"
    return HttpResponse(response)