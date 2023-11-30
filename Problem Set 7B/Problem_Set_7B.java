import java.util.ArrayList;
public class Problem_Set_7B{
    public static void main(String[]args){
        //question1
        System.out.println(sieve(10));
        
        //question2
        System.out.println(goldbach(100));
        
        //Question 3
         
        ArrayList<Integer> list1 = new ArrayList();
        ArrayList<Integer> list2 = new ArrayList();
       
        list1.add(1);
        list1.add(0);
        list1.add(3);
        
        list2.add(2);
        list2.add(0);
        list2.add(9);
 
        System.out.println("list1:"+list1);
        System.out.println("list2:" + list2);
        System.out.print("sum:"+add(list1,list2));
        
    }
    
    //Sieve of Eratosthenes
    public static ArrayList<Integer> sieve(int n){
        ArrayList<Integer> list = new ArrayList();
        for(int i = 2; i<=n; i++){
            list.add(i);
        }
        for(int i = 0; i<list.size(); i++){
            int p = list.get(i);
            for(int k = i+1; k<list.size();k++){
                if(list.get(k)%p==0){
                list.remove(k);
                k--;
                }
            }
        }
        return list;
    }
    
    //Goldbach Conjecture
    public static ArrayList<Integer> goldbach(int n){
        ArrayList<Integer> p = sieve(n);
        ArrayList<Integer> list = new ArrayList();
        for(int i=0; i<p.size();i++){
            int s1 = p.get(i);
            for(int k = 0; k<p.size(); k++){
                int s2 = p.get(k);
                if(s1+s2==n){
                list.add(s1);
                list.add(s2);
                return list;
                }
            }  
        }
        return list;
        }
        
    //Adding BigInts
    public static ArrayList<Integer> add (ArrayList<Integer> one, ArrayList<Integer> two){
       ArrayList<Integer> ans = new ArrayList();
        int sum = 0;
        int len1 = one.size()-1;
        int len2 = two.size()-1;
        int carry = 0;  
        if(len1>len2){
            while(len2>=0){
                sum=one.get(len1)+two.get(len2)+carry;
                if(sum>9){
                    carry = 1;
                    sum-=10;
                }else{
                    carry = 0;
                }
                ans.add(0,sum);
                len2--;
                len1--;
            }
            while(len1>=0){
                sum=one.get(len1)+carry;
                if(sum>9){
                    carry = 1;
                    sum-=10;
                }else{
                    carry = 0;
                }
                ans.add(0, sum);
                len1--;
            }   
        }else if(len2>len1){     
            while(len1>=0){
                sum=one.get(len1)+two.get(len2)+carry;
                if(sum>9){
                    carry = 1;
                    sum-=10;
                }else{
                    carry = 0;
                }
                ans.add(0,sum);
                len2--;
                len1--;
            }
            while(len2>=0){
                sum=two.get(len2)+carry;
                if(sum>9){
                    carry = 1;
                    sum-=10;
                }else{
                    carry = 0;
                }
                ans.add(0, sum);
                len2--;
            }   
        }else{
            for(int x = len1;x>=0;x--){
                sum = one.get(x)+two.get(x)+carry;
                if(sum>9){
                    carry = 1;
                    sum-=10;
                }else{
                    carry = 0;
                }
                ans.add(0,sum);
            }   
        }
        if(carry>0){
              ans.add(0,1);      
        }
        return ans;
    }
}
