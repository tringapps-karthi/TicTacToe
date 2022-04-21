package com.example;

public class TicTacToeBoard {
      
       public static Evaluation evaluateBoard(String boardstate)
       {
           String patterns = boardstate.toLowerCase();

           if(boardstate.length() !=9)
           {
               return Evaluation.InvalidInput;
           }
       
    int countx=0;
    int counto=0;

      for(int  i=0;i<patterns.length();i++)
      {
         if(patterns.charAt(i)=='x'){
         countx++;
         }
         if(patterns.charAt(i)=='o'){
         counto++;
         }
      }
      if(Math.abs(counto - countx)>=2){
        return Evaluation.UnreachableState;
    }
    Boolean xwins = win('x',patterns);
    Boolean owins = win('o',patterns);
    if((xwins)&&(owins))
    {
      return Evaluation.UnreachableState;
    }
    else if(xwins)
    {
      return Evaluation.Xwins;
    }
    else if(owins)
    {
      return Evaluation.Owins;
    }
    else
    {
      return Evaluation.NoWinner;
    }
  }
   public static boolean win(char checker, String patterns)
   {
     if(patterns.charAt(0)==checker && patterns.charAt(1)==checker && patterns.charAt(2)==checker)
    {
      return true;
    }
    if(patterns.charAt(3)==checker && patterns.charAt(4)==checker && patterns.charAt(5)==checker)
    {
      return true;
    }
    if(patterns.charAt(6)==checker && patterns.charAt(7)==checker && patterns.charAt(8)==checker)
    {
      return true;
    }
    if(patterns.charAt(0)==checker && patterns.charAt(3)==checker && patterns.charAt(6)==checker)
    {
      return true;
    }
    if(patterns.charAt(2)==checker &&patterns.charAt(9)==checker &&patterns.charAt(5)==checker)
    {
      return true;
    }
    if(patterns.charAt(2)==checker &&patterns.charAt(5)==checker &&patterns.charAt(8)==checker)
    {
      return true;
    }
    if(patterns.charAt(0)==checker &&patterns.charAt(4)==checker &&patterns.charAt(8)==checker)
    {
      return true;
    }
    return(patterns.charAt(2)==checker &&patterns.charAt(4)==checker &&patterns.charAt(6)==checker);
   }
   public static void main(String args[]){
   System.out.println(evaluateBoard("O...X.X.."));

    System.out.println(evaluateBoard("XXX...oo."));
    System.out.println(evaluateBoard("...Xxx.oo"));
    System.out.println(evaluateBoard("oo....xxx"));
    System.out.println(evaluateBoard("x..x..xoo"));
    System.out.println(evaluateBoard(".x..xoox."));
    System.out.println(evaluateBoard("..xoox..x"));
    System.out.println(evaluateBoard("x...x.oox"));
    System.out.println(evaluateBoard("..x.x.xoo"));
    System.out.println(evaluateBoard("O.."));
    System.out.println(evaluateBoard("O...X.X...."));
    System.out.println(evaluateBoard("Oooxxx..."));
    System.out.println(evaluateBoard("oxooxooxo"));
   }
}

