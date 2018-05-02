]
import java.awt.Toolkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Component;
import javax.swing.*;



public class Highscore implements myvariables {
		
	Component rootPane;
	

	public Highscore (int k) {
		int scores=k;
		JFrame f=new JFrame();   
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    String nameed=JOptionPane.showInputDialog(f,"Enter Name, you scored "+scores);  
	   // String scoreded=JOptionPane.showInputDialog(f,scores);  
		
		
		Connection myconnection=null;
		//run when game ends
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		myconnection=(Connection)DriverManager.getConnection(path+place,username,password);
		try{
		String q="insert into scorer values(?,?)";
		//INSERT INTO table_name (column1, column2, column3, ...)
		//VALUES (value1, value2, value3, ...);
        PreparedStatement mystatement=myconnection.prepareStatement(q);
        mystatement.setString(1,nameed);
        mystatement.setString(2,""+scores);
        mystatement.executeUpdate();
        
        String q2="Select * from scorer order by scored desc limit 10 ";
        PreparedStatement mystatement2=(PreparedStatement)myconnection.prepareStatement(q2);
        ResultSet myresult = mystatement2.executeQuery();
        int i=1;
        String output="";
        if(myresult.next())
        {
        	         	
            do{
            //    String name,scored;
             
              String name=myresult.getString("name");
              String scored=myresult.getString("scored");  
              String number=Integer.toString(i);
              output=output+number+") "+name+"  ->  "+scored+"\n";
              // mymodel.addRow(new Object[]{name,score});
              i++;
            }
            while(myresult.next());
       }
        JFrame f2=new JFrame();
        f2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JOptionPane.showMessageDialog(f2,"High Scores : \n"+output);  
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(rootPane, "Error in Query : "+e.getMessage());
			
		}
		finally
	    {
	        myconnection.close();

	    }
}
catch(Exception e)
{

    JOptionPane.showMessageDialog(rootPane,"Error in Connection : "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
}        
	}

	/**
	 * @return     Player's highscore
	 */

}
