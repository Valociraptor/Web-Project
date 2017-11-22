from django.conf.urls import url, include
from . import views

urlpatterns = [
    url(r'^main$', views.index),
    url(r'^quotes$', views.quotes),
    url(r'^create', views.create),  #add a new quote
    url(r'^register', views.register),
    url(r'^login', views.login),
    url(r'^logout', views.logout),
    url(r'^favorite', views.favorite),
    url(r'^removefav', views.removefav), #favorite a quote
    url(r'^users/(?P<id>\d+)', views.users)

]