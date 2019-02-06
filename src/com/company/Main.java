
import java.util.Scanner;

class Zork {
    public static int counter=0;
    public static void main(String[] args) {
        System.out.println("|----------------------------|");
        System.out.println("|****************************|");
        System.out.println("|***WELLCOME TO THE PROGRAM**|");
        System.out.println("|************ZORK************|");
        System.out.println("|----------------------------|");
        foyer();
    }
    public static void foyer(){
        counter++;
        String answer="";
        System.out.println("'ROOM:'  FOYER   'CONTAIN:'   DEAD SCORPION    'DIRECTION TO:'  (n2)\n");
        System.out.println();
        while(true){
            System.out.println("type n2 OR press 'q' to exit");
            Scanner scanner=new Scanner(System.in);
            answer=scanner.nextLine();
            if(!(answer.equalsIgnoreCase("q"))){
                front_room();
            }
            else if((answer.equalsIgnoreCase("q"))){
                System.out.println("YOU VISIT "+counter +" ROOM");
                System.out.println("THANKS");
                System.exit(0);
            }
            else {
                System.out.println("please enter the correct choice");
            }
        }
    }
    public static void front_room(){
        counter++;
        String answer="";
        System.out.println("'ROOM:'  FRONT_ROOM   'CONTAIN:'   PIANO    'DIRECTION TO:'  (s1|w3|e4)\n");
        while(true){
            System.out.println("which room you want to travel.. OR press 'q' to exit");
            Scanner scanner=new Scanner(System.in);
            answer=scanner.nextLine();
            if(!(answer.equalsIgnoreCase("q"))){
                switch(answer){
                    case "s1":
                        foyer();
                        break;
                    case "w3":
                        library();
                        break;
                    case "e4":
                        kitchen();
                        break;
                    default:
                        System.out.println("please enter the correct direction");
                }
            }
            else if((answer.equalsIgnoreCase("q"))){
                System.out.println("YOU VISIT "+counter +" ROOM");
                System.out.println("THANKS");
                System.exit(0);
            }
            else {
                System.out.println("please enter the correct choice");
            }

        }


    }
    public static void library(){
        counter++;
        String answer="";
        System.out.println("'ROOM:'  LIBRARY   'CONTAIN:'   SPIDERS    'DIRECTION TO:'  (n5|e2)\n");
        while(true){
            System.out.println("which room you want to travel.. OR press 'q' to exit");
            Scanner scanner=new Scanner(System.in);
            answer=scanner.nextLine();
            if(!(answer.equalsIgnoreCase("q"))){
                switch (answer){
                    case "e2":
                        front_room();
                        break;
                    case "n5":
                        dining_room();
                        break;
                    default:
                        System.out.println("please enter the correct direction");
                }
            }
            else if((answer.equalsIgnoreCase("q"))){
                System.out.println("YOU VISIT "+counter +" ROOM");
                System.out.println("THANKS");
                System.exit(0);
            }
            else {
                System.out.println("please enter the correct choice");
            }

        }

    }
    public static void kitchen(){
        counter++;
        String answer="";
        System.out.println("'ROOM:'  KITCHEN   'CONTAIN:'   BATS    'DIRECTION TO:'  (w2|n7)\n");
        while(true){
            System.out.println("which room you want to travel..  OR press 'q' to exit");
            Scanner scanner=new Scanner(System.in);
            answer=scanner.nextLine();
            if(!(answer.equalsIgnoreCase("q"))){
                switch(answer){
                    case "w2":
                        front_room();
                        break;
                    case "n7":
                        parlor();
                        break;
                    default:
                        System.out.println("please enter the correct room direction");
                }
            }
            else if((answer.equalsIgnoreCase("q"))){
                System.out.println("YOU VISIT "+counter +" ROOM");
                System.out.println("THANKS");
                System.exit(0);
            }
            else {
                System.out.println("please enter the correct choice");
            }

        }

    }
    public static void dining_room(){
        counter++;
        String answer="";
        System.out.println("'ROOM:'  DINING_ROOM   'CONTAIN:'  DUST EMPTY BOX    'DIRECTION TO:'  (s3)\n");

        while (true){
            System.out.println("which room you want to travel..  OR press 'q' to exit");
            Scanner scanner=new Scanner(System.in);
            answer=scanner.nextLine();
            if(answer.equalsIgnoreCase("s3")){
                library();
            }
            else if(answer.equalsIgnoreCase("q")){
                System.out.println("YOU VISIT "+counter +" ROOM");
                System.out.println("THANKS");
                System.exit(0);
            }
            else {
                System.out.println("please enter the correct choice");
            }
        }
    }
    public static void valut(){
        counter++;
        String answer="";
        System.out.println("'ROOM:'  VALUT   'CONTAIN:'  3 WALKING SKELETONS    'DIRECTION TO:'  (e7|e8)\n");

        while(true){
            System.out.println("which room you want to travel..  OR press 'q' to exit");
            Scanner scanner=new Scanner(System.in);
            answer=scanner.nextLine();
            int random=(int)(Math.random()*10+1);
            if((answer.equalsIgnoreCase("e7"))||(answer.equalsIgnoreCase("e8"))) {
                if (random >= 7) {
                    parlor();
                } else if (random < 7) {
                    secret_room();
                }
            }
            else if(answer.equalsIgnoreCase("q")){
                System.out.println("YOU VISIT "+counter +" ROOM");
                System.out.println("THANKS");
                System.exit(0);
            }
            else{
                System.out.println("please enter the correct choice");
            }
        }
    }
    public static void parlor(){
        counter++;
        String answer="";
        System.out.println("'ROOM:'  PARLOR   'CONTAIN:'  TREASURE CHEST    'DIRECTION TO:'  (e6|s4)\n");

        while (true){
            System.out.println("which room you want to travel..  OR press 'q' to exit");
            Scanner scanner=new Scanner(System.in);
            answer=scanner.nextLine();
            if(answer.equalsIgnoreCase("e6")){
                valut();
            }
            else if(answer.equalsIgnoreCase("s4")){
                kitchen();
            }
            else if(answer.equalsIgnoreCase("q")){
                System.out.println("YOU VISIT "+counter +" ROOM");
                System.out.println("THANKS");
                System.exit(0);
            }
            else {
                System.out.println("please enter the correct choice");
            }
        }
    }
    public static void secret_room(){
        counter++;
        String answer="";
        System.out.println("YOU ARE IN SECRET ROOM RIGHT NOW\n");
        System.out.println("'ROOM:'  SECRET_ROOM   'CONTAIN:'  PILES OF GOLD    'DIRECTION TO:'  (w6)\n");

        while (true){
            System.out.println("which room you want to travel..  OR press 'q' to exit");

            Scanner scanner=new Scanner(System.in);
            answer=scanner.nextLine();
            if(answer.equalsIgnoreCase("w6")){
                valut();
            }
            else if(answer.equalsIgnoreCase("q")){
                System.out.println("YOU VISIT "+counter +" ROOM");
                System.out.println("THANKS");
                System.exit(0);
            }
            else {
                System.out.println("please enter the correct choice");
            }
        }
    }

}

