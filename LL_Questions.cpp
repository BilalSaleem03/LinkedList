#include<iostream>
using namespace std;

class node
{
    public:
    int data;
    node* next;

    node(int val)
    {
        data = val;
        next = NULL;
    }
};

void insert(node* &head , int val)
{
    node* n = new node(val);

    if(head==NULL)
    {
        head = n;
        return;
    }
    node* temp = head;
    while(temp->next != NULL)
    {
        temp = temp->next;
    }
    temp->next = n;

}

void insertStart(node* &head , int val)
{
    node* n = new node(val);
    if(head == NULL)
    {
        head = n;
        return;
    }
    n->next = head;
    head = n;
}

void delLast(node* &head)
{
    if(head->next == NULL)
    {
        head=NULL;
        return;
    }
    node* temp = head;
    while(temp->next->next != NULL)
    {
        temp = temp->next;
    }
    temp->next = NULL;
}

void delNth(node* &head , int del)
{
    node* temp = head;
    for(int i = 1 ; i<del-1;i++)
    {
        temp = temp->next;
    }
    temp->next = temp->next->next;
}

node* reverse(node* &head)
{
    node* pre = NULL;
    node*curr = head;
    node* nextn;
    while(curr != NULL)
    {
        nextn = curr->next;
        curr->next = pre;
        pre = curr;
        curr = nextn;
        
    }
    return pre;
}

node* reverseRecursively(node* &head)
{
    if(head==NULL || head->next == NULL)
    {
        return head;
    }
    node* newHead = reverseRecursively(head->next);
    head->next->next = head;
    head->next = NULL;

    return newHead;
}

node* reverseK(node* &head , int k)
{
    node* pre = NULL;
    node*curr = head;
    node* nextn;
    int count = 0;
    while(curr != NULL  && count<k)
    {
        nextn = curr->next;
        curr->next = pre;
        pre = curr;
        curr = nextn;
        count++; 
    }

    if(nextn != NULL)
    {
        head->next = reverseK(nextn , k);
    }
    

    return pre;

}

void display(node* head)
{
    while(head != NULL)
    {
        cout<<head->data<<"->";
        head = head->next;
    }
    cout<<"NULL";
}

int main()
{
    node* head = NULL;
    insert(head , 1);
    //del(head);
    //display(head);
    //cout<<endl;
    insert(head , 2);
    insert(head , 3);
    insert(head , 4);
    insert(head , 5);
    insert(head , 6);
    insert(head , 7);
    insertStart(head , 0);
    display(head);
    cout<<endl;
    //delNth(head , 4);
    //delLast(head);
    display(reverseK(head , 3));
    
    //display(reverseRecursively(head));
    return 0;
}