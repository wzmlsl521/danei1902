package cn.tedu.demo02;

public class Demo05 {

	public static void main(String[] args) throws InterruptedException {
		Logger log = new Logger();
		log.open();
		
		log.println("Hello World"); 
		log.println("Hello World"); 
		log.println("Hello World"); 
		log.println("Hello World"); 
		log.println("Hello World"); 
		log.println("Hello World"); 
		log.println("Hello World"); 
		log.println("Hello World"); 
		log.println("Hello World"); 
		
		Thread.sleep(1000); 
		
		log.close();
	}

}
