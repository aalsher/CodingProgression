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
        print postData
        if len(postData['name']) < 2:
            errors["name"] = "Name should be more than 2 characters"
            flag = False;
        if len(postData['alias']) < 2:
            errors["alias"] = "Alias should be more than 2 characters"
            flag = False;
        if len(postData['email']) <5:
            errors["email"] = "Email must be longer than 5 characters"
            flag =False;
        if not EMAIL_REGEX.match(postData['email']):
            errors["email"] = "Email must be a valid email address"
            flag = False;
        if len(postData['password']) < 8:
            errors["password"] = "Password should be more than 8 characters"
            flag = False;
        if postData['password'] != postData['confirm_password']:
            errors['confirm_password'] = "Passwords do not match"
            flag = False;

        if flag:
            hash1 = bcrypt.hashpw(postData['password'].encode(), bcrypt.gensalt())
            u = Users.objects.create(name = postData['name'], alias = postData['alias'], email = postData['email'], password= hash1)
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
    name = models.CharField(max_length=255)
    alias = models.CharField(max_length=255)
    email = models.CharField(max_length=255)
    password = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add = True)
    updated_at = models.DateTimeField(auto_now = True)
    objects = UsersManager()
    def __repr__(self):
      return "<Users object: {} {}>".format(self.name, self.alias)

class Books(models.Model):
    title = models.CharField(max_length=255, default='TITLE')
    author = models.CharField(max_length=255, default='AUTHOR')
    created_at = models.DateTimeField(auto_now_add = True)
    updated_at = models.DateTimeField(auto_now = True)
    uploader = models.ManyToManyField(Users, related_name = "uploaded_books")
    def __repr__(self):
      return "<Books object: {} {}>".format(self.title, self.author)

class Reviews(models.Model):
    review = models.CharField(max_length=255)
    rating = models.CharField(max_length=1)
    created_at = models.DateTimeField(auto_now_add = True)
    updated_at = models.DateTimeField(auto_now = True)
    reviewed_users = models.ManyToManyField(Users, related_name= "reviewed_books")
    reviewed_book = models.ManyToManyField(Books, related_name= "book_reviews")
    def __repr__(self):
      return "<Reviews object: {} {}>".format(self.review, self.rating)

class Comments(models.Model):
    comment = models.TextField(max_length=255, default='COMMENT')
    created_at = models.DateTimeField(auto_now_add = True)
    updated_at = models.DateTimeField(auto_now = True)
    review = models.ForeignKey(Reviews, related_name = "commented_on_review")
    user = models.ForeignKey(Users, related_name= "comment_user")
    def __repr__(self):
      return "<Comments object: {} {}>".format(self.comment, self.created_at)
