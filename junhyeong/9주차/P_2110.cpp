//
// Created by 김준형 on 2022/12/11.
//




#include <bits/stdc++.h>

using namespace std;

int N;
int C;

int arr[200001];


int main() {

    cin >> N;
    cin >> C;


    int max_tmp=0;

    for (int i = 0; i <N ; ++i) {
        cin >> arr[i];
        max_tmp = max(arr[i],max_tmp);
    }

    sort(arr,arr+N);


    int low = 1;
    int high = max_tmp;
    int ans = 0;

    while(low<=high){
        int cnt = 1;

        int mid = (low+high)/2;
        int prevhouse = arr[0];
        for (int i = 1; i <N ; ++i) {
            if(arr[i] - prevhouse >= mid){
                cnt++;
                prevhouse = arr[i];
            }
        }

        if(cnt>=C){
            ans = max(mid,ans);
            low = mid+1;
        }else{
            high = mid-1;
        }
    }

    cout << ans <<"\n";



}













