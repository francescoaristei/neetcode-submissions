/*
* I know that the length of each string within the list strs is at max 200. 
* I can prepend each string in the List with 3 chars giving the length
* of the following string.
* In this way, in the decode() method I can read this first prefix to figure
* out the length of the following string and extract it from the string str.
*/ 
class Solution {

    fun encode(strs: List<String>): String {
        var result: String = "";
        for (str in strs) {
            val str_length = encode_length(str.length);
            result += (str_length + str);
        }
        return result;
    }

    fun encode_length(length: Int): String {
        var str_length = length.toString();
        while (str_length.length < 3) {
            str_length = '0' + str_length;
        }
        return str_length;
    }

    fun decode(str: String): List<String> {
        var result = mutableListOf<String>();
        var counter = 0;
        var substr_length = 0;
        while (counter < str.length) {
            substr_length = decode_length(str.substring(counter, counter + 3));
            counter += 3;
            val substr = str.substring(counter, counter + substr_length);
            counter += substr_length;
            result.add(substr);
        }
        return result;
    }

    fun decode_length(str_length: String): Int {
        if (str_length[0] == '0') {
            if (str_length[1] == '0') {
                return str_length.last().digitToInt();
            } else {
                return str_length.substring(1, 3).toInt();
            }
        } else {
            return str_length.toInt();
        }
    }
}
