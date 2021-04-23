package HomeWork1;

public class Race {
    public static void main (String[] args) {
       Capabilities[] capabilities = {
               new Cat("Barsik",150, 60),
               new Cat("Murzik",4_000,60),
               new Human("Martin",500, 100),
               new Human("Maks", 550, 150),
               new Robot("T1000", 5_000,100),
               new Robot("Mark2", 10_000, 10_000)
       };
       Let[] let = {
               new Wall(10),
               new Distance(160),
               new Wall(70),
               new Distance(200),
               new Wall(120),
               new Distance(520),
               new Wall(150),
               new Distance(3_000)
       };
       for (Let lets: let) {
           for (Capabilities capa : capabilities){
               if (lets instanceof Wall) capa.jump(lets.getHeight());
               if (lets instanceof Distance) capa.run(lets.getLength());
           }
       }
    }
}
