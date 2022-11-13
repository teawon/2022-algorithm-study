#include <iostream>
using namespace std;

int R , C;
int visited[10001][501];
char graph[10001][501];

// 여기서 dx가 R 즉 y축
// 여기서 dy가 C 즉 x축
// 즉 오른쪽 위부터 탐색함
int dx[] = {-1,0,1};

int dy[] = {1,1,1};
int cnt=0;
bool check = false;
void dfs(int sx, int sy) {

    visited[sx][sy] = 1;

    //가스관이 끝까지 도달할경우만 cnt ++
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

            //가스관이 끝까지 도달했을경우 dfs 종료
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

    //dfs 연산을 종료시키는 check 초기화
    for(int i = 0 ; i<R;i++){
        dfs(i,0);
        check=false;
    }
    cout << cnt<<"\n";

}
