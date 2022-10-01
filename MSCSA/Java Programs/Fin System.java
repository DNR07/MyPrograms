import java.util.*;
import java.io.*;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; 
public class prgm5 {
    static Scanner sc_new=new Scanner(System.in);
    static String[][] ele=new String[10][5];
    static public String username;
    static private String password;
    static public String phone;
    static public String email;
    static public String u_dev="Dev";
    static private String p_dev="idk";
    static int count=2;
    public static void main(String[] args){
        ele[0][0]="Username";
        ele[0][1]="Password";
        ele[0][2]="Phone Number";
        ele[0][3]="Email";
        ele[0][4]="Balance";
        ele[1][0]="User1";
        ele[1][1]="password";
        ele[1][2]="012345678901";
        ele[1][3]="ok@mail.com";
        ele[1][4]="1000";
        ele[2][0]="Dev";
        ele[2][1]="idk";
        ele[2][2]="918884179004";
        ele[2][3]="dev@gmail.com";
        ele[2][4]="100000";
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("Welcome to THE FINANCIAL SYSTEM");
            System.out.println("Enter 1 to create a new account and enter 2 to login to an existing account.");
            do{
                int choice = sc_new.nextInt();
                if (choice==1){
                    count+=1;
                    new_user(count);
                    break;
                }
                else if(choice==2){
                    existing_user();
                    break;
                }
                else{
                    System.out.println("Enter either 1 or 2.");
                }
            }while(true);
            System.out.println("Do you wish to repeat the program?(y/n)");
            StringBuffer sbuf=new StringBuffer();
            sbuf=sbuf.append(sc.nextLine());
            sbuf.delete(1,sbuf.capacity());
            if ((sbuf.toString().equals("y")) || (sbuf.toString().equals("Y"))){
                continue;
            }
            else{
                break;
            }
        }while(true);
    }
    public static void new_user(int count_){
        Console csn=System.console();
        Scanner sc2=new Scanner(System.in);
        //String menu_new="1. User Options\n2. Transactions\n3. Balances \n4. Assets\n5. Exit";
        String menu_new="1. User Options\n2. Transactions Options\n3. Asset Options\n4. Exit";
        sc_new.nextLine();
        System.out.println("Enter new username: ");
        username=sc_new.nextLine();
        ele[count_][0]=username;
        System.out.println("Enter new password");
        char[] pass=csn.readPassword();
        password=new String(pass);  
        ele[count_][1]=password;
        do{
            System.out.println("Enter phone number: ");
            phone=sc_new.nextLine();
            String regex = "(0|91)?[7-9][0-9]{9}";
            if (phone.matches(regex)){
                break;
            }
        }while(true);
        ele[count_][2]=phone;
        do{
            System.out.println("Enter email ID: ");
            email=sc_new.nextLine();
            String mail_regex="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
            if (email.matches(mail_regex)){
                break;
            }
        }while(true);
        ele[count_][3]=email;
        ele[count_][4]="10000";
        main_options(count_);
        /*
        int ch1;
        int asset_trans_count=0;
        do{
            System.out.println("Choose one of the below options: ");
            System.out.println(menu_new);
            ch1=sc_new.nextInt();
            switch(ch1){
                case 1: user obj_user=new user();
                        obj_user.main_user(username, password, phone, email);
                        break;
                case 2: transactions obj_transactions=new transactions();
                        ele=obj_transactions.main_transactions(ele);
                case 3: asset_trans_count+=1;
                        record_assets obj = new record_assets(ele,asset_trans_count);
                        obj.disp_asset();
                case 4: break;
                default: System.out.println("Enter a number between 1 to 3 ONLY");
                }
            if (ch1==4){
                break;
            }
        }while(true);
        */
    }
   public static void existing_user(){ 
      //System.out.println(ele[0][1]);
      Console csnl=System.console();
      Scanner sc1=new Scanner(System.in);
      String menu_new="1. User Options\nTransactions Options\n3. Exit";
      System.out.println("Enter username: ");
      sc_new.nextLine();
      username=sc_new.nextLine();
      sc_new.nextLine();
      System.out.println("Enter password: ");
      char[] pass=csnl.readPassword();
      password=new String(pass);
      for (int i=0;i<ele.length;i++){
         if (username.equals(ele[i][0]) && password.equals(ele[i][1])){
            main_options(i);
         }
      }
        /* 
        u_dev="Dev";
        p_dev="idk";
        String u_ex="User1";
        String pass_ex="password";
        String phone_ex="092142168992";
        String mail_ex="ok@mail.com";
        String phone_dev="918884179332";
        String mail_dev="developer@gmail.com";
        do{
            System.out.println("Enter username: ");
            sc_new.nextLine();
            username=sc_new.nextLine();
            sc_new.nextLine();
            System.out.println("Enter password: ");
            char[] pass=csnl.readPassword();
            password=new String(pass);
            if ((username.equals(u_dev)) && (password.equals(p_dev))){
                System.out.println("Welcome Developer!");
                do{
                    sc_new.nextLine();
                    System.out.println("Choose one of the below options: ");
                    System.out.println(menu_new);
                    int ch1=sc1.nextInt();
                    switch(ch1){
                        case 1: user obj_user=new user();
                                obj_user.main_user(u_dev, p_dev, phone_dev, mail_dev);
                                break;
                        case 2: transactions obj_transactions=new transactions();
                                ele=obj_transactions.main_transactions(ele);
                        default: System.out.println("Enter a number between 1 to 3 ONLY");
                        }
                    if (ch1==3){
                        break;
                    }
                }while(true);
                break;
            }
            else if((username.equals(u_ex)) && (password.equals(pass_ex))){
                System.out.println("Welcome "+username);
                do{
                    System.out.println("Choose one of the below options: ");
                    System.out.println(menu_new);
                    int ch1=sc_new.nextInt();
                    switch(ch1){
                        case 1: user obj_user=new user();
                                obj_user.main_user(username, password, phone_ex, mail_ex);
                                break;
                        case 2: transactions obj_transactions=new transactions();
                                ele=obj_transactions.main_transactions(ele);
                        default: System.out.println("Enter a number between 1 to 3 ONLY");
                        }
                    if (ch1==3){
                        break;
                    }
                }while(true);
                break;
            }
            else{
                System.out.println(username);
                System.out.println(password);
                System.out.println("Username and password does not exist.\nEnter 1 to login again or enter 2 to create new account: ");
                int ch1=sc_new.nextInt();
                if (ch1==1){
                    continue;
                }
                else if (ch1==2){
                    count+=1;
                    new_user(count);
                    break;
                }
            }
        }while(true);
        */
   }
   public static void main_options(int row){    
    String menu_new="1. User Options\n2. Transactions Options\n3. Asset Options\n4. Exit";
        int ch1;
        int asset_trans_count = 0;
        int trans_count = 0;
        do{
            System.out.println("\nChoose one of the below options: ");
            System.out.println(menu_new);
            ch1=sc_new.nextInt();
            switch(ch1){
                case 1: user obj_user=new user();
                        obj_user.main_user(ele,row);
                        break;  
                case 2: trans_count+=1;
                        transactions obj_transactions=new transactions();
                        ele=obj_transactions.main_transactions(ele,trans_count);
                        transactions.Balance obj_bal=new transactions.Balance();
                        obj_bal.disp_trans();
                        break;
                case 3: asset_trans_count+=1;
                        record_assets obj = new record_assets(ele,asset_trans_count);
                        obj.disp_asset();
                case 4: break;
                default: System.out.println("Enter a number between 1 to 3 ONLY");
                }
            if (ch1==4){
                break;
            }
        }while(true);
    }
}
class user{
    Scanner sc2_new=new Scanner(System.in);
    public void main_user(String[][] ele1,int row1){
        Scanner sc3=new Scanner(System.in);
        //int pass_len=passw.length();
        do{
            System.out.println("Enter 1 for viewing details and 2 for deleting account.");
            int ch2=sc2_new.nextInt();    
            if (ch2==1){
                for (int i=0;i<ele1[row1].length;i++){
                    if (i==1){
                        System.out.print(ele1[row1][i].charAt(0)+"*".repeat(ele1[row1][i].length()-1));
                        System.out.print(" | ");
                        continue;
                    }
                    System.out.print(ele1[row1][i]);
                    System.out.print(" | ");
                }
                break;
            }
            //else if (ch2==2){
                //delete_account(usern,passw);
                //break;
            //}
            else{
                System.out.println("Enter ONLY 1 or 2.");
            }
        }while(true);
        //sc3.close();
    }
    public void delete_account(String usern,String passw){
        String ch4;
        Scanner sc4=new Scanner(System.in);
        System.out.println("Are you sure you want to delete your account?(y/n)");
        ch4=sc2_new.nextLine();
        if (ch4=="y"){
            Scanner sc5=new Scanner(System.in);
            System.out.println("Enter password to delete account: ");
            String pass=sc2_new.nextLine();
            if (pass.equals(passw)){
                System.out.println("ACCOUNT DELETED!!\n\nGOODBYE!!");
                System.exit(0);
            }
        }
    }
} 

