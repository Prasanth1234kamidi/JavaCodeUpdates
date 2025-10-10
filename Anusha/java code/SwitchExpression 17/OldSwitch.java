public class OldSwitch {
    public static void main(String[] args) {
        int day = 6;
        String result;

        switch (day) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                result = "Weekday";
                break;
            case 6:
            case 7:
                result = "Weekend";
                break;
            default:
                result = "Invalid";
        }

        System.out.println("Old Switch Result: " + result);
    }
}
