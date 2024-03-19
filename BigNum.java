public class BigNum {
    //creating the attributes of the class
    final private int MAX_DIGITS = 50;
   private int[] num = new int[MAX_DIGITS];

    public BigNum() {  //the empty builder
        num[0] = 0;
        for (int i = 1; i < MAX_DIGITS; i++)
            num[i] = -1;
    }

    public BigNum(long n) {  // the builder for the class that gets a long type number and insert his digits into the num attribute according to the instructions

        long temp = n;  //to get the number of digits of the long number
        int digits = 0;
        while (temp > 0) {
            digits++;
            temp = temp / 10;
        }
        if (n == 0) {
            num[0] = 0;
        } else {
            for (int i = digits - 1; i >= 0; i--) {
                num[i] = (int) (n % 10);
                n /= 10;
            }
        }
        if (num[0] == 0)
            digits++;
        for (int i = digits; i < MAX_DIGITS; i++)
            num[i] = -1;


    }

    public BigNum(BigNum n) {  //copy builder
        for (int i = 0; i < this.MAX_DIGITS; i++)
            this.num[i] = n.num[i];
    }


    public String toString() { // to string function that puts "," after every 3 digits from the right
        String s = "";
        int count = 0;
        int digit = getNumOfDigits() - 1;
        for (int i = digit; i >= 0; i--) {
            if (i == 0 && this.num[0] >= 10) {

                this.move();
                num[0] = num[i] / 10;
                num[1] = num[1] % 10;
            }

            s = num[i] + s;
            count++;
            if (count % 3 == 0 && i != 0)
                s = "," + s;
        }

        return s;
    }

    public int getNumOfDigits() {   //method to get the number of digits the number that the BigNum represent
        int digit = 0;
        while (digit < MAX_DIGITS && (num[digit] != -1)) {
            digit++;
        }

        return digit;
    }

    public boolean equals(BigNum n) { // equals method

        if (this.getNumOfDigits() != n.getNumOfDigits()) //if the number of digits is different so they are not equal and we can skip checking the cell value of the BigNums
            return false;

        for (int i = 0; i < this.getNumOfDigits(); i++)
            if (this.num[i] != n.num[i])
                return false;
        return true;

    }

    public BigNum add(BigNum n) { // add method gets a BigNum type object and retruns BigNum type object
        if(n.num[0]==0)
            return  new BigNum(this); // checking who is the bigger n or this to use the bigger one as the base in the add function
        BigNum small;
        BigNum big;
        if (this.getNumOfDigits() >= n.getNumOfDigits()) {
            big = new BigNum(this);
            small = new BigNum(n);
        } else {
            big = new BigNum(n);
            small = new BigNum(this);
        }
        for (int i = 0; i < small.getNumOfDigits(); i++) { //checking all the cells in the smaller BigNum and adding their value to the bigger BigNum

            big.num[big.getNumOfDigits() - 1 - i] = big.num[big.getNumOfDigits() - 1 - i] + small.num[small.getNumOfDigits() - 1 - i];
        }
        for (int i = big.getNumOfDigits() - 1; i >0; i--) { // if the value of the cell is bigger or equal to 10 we need to add 1 to the next cell and substart 10 from the cell ( the biggest value possible in the cell is 18 because 9+9 is 18 so there is no need to check for something bigger )
            if (big.num[i] > 9 && i != 0) {
                big.num[i] -= 10;
                big.num[i - 1]++;

            }
            if (big.getNumOfDigits() == MAX_DIGITS && big.num[0] >=10) //if in the last cell the number inside is bigger or equal 10 and his digits are MAXDIGITS so he is going to be bigger then we allow so we return null as instracted
                return null;

            if (big.num[i] > 9 && i == 0) {
                big.move(); // support method that i created to use here  that moves the cells one step to the right to create more space if possible  (for example from [1][1][0][-1][-1]... to [0][1][1][0][-1][-1]....
                big.num[1] -= 10;
                big.num[0]++;

            }


        }
        return new BigNum(big);


    }

    public BigNum add(int n) { //add method that gets an int and returns BigNum type object

        long x = n; // converting the int to long and then creating a BigNum to call the add function from before (that gets a BigNum and retruns a BigNum)
        BigNum temp = new BigNum(x);
        temp = this.add(temp);
        return new BigNum(temp);
    }

    public BigNum plusplus() {
        return this.add(1);
    } //the method gets nothing and returns BigNum type object. the method does a plus one to the BigNum using the add method from before


    public BigNum multiply(BigNum n) { // a multiply method gets a BigNum type object and returns a BigNum type object
        BigNum n1 = new BigNum(n); //creating copies of the n and this so i wont ruin their values
        BigNum this1 = new BigNum(this);
        int digit = this1.getNumOfDigits();
        this1 =this1.normal(); // a method i created to make the calculations easier that moves all the digits of the num to the right and get rid of the -1
        int n_digit = n1.getNumOfDigits();
       n1= n1.normal();
        BigNum answer = new BigNum();
        answer =answer.normal();
        for (int i = 0; i < digit; i++) {       //passing through every cell of the 2 BigNums (that has a value ) and multiplying them and storing the value in the right cell
            for (int j = 0; j < n_digit; j++) {

                answer.num[MAX_DIGITS - j - i - 1] = answer.num[MAX_DIGITS - j - i - 1] + this1.num[MAX_DIGITS - i - 1] * n1.num[MAX_DIGITS - j - 1];
                if (answer.num[MAX_DIGITS - j - i - 1] >= 10) { //if the cell value is bigger then 10 we need to seperate the value to tens digit and  units digit (or ones) and adding the tens digits in the next cell that represent them
                    if (answer.num[0] > 10) // because the cells are orginazed after the "normal" method they look like(for example the number 110) [0][0][0]....[1][1][0] so if the number in the last cell is bigger then 10 we are getting a number with more digits then MAXDIGITS so i return null
                        return null;
                    answer.num[MAX_DIGITS - j - i - 1 - 1] += answer.num[MAX_DIGITS - j - i - 1] / 10;
                    answer.num[MAX_DIGITS - j - i - 1] %= 10;

                }

            }
        }
        if(MAX_DIGITS - this.getNumOfDigits() != 0) { // used to return the BigNum to his usual (for example the number 110 ) from [0][0][0]....[1][1][0] to [1][1][0][0][0]....
            int counter = 0; //counter and the start veriables used to find the last digits of the number so it will skip the 0 digits of the number in numbers like 10 ,100,20000 and like the 0's are still part of the number so i need to know which 0 is part of the number and which isnt
            int start = 0;
            for (int i = 0; i < MAX_DIGITS; i++) {
                if (answer.num[i] != 0) {
                    start = i;
                    break;
                }
            }
            for (int i = start; i < MAX_DIGITS; i++) {
                answer.num[counter] = answer.num[i];
                answer.num[i] = 0;
                counter++;
            }
            for (int i = counter; i < MAX_DIGITS; i++) { // the not needed 0 are convorted back to -1
               if(i!=MAX_DIGITS-1)
                if (answer.num[i] == 0)
                    answer.num[i] = -1;
            }
            if(answer.num[MAX_DIGITS-2]==-1)
                answer.num[MAX_DIGITS-1]=-1;

        } // end of convertion prosses to return the BigNum as it should look like
        return answer;
    }

 private void move() //method to move the number one step to make move for calculations for example this =[1][1][0][-1][-1]....  in the end will look like [0][1][1][0][-1][-1]....
    {


        for (int i = this.getNumOfDigits() - 1; i >= 0; i--) {
            if (this.getNumOfDigits() != 50) {
                this.num[i + 1] = this.num[i];
            }

        }
        this.num[0] = 0;
    }

    private BigNum normal() { //a method i created to make the BigNum easier to calculate convert him to (for example 110)[0][0][0].....[1][1][0] just moves the digits with the MAXDIGITS and the digits of the number to the right
        BigNum temp = new BigNum(this);
        for (int i = 0; i < this.getNumOfDigits(); i++) {
            if (MAX_DIGITS - this.getNumOfDigits() != 0) {
                temp.num[MAX_DIGITS - this.getNumOfDigits() + i] = temp.num[i];
                temp.num[i] = 0;
            }
        }
        for (int i = 1; i < this.MAX_DIGITS; i++)
            if (temp.num[i] == -1)
                temp.num[i] = 0;
        return new BigNum(temp);
    }

    private int compare(BigNum n) { // a compare method i created to use in calculations get a BigNum and return 1 if this bigger then num -1 if otherwise and 0 if they are equal
        if (this.getNumOfDigits() > n.getNumOfDigits()) {
            return 1;
        }
        if (this.getNumOfDigits() < n.getNumOfDigits()) {
            return -1;
        }

        for (int i = 0; i < MAX_DIGITS; i++) {
            if (num[i] > n.num[i])
                return 1;
            if (num[i] < n.num[i])
                return -1;

        }
        return 0;
    }



    private BigNum divTwo() {  // div by 2 method i created to be used for calculations gets nothing returns BigNum type object
        BigNum temp = new BigNum(this);
        for (int i = 0; i < this.getNumOfDigits(); i++) {

            temp.num[i + 1] += (temp.num[i] % 2) * 10;
            temp.num[i] /= 2;

        }

        temp.num[this.getNumOfDigits()] = -1;
        if (temp.num[0] == 0)
            for (int i = 0; i < this.getNumOfDigits(); i++)
                temp.num[i] = temp.num[i + 1];

        return new BigNum(temp);
    }

    public BigNum mod(BigNum n) { // a mod function that works like this : finding the Quotient  that him multiply n(the Divisor  )will give the largest Quotient  possible that will give us a number smaller then this (a div function in short) using binary search to make it efficiant
        //and then finding the mod by adding a number(Remainder ) to the Quotient × Divisor untill we get this(the Dividend) (using binary search to find this number for efficensy and a good run time
       //Quotient × Divisor + Remainder = Dividend
        if(this.num[0]==0) // 0 mod anything is 0
            return new BigNum(0);
        if(n.num[0]==0) //anything mod 0 is impossible here couse 0 is undefined. returning null and printing a error massage on the screen
        {
            System.out.println("0 is undefined ");
            return null;
        }
        BigNum middle = new BigNum();
        if (this.compare(n) == -1)  //in case this is smaller then n the modulo is this
            return new BigNum(this);
        BigNum low = new BigNum(1);
        BigNum high = new BigNum(this);
        while (low.compare(high) != 1) {  //binary search to find the largest Quotient  that will give us a number smaller or equal to this (div function if there is no mod)
            if(high.add(low)!=null)
            middle = (high.add(low)).divTwo();
            else{
                System.out.println("the middle is out of bounds");  // cant calculate the middle becouse high and low has more diggits then MAX DIGGITS
                return null;
            }

            if ((middle.multiply(n)).compare(this) == 0) //if there is no modulo returns 0

                return new BigNum(0);
            if ((middle.multiply(n)).compare(this) == 1) {
                high = middle.minus(); // minus function i made to use for the binary search (substracts 1 from the number)

            } else {

                low= middle.plusplus();
            }

        }
        if ((middle.multiply(n)).compare(this) == 1)  //becouse unlike normal binary seach i am searching for a number that can be smaller and not equal to what i am looking it is possible to go one more round before exiting the binary search so in this case i reduce one with the minus function i made to adjast to it
            middle=middle.minus();
        if((middle.multiply(n)).compare(this) ==0)
            return new BigNum(0);
        BigNum temp = new BigNum(middle);  // starting the second binary search to find the reminder
        low = new BigNum(1);
        high = new BigNum(n);
        while (low.compare(high) != 1) {
            middle = (high.add(low)).divTwo();
            if (((temp.multiply(n)).add(middle)).compare(this) == 0) {
                return middle;
            } else if (((temp.multiply(n)).add(middle)).compare(this) == 1) {
                high = middle.minus();

            } else {
                if(low.compare(middle)==0)
                    break;
                low =new BigNum(middle);
            }

        }


        return new BigNum(middle);

    }

    private BigNum minus() {  // a minusminus type method i created to use in the binary search substrats one from the number represented in BigNum
        BigNum temp = new BigNum(this);
        if (temp.compare(new BigNum(0)) == 0) //specific case for 0
            return new BigNum(0);
        //specific case for 10
        if (temp.compare(new BigNum(10)) == 0) //if the number in the cell is 0 i change it to 9 (his right value after i substart one from the cell its possible to substract
            return new BigNum(9);
        for (int i = this.getNumOfDigits() - 1; i >= 0; i--) { //substracting one from the cell its possible to do so
            if (temp.num[i] >= 1) {
                temp.num[i]--;
                break;
            }
            if (temp.num[i] == 0) {
                temp.num[i] = 9;
            }
        }


        return new BigNum(temp);
    }

}

