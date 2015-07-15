#include<stdio.h>
#include<string.h>
#include<ctype.h>

char input[20];
int error=0;
void E();
void Edash();
void T();
void F();
void Tdash();
int i=0;
int main()
{
	
	printf("Enter Expression");
	gets(input);
	E();
	if(error==0 && strlen(input) == i)
	{
		printf("ACCEPTED");
	}
	else
	{
		printf("Not Accepted");
	}
}

void E()
{
	T();
	Edash();
}
void Edash()
{
	if(input[i] == '+')
	{
		i++;
		T();
		Edash();
	}
}

void T()
{
	F();
	Tdash();
}
void Tdash()
{
	if(input[i]=='*')
	{
		i++;
		F();
		Tdash();
	}
}
void F()
{
	if(isalpha(input[i]))
	{
		i++;
	}
	else if(isdigit(input[i]))
	{
		i++;
	}
	else if(input[i] == '(')
	{
		i++;
		E();
		if(input[i] == ')')
		{
			i++;
		}
		else
		{
			error = 1;
		}
	}
	else
	{
		error = 1;
	}
}
