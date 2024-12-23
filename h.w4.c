#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_STR_LEN 20

typedef struct Patient {
    char name[MAX_STR_LEN];
    char id[MAX_STR_LEN];
    int urgency;
    struct Patient *next;
} Patient;
Patient *readFile(const char *filename, Patient *head);
Patient *addPatient(Patient *head, const char *name, const char *id, int urgency);
Patient *treatPatient(Patient *head);
void freeList(Patient *head);
void printList(Patient* head) {
    Patient *temp = head;
    while (temp != NULL) {
        printf(" %s\n",temp->name);
        printf(" %s\n",temp->id);
        printf(" %d\n",temp->urgency);
        temp = temp->next;
    }
}


int main(void)
{

Patient *head =NULL;
    head=readFile("Sick.txt",head);
printList(head);


freeList(head);
    return 0;
}

Patient *readFile(const char *filename, Patient *head) {

    FILE *fp;
    fp = fopen(filename, "r");
    if(fp == NULL)
    {
        printf("cannot open file\n");
        return NULL;
    }



    if(!feof(fp)) {

        while(!feof(fp)) {
            Patient *a=(Patient *) malloc(sizeof(Patient));
            fscanf(fp, "%s %s %d",a->name,a->id,&a->urgency );
            a->next=NULL;
            // Patient *temp = (Patient *) malloc(sizeof(Patient));
            // fscanf(fp, "%s %s %d",temp->name,temp->id,&temp->urgency);
            // temp->next=NULL;
            //
            // temp->next=a;
            // a=temp;

head=addPatient(head,a->name,a->id,a->urgency);
            free(a);
            char test ;
        }
    }



    return head;
}








Patient *addPatient(Patient *head, const char *name, const char *id, int urgency) {
Patient *new = (Patient *) malloc(sizeof(Patient));
    strcpy(new->name, name);
    strcpy(new->id, id);
    new->urgency = urgency;
    new->next = NULL;
    Patient *temp=head;
    if(temp==NULL) {
        head=new;
        return head;
    }
    Patient *tempNext=head->next;

if(temp->urgency==urgency) {
    if(strcmp(temp->id,id)==-1) {
        new->next=temp;
        head=new;
        return head;
    }
}
    if(temp->urgency>urgency) {
        new->next=head;
        return  new;
    }
    while (tempNext!=NULL) {

if(urgency>temp->urgency&&tempNext->urgency>urgency) {
temp->next=new;
    new->next=tempNext;
return  head;
}
if(urgency==temp->urgency) {
if(tempNext->urgency>urgency) {
    temp->next=new;
    new->next=tempNext;
    return  head;
}



}
if(tempNext->urgency==urgency) {
    if(strcmp(tempNext->id,id)==-1) {
        temp->next=new;
        new->next=tempNext;
        return  head;
    }
}

        temp=temp->next;
        tempNext=tempNext->next;
    }
    if(temp->urgency==urgency) {
        if(strcmp(temp->id,id)==-1) {
            new->next=temp;
new=head;
            return  head;
        }
    }
    temp->next=new;
    return  head;



}
Patient *treatPatient(Patient *head) {
if(head==NULL) {
    return head;
}
    head=head->next;

    return head;
}
void freeList(Patient *head) {
Patient *temp = head;
    while (temp != NULL) {
        temp = head;
        head=head->next;
        free(temp);
        temp=head;
    }


}