class transactions{
    static String[][] trans=new String[10][5];
    static Scanner sc_new2=new Scanner(System.in);
    public String[][] main_transactions(String[][] ele1,int count){
        System.out.println("Enter one of the following options: \n1. Record Transaction\n2. Display Transactions");
        int ch=sc_new2.nextInt();
        trans[0][0]="Sl. No.";
        trans[0][1]="Sender";
        trans[0][2]="Receiver";
        trans[0][3]="Amount";
        trans[0][4]="Date Time";
        if (ch==1){
            System.out.println("Enter which credentials you wish to use for authorizing transacion\n1. Password\n2. Personal Details");
            int ch1=sc_new2.nextInt();
            if (ch1==1){
                ele1=record_trans(ele1,ch1,count);
            }
            else if(ch1==2){
                ele1=record_trans(ele1,count);
            }
            else{
                System.out.println("Enter either 1 or 2 ONLY");
            }
        }
        return ele1;
    }
    public String[][] record_trans(String[][] ele2,int x,int count){
        int row_len=ele2.length;
        //int col_len=ele2[0].length;
        sc_new2.nextLine();
        System.out.println("Enter first username: ");
        String u_1=sc_new2.nextLine();
        System.out.println("Enter first password: ");
        String p_1=sc_new2.nextLine();
        sc_new2.nextLine();
        System.out.println("Enter second username: ");
        String u_2=sc_new2.nextLine();
        System.out.println(u_2);
        System.out.println("Enter second password: ");
        String p_2=sc_new2.nextLine();
        System.out.println(p_2);
        int f1=0;
        int f2=0;
        for (int i=1;i<row_len;i++){
            if ((u_1.equals(ele2[i][0]))&&(p_1.equals(ele2[i][1]))){
                f1=i;
            }    
        }
        if (f1==0){
            System.out.println("First user details are incorrect.");
        }
        for (int j=1;j<row_len;j++){
            if ((u_2.equals(ele2[j][0]))&&(p_2.equals(ele2[j][1]))){
                f2=j;
                break;
            }
        }
        if (f2==0){
            System.out.println("Second user details are incorrect.");
        }
        if ((f1!=0) && (f2!=0)){
            System.out.println("Enter \n1. If first user sends money\n2. If second user sends money");
            int ch2=sc_new2.nextInt();
            System.out.println("Enter transaction amount: ");
            int amt=sc_new2.nextInt();
            trans[count][0]=String.valueOf(count);
            trans[count][3]=String.valueOf(amt);
            if (ch2==1){
                int bal_1=Integer.parseInt(ele2[f1][4]);
                int bal_2=Integer.parseInt(ele2[f2][4]);
                bal_1-=amt;
                bal_2+=amt;
                ele2[f1][4]=String.valueOf(bal_1);
                ele2[f2][4]=String.valueOf(bal_2);
                trans[count][1]=ele2[f1][0];
                trans[count][2]=ele2[f2][0];
            }
            if (ch2==2){
                int bal_1=Integer.parseInt(ele2[f1][4]);
                int bal_2=Integer.parseInt(ele2[f2][4]);
                bal_2-=amt;
                bal_1+=amt;
                ele2[f1][4]=String.valueOf(bal_1);
                ele2[f2][4]=String.valueOf(bal_2);
                trans[count][1]=ele2[f2][0];
                trans[count][2]=ele2[f1][0];
            }
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        trans[count][4]=formattedDate;
        }
        return ele2;
    }
    public String[][] record_trans(String[][] ele2,int count){   
        sc_new2.nextLine();
        System.out.println("Enter first user phone number: ");
        String u_1=sc_new2.nextLine();
        System.out.println("Enter first user email: ");
        String p_1=sc_new2.nextLine();
        System.out.println("Enter second user phone number: ");
        String u_2=sc_new2.nextLine();
        System.out.println("Enter second user email: ");
        String p_2=sc_new2.nextLine();
        int row_len=ele2.length;
        int col_len=ele2[0].length;
        int f1=0;
        int f2=0;
        for (int i=0;i<row_len;i++){
            if ((u_1.equals(ele2[i][2]))&&(p_1.equals(ele2[i][3]))){
                f1=i;
            }
        }
        if (f1==0){
            System.out.println("First user details are incorrect.");
        }
        for (int i=0;i<row_len;i++){
            if ((u_2.equals(ele2[i][2]))&&(p_2.equals(ele2[i][3]))){
                f2=i;
            }
        }
        if (f2==0){
            System.out.println("Second user details are incorrect.");
        }
        if ((f1!=0) && (f2!=0)){
            trans[count][0]=String.valueOf(count);  
            System.out.println("Enter \n1. If first user sends money\n2. If second user sends money");
            int ch2=sc_new2.nextInt();
            System.out.println("Enter transaction amount: ");
            int amt=sc_new2.nextInt();
            trans[count][3]=String.valueOf(amt);
            if (ch2==1){
                int bal_1=Integer.parseInt(ele2[f1][4]);
                int bal_2=Integer.parseInt(ele2[f2][4]);
                bal_1-=amt;
                bal_2+=amt;
                ele2[f1][4]=String.valueOf(bal_1);
                ele2[f2][4]=String.valueOf(bal_2);
                trans[count][1]=ele2[f1][0];
                trans[count][2]=ele2[f2][0];
            }
            if (ch2==2){
                int bal_1=Integer.parseInt(ele2[f1][4]);
                int bal_2=Integer.parseInt(ele2[f2][4]);
                bal_2-=amt;
                bal_1+=amt;
                ele2[f1][4]=String.valueOf(bal_1);
                ele2[f2][4]=String.valueOf(bal_2);
                trans[count][1]=ele2[f2][0];
                trans[count][2]=ele2[f1][0];
            }
        }
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        trans[count][4]=formattedDate;
        return ele2;
    }
    public static class Balance{
        static {
            System.out.println("Transaction Details: ");
        }
        public void disp_trans(){
            for (int i = 0; i < trans.length; i++) { //this equals to the row in our matrix.
                for (int j = 0; j < trans[i].length; j++) { //this equals to the column in each row.
                    if (trans[i][j]!=null){
                        System.out.print(trans[i][j] + " ");
                        System.out.print(" | ");
                    }
                }
                if (trans[i][trans[i].length-1]!=null){
                    System.out.println();
                }
            }
        } 
    }
}

