//
// Created by 김준형 on 2022/12/11.
//



#include <bits/stdc++.h>
#define ll long long int

using namespace std;

ll m;


ll count5func(ll mid){
    ll tmp=0;

    while(mid>=5){
        mid /= 5;
        tmp += mid;
    }
    return tmp;
}

int main() {

    cin >> m;

    ll low = 5;
    // high를 M의 크기인 100000000으로 하면 오답처리 된다. M은 0의 크기이기 때문에 high값은 그것보다 훨씬 더 큰 값이어야함
    ll high = 1e10+1;


    //N!중 가장 작은 N을 출력해야 함. count5>=m 일때마다 high = mid 값이 됨 -> 가장 작은 N값 자동 할당
    while(low<high){
        ll mid = (low+high)/2;
        ll count5 = count5func(mid);
        if(count5 < m){
            low = mid+1;
        }else{
            high = mid;
        }
    }

    if(m== count5func(high)){
        cout << high;
    }else{
        cout << -1;
    }






}













