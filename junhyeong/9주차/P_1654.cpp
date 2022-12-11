//
// Created by 김준형 on 2022/12/11.
//
#include <bits/stdc++.h>
//8ms
using namespace std;


int K,N;

int li[10001];

int max1=0;

int main() {

    cin >> K >> N;

    for (int i = 0; i < K; ++i) {
        cin >> li[i];
        if(max1<li[i]) max1= li[i];
    }

    long long low = 1;
    long long high = max1;
    int ans = 0 ;


    while(low<=high){
        long long mid = (low + high)/2;
        int cnt = 0;

        for (int i = 0; i <K ; ++i) {
            cnt += li[i] / mid;
        }

        if(cnt >= N){
            low = mid +1;
            if(ans<mid)ans = mid;
        }else{
            high = mid-1;
        }

    }
    cout << ans <<"\n";

}













