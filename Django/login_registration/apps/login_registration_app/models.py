from __future__ import unicode_literals
from django.db import models
import re
import bcrypt
  # Create your models here.
class UsersManager(models.Manager):
    def basic_validator(self, postData):
        flag = True;
        errors = {}
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        if len(postData['first_name']) < 2:
            errors["first_name"] = "First name should be more than 5 characters"
            flag = False;
        if len(postData['last_name']) < 2:
            errors["last_name"] = "Last name should be more than 5 characters"
            flag= False;
        if len(postData['email']) <5:
            errors["email"] = "Email must be longer than 5 characters"
            flag =False;
        if not EMAIL_REGEX.match(postData['email']):
            errors["email"] = "Email must be a valid email address"
            flag = False;
        if len(postData['password']) < 8:
            errors["first_name"] = "Password should be more than 8 characters"
            flag = False;
        if postData['password'] != postData['confirm_password']:
            errors['confirm_password'] = "Passwords do not match"
            flag = False;

        if flag:
            hash1 = bcrypt.hashpw(postData['password'].encode(), bcrypt.gensalt())
            u = Users.objects.create(first_name = postData['first_name'], last_name = postData['last_name'], email = postData['email'], password= hash1)
            return(flag, u)
        else:
            return(flag, errors)

    def validate_login(self, postData):
        #does email exist
        user = Users.objects.get(email = postData['login_email'])

        if user:
            print user
            print user.password
            if bcrypt.checkpw(postData['login_password'].encode(), user.password.encode()):
                return(True, user)
            else:
                return(False)

class Users(models.Model):

    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    email = models.CharField(max_length=255)
    password = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add = True)
    updated_at = models.DateTimeField(auto_now = True)
    objects = UsersManager()
    def __repr__(self):
      return "<Users object: {} {}>".format(self.first_name, self.last_name)
