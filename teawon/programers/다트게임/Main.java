package teawon.programers.다트게임;

public class Main {
    public static void main(String[] args) {
        String[] input = new String[] { "1S2D*3T", "1D2S#10S", "1D2S0T" };

        for (int i = 0; i < input.length; i++) {
            System.out.println(Solution.solution(input[i]));
        }

    }

}
