#include <bits/stdc++.h>
using namespace std;


int n ;


vector<int>graph[101];
vector<int>ans;

int visited[101];

void dfs(int start){
    //if(visited[start]!=0){
//        cout << "restarted!! "<< start  <<"\n";
//    }

    //cout << start << "\n";
    if(visited[start]==1){
        //cout << "checked!! " << start <<"\n";
        ans.push_back(start);
        return;
    }

    visited[start]=1;



    for (int i = 0; i <graph[start].size() ; ++i) {
        int next = graph[start][i];

        dfs(next);

    }




}

int main(){

    cin >> n;

    for(int i = 1 ; i <= n;i++){
        int a;
        cin >> a;
        graph[i].push_back(a);
    }

    for (int i = 1; i <=n; ++i) {
        dfs(i);
        for(int i = 1 ; i <=n;++i){
            visited[i]  = 0;
        }
        //cout << "\n";
    }

    std::sort(ans.begin(), ans.end());
    ans.erase(std::unique(ans.begin(), ans.end()),ans.end());
    cout << ans.size() <<"\n";

    for (int i = 0; i <ans.size() ; ++i) {
        cout << ans[i]<<"\n";

    }






}