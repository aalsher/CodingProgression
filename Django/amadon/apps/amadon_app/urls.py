from django.conf.urls import url
from . import views
urlpatterns = [
    url(r'^$', views.index),
    url(r'^add_items$', views.add_items),
    url(r'^check_out$', views.check_out),
]
