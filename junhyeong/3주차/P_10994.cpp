//
// Created by 김준형 on 2022/10/30.
//

#include "P_10994.h"

#include <bits/stdc++.h>

using namespace std;

int n;

int main(){

    cin >> n;

    int k = n;


    int mstart = ((n-1)*4) +1;
    int mstart2 = mstart;
    int mstart3 =0 ;

    //cout << mstart;


    while(k--){
        if(k!=0){
            for (int i = 0; i <mstart3/2 ; ++i) {

                if(i==0){
                    cout << "*";
                }else{
                    if(i%2==0){
                        cout << "*";
                    }else{
                        cout <<" ";
                    }
                }

            }

            for (int i = 0; i <mstart2 ; ++i) {
                cout << "*";
            }

            for (int i = 0; i <mstart3/2 ; ++i) {
                if(i%2==1){
                    cout << "*";
                }else{
                    cout <<" ";
                }

            }


            mstart2-=4;
            mstart3+=4;
            cout << "\n";

        }


        if(k!=0){
            for (int i = 0; i <mstart3/2 ; ++i) {

                if(i==0){
                    cout << "*";
                }else{
                    if(i%2==0){
                        cout << "*";
                    }else{
                        cout <<" ";
                    }
                }

            }
            for (int i = 0; i <mstart-mstart3 ; ++i) {
                cout << " ";

            }

            for (int i = 0; i <mstart3/2 ; ++i) {
                if(i%2==1){
                    cout << "*";
                }else{
                    cout <<" ";
                }

            }
            cout <<"\n";
        }



    }

    //--//

    for (int i = 0; i <mstart3/2 ; ++i) {

        if(i==0){
            cout << "*";
        }else{
            if(i%2==0){
                cout << "*";
            }else{
                cout <<" ";
            }
        }

    }

    for (int i = 0; i <mstart2 ; ++i) {
        cout << "*";
    }

    for (int i = 0; i <mstart3/2 ; ++i) {
        if(i%2==1){
            cout << "*";
        }else{
            cout <<" ";
        }

    }
    cout << "\n";


    //int mstart = ((n-1)*4) +1;
    //int mstart2 = mstart;

    mstart3 = mstart-1;
    mstart2= 0;


    //--//

    while(n--){


        if(n!=0){
            for (int i = 0; i <mstart3/2 ; ++i) {

                if(i==0){
                    cout << "*";
                }else{
                    if(i%2==0){
                        cout << "*";
                    }else{
                        cout <<" ";
                    }
                }

            }
            for (int i = 0; i <mstart-mstart3 ; ++i) {
                cout << " ";

            }

            for (int i = 0; i <mstart3/2 ; ++i) {
                if(i%2==1){
                    cout << "*";
                }else{
                    cout <<" ";
                }

            }
            cout <<"\n";
            mstart2+=4;
            mstart3-=4;
        }


        if(n!=0){
            for (int i = 0; i <mstart3/2 ; ++i) {

                if(i==0){
                    cout << "*";
                }else{
                    if(i%2==0){
                        cout << "*";
                    }else{
                        cout <<" ";
                    }
                }

            }

            for (int i = 0; i <mstart2+1 ; ++i) {
                cout << "*";
            }

            for (int i = 0; i <mstart3/2 ; ++i) {
                if(i%2==1){
                    cout << "*";
                }else{
                    cout <<" ";
                }

            }



            cout << "\n";

        }



    }










}
