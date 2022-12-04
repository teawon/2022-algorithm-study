//
// Created by 김준형 on 2022/12/04.
//

//0ms
#include <bits/stdc++.h>
#define ll unsigned long long int

using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);


    ll n;
    cin >> n;

    ll q = sqrt(n);

    if((q*q) < n){
        q++;
    }

    cout << q ;



}













