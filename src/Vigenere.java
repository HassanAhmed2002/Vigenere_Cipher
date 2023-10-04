public class Vigenere {

    /*
        This will remove all characters from a string except
        for lower case letters (‘a’ to ‘z’). This string is the message,
        which you want to encrypt. If you input upper-case alphabets,
        then it converts them into lower-case.
     */
    public static String compress(String text){
        String s = "";
        text = text.toLowerCase();
        for (int i = 0; i < text.length(); i++){
            if((text.charAt(i) >= 'a' && text.charAt(i) <= 'z') || (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z')){
                s+= text.charAt(i);
            }
        }
        return s;
    }

    /*
        This function takes the key as input and expand it by repeating the key
        letters until the length of key is equal to that of the plaintext.
        The method prints the compressed plaintext and the expanded key
        on separate lines
     */
    public static String expandedKey(String key, String compressed){
        String s = "";
        for(int i = 0; i < compressed.length(); i++){
            s+= key.charAt(i % key.length());
        }
        s=s.toLowerCase();
        System.out.println("\n\nCompressed String: " + compressed);
        System.out.println("Expanded key: " + s);
        return s;
    }



    public static String encode(String message, String key){
        String compressedMsg = compress(message);
        String keyExpanded = expandedKey(key, compressedMsg);
        String encoded = "";
        int count = 1;
        for (int i = 0; i < compressedMsg.length(); i++){
            int asciiVal = keyExpanded.charAt(i);
            char c= (char) (97 + ((compressedMsg.charAt(i) - 97 + asciiVal - 97) % 26));
            encoded += c;
            if(count % 5 ==0){
                encoded+= " ";
            }
            count++;
        }
        return encoded;
    }

    public static String decode(String message, String key){
        String compressedMsg = compress(message);
        String keyExpanded = expandedKey(key, compressedMsg);
        String decoded = "";
        for (int i = 0; i < compressedMsg.length(); i++){
            int asciiVal = keyExpanded.charAt(i);
            int diff = (compressedMsg.charAt(i) - 97) - (asciiVal - 97);
            char c;
            if (diff >= 0) {
                 c = (char) (97 + ((compressedMsg.charAt(i) - 97) - (asciiVal - 97)));
            }else{
                 c = (char) (97 + (26 + diff));
            }
            decoded += c;
        }
        return decoded;
    }
}