#include <stdio.h>
#include <stdlib.h>
#include<dos.h>
#include<conio.h>
#include<windows.h>
#include<time.h>
#define WAIT_TIME 500
//定义direction的每个值代表的方向,ASDW(大写)
#define UP 0
#define DOWN 1
#define LEFT 2
#define RIGHT 3
#define ESC 0x011b
#define H 23
#define W 75
initGraph();
int a[H][W];        //地图数组
int s[100][2];      //蛇身坐标数组
int sLength;        //蛇的长度
int direction;      //蛇的方向

void Gameover();
void Play();
void wall();

void wall()
  {   srand((unsigned)time(NULL));            //设置随机数种子为现在的时间（不知道）
        CONSOLE_CURSOR_INFO cursor_info = {1, 0};
        SetConsoleCursorInfo(GetStdHandle(STD_OUTPUT_HANDLE), &cursor_info);    //隐藏关标
      int i,j;
      for(i=0; i<H; i++)
      {
          a[i][0]=1;          //让第一列为1
          a[i][W-1]=1;        //让最后一列为1
      }
      for(j=0; j<W; j++)
     {
         a[0][j]=1;          //让第一行为1
         a[H-1][j]=1;        //让最后一行为1
     }
     sLength=4;          //让蛇的最初长度为4
     s[0][0]=H/2;
     s[0][1]=W/2;        //给蛇头坐标赋值
     for(i=1;i<4;i++)
    {
        s[i][0]=s[0][0]+i;
        s[i][1]=s[0][1];  //给刚开始的蛇身几个初始坐标
    }
      direction=UP;
 }
 void gotoxy(int i,int j)        //移动光标（不知道）
{
    COORD position={j,i};
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE),position);
}

int check(int ii,int jj)        //判断这个点能不能放食物，可以放返回1，不能放返回0
{
    if(a[ii][jj]==1)        //如果有障碍物，返回0
        return 0;
    int i;
    for(i=0; i<sLength; i++)
    {
        if(ii==s[i][0]&&jj==s[i][1])      //如果和其中一个蛇身重合，就返回0
            return 0;
    }
    if(ii==0||ii==H-1||jj==0||jj==W-1)      //如果在边界上面，返回0
        return 0;
    return 1;                       //最后筛选 过后的是符合条件的点
}

void food()
{
    int i,j;
    do
    {
        i=rand()%H;                 //生成0~H-1之间的一个数
        j=rand()%W;
    }
    while(check(i,j)==0);           //生成点直到满足条件
    a[i][j]=-1;                     //标记为食物
    gotoxy(i,j);
    printf("$");                    //画出食物
}

void drawMap()      //画地图
{
    gotoxy(0,0);
    int i,j;
    for(i=0;i<H;i++)
    {
        for(j=0;j<W;j++)            //两重for循环遍历数组
        {
            if(a[i][j]==0)          //为0输出空格
                printf(" ");
            else                    //为1输出#
                printf("#");
        }
        printf("\n");               //别忘了换行
    }
}
void move()
{
    int i;
    gotoxy(s[sLength-1][0],s[sLength-1][1]);
    printf(" ");                            //在尾巴上面画空格以擦除尾巴
    for(i=sLength-1;i>0;i--)                //从尾巴开始，每一个点的位置等于它前面一个点的位置
    {
        s[i][0]=s[i-1][0];
        s[i][1]=s[i-1][1];
    }
    switch(direction)
    {
    case UP:
        s[0][0]--;
        break;
    case DOWN:
        s[0][0]++;
        break;
    case LEFT:
        s[0][1]--;
        break;
    case RIGHT:
        s[0][1]++;
        break;
    }

}

void drawSnake()                //画蛇
{
    int i;
    for(i=0;i<sLength;i++)
    {
        gotoxy(s[i][0],s[i][1]);        //移动关标到蛇的坐标
        printf("@");                    //在这个位置画蛇
    }
}
void key()
{
    if(kbhit()!=0)          //如果有键盘输入
    {
        char in;
        while(!kbhit()==0)  //如果玩家输入了多个按键，以最后一个按键为准
            in=getch();
        switch(in)
        {
        case 'w':
        case 'W':
            if(direction!=DOWN)         //不能缩头吧。。。。
                direction=UP;
            break;
        case 's':
        case 'S':
            if(direction!=UP)
                direction=DOWN;
            break;
        case 'a':
        case 'A':
            if(direction!=RIGHT)
                direction=LEFT;
            break;
        case 'd':
        case 'D':
            if(direction!=LEFT)
                direction=RIGHT;
            break;
        }
    }
}
int main()
{
    wall();
    drawMap();
    while(1)
    {
        drawSnake();                //画蛇
        Sleep(WAIT_TIME);           //等待一段时间
        key();
        move();                     //移动蛇（主要是修改蛇身数组的数据）
        if(a[s[0][0]][s[0][1]]==-1) //如果蛇头碰到食物，就重新投放食物，并且把食物点重置为0
        {
            food();
            a[s[0][0]][s[0][1]]=0;
        }
    }
    getchar();
    return 0;
}
