import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/22859
 * 
 * 문제 접근 방법 & 사용 알고리즘: 
 * - trim() : 공백제거 
 * - replaceAll("a", "b"); -> A를 B로 치환 " +", " ") 사용시 하나이상의 공백을 치환한다.
       
 */

public class P_22859 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        html_parsing(0, str.length(), str);
    }

        public static void html_parsing(int start, int end, String str ){

            int index = start;
            while(index < end) { 
            String tag = "";

            index++;
            while(index < end && str.charAt(index)!='>'){ //태그 내부의 문자열 가져오기 div - ("d" "i" "v")
                tag+= str.charAt(index);
                index++;
            }  
            index++;
        
            if(tag.length()>=3 && tag.substring(0,3).equals("div")){ //div태그라면 title출력 후 내부str에 대해 재귀호출
                System.out.print("title : ");
                System.out.println(tag.substring(11, tag.length()-1));

                int curIndex = index;
                while(!str.substring((index),index+6).equals("</div>")){
                    index++;
                }
                html_parsing(curIndex,index,str); //<div><p>123</p></div> - "<p>123</p>" 부분을 다시 재귀호출
                index+=6;
            }
            
            else if (tag.equals("p")){
                int curIndex = start;
                while(!str.substring(index,index+4).equals("</p>")){
                    index++;
                }
                parse_print(curIndex,index,str); // <p>123</p> - p태그 내부의 "123"부분에 대해 출력함수 호출
                index+=4;
            }
        }

    }
    public static void parse_print(int start, int end, String str){ //P태그의 내부값을 모두 출력
        StringBuffer sb = new StringBuffer();
        for(int i=start; i<end; i++){

            if(str.charAt(i) == '<'){
                while(str.charAt(i) != '>') 
                { i++; }
                continue;
            }
           
            if(i<end){
                sb.append(str.charAt(i));
            }
        }
        String result = sb.toString().trim().replaceAll(" +", " ");
        System.out.println(result);
    } 
}




