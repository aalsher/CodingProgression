from __future__ import unicode_literals
from django.db import models
  # Create your models here.
class dojos(models.Model):
    name = models.CharField(max_length=255)
    desc = models.TextField(max_length=255, default='SOME STRING')
    city = models.CharField(max_length=255)
    state = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add = True)
    updated_at = models.DateTimeField(auto_now = True)
    def __repr__(self):
      return "<dojos object: {} {} {}>".format(self.name, self.city, self.state)

class ninjas(models.Model):
    first_name = models.CharField(max_length=255)
    desc = models.TextField(max_length=255, default='SOME STRING')
    last_name = models.CharField(max_length=255)
    Dojos = models.ForeignKey(dojos, related_name = "dojos")
    def __repr__(self):
      return "<ninjas object: {} {}>".format(self.first_name, self.last_name)
