/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockinventory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
/**
 *
 * @author user
 */

public class DbConnect {
    private Connection con;
    private Statement st;
    private ResultSet rs1,rs4;
    
    public DbConnect()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/stockinventory","root","");
            st =  con.createStatement();
            
        }catch(Exception ex){
            System.out.println("Error:"+ex);
        }
    }
    public ResultSet genID ()
    {
        try 
        {
            String new_opd="select roll from currentroll where id=1 ";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
     public ResultSet challanID (String type)
    {
        try 
        {
            String new_opd="select max(challan_no) from "+type+" ";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
    public ResultSet Inventory (String i,String subcateg ,String color,boolean b)
    {
        try 
        {
            String new_opd="";
            if(b==false)
            new_opd="select * from stock where category='"+i+"' and subcateg='"+subcateg+"' and color='"+color+"'";
            else
              new_opd="select * from stock where category='"+i+"' and subcateg='"+subcateg+"'";  
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
    public ResultSet Inventory3 ()
    {
        try 
        {
            
           
            
            String  new_opd="select * from stock where returned=1";  
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
    public ResultSet Inventory2 (String i,String subcateg ,String color,String design,boolean b)
    {
        try 
        {
            String new_opd="";
            if(b==false)
            new_opd="select * from stock where category='"+i+"' and subcateg='"+subcateg+"' and color='"+color+"' and description ='"+design+"'" ;
            else
              new_opd="select * from stock where category='"+i+"' and subcateg='"+subcateg+"' and description ='"+design+"'";  
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
    public void remID (String id)
    {
        try 
        {
            String new_opd="delete  from stock where stockid='"+id+"' ";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        
    }
    public ResultSet rollDet (int stid)
    {
        try 
        {
            String new_opd="select * from stock where stockid='"+stid+"' ";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
    public ResultSet rollDet2 (int stid)
    {
        try 
        {
            String new_opd="select category,stockid,subcateg,description,color,kg,returned from stock where stockid='"+stid+"' ";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
    public ResultSet loadyarn ()
    {
        try 
        {
            String new_opd="select * from yarn";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
    public ResultSet loadquality (String y)
    {
        try 
        {
            String new_opd="select * from quality where yarn='"+y+"'";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
     public ResultSet loadcolor (String y)
    {
        try 
        {
            String new_opd="select color from color where quality='"+y+"'";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
     public ResultSet dispatchDet (int stid,String type)
    {
        try 
        {
            String new_opd="select * from "+type+" where challan_no='"+stid+"' ";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
     public ResultSet dispatchItems (int stid,String type)
    {
        try 
        {
            String new_opd="select stockid,yarn,quality,color,description,weight,yard from "+type+" where dispatchid='"+stid+"' ";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
      public ResultSet getQuality (String stid)
    {
        try 
        {
            String new_opd="select quality_name as qual from quality where yarn='"+stid+"' ";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
       public ResultSet getParty ()
    {
        try 
        {
            String new_opd="select pName from partydetails ";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
       public ResultSet getTrans ()
    {
        try 
        {
            String new_opd="select name from transportdet ";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
       public ResultSet getPartyDetails (String pname)
    {
        try 
        {
            String new_opd="select pGst,pAdd1,pAdd2,p2Add1,p2Add2 from partydetails where pName='"+pname+"' ";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
        public ResultSet getInvoiceList (String type,String d1,String d2)
    {
        try 
        {
            String new_opd="SELECT DATE_FORMAT(date, \"%d/%m/%Y\") AS dateList,challan_no,payee,to_1,totalrolls,totalwt,yard,deliveryby\n" +
"from "+type+" where date>='"+d1+"' and date<='"+d2+"' order by challan_no DESC";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
      /* public ResultSet getInvoiceList (String type)
    {
        try 
        {
            String new_opd="SELECT convert(datetime,date,3) AS dateList,challan_no,payee,to_1,totalrolls,totalwt,deliveryby\n" +
"from "+type+" order by dateList DESC";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }*/
        public ResultSet getDistinctQual (String type,String challan)
    {
        try 
        {
            String new_opd="SELECT GROUP_CONCAT(DISTINCT quality )as qual FROM "+type+" where dispatchid='"+challan+"'";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
        public ResultSet getBillByRoll (String type,int id)
    {
        try 
        {
            String new_opd="SELECT dispatchid  from "+type+" where stockid='"+id+"'";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }

         public ResultSet getInvoiceListCustom (String type,String party,String d1,String d2)
    {
        try 
        {
            String new_opd="SELECT DATE_FORMAT(date, \"%d/%m/%Y\") AS date,challan_no,payee,to_1,totalrolls,totalwt,yard,deliveryby from "+type+" where payee='"+party+"' and date>='"+d1+"' and date<='"+d2+"' order by challan_no desc";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
        public ResultSet yarnList ()
    {
        try 
        {
            String new_opd="select yarnname from yarn ";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
        
         public ResultSet qualList (String yarn)
    {
        try 
        {
            String new_opd="select quality_name from quality where yarn='"+yarn+"' ";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
         
         public ResultSet getDesign (String qual)
    {
        try 
        {
            String new_opd="select distinct description from stock where subcateg='"+qual+"' ";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
          public ResultSet getColours (String qual)
    {
        try 
        {
            String new_opd="select color  from color where quality='"+qual+"' ";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
            
          public ResultSet stockSummary ()
    {
        try 
        {
            String new_opd="select  category,subcateg, color,description,count(id)  from stock where returned=0 group BY category,subcateg,description,color ";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
    public ResultSet stockSummary1 (String yarn)
    {
        try 
        {
            String new_opd="select  category,subcateg, color,description,count(id)  from stock where category='"+yarn+"' and returned=0 group BY category,subcateg,description,color";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
    public ResultSet stockSummary2 (String yarn,String qual)
    {
        try 
        {
            String new_opd="select  category,subcateg, color,description,count(id)  from stock where returned=0 and category='"+yarn+"' and subcateg='"+qual+"' group BY category,subcateg,description,color";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
    public ResultSet stockSummary3 (String yarn,String qual,String color)
    {
        try 
        {
            String new_opd="select  category,subcateg, color,description,count(id)  from stock where returned=0 and category='"+yarn+"' and subcateg='"+qual+"' and color='"+color+"' group BY category,subcateg,description,color";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
     public ResultSet stockSummaryD ()
    {
        try 
        {
            String new_opd="select  category,subcateg, color,count(id)  from stock where returned=0 group BY category,subcateg,color ";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
    public ResultSet stockSummary1D (String yarn)
    {
        try 
        {
            String new_opd="select  category,subcateg, color,count(id)  from stock where category='"+yarn+"' and returned=0 group BY category,subcateg,color";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
    public ResultSet stockSummary2D (String yarn,String qual)
    {
        try 
        {
            String new_opd="select  category,subcateg, color,count(id)  from stock where returned=0 and category='"+yarn+"' and subcateg='"+qual+"' group BY category,subcateg,color";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
    public ResultSet stockSummary3D (String yarn,String qual,String color)
    {
        try 
        {
            String new_opd="select  category,subcateg, color,count(id)  from stock where returned=0 and category='"+yarn+"' and subcateg='"+qual+"' and color='"+color+"' group BY category,subcateg,color";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
    public ResultSet stockStats1 (String t,String d)
    {
        try 
        {
            String new_opd=" select  yarn,quality, color,description,count(id) from (select id,yarn,quality,color,description from  dispatch_details where `date`>= DATE_SUB( '2018/05/30' , INTERVAL 80 DAY ) \n" +
" union ALL select  id,yarn,quality, color,description from dispatch_details2  where `date`>= DATE_SUB( '"+d+"' , INTERVAL "+t+" DAY )) as custom\n" +
" GROUP BY yarn,quality,description,color ";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
}
    public ResultSet stockStats2 (String t,String d,String yarn)
    {
        try 
        {
            String new_opd=" select  yarn,quality, color,description,count(id) from (select id,yarn,quality,color,description from  dispatch_details where  yarn='"+yarn+"' and  `date`>= DATE_SUB( '2018/05/30' , INTERVAL 80 DAY ) \n" +
" union ALL select  id,yarn,quality, color,description from dispatch_details2  where  yarn='"+yarn+"' and `date`>= DATE_SUB( '"+d+"' , INTERVAL "+t+" DAY ) ) as custom\n" +
" GROUP BY yarn,quality,description,color ";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
}
    public ResultSet stockStats3(String t,String d,String yarn,String qual)
    {
        try 
        {
            String new_opd=" select  yarn,quality, color,description,count(id) from (select id,yarn,quality,color,description from  dispatch_details where  yarn='"+yarn+"' and quality='"+qual+"' and  `date`>= DATE_SUB( '2018/05/30' , INTERVAL 80 DAY ) \n" +
" union ALL select  id,yarn,quality, color,description from dispatch_details2  where  yarn='"+yarn+"' and quality='"+qual+"' and `date`>= DATE_SUB( '"+d+"' , INTERVAL "+t+" DAY ) ) as custom\n" +
" GROUP BY yarn,quality,description,color ";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
}
    public ResultSet stockStats4(String t,String d,String yarn,String qual,String col)
    {
        try 
        {
            String new_opd=" select  yarn,quality, color,description,count(id) from (select id,yarn,quality,color,description from  dispatch_details where  yarn='"+yarn+"' and quality='"+qual+"' and color='"+col+"' and `date`>= DATE_SUB( '2018/05/30' , INTERVAL 80 DAY ) \n" +
" union ALL select  id,yarn,quality, color,description from dispatch_details2  where  yarn='"+yarn+"' and quality='"+qual+"' and color='"+col+"' and `date`>= DATE_SUB( '"+d+"' , INTERVAL "+t+" DAY ) ) as custom\n" +
" GROUP BY yarn,quality,description,color ";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
}
    public ResultSet checkBill (int challan,String type)
    {
        try 
        {
            String new_opd="select id  from "+type+" where challan_no='"+challan+"' ";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
    public ResultSet getBillByID (String type,int roll)
    {
        try 
        {
            String new_opd="select dispatchid  from "+type+" where stockid='"+roll+"' ";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
    public ResultSet getInvoiceDetails (String type,int id)
    {
        try 
        {
            String new_opd="SELECT DATE_FORMAT(date, \"%d/%m/%Y\") AS date,challan_no,payee,to_1,totalrolls,totalwt,yard,deliveryby from "+type+" where challan_no='"+id+"'";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
    public ResultSet getPartyID (String name)
    {
        try 
        {
            String new_opd="SELECT * from partydetails where pName='"+name+"'";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
    public ResultSet getStockByDate (String d1,String d2)
    {
        try 
        {
            String new_opd="SELECT * from stock where date>='"+d1+"' and date<='"+d2+"'";
            rs1=st.executeQuery(new_opd);
        }
        catch (Exception e)
        {
            System.out.println("Error at gen opd"+e);
        }
        return rs1;
    }
}
