import java.util.Scanner;

public class Task {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);

        String choice;
        while (true){
            System.out.println("Welcome to Vigenère Cipher" +
                    "\nInput en for encryption" +
                    "\nInput de for decryption");
            choice = s.nextLine();

            if (!(choice.equals("en")|| choice.equals("de"))){
                System.out.println("Invalid input");
                continue;
            }
            break;
        }

        System.out.println("Input the message");
        String msg = s.nextLine();

        System.out.println("Input the key");
        String key = s.nextLine();


        if (choice == "en") {
            String encoded = Vigenere.encode(msg, key);
            System.out.println("Encoded String: " + encoded);
        } else{
            String decoded = Vigenere.decode(msg, key);
            System.out.println("Decoded String: " + decoded);
        }
    }
}