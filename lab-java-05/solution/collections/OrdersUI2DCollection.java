import java.util.*; // Scanner, Set, TreeSet...


public class OrdersUI2DCollection {
    // private final int LEN=2;
    private List<Order> homelist = new ArrayList<Order>();
    private List<Order> officelist = new ArrayList<Order>();
    // private Order[] myOrders = new Order[LEN];

    public void menu(){
        System.out.println("Welcome to the best ordering system!!!");
        Scanner sc = new Scanner(System.in);
        char input = ' ';
        do {
            System.out.print("Menu \n"+
            "A to Add an order\nL to List orders\nR to Remove an order\nQ to Quit"+
            "Type A|L|R|Q: ");
            String s = sc.nextLine();
            input = s.length()>0 ? s.charAt(0) : ' ';  // (cond)?(if true):(if false)
            switch (input){
                case 'A':
                    this.add();
                    break;
                case 'L':
                    this.list();
                    break;
                case 'R':
                    System.out.println("Removed: "+this.remove());
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (input!='Q');
    }

    public void add(){
        Scanner sc = new Scanner (System.in);
        System.out.print("Type your order name: ");
        String n = sc.nextLine();
        System.out.print("Type the product's price value: ");
        double nv = sc.nextDouble();
        System.out.print("Type the product's quantity: ");
        int q = sc.nextInt();
        System.out.print("Type the product's discount: ");
        double d = sc.nextDouble();

        Order o = new Order(n, nv, q, d);
        String lstr = null;
        sc.nextLine(); // Consume \n from input stream.
        do {
            System.out.print("Which list should this order go to? (Type H for home, O for office): ");
            lstr = sc.nextLine();
        } while (lstr==null || lstr.length()<1 || (lstr.charAt(0)!='H' && lstr.charAt(0)!='O'));

        List<Order> addToList = (lstr.charAt(0)=='H')?this.homelist:this.officelist;

        Order other = this.search(o, addToList);
        System.out.println("Found? "+other);
        if( other==null ){
            addToList.add(o);
            System.out.println("Successfully added: "+o);
        } else {
            other.setQuantity(other.getQuantity()+o.getQuantity());
            other.setDiscount(other.getDiscount()>o.getDiscount()?other.getDiscount():o.getDiscount());
            System.out.println("Updated: "+other);
        }

    }

    private Order search(Order s, List<Order> lookInOrders){
        for(Order o: lookInOrders){
            if ( s.equals(o) )
                return o;
        }
        return null;
    }


    public void list(){
        int i=1;
        for(Order o: this.homelist){
            if ( o !=null )
                System.out.println("Order item "+(i++)+": "+ o);
            else
                break;
        }
        System.out.println("List items= "+this.homelist.size());
        for(Order o: this.officelist){
            if ( o !=null )
                System.out.println("Order item "+(i++)+": "+ o);
            else
                break;
        }
        System.out.println("List items= "+this.officelist.size());

    }

    public Order remove(){
        Scanner sc = new Scanner (System.in);
        String lstr = null;
        do {
            System.out.print("Which list should this order be removed from? (Type H for home, O for office): ");
            lstr = sc.nextLine();
        } while (lstr==null || lstr.length()<1 || (lstr.charAt(0)!='H' && lstr.charAt(0)!='O'));
        List<Order> remFromList = (lstr.charAt(0)=='H')?this.homelist:this.officelist;
        if ( remFromList.isEmpty() ) {
            System.out.print("List is empty; nothing to remove. ");
            return null;
        }
        int pos;
        do {
            System.out.print("Type the order index to remove: ");
            pos = sc.nextInt();
        } while( pos<1 || pos>remFromList.size());
        return remFromList.remove(pos-1);
    }

    public static void main(String[] args){
        OrdersUI2DCollection ui = new OrdersUI2DCollection();
        ui.menu();
    }

}
