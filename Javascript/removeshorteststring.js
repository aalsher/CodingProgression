function removeshorter(arr,strlen){
    for(var i=0; i < arr.length; i++){
      console.log(arr[i].length);
        if (arr[i].length < strlen){
            for (var j=i; j<arr.length-1; j++){
                arr[j]=arr[j+1];
            }
          arr.pop();
          i--;
        }
    }
    return arr;
}

removeshorter(["Hello","Burrito","Hi","Happy"],3);
