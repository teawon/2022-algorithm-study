package seonghan.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class sort_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case=0;test_case<T;test_case++){
            Person [] person = new Person[Integer.parseInt(br.readLine())];
            int result =1;
            boolean visited[] = new boolean[person.length];
            StringTokenizer st;
            for(int i=0;i<person.length;i++){
                st=new StringTokenizer(br.readLine());
                person[i] = new Person(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }

            Arrays.sort(person, new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    return o1.score-o2.score;
                }
            });
            int preScore = person[0].score2;
            for(int i=1;i<person.length;i++){
                if(person[i].score2<preScore){
                    result++;
                    preScore = person[i].score2;
               }
            }





            System.out.println(result);


        }
    }


    public static class Person{
        int score;
        int score2;

        Person(int score,int score2) {
            this.score = score;
            this.score2 = score2;
        }


    }
}
