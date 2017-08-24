# -*- coding: utf-8 -*-
# Generated by Django 1.11.4 on 2017-08-24 16:04
from __future__ import unicode_literals

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Quotes',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('quoted_by', models.CharField(max_length=255)),
                ('message', models.CharField(max_length=1)),
                ('created_at', models.DateTimeField(auto_now_add=True)),
                ('updated_at', models.DateTimeField(auto_now=True)),
            ],
        ),
        migrations.CreateModel(
            name='Users',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=255)),
                ('alias', models.CharField(max_length=255)),
                ('email', models.CharField(max_length=255)),
                ('password', models.CharField(default='PASSWD', max_length=255)),
                ('date_of_birth', models.DateField(default=True)),
                ('created_at', models.DateTimeField(auto_now_add=True)),
                ('updated_at', models.DateTimeField(auto_now=True)),
            ],
        ),
        migrations.AddField(
            model_name='quotes',
            name='favorited_user',
            field=models.ManyToManyField(related_name='favorited_quotes', to='quotes_app.Users'),
        ),
        migrations.AddField(
            model_name='quotes',
            name='quote_uploader',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='uploaded_quotes', to='quotes_app.Users'),
        ),
    ]
