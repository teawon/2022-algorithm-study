//
// Created by 김준형 on 2022/12/04.
//
// 304ms
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){

    ios::sync_with_stdio(false);
    cin.tie(NULL);



    int N ;
    cin >> N;
    vector<int>v1(N);
    for(int i = 0 ; i< N;i++){
        cin >> v1[i];
    }
    int M ;
    cin >> M;
    vector<int>v2(M);

    std::sort(v1.begin(), v1.end());


    for(int i = 0 ; i< M;i++){
        cin >> v2[i];
    }

    for(int i = 0; i<M;i++){
        cout << std::upper_bound(v1.begin(), v1.end(),v2[i]) - std::lower_bound(v1.begin(), v1.end(),v2[i]) <<
             " ";
    }







}