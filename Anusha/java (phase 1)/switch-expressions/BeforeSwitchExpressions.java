// Before Java 17 - Traditional switch statements
class SwitchBefore {
    
    public static String getDayType(String day) {
        String result;
        switch (day) {
            case "MONDAY":
            case "TUESDAY":
            case "WEDNESDAY":
            case "THURSDAY":
            case "FRIDAY":
                result = "Weekday";
                break;
            case "SATURDAY":
            case "SUNDAY":
                result = "Weekend";
                break;
            default:
                result = "Invalid day";
                break;
        }
        return result;
    }
    
    public static int getMonthDays(int month) {
        int days;
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31;
                break;
            case 4: case 6: case 9: case 11:
                days = 30;
                break;
            case 2:
                days = 28; // Simplified
                break;
            default:
                days = -1;
                break;
        }
        return days;
    }
}

public class BeforeSwitchExpressions {
    public static void main(String[] args) {
        System.out.println("=== Before Switch Expressions ===");
        
        String[] days = {"MONDAY", "SATURDAY", "FRIDAY", "INVALID"};
        int[] months = {1, 2, 4, 13};
        
        for (String day : days) {
            System.out.println(day + " is a " + SwitchBefore.getDayType(day));
        }
        
        for (int month : months) {
            System.out.println("Month " + month + " has " + SwitchBefore.getMonthDays(month) + " days");
        }
    }
}