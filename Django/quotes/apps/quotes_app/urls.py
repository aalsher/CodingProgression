from django.conf.urls import url
from . import views
urlpatterns = [
    url(r'^main/$', views.index),
    url(r'^create$', views.register),
    url(r'^login$', views.login),
    url(r'^logout$', views.logout),
    url(r'^quotes/$', views.quotes),
    url(r'^quotes/newquote/$', views.add_quote_post),
    url(r'^users/(?P<id>\d+)$', views.view_user),
    url(r'^quotes/favorite/(?P<id>\d+)$', views.favorite_quote),
    url(r'^quotes/favorite/delete/(?P<id>\d+)$', views.favorite_quote_delete),
]
