from django.conf.urls import url, include
from . import views

urlpatterns = [
    url(r'^$', views.index), #login page
    url(r'^register', views.register),
    url(r'^login', views.login),
    url(r'^home', views.home),
    url(r'^registration_page', views.land_here)
    
]