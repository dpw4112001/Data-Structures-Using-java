#include<bits/stdc++.h>
using namespace std;
typedef struct node{
	int data;
	struct node *next;
	
}NODE;
typedef struct queue{
	NODE *fr,*rr;
}Q;
void init(Q* t)
{
	t->fr=t->rr=NULL;
}
NODE *createNode(int d)
{
	NODE *a=(NODE *)malloc(sizeof(NODE));
	a->data=d;
	a->next=NULL;
	return a;
}
void insert(Q *t,int d)
{
	NODE *a=createNode(d);
	NODE *b=t->fr;
	if(b==NULL)
	{
		t->fr=t->rr=a;
		return ;
	}
	b=t->rr;
	b->next=a;
	t->rr=a;
}
void del(Q *t)
{
	NODE *a=t->fr;
	if(a==NULL)
	{
		printf("Underflow\n");
		return;
	}
	if(t->fr==t->rr)
	{
		t->fr=t->rr=NULL;
	}
	else
	{
		t->fr=a->next;
	}
	free(a);
}
void display(Q *t)
{
	NODE *a=t->fr;
	if(a==NULL)
	{
		printf("Empty Queue\n");
		return;
	}
	printf("\nQueue : ");
	while(a!=NULL)
	{
		printf("%4d\n",a->data);
		a=a->next;
	}
}

int main()
{
	Q q;
	init(&q);
	
	int opt,d;
	while(1)
	{
		printf("1.insert\n2.delete\n3.display\n4.exit\n");
		scanf("%d",&opt);
		if(opt>3)
			return 0;
		switch(opt)
		{
			case 1:
			printf("\nData : ");
			scanf("%d",&d);
			insert(&q,d);
			break;
			case 2:
			del(&q);
			break;
			case 3:
			display(&q);
		}
	}
	return 0;
}
