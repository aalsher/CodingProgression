from __future__ import unicode_literals
from django.db import models
from datetime import date
import time
import bcrypt
import re

class UsersManager(models.Manager):
    def basic_validator(self, postData):
        flag = True;
        errors = {}
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

        print postData
        if len(postData['name']) < 2:
            errors["name"] = "Name should be more than 2 characters"
            flag = False;
        if len(postData['alias']) < 3:
            errors["alias"] = "Alias should be more than 2 characters"
            flag = False;
        if len(postData['password']) < 8:
            errors["password"] = "Password should be more than 8 characters"
            flag = False;
        if postData['password'] != postData['confirm_password']:
            errors['confirm_password'] = "Passwords do not match"
            flag = False;
        if len(postData['email']) <5:
            errors["email"] = "Email must be longer than 5 characters"
        if not EMAIL_REGEX.match(postData['email']):
            errors["email"] = "Email must be a valid email address"

        if flag:
            hash1 = bcrypt.hashpw(postData['password'].encode(), bcrypt.gensalt())
            u = Users.objects.create(name = postData['name'], alias= postData['alias'], email = postData['email'], date_of_birth= postData['date_of_birth'],password= hash1)
            return(flag, u)
        else:
            return(flag, errors)

        try:
            datetime.datetime.strptime(date_text, '%m-%d-%Y')
        except:
            errors["date_of_birth"] = "Date of birth entered in incorrect format"

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

class QuotesManager(models.Manager):
    def quotes_validator(self, postData):
        flag = True;
        errors = {}
        print postData
        if len(postData['quoted_by']) < 3:
            errors["quoted_by"] = "Quoted by should be more than 3 characters"
            flag = False;
        if len(postData['message']) < 10:
            errors["message"] = "Message should be more than 10 characters"
            flag = False;

        return(flag, errors)

class Users(models.Model):
    name = models.CharField(max_length=255)
    alias = models.CharField(max_length=255)
    email = models.CharField(max_length=255)
    password = models.CharField(max_length=255, default='PASSWD')
    date_of_birth = models.DateField(default=True)
    created_at = models.DateTimeField(auto_now_add = True)
    updated_at = models.DateTimeField(auto_now = True)
    objects = UsersManager()
    def __repr__(self):
      return "<Users object: {} {}>".format(self.name, self.alias)

class Quotes(models.Model):
    quoted_by = models.CharField(max_length=255)
    message = models.CharField(max_length=1)
    created_at = models.DateTimeField(auto_now_add = True)
    updated_at = models.DateTimeField(auto_now = True)
    quote_uploader = models.ForeignKey(Users, related_name= "uploaded_quotes")
    favorited_user= models.ManyToManyField(Users, related_name="favorited_quotes")
    objects = QuotesManager()
    def __repr__(self):
        return "<Quotes object: {} {}>".format(self.quoted_by, self.message)
