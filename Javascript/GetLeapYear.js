function getleapyear(year){
  if (year % 4 == 0 && year % 100 == 0){
  }
    return ("It's not a leap year!");
  }
  elseif (year %4 ==0 || year %400 == 0){
    return ("Its a leap year!");
  }
  else {
    return ("It's not a leap year");
  }
}
