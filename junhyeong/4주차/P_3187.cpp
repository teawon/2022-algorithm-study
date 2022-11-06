//
// Created by 김준형 on 2022/11/06.
//
#include <iostream>

using namespace std;

int R,C;

char graph[251][251];
int visited[251][251];

int v =0;
int k = 0;

int dx[]={1,-1,0,0};
int dy[]={0,0,-1,1};


int ansv =0;
int ansk=0;

void dfs(int sx,int sy){
    visited[sx][sy] = 1;

    if(graph[sx][sy]=='v'){
        v++;
    }else if(graph[sx][sy]=='k'){
        k++;
    }

    for(int i = 0 ; i < 4;i++ ){
        int nx = sx+dx[i];
        int ny = sy+dy[i];

        if(visited[nx][ny]==0&& nx>=0&&ny>=0&nx<R&&ny<C&&graph[nx][ny]!='#'){
            dfs(nx,ny);
        }
    }
}



int main(){
    cin >> R>> C;

    for(int i = 0 ; i<R;i++){
        for(int i1=0;i1<C;i1++){
            cin >> graph[i][i1];
            //cout << graph[i][i1];
        }
        //cout <<"\n";
    }

    for (int i = 0; i <R ; ++i) {
        for (int j = 0; j < C; ++j) {
            if(graph[i][j]!='#'&&visited[i][j]==0){
                dfs(i,j);
                if(v>=k){
                    ansv+=v;
                }else{
                    ansk+=k;
                }
                v=0;
                k=0;

            }
        }
    }

    cout << ansk << " " << ansv;

}