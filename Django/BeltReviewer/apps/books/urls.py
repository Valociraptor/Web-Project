from django.conf.urls import url, include
from . import views


urlpatterns = [
    url(r'^$', views.index),
    url(r'^books$', views.books),
    url(r'^add$', views.add),
    url(r'^create', views.create),
    url(r'^register', views.register),
    url(r'^login', views.login),
    url(r'^logout', views.logout),
    url(r'^destroy/(?P<id>\d+)$', views.destroy),
    url(r'^books/(?P<id>\d+)$', views.abook),
    url(r'^users/(?P<id>\d+)$', views.users),

]