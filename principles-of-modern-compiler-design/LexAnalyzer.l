%{
	#include<stdio.h>	
%}

%%

"short"|"int"|"long"|"char"|"double"|"float"|"bool"	{ printf("\nData Type : %s",yytext); }

"main"	{ printf("\nMain Function : %s",yytext); }
"("	{ printf("\nOpen Param : %s",yytext); }
")"	{ printf("\nClose Param : %s",yytext); }
"{"	{ printf("\nOpen Function : %s",yytext); }
"}"	{ printf("\nClose Function : %s",yytext); }
";"	{ printf("\nEnd : %s",yytext); }

"printf"	{ printf("\nPrint Function : %s",yytext); }

"return"[ 0-9]*	{ printf("\nReturn : %s",yytext); }

"#include"[\t]*"<"[\t]*[a-z]+[.][hc][\t]*">"	{ printf("\nPreprocessor : %s",yytext); }

[a-zA-Z_][a-zA-Z0-9_]* { printf("\nIdentifiers : %s",yytext); }

.

%%

main(){

	FILE *filePointer;
	filePointer = fopen("HelloWorld.c","r");
	yyin = filePointer;
	yylex();
}

int yywrap() { return 1; }
