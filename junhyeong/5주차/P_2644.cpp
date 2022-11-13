//
// Created by 김준형 on 2022/11/13.
//
#include <iostream>
#include <vector>

using namespace std;

int visited[101];
vector<int>v1[101];

int n;
int m;
int p1,p2;
int ans;
int c1;

void dfs(int sx, int sy, int c1){

    //sy는 처음 입력받은 그대로 계속 이어나감
    //sx는 연결된 노드에 따라 실행시마다 바뀜
    //목표지점 도달
    if(sx==sy){
        ans = c1;
    }
    visited[sx] = 1;
    for(int i=0;i<v1[sx].size();i++){
        int next = v1[sx][i];
        if(visited[next]==0){
            dfs(next,sy,c1+1);
        }
    }
}


int main(){

    cin >> n;
    cin >> p1 >> p2;
    cin >> m;

    for(int i = 0 ; i < m;i++){
        int x,y;
        cin >> x>>y;
        v1[x].push_back(y);
        v1[y].push_back(x);
    }

    dfs(p1,p2,c1);

    if(ans!=0){
        cout << ans;
    }else{
        cout << -1;
    }

}