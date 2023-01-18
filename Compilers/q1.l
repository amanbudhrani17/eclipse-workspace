%{
#include <stdio.h>
%}

%%

"/*"[a-zA-Z0-9 \t\n]+"*/"  {;}
"//"[a-zA-Z0-9 \t=,+]+  {;}
. ECHO;

%%

int main(int argc, char *argv[])
{
    yyin = fopen("t.java","r");
    yyout = fopen("tSol.java","w");
    yylex();
    fclose(yyin);
    fclose(yyout);
    return 0;
}
