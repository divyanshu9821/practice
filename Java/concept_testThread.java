package Practice.Java;
class Multi extends Thread
{  
	public void run()
	{  
		System.out.println("thread is running...");  
	} 
}

public class concept_testThread {

	public static void main(String[] args) {
		
		Multi t1=new Multi();  
		t1.start();
	}

}
