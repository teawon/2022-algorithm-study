//
// Created by 김준형 on 2022/12/04.
//
//680ms
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

vector<long long>tree;

long long  N , M ;

int main(){

    cin >> N >> M;

    for(int i = 0 ; i < N;i++){
        int a= 0;
        cin >> a;
        tree.push_back(a);
    }

    std::sort(tree.begin(), tree.end());

    long long left = 0;
    long long right = tree[tree.size()-1];
    long long mid = 0;
    long long  sum = 0;
    long long ans = 0;
    while(left<=right){
        mid = (left+right)/2;
        sum=0;
        for(int i = 0 ; i <N;i++){
            if(tree[i]>mid){
                sum += tree[i] - mid;
            }
        }
        if (sum>=M){
            ans=mid;
            left = mid+1;
        }else{
            right = mid-1;
        }
    }
    cout << ans;
}


