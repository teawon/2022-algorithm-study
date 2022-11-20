    package seonghan.sort;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

    public class sort_22945 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<arr.length;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int start = 0;
            int end = N-1;
            int max = 0;
            while(start!=end){
                max = Math.max(max,(end-start-1)*Math.min(arr[start],arr[end]));

                if(arr[start]<arr[end]){
                    start++;
                }else{
                    end--;
                }
            }

            System.out.println(max);
        }
    }
