%{
    #include <stdio.h>
    FILE *a;
%}

%%

"/*"[a-zA-Z0-9 \t\n]+"*/"  {;}
"//"[a-zA-Z0-9 \t=,+]+  {;}
"/**"[*a-zA-Z0-9 \t\n]+"*/" {{fputs(yytext,a);}};
. ECHO;

%%

int main(int argc, char *argv[])
{
    yyin = fopen("t.java","r");
    a=fopen("comment.txt", "w");
    yyout = fopen("q2Sol.java", "w");
    yylex();
    return 0;
}
