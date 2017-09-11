// Pseudo code:
// 1- find middle (arr.length/2)
// 2- travel towards middle, track sums on two sides
// 3- if sums are ==, return middle index
// 4- else move both i and k right by 1 index until k= arr.length
// 5- if that does not return anything, move i and k left until i >= 0

function findBalInx(arr){
  var i =0;
  var k=arr.length-1;
  var isum = arr[i];
  var ksum = arr[k];
  var mid = arr.length/2;
  while(i+1 != mid){
    i++;
    ksum += arr[k];
  }
  if (isum == ksum){
    return mid;
  }
  while(k!= arr.length){
    i++;
    isum +=arr[i];
    ksum -=arr[k];
    k++;
    if(isum == ksum){
      return i+1;
    }
  }
  while(i >=0){
    k--;
    ksum += arr[k];
    isum -= arr[i];
    i--;
    if(isum == ksum){
      return i+1;
    }
  }
  return -1;
}
