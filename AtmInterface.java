import java.util.Scanner;

class AtmInterface {

    String name;
    String Username;
    String password;
    String Accountnumber;
    float balance = 1000;
    int transactions = 0;
    String transactionHistory = "";
    boolean isLoggedIn = false;

    //....rest ofthe class remains the same ...
        public static int takenInteger(int limit) {
            int input = 0;
            boolean flag = false;
    
            while (!flag) {
                try {
                    Scanner sc = new Scanner(System.in);
                    input = sc.nextInt();
                    flag = true;
    
                    if (flag && input > limit || input < 1) {
                        System.out.println("Choose the number between 1 to " + limit);
                        flag = false;
                    }
                } catch (Exception e) {
                    System.out.println("Enter only integer value.");
                    flag = false;
                }
            }
            return input;
        }

          public static void main(String[] args) {
            System.out.println("\n*******************WELCOME TO SAAKSHI ATM INTERFACE**********************");
            System.out.println("1.Register \n2.Exit");
            System.out.println("Choose one option :");
            int choose = takenInteger(2);
    
            if (choose == 1) {
            AtmInterface b = new AtmInterface();
                b.register();}
            }

    public void register(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter your name :");
        this.name = sc.nextLine();
        System.out.println("\nEnter your Username :");
        this.Username = sc.nextLine();
        System.out.println("\nEnter your password :");
        this.password = sc.nextLine();
        System.out.println("\n Enter yourAccountnumber :");
        this.Accountnumber = sc.nextLine();
        System.out.println("\n Registration successful . please log in to your bank Account");
    }
    public boolean login(){
        
        Scanner sc = new Scanner(System.in);
        while(! isLoggedIn){
            System.out.println("\n Enter your Username :");
            String inputUsername = sc.nextLine();
            if (inputUsername.equals(this.Username)){
                
                    System.out.println("\nEnter your password :");
                    String inputPassword = sc.nextLine();
                    if(inputPassword.equals(this.password)){
                      System.out.println("\n Login successful");
                      isLoggedIn = true;
                    }
                    else{
                        System.out.println("\nIncorrect password");
                    }
                } else{
                    System.out.println("\n Username not found");
                 }
            }
            return isLoggedIn;
        }
        public void Withdraw(){
            if(isLoggedIn){
          System.out.println("\n Enter Amount to withdraw :");
          Scanner sc = new Scanner(System.in);
        
          try{
            float amount = sc.nextFloat();
            if(balance >= amount) {
                transactions++;
                balance -= amount;
                System.out.println("\nwithdral successful :");
                String atr = amount + "Rs Withdrawn\n";
                transactionHistory = transactionHistory.concat(atr);
             }
             else{
                System.out.println(" \n Insufficient Balance.");
             }
            
               } catch(Exception e) {
                System.out.println("\n Invalid input.");
               }
            }else{
                System.out.println("\n Please log in Frist. ");
            }
        }
          public void deposit(){
            if(isLoggedIn){
            System.out.println("\n Enter Amount to Deposit :");
            Scanner sc = new Scanner(System.in);
            
            try{
                float amount = sc.nextFloat();
              if(amount <= 1000f) {
                  transactions++;
                  balance += amount;
                  System.out.println("\nDeposit successful :");
                  String atr = amount + "Rs Deposited\n";
                  transactionHistory = transactionHistory.concat(atr);
               }
               else{
                  System.out.println(" \n Sorry. The limit is 1000");
               }
              
            } catch(Exception e) {
                System.out.println("\n Invalid input.");
              }
  
            }else{
                System.out.println("\nPlease log in Frist");
            }
        }
    
            public void transfer(){
                if (isLoggedIn){
                Scanner sc = new Scanner(System.in);
                System.out.println("\nEnter Receipent's Name :");
                String receipent = sc.nextLine();
                System.out.println("\n Enter Amount to transfer:");
                 
                try{
                    float amount = sc.nextFloat();
                    if(balance >= amount){
                  if(amount <= 5000f) {
                      transactions++;
                      balance -= amount;
                      System.out.println("\n successful Transferred to" +receipent);
                      String atr = amount + "Rs transferred to" +receipent + "\n" ;
                      transactionHistory = transactionHistory.concat(atr);
                   } else{
                    System.out.println("\n Sorry.The limit is 5000.");
                   }

                }else{
                      System.out.println(" \n Insufficient Balance.");
                   }
                  
                } catch(Exception e){
                       }
            }
        }
       

        public void checkbalance(){
            System.out.println("\n" +balance+ "Rs");
        }
    


    public void trsansHistory(){
        if(transactions == 0){
            System.out.println("No Transactions happened");
        }else {
            System.out.println("\n" +transactionHistory);
        }
    }


}


