package seonghan.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Implement_12933 {

    static ArrayList<Integer> duck = new ArrayList<Integer>();
    static int maxlength =-1;
    static HashMap<String, Integer> quack = new HashMap<String, Integer>(){{
        put("q",1);
        put("u",2);
        put("a",3);
        put("c",4);
        put("k",5);
    }};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String temp[] = br.readLine().split("");

        for(String s : temp) {
            int number = quack.get(s);
            boolean flag = false;

            //오리의 시작
            if(number==1) {
                duck.add(1);

            }

            else {
                for(int index=0;index<duck.size();index++) {
                    //올바른 울음소리 순서
                    if(duck.get(index) == number-1) {
                        duck.set(index, number);
                        if(number == 5) {
                            //오리 수
                            maxlength = Math.max(maxlength, duck.size());
                            duck.remove(index);
                        }

                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    System.out.print(-1);
                    return;
                }
            }

        }

        if(duck.size()!=0)
            System.out.print(-1);
        else
            System.out.println(maxlength);
    }

}
