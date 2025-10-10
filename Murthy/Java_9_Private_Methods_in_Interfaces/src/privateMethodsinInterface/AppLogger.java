package privateMethodsinInterface;

public class AppLogger implements Logger{

	public static void main(String[] args) {
		
        AppLogger app = new AppLogger();
        
        app.logInfo(" hello ");
        
        app.logError(" something went wrong ");
        
        //Logger.format("hi"); Compile error — hidden


	}

}
