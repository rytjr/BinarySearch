import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String str = br.readLine();
            if(str.equals(".")) break;
            str = str.trim();

            Stack<Character> s = new Stack<>();
            boolean flag = true;
            for(int i=0; i<str.length(); i++) {
                if(str.charAt(i) == '(' || str.charAt(i) == '[') {
                    s.push(str.charAt(i));
                } else if(str.charAt(i) == ')' || str.charAt(i) == ']') {
                    if(!s.isEmpty() && s.peek().equals('(') && str.charAt(i) == ')') s.pop();
                    else if(!s.isEmpty() && s.peek().equals('[') && str.charAt(i) == ']') s.pop();
                    else {flag = false; break;}
                } else continue;
            }
            if(!str.endsWith(".") || !s.isEmpty()) flag = false;

            if(!flag) bw.write("no");
            else bw.write("yes");
            s.clear();
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}