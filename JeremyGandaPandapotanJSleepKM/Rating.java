package JeremyGandaPandapotanJSleepKM;


public class Rating
{
    private long total;
    private long count;

   public Rating(){
    total = 0;
    count = 0;
   }

   public void insert(int rating){
    total = total + rating;
    count++;
   }

   public double getAverage(){
    if(count == 0){
        return 0;
    }
    return total / count;
   }

   public long getCount(){
    return count;
   }//getter count

   public long getTotal(){
    return total;
   }

   public String toString() {
       return "\nTotal: " + total + "\nCount: " + count;
   }
}
