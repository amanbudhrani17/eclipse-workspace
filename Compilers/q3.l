%{
#include <stdio.h>
int html=0,head=0,title=0,body=0,p=0;

%}

%%
"<html>"  { html++; }
"</html>" { html++; }

"<head> "  { head++; }
"</head> "  { head++; }

"<title>"  { title++;}
"</title>"  { title++;}

"<body> "  { body++;}
"</body> "  { body++;}

"<p>" { p++; }
"</p>" {p++;}
%%

int main() {
    yyin=fopen("index.txt","r");
    yylex();
    printf("html %d\n",html);
    printf("head %d\n",head);
    printf("title %d\n",title);
    printf("body %d\n",body);
    printf("p %d\n",p);
    return 0;
}