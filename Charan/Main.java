 // Lambada expresssion JAVA 8
interface  A{
    void check (int num,String name);
        }
        class demo {
    public static void main(String args[]){
                A obj = (num, name)->{
        System.out.println(name);
            };
            obj.check(7,"Charan");
        }
    }