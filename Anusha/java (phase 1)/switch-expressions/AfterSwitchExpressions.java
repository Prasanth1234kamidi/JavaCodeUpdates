// Java 17 - Switch expressions
class SwitchAfter {
    
    public static String getDayType(String day) {
        return switch (day) {
            case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> "Weekday";
            case "SATURDAY", "SUNDAY" -> "Weekend";
            default -> "Invalid day";
        };
    }
    
    public static int getMonthDays(int month) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> 28; // Simplified
            default -> -1;
        };
    }
    
    // Multi-line switch expressions with yield
    public static String getSeasonDescription(String season) {
        return switch (season.toUpperCase()) {
            case "SPRING" -> {
                System.out.println("Processing spring...");
                yield "Flowers bloom in spring";
            }
            case "SUMMER" -> {
                System.out.println("Processing summer...");
                yield "Hot and sunny weather";
            }
            case "AUTUMN", "FALL" -> {
                System.out.println("Processing autumn...");
                yield "Leaves change colors";
            }
            case "WINTER" -> {
                System.out.println("Processing winter...");
                yield "Cold and snowy season";
            }
            default -> "Unknown season";
        };
    }
}

public class AfterSwitchExpressions {
    public static void main(String[] args) {
        System.out.println("=== After Switch Expressions (Java 17) ===");
        
        String[] days = {"MONDAY", "SATURDAY", "FRIDAY", "INVALID"};
        int[] months = {1, 2, 4, 13};
        String[] seasons = {"SPRING", "SUMMER", "WINTER", "UNKNOWN"};
        
        for (String day : days) {
            System.out.println(day + " is a " + SwitchAfter.getDayType(day));
        }
        
        for (int month : months) {
            System.out.println("Month " + month + " has " + SwitchAfter.getMonthDays(month) + " days");
        }
        
        for (String season : seasons) {
            System.out.println(season + ": " + SwitchAfter.getSeasonDescription(season));
        }
    }
}