
package CarSales;
import java.io.Serializable;

public class s implements Serializable{
     String usen;
     String lname,fname,eid,db,gen,add;
     String pass;
    public s(String u,String f, String l,String p,String eid,String db,String gen,String add){
  
        usen=u;
        fname=f;
        lname=l;
     pass = p;
     this.eid = eid;
     this.db = db;
     this.gen = gen;
     this.add = add;
     }
    public s(){}
   }
