%{
struct symT
{
	char sym_name[15];
};

int cnt=0;
void insert(char tok[15]);
void print();
struct symT sym[10];
%}
%%

"if"|"else"|"int"|"unsigned"|"long"|"char"|"switch"|"case"|"struct"|"do"|"while"|"void"|"for"|"float"|"continue"|"break"|"include" { printf("\n%s\tKeyword",yytext); }

[_a-zA-Z][_a-zA-Z0-9]* {printf("\n%s\tIdenifier",yytext);insert(yytext);}
"+"|"/"|"*"|"-" {printf("\n%s\tOperator",yytext);}
"="|"<"|">"|"!="|"=="|"<="|">=" {printf("\n%s\tRelational Operator",yytext);}
"%d"|"%s"|"%c"|"%f" {printf("\n%s\tTokenizer",yytext);}
"#" {printf("%s Is Preprocessor\n",yytext);}
[<]+[a-zA-Z]+[.h]+[>]+ 				{printf("%s Header file\n",yytext);}
[a-zA-z0-9]+["()"]+ {printf("%s function\n",yytext);}
["][a-zA-Z0-9]*["] {printf("%s \n test",yytext);}
";"|"," {printf("\n%s\tDelimiter",yytext);}
[int|void]+[a-zA-Z0-9]+["()"]+ {printf("%s \n user define function",yytext);}
"("|")" {if(strcmp(yytext,"(")==0)
	 {
		printf("\n%c\tOpening Parenthesis",yytext[0]);
	 }
	 else
	 {
		printf("\n%c\tClosing Parenthesis",yytext[0]);
	 }
	;}
"{" {printf("\n%s\tStart Of Function/Loop",yytext);}
"}" {printf("\n%s\tEnd of Function",yytext);}
%%

main()
{
	int i;
	FILE *fp;
	fp=fopen("abc.txt","r");
	if(fp==NULL)
	{
			printf("Unable To Open File");
	}
	else
	{
		yyin=fp;
	}
	yylex();
	printf("\n********* Symbol Table **********\n");
	for(i=0;i<cnt;i++)
		printf("%s\n",sym[i].sym_name);

}

void insert(char tok[15])
{
	int fl=0,i;
	for(i=0;i<cnt;i++)
	{
		if(strcmp(sym[i].sym_name,tok)==0)
		{
			fl=1;
			break;
		}
	}
	if(fl==0)
	{
		strcpy(sym[cnt++].sym_name,tok);
	}
}
