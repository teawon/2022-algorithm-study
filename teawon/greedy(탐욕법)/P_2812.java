import java.util.*;
/*
 * 문제 주소 :  https://www.acmicpc.net/problem/2812
 *  
 * 문제 접근 방법 & 사용 알고리즘: 
 * 
 * 첫번째 접근방법 - 결국 주어진 숫자에서 K개를 지웠을 때 자릿수는 유지되므로 첫번째 자리수의 값이 가장 커야한다.
 * K+1개의 숫자를 보고 가장 큰수를 남기고 지운다. 그리고 두번째 자리수도 이를 반복하기
 *   
 * 
 * 좋은 풀이 방식은 아닌 것 같음. 무식하게 첫번쨰 방법으로 풀면서 예외를 처리했는데 다른 방법이 있는 지 찾아볼 것
 **/




public class P_2812 {

        public static void main(String[] args) {
        
            Scanner sc = new Scanner(System.in);
            
            int N = sc.nextInt(); //N자리 숫자
            int K = sc.nextInt(); //K개의 숫자를 지울 수 있다.

        
            String[] digits = sc.next().split("(?<=.)");

        
            int restCount = K; //지워야 할 개수
            int curIndex = 0; // 현재 인덱스

            if(N == K){
                System.out.println("0"); //n자리수 일때 k개를 지운다면 0을 출력하도록 예외처리
            }
            else{

                while(true){
                    
                    if(restCount == 0) break; //지워야 할 개수가 0개라면 종료한다.

                    if(digits.length - curIndex == restCount){   // 만약 현재 인덱스를 기준으로 남은자릿수를 모두 지워야하는 경우라면 나머지 자릿수를 다 버린다 (예외처리)
                        for(int k = curIndex; k<digits.length; k++){
                            digits[k] = null;
                        }
                        break;
                    }

                    int maxValue = Integer.parseInt(digits[curIndex]); // loop의 시작인덱스를 기준으로 최대 값
                    int maxIndex = curIndex; // loop의 시작 인덱스를 기준으로 최대값을 가지는 인덱스

                    for(int i=curIndex+1; i<curIndex+restCount+1; i++){ //k개를 최대 지울 수 있으므로 특정 인덱스에서 k+1번째 중 가장 큰 값을 찾는다.
                        
                        if(maxValue < Integer.parseInt(digits[i])){ 
                            maxValue = Integer.parseInt(digits[i]);
                            maxIndex = i;
                        }


                        if(Integer.parseInt(digits[i]) == 9 || i == curIndex+restCount){ //만약 가장큰 값(9)가 있거나 , 탐색의 마지막 범위까지 갔다면

                            for(int j = curIndex; j<maxIndex; j++ ){ //가장 큰 값을 기준으로 앞 자리를 다 지운다
                                digits[j] = null;
                            }

                            restCount = restCount - (maxIndex - curIndex); //지운 개수를 지워야 할 개수에서 뺀다.
                            curIndex = maxIndex+1; //가장 큰 값의 다음 인덱스부터 이를 반복한다.
                            break;
                        }
                    }
                    
                }

                for(int i=0; i<digits.length; i++){ //지운 값(null)이 아닌 자릿수만 모두 출력
                    if(digits[i] != null)
                    System.out.print(digits[i]);
                }
                System.out.print("\n");
            }
        }
}
