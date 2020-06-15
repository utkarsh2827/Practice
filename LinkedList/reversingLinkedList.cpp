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
    while(ptr)
    {
        cout<<ptr->data<<"->";
        ptr = ptr->next;
    }
    cout<<"\n";
}

node* reverse(node* ptr){
    if(ptr==NULL||ptr->next==NULL){
        return ptr;
    }
    node* rest = reverse(ptr->next);
    ptr->next->next = ptr;
    ptr->next = NULL;
    return rest;
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
    cout<<"Original List:\n";
    display_Linked_List(head);
    cout<<"List after reversal\n";
    head = reverse(head);
    display_Linked_List(head);
    
    return 0;
}