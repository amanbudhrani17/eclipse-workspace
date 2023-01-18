#include<stdio.h>
#include<stdlib.h>
#include <sys/time.h>
#include <sys/stat.h>
double getTime() {
    struct timeval t;
    gettimeofday(&t, NULL);
    return (double) t.tv_sec + (double) t.tv_usec/1e6;
}

void wait(int howlong) {
    double t = getTime();
    while ((getTime() - t) < (double) howlong)
      ;
}
int main(int argc, char *argv[]){
    int *p;
    p = malloc(sizeof(int));
    printf("%d pointer is pointed to address %p \n",(int)getpid(),p);
    *p = atoi(argv[1]);
    while (1)
    {
        wait(2);
        *p = *p + 1;
        printf("%d value of p %d\n",getpid(),*p);
    }
    return 0;
    
}