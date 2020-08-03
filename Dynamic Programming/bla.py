l=list(map(int,input().split()))
n=int(input())
t=0;
l.sort()
for i in range(len(l)):
    l[i]*=2
x=0
while(x!=n):
    for i in range(3):
        if(l[i]!=0):
            l[i]-=1
            t=t+1
            if(l[i]%2==0):
                x+=1
                if(l[i]!=0):
                    l[i]-=1
                    t=t+1
                break
print(t)