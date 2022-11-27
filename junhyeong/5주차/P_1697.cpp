
#include <bits/stdc++.h>
using namespace std;

int N;

vector<pair<int,int>>score;

int main(){

    cin >> N;
    for (int i = 0; i <N ; ++i) {
        int a;
        int b;
        cin >> a;
        cin >> b;

        if(a>b){
            score.push_back({1,(a-b)});
        }else{
            score.push_back({2,(b-a)});
        }

        cout << score[i];

    }










}