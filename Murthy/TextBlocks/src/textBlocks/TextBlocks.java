package textBlocks;

public class TextBlocks {

	public static void main(String[] args) {
		String errorMessage = """
                ERROR: Unable to connect to the database.
                Please check:
                  - Network connection
                  - Database credentials
                  - Firewall settings
                """;
		System.out.println(errorMessage);
		
		String markdown = """
                # Project Documentation

                ## Features
                - User Authentication
                - File Uploads
                - Reporting Dashboard

                ## License
                MIT License
                """;

        System.out.println(markdown);
        

	}

}
