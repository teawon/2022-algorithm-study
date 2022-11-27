//
// Created by 김준형 on 2022/11/27.
//
#include <bits/stdc++.h>
using namespace std;

int n;

vector<int>v1;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;

    for (int i = 0; i < n; ++i) {
        int a ;
        cin >> a;
        v1.push_back(a);

    }

    std::sort(v1.begin(), v1.end());
    bool check = false;

    for (int i = n-1; i >=2; --i) {
        if ( v1[i] < v1[i-2] + v1[i-1] ){
            //cout << v1[i] << " " << v1[i-2] << " " << v1[i-1] << "\n";
            cout << v1[i] + v1[i-2] + v1[i-1];
            check = true;
            break;
        }
    }
    if(check==false){
        cout << -1;
    }

}




