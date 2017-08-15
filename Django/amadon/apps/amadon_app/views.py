from django.shortcuts import render, HttpResponse, redirect


def index(request):

    if 'total_quantity' not in request.session:
        request.session['total_quantity'] = 0
    if 'total_price' not in request.session:
        request.session['total_price']= 0

    return render(request,'amadon_app/index.html')

def add_items(request):
    prices = {
        "1001": 19.99,
        "1002": 29.99,
        "1003": 4.99,
        "1004": 49.99
    }

    if request.method == "POST":
        request.session['price_charged'] = float(prices[request.POST['product_id']]) * int(request.POST['quantity'])


    request.session['total_price']+= int(request.POST['quantity']) * float(prices[request.POST['product_id']])
    request.session['total_quantity'] += int(request.POST['quantity'])

    return redirect("/amadon/check_out")

def check_out(request):
    return render(request, 'amadon_app/checkout.html')
