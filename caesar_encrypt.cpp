/*
 * Encrypts plaintext into a Caesar cipher
 * 
 * @author Gabriel Votaw
 * @version FINAL 2021-10-03
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

#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

int main() {
    string usage = "encrypt <text> <key>\n";
           usage += "text restricted to alphabetical characters and\n";
           usage += "key must be in the range 1-25\n";

    char input[100];
    char* ptr;
    int key;
    string message;
    vector<string> tokens;
    
    cin.getline(input, 100);
    ptr = strtok(input, " ");

    while (ptr != NULL) {
        tokens.push_back(ptr);
        ptr = strtok(NULL, " ");
    }

    key = stoi(tokens[2]);
    message = tokens[1];

    if (tokens.size() != 3 || tokens[0] != "encrypt" || key < 1 || key > 25) {
        cout << usage << endl;
        exit(0);
    }

    for (auto& c : message) {
        c = tolower(c);
        c = (char) c + key;
        if (c > 'z') {
            c = (char) c + 'a' - 'z' - 1;
        }
    }

    cout << message;

    return 0;
}