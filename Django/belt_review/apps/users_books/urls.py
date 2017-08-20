from django.conf.urls import url
from . import views
urlpatterns = [
    url(r'^$', views.index),
    url(r'^create$', views.register),
    url(r'^login$', views.login),
    url(r'^users/(?P<id>\d+)$', views.view_user),
    url(r'^books/$', views.books),
    url(r'^books/add',views.add_book_get),
    url(r'^books/newbook/', views.add_book_post),
    url(r'^books/newreview/', views.add_review),
    url(r'^books/(?P<id>\d+)', views.view_book),
    url(r'^books/delete/(?P<id>\d+)$', views.delete_book),
    url(r'^books/delete/review/(?P<id>\d+)$', views.delete_review),
]
