#include <stdio.h>
#include <iostream>
#include <ctime>
#include <iomanip>

using namespace std;

void matrix(float **&a,int n,int m)
{
	a=new float *[n];
	for(int i=0; i<n; i++)
	a[i]= new float [m];
	return;
}

void record( float** matrix, int rows, int cols ) //‘ункци€ дл€ заполнени€ матрицы
{
	cout << "¬ведите элементы в матрицу" << endl;
    for( int i = 0; i < rows; i++ )
        for( int j = 0; j < cols; j++ )
            cin >> matrix[ i ][ j ];
} 



void print(float **a,int n,int m)
{
	//выводим матрицу на экран
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		cout << setw(14) << a[i][j];
		cout << endl << endl;
	}
	cout<<"______________________________________"<<endl;
	return; 
}
void simplex(float **a,float **b,float **a2,float **b2,int n,int m)
{
	for(int i=1;i<4;i++){
		for(int j=0;j<4;j++){
			if((a[i][j]*a[0][j]<0)&&(a2[i][j]*a2[i][4]<0))
				cout<<"a["<<i<<"]["<<j<<"]="<<a[i][j]<<";"<<a2[i][j]<<endl;
		}
	}
	cout << "”кажите координаты разрешающего элемента" << endl;
	int s,t;
	cin >> s;
	cin >> t;
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		{
			if(i == s && j == t)
				b[i][j] = 1/a[i][j];
			if(i == s && j != t) 
				b[i][j] = a[i][j]/a[s][t];
			if(i != s && j == t) 
				b[i][j] = -a[i][j]/a[s][t];
			if(i != s && j != t) 
				b[i][j] = a[i][j] - ((a[s][j]*a[i][t])/a[s][t]);

			if (i == s && j == t)
				b2[i][j] = 1 / a2[i][j];
			if (i == s && j != t)
				b2[i][j] = -a2[i][j] / a2[s][t];
			if (i != s && j == t)
				b2[i][j] = a2[i][j] / a2[s][t];
			if (i != s && j != t)
				b2[i][j] = a2[i][j] - ((a2[s][j] * a2[i][t]) / a2[s][t]);
		}
	}
	return; 
}


void main()
{
	setlocale(LC_ALL, "Russian" );

		int n=4, m=5;
		float **a;
		float **b;
		float **a2;
		float **b2;
		matrix(a, n, m);
		matrix(b, n, m);
		matrix(a2, n, m);
		matrix(b2, n, m);
		//record(a, n, m);
		//record(a2, n, m);
		a[0][0]=-1; a[0][1]=-1; a[0][2]=-1; a[0][3]=-1; a[0][4]=0;
		a[1][0]=7; a[1][1]=4; a[1][2]=3; a[1][3]=8; a[1][4]=-1;
		a[2][0]=2; a[2][1]=9; a[2][2]=5; a[2][3]=7; a[2][4]=-1;
		a[3][0]=5; a[3][1]=3; a[3][2]=6; a[3][3]=4; a[3][4]=-1;

		a2[0][0]=-1; a2[0][1]=-1; a2[0][2]=-1; a2[0][3]=-1; a2[0][4]=0;
		a2[1][0]=5; a2[1][1]=8; a2[1][2]=7; a2[1][3]=3; a2[1][4]=-1;
		a2[2][0]=4; a2[2][1]=0; a2[2][2]=2; a2[2][3]=7; a2[2][4]=-1;
		a2[3][0]=3; a2[3][1]=7; a2[3][2]=6; a2[3][3]=5; a2[3][4]=-1;

		int q=1;
		while(q){
			system("cls");
			print(a, n, m);
			print(a2, n, m);
			simplex(a, b, a2, b2, n, m);
			print(b, n, m);
			print(b2, n, m);
			for(int i=0;i<4;i++){
				for(int j=0;j<5;j++){
					a[i][j]=b[i][j];
					a2[i][j]=b2[i][j];
				}
			}
			if((b[0][0]>0)&&(b[0][1]>0)&&(b[0][2]>0)&&(b[0][3]>0)&&(b2[1][4]>0)&&(b2[2][4]>0)&&(b2[3][4]>0))
				cout<<endl<<endl<<"ACHTUNG!!!!!!!!!!!!"<<endl<<endl<<endl;
			cout<<"enter q: 1=repeat, 0=exit;"<<endl;
			cin>>q;
		}

	
}