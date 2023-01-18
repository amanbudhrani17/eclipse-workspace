%{
    FILE *a;
%}
  
%%
  
\/\*\*(.*\n)*.*\*\/ {fputs(yytext,a);}
  
%%
  
int main(int k,char **argcv)
{
yyin=fopen(argcv[1],"r");
a=fopen("comment.txt", "w");
yylex();
return 0;
}
int yywrap(){return(1);}