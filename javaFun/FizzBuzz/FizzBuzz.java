


public class FizzBuzz {
    public String fizzBuzz(int number) {
        if(number % 3 == 0 && number % 5 != 0) {
            return "Fizz";
        } else if (number % 3 != 0 && number % 5 == 0 ) {
            return "Buzz";
        } else if (number % 3 == 0 && number % 5 == 0 ) {
            return "FizzBuzz";
        } else {
            return Integer.toString(number);
        }
    }
}



//public class FizzBuzz
//{
  //public String fizzBuzz (int number)
  //{
    //String s = "Fizz";
    //String k = "FizzBuzz";
    //String l = "Buzz";
    
    //if (number % 3 == 0 && number % 5 == 0) 
      // return k;
    
	
	//else if (number % 3 == 0)
    //  return s;
    
    
    //else if (number % 5 == 0)
      //  return l;
        
    
    //else 
      //  return Integer.toString(number);
    
    //}
  //}

