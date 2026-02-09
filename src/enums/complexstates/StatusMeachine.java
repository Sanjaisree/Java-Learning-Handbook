package enums.complexstates;
enum OrderStatus{
    NEW{
        @Override
        OrderStatus next(){
            return PROCESSING;
        }
    },
    PROCESSING{
        @Override
        OrderStatus next(){
            return SHIPPING;
        }
    },
    SHIPPING{
        @Override
        OrderStatus next(){
            return DELIVERED;
        }
    },
    DELIVERED{
        @Override
        OrderStatus next(){
            throw new IllegalStateException("order already delivered ");
        }
    };
    abstract OrderStatus next();
}

class Order{
    private OrderStatus status;

    public Order(){
        this.status = OrderStatus.NEW;
    }
    public OrderStatus getStatus(){
        return status;
    }
    public void moveToNext(){
        status = status.next();
    }
}
public class StatusMeachine {
    public static void main(String[] args) {

        Order order = new Order();

        System.out.println(order.getStatus()); // NEW

        order.moveToNext();
        System.out.println(order.getStatus()); // PROCESSING

        order.moveToNext();
        System.out.println(order.getStatus()); // SHIPPED

        order.moveToNext();
        System.out.println(order.getStatus()); // DELIVERED

        // Invalid transition
        order.moveToNext(); // Exception
    }
}

