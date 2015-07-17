/*
* Parser for Production :
	E -> TE'
	E'-> +TE'
	T -> FT'
	T'-> *FT'
	F -> [a-z]*[A-Z]*[0-9]*(,)
*/

#include<stdio.h>
#include<string.h>
#include<ctype.h>

// Global Variables
char inputString[20];
int error = 0;
int i = 0;

void E();
void E_Dash();
void T();
void T_Dash();
void F();

int main(){

	printf("Enter String : ");
	gets(inputString);
	
	E();
	
	if( error == 0 && strlen(inputString) == i ){
		
		printf("String Accepted");
	
	}else{
		
		printf("String Not Accepted");
	}
	
}

void E(){

	T();
	E_Dash();
}

void E_Dash(){
	
	if( inputString[i] == '+'){
		i++;
		T();
		E_Dash();
	}
}

void T(){
	
	F();
	T_Dash();
}

void T_Dash(){

	if( inputString[i] == '*' ){
		i++;
		F();
		T_Dash();
	}
}

void F(){

	if( isalpha(inputString[i]) ){
	
		i++;
	
	}else if( isdigit(inputString[i]) ){
		
		i++;
	
	}else if( inputString[i] == '(' ){
	
		i++;
		
		E();
		
		if( inputString[i] == ')'){
			
			i++;
		
		}else{
			
			error = 1;
		}
	
	}else{
	
		error = 1;
	}
}