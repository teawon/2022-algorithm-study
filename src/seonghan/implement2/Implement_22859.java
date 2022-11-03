package seonghan.implement2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Implement_22859 {
    static ArrayList<String> html;

    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        html = new ArrayList<>();
        while (st.hasMoreTokens()) {
            html.add(st.nextToken());
        }
//        for (int i = 0; i < html.size(); i++) {
//            System.out.print(html.get(i));
//            System.out.print(" ");
//        }
        solution();
    }

    public static void solution() {
        int paraNum = findDiv() / 2;
        String[] title = new String[paraNum];
        title = findTitle(paraNum);

    }

    public static String[] findTitle(int paraNum) {
        String[] title = new String[paraNum];
        for(int o = 0; o < title.length;o++) {
            for (int i = 0; i < html.size(); i++) {
                String s = html.get(i);
                if (s.contains("title")) {
                    ArrayList<Integer> t_list = new ArrayList<>();
                    for (int j = 0; j < s.length(); j++) {
                        if (s.charAt(j) == 't') { // 첫 문자가 t 인 경우
                            t_list.add(j);
                        }
                    }

                    String titleCheck = "";
                    for (int k = 0; k < t_list.size(); k++) {
                        int startIdx = t_list.get(k);
                        titleCheck = s.substring(startIdx, startIdx + 5);
                        if (titleCheck.equals("title")) {

                        }
                    }
                }
            }
        }

        return title;
    }

    public static int findDiv() {
        int div = 0;
        for (int i = 0; i < html.size(); i++) {
            String s = html.get(i);
            if (s.contains("div")) {
                ArrayList<Integer> d_list = new ArrayList<>();
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == 'd') {
                        d_list.add(j);
                    }
                }
                String divCheck = "";
                for (int k = 0; k < d_list.size(); k++) {
                    int start_idx = d_list.get(k);
                    divCheck = s.substring(start_idx, start_idx + 3);
                    if (divCheck.equals("div")) {
                        div++;
                    }
                }
            }
        }

        return div;
    }

}
