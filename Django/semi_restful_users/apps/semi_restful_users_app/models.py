from __future__ import unicode_literals
from django.db import models
import re
  # Create your models here.
class UsersManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        if len(postData['first_name']) < 2:
            errors["first_name"] = "First name should be more than 5 characters"
        if len(postData['last_name']) < 2:
            errors["last_name"] = "Last name should be more than 5 characters"
        if len(postData['email']) <5:
            errors["email"] = "Email must be longer than 5 characters"
        if not EMAIL_REGEX.match(postData['email']):
            errors["email"] = "Email must be a valid email address"
        return errors;

class Users(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    email = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add = True)
    updated_at = models.DateTimeField(auto_now = True)
    objects = UsersManager()
    def __repr__(self):
      return "<Users object: {} {}>".format(self.first_name, self.last_name)
