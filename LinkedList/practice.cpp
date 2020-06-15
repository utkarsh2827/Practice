#include<bits/stdc++.h>
using namespace std;

//Structure of node
struct node {
	int data;
	struct node *next;
}*head,*tail;

//PROTOTYPES
node *create_new_node(int);
void insert(node *);
void display_Linked_List(node *);
node *find_Mid(node *);

node *create_new_node(int info)
{
    node *ptr = new node;
    ptr->data=info;
    ptr->next=NULL;
    return ptr;
}

void insert(node *newptr)
{
    if(!head)
    {
        head = tail = newptr;
        return;
    }
    //Else
    tail->next = newptr;
    tail = tail->next;
}

void display_Linked_List(node *ptr)
{
    if(!ptr)
    {
        cout<<"Empty List\n";
        return;
    }
    //ELSE
    cout<<"\nCreated Linked List is\n";
    while(ptr)
    {
        cout<<ptr->data<<"->";
        ptr = ptr->next;
    }
}

node *find_Mid(node *ptr)
{
    if(!head)       //If List is empty
        return NULL;
    node *sptr,*fptr;
    sptr = fptr = head;
    while(fptr && fptr->next)     //Travesre till fptr reaches End of List
    {
        sptr=sptr->next;
        fptr=fptr->next;
        if(fptr)
            fptr=fptr->next;
    }
    return sptr;    //This is our middle node
}

int main()
{
    int choice=1;
    int info;
    head = tail = NULL;

    while(choice==1)
    {
        cout<<"Enter node value\n";
        cin>>info;
        node *newptr = create_new_node(info);
        insert(newptr);
        cout<<"Wnna enter more node? 1->YES 2->NO\n";
        cin>>choice;
    }
    //To see the created Linked List
    display_Linked_List(head);

    node *mid = find_Mid(head);
    if(!mid)
        cout<<"\nLinked List is empty\n";
    else
        cout<<"\nMiddle element is "<<mid->data<<"\n";
    
    return 0;
}