class record_assets{
    static Scanner sc_trans=new Scanner(System.in);
    static String[][] assets=new String[10][6];
    static double gold_value;
    static double silver_value;
    static String asset_name;
    static double asset_quantity;
    static String usern;
    static int asset_ch1;
    record_assets(String[][] ele,int j){
        this(ele);
        assets[j][0]=String.valueOf(j);
        assets[j][1]=usern;
        if (asset_ch1==1){
            assets[j][2]="Gold";
            assets[j][3]=String.valueOf(gold_value);
        }
        else{
            assets[j][2]="Silver";
            assets[j][3]=String.valueOf(silver_value);
        }
        assets[j][4]=String.valueOf(asset_quantity);   
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        assets[j][5]=formattedDate;
    }
    record_assets(String[][] ele){
        assets_main(ele);
    }
    

    void assets_main(String [][] ele){
        Random rand=new Random();
        assets[0][0]="Asset Trade Number";
        assets[0][1]="Username";
        assets[0][2]="Asset Name";
        assets[0][3]="Asset Value";
        assets[0][4]="Quantity (gm)";
        assets[0][5]="Date Time";
        gold_value=4500;
        silver_value=6000;
        long var1=rand.nextLong();
        long x=100000000;
        var1=var1/x;
        var1=(var1/x);
        gold_value+=var1;
        long var2=rand.nextLong();
        var2/=x;
        var2/=x;
        silver_value+=var2;
        sc_trans.nextLine();
        System.out.println("Enter Username: ");
        usern=sc_trans.nextLine();
        System.out.println("Asset List: ");
        System.out.println("Gold 1g = "+gold_value+" rupees");
        System.out.println("Silver 100g = "+silver_value+" rupees");
        System.out.println("Enter which asset you wish to purchase: \n1. Gold\n2. Silver");
        asset_ch1=sc_trans.nextInt();
        System.out.println("How much of it do you wish to purchase? (Default Quantity is given in list of assets)");
        asset_quantity=sc_trans.nextDouble();
        silver_value*=asset_quantity;
        if (asset_ch1==2){
            asset_quantity*=100.0;
        }
        gold_value*=asset_quantity;
    }
    public void disp_asset(){
        for (int i = 0; i < assets.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < assets[i].length; j++) { //this equals to the column in each row.
                if (assets[i][j]!=null){
                    System.out.print(assets[i][j] + " ");
                    System.out.print(" | ");
                }
            }
            if (assets[i][assets[i].length-1]!=null){
                System.out.println();
            }
        }
    }
}





/* 
class balances{
    public void main_balances(){

    }
    public void display_balance(){
        int balance;
    }
}
class dev{
    public void main_dev(){

    }
    public void all_user_details(){
        String users;
        String name;
        String username;
        String enc_password; 
    }
    public void update_account(){
        String new_deets;
    }
    public void delete_accounts(){
        String del_user;
    }
}
class assets{
    public void main_assets(){

        }
    public void disp_assets(){
        String asset;
        String user;
        int asset_value;
    }
    public void disp_available_assets(){
        String asset_name;
        int asset_value;
    }
    public void record_asset_trades(){
        String asset_buyer;
        String asset_seller;
        int asset_trade_value;
    }
}
*/
