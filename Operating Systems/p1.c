#include <stdio.h>
#include <stdlib.h>

int  main(int argc, char *argv[]){
    printf("Starting the program.. (pid = %d)\n",(int)getpid());
    int child = fork();
    printf("%d",child);
    if(child<0){
        printf(stderr, "Child process was not created\n");
        exit(1);
    }else if (child == 0){
        printf("This is child process) (pid = %d)\n",(int)getpid());
        sleep(1);
    }else{
        int waiting = wait(NULL);
        printf("This is parent process (pid = %d)\n",waiting, (int)getpid());
    }
    return 0;
}