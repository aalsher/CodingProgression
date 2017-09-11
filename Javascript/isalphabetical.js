function isAlpha(str){
    for(var i = 0; i <str.length; i++){
        if(str[i] > str[i+1]){
            return false;
        }
    }
    return true;
}

// Second way

function isAlpha(str){
    if (str.sort() === str){
        return.true;
    }
    return false;
}