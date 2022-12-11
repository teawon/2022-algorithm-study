//
// Created by 김준형 on 2022/12/11.
//
#include <bits/stdc++.h>
#define ull unsigned long long int

using namespace std;
//4ms


int main() {

    ios::sync_with_stdio(false);
    cin.tie(0);

    int T;  cin >> T;

    while(T--){
        ull n;
        cin >> n;
        ull start = 1;
        ull end =1e16;
        ull ans = 0 ;

        while(start<=end){
            ull mid = (start + end)/2;

            if(mid * (mid+1) <= 2*n){
                ans = max(ans,mid);
                start = mid +1;
            }else{
                end = mid-1;
            }

        }
        cout << ans <<"\n";
    }
}













