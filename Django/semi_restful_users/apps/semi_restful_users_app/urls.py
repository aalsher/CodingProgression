from django.conf.urls import url
from . import views
urlpatterns = [
    url(r'^$', views.index),
    url(r'^new$', views.create_user_get),
    url(r'^create$', views.create_user_post),
    url(r'^(?P<id>\d+)$', views.user),
    url(r'^edit/(?P<id>\d+)$', views.edit_user_get),
    url(r'^patch/(?P<id>\d+)$', views.edit_user_post),
    url(r'^destroy/(?P<id>\d+)$', views.destroy),
]
