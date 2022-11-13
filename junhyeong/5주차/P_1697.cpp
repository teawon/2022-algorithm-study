//
// Created by 김준형 on 2022/11/13.
//
//
// Created by 김준형 on 2022/11/13.
//


#include <iostream>
#include <queue>
using namespace std;
int n, k;
bool visit[100001];

int dx[3]={1,-1,2};


//기본 bfs문제
// 1,-1,2의 모든 경우 완전탐색
// 가장 빠른 시간은 bfs로 돌리면 찾을 수 있음, dfs는 불가능
//https://nulls.co.kr/graph/141
void bfs(int a){
    queue<pair<int, int>> q;
    q.push(make_pair(a, 0));
    while(!q.empty()){
        int x = q.front().first;
        int cnt = q.front().second;
        q.pop();
        if(x==k){
            cout << cnt;
            break;
        }

        for(int i=0 ; i<3; i++){
            int nx = 0;
            if(i<2){
                nx = x + dx[i];
            }else{
                nx = x*dx[i];
            }
            if(nx>=0&&nx<100001){
                if(!visit[nx]){
                    visit[nx]=true;
                    q.push(make_pair(nx,cnt+1));
                }
            }


        }

    }
}
int main(){
    cin >> n >> k;
    visit[n] = true;
    bfs(n);
    return 0;
}
