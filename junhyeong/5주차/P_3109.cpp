#include <iostream>
using namespace std;

int R , C;
int visited[10001][501];
char graph[10001][501];

int dx[] = {-1,0,1};
int dy[] = {1,1,1};
int cnt=0;
bool check = false;
void dfs(int sx, int sy) {

    visited[sx][sy] = 1;

    if(sy == C-1){
        //cout << "arived" << " " << cnt << "\n";
        //cout << sx <<" " << sy <<"\n";
        cnt++;
        check = true;
    }

    for(int i = 0 ; i < 3; i++){
        int nx = dx[i] + sx;
        int ny = dy[i] + sy;
        if(visited[nx][ny]==0&&nx>=0&&ny>=0&&nx<R&&ny<C&&graph[nx][ny]=='.'){
            dfs(nx,ny);
            if(check == true){
                return;
            }
        }
    }
}

int main(){
    cin >> R >> C;

    for(int i = 0 ; i < R;i++){
        string s ;
        cin >> s;
        for(int j = 0 ; j<C;j++){
            graph[i][j] = s[j];
        }
    }
    for(int i = 0 ; i<R;i++){
        dfs(i,0);
        check=false;
    }
    cout << cnt<<"\n";

}
