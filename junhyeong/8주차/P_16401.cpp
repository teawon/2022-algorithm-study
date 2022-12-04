//
// Created by 김준형 on 2022/12/04.
//

//400ms

#include <bits/stdc++.h>
#define ll long long int

using namespace std;


ll li[1000001];
int main() {

    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int M , N ;
    cin >> M >> N;
    ll max1=0;


    for (int i = 0; i <N ; ++i) {
        cin >> li[i];
        max1 = max(max1,li[i]);
    }


    ll low =1;
    ll high =max1;
    ll ans=0;

    while(low<=high){
        ll cnt = 0;
        ll mid = (low+high)/2;
        for (int i = 0; i < N; ++i) {
            if ( li[i] / mid > 0 ){cnt+=li[i]/mid;}
        }

        if(cnt >= M){
            ans = max(ans,mid);
            low = mid+1;
        }else{
            high = mid-1;
        }
    }

    if(ans==-1){
        cout << 0;
    }else{
        cout << ans<<"\n";

    }









}













