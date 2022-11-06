//
// Created by 김준형 on 2022/10/30.
//

#include "P_14719.h"
#include <bits/stdc++.h>

using namespace std;

int h , w ;

vector<int> graph;
vector<int> ansgraph;

int main() {

    cin >> h >> w;

    for (int i = 0; i <w ; ++i) {
        int a ;
        cin >> a;
        graph.push_back(a);
    }

    int ans = 0;

    for (int i = 0; i < w; ++i) {

        int left = 0 ; int right=0;

        for (int j = 0; j <i; ++j) {
            left = max(left,graph[j]);
        }

        for (int j = i; j < w; ++j) {
            right = max(right,graph[j]);
        }

        ans += max(0,min(left,right)-graph[i]);

    }

    cout << ans <<"\n";




}