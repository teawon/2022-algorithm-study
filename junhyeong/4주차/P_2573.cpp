//
// Created by 김준형 on 2022/11/06.
//
#include <iostream>

using namespace std;

int N,M;

int graph[301][301];
int visited[301][301];
int dx[] = {1,0,-1,0};
int dy[] = {0,1,0,-1};
int ngraph[301][301];
bool iceclean=false;
void dfs(int x, int y){
    visited[x][y] = 1;
    for(int i = 0 ; i < 4;i++){
        int nx  = x + dx[i];
        int ny = y + dy[i];
        if(visited[nx][ny] == 0 && nx < N && ny < M && nx>=0 && ny>=0 && graph[nx][ny]>0){
            dfs(nx,ny);
        }
    }
}

int c2;
int zerocount;
int main(){
    cin >> N >> M;

    for(int i=0;i<N;i++){
        for(int i1=0;i1<M;i1++){
            cin >> graph[i][i1];
            if(graph[i][i1]!=0){
            }
        }
    }
    int c3=0;

    int year=0;
    while(iceclean==false){
        for(int i = 0 ; i<N;i++){
            for(int i1=0;i1<M;i1++){
                if(visited[i][i1]==0&&graph[i][i1]>0){
                    dfs(i,i1);
                    c2++;
                    //cout << c2<<"\n";
                }
            }
        }
        //cout << c2 << "c2"<<"\n";

        if(c2>=2){
            cout << year<<"\n";
            break;
        }
        c2=0;


        for(int i = 0 ; i < N;i++){
            for(int i1=0;i1<M;i1++){
                visited[i][i1]=0;
                if(graph[i][i1]!=0){
                    for(int i2=0;i2<4;i2++){
                        int nx = i+dx[i2];
                        int ny = i1+dy[i2];
                        if(graph[nx][ny]==0){
                            ngraph[i][i1]++;
                        }
                    }
                }
            }
        }

        for(int i = 0 ; i <N;i++){
            for(int i1=0;i1<M;i1++){
                graph[i][i1] = graph[i][i1] - ngraph[i][i1];
                if(graph[i][i1]<=0){
                    graph[i][i1]=0;
                    zerocount++;
                }
                ngraph[i][i1]=0;
                //cout << graph[i][i1];
            }
            //cout <<"\n";
        }

        if((N*M)==zerocount){
            cout <<"0"<<"\n";
            break;
        }
        zerocount=0;
        year++;

    }







}