//
// Created by 김준형 on 2022/11/27.
//
#include <bits/stdc++.h>
using namespace std;


map<long long ,long long>m1;



int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n ;
    cin >> n;

    for (int i = 0; i <n ; ++i) {
        long long a;
        cin >> a;
        m1[a]++;
    }

    int n2;
    cin >> n2;

    for (int i = 0; i < n2; ++i) {
        long long b;
        cin >> b;
        if(m1[b]>0){
            cout << 1 <<"\n";
        }else{
            cout << 0 <<"\n";
        }
    }






}




