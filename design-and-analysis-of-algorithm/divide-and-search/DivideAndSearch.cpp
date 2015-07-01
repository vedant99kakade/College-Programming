/*
*  Divide and Search Algorithm for Binary Tree
*  Input e.g. 0 1 2 3 4 5 6 7
*/

#include<iostream>
using namespace std;


int inputArray[10] = {0,1,2,3,4};
int key;


void  sortInput(){


}

int getMiddle(int firstInt, int secondInt){

	return ( (firstInt+secondInt) / 2 );

}

int searchKey(int key, int minPos, int maxPos){


	cout<<endl<<endl;
	cout <<"KEY : "<<key<<" ";
	cout <<"MIN : "<<minPos<<" ";
	cout <<"MAX : "<<maxPos<<" ";


	if( minPos <= maxPos){

		int midPos = getMiddle(minPos,maxPos);
		cout<<"MID : "<<midPos<<" ";

		if( key == inputArray[midPos] ){
			return minPos;
		}

		if( key < inputArray[midPos]){

			searchKey(key,minPos,midPos);

		}

		if( key > inputArray[midPos] ){

			searchKey(key,midPos+1,maxPos);

		}

	}else{

		if( minPos == maxPos ){

			if( key == inputArray[minPos] ){

				return minPos;
			}
		}
		return -1;
	}

}

int main(){


	cout<<"Enter Search Key : ";
	cin>>key;

	if( searchKey(key,0,4) != -1 ){

		cout<<endl<<endl;
		cout<<"Key Found";

	}else{

		cout<<endl<<endl;
		cout<<"Key Not Found";
	}

	cout<<endl<<endl;

	return 0;

}
