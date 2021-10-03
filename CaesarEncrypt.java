/*
 * Encrypts plaintext into a Caesar cipher
 * 
 * @author Gabriel Votaw
 * @since 2021-09-28
 * 
 * Copyright (c) 2021 Gabriel Votaw
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package caesarencrypt;

import java.util.Scanner;

public class CaesarEncrypt {
    public static void main(String[] args) {
        String usage = "CaesarEncrypt <text> <key>\n";
        usage += "Text restricted to alphabetical characters and\n";
        usage += "key must be in the range 1-25\n";
        
        Scanner in = new Scanner(System.in);
        String[] tokens = in.nextLine().split(" ");
        
        if (tokens.length != 3 || !tokens[0].equals("CaesarEncrypt")) {
            System.out.println(usage);
            System.exit(1);
        }
        
        String message = tokens[1].toLowerCase();
        StringBuilder encryptedMessage = new StringBuilder();
        int key = Integer.parseInt(tokens[2]);
        char ch;
        
        if (key < 1 || key > 25) {
            System.out.println(usage);
            System.exit(1);
        }
        
        for (int i = 0; i < message.length(); i++) {
            ch = (char)(message.charAt(i) + key);
            
            if (ch > 'z') {
                ch = (char)(ch + 'a' - 'z' - 1);
            }
            
            encryptedMessage.append(ch);
        }
        
        System.out.println(encryptedMessage);
    }
}
