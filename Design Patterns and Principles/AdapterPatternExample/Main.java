public interface PaymentProcessor {
    void processPayment(double amount);
}
public class StripePayment {
    public void charge(double amount) {
        System.out.println("Charging " + amount + " through Stripe.");
    }
}
public class PayPalPayment {
    public void makePayment(double amount) {
        System.out.println("Processing " + amount + " payment through PayPal.");
    }
}
public class StripeAdapter implements PaymentProcessor {
    private StripePayment stripePayment;

    public StripeAdapter(StripePayment stripePayment) {
        this.stripePayment = stripePayment;
    }

    @Override
    public void processPayment(double amount) {
        stripePayment.charge(amount);
    }
}
public class PayPalAdapter implements PaymentProcessor {
    private PayPalPayment payPalPayment;

    public PayPalAdapter(PayPalPayment payPalPayment) {
        this.payPalPayment = payPalPayment;
    }

    @Override
    public void processPayment(double amount) {
        payPalPayment.makePayment(amount);
    }
}
public class PaymentService {
    private PaymentProcessor paymentProcessor;

    public PaymentService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void process(double amount) {
        paymentProcessor.processPayment(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        // Using Stripe through the adapter
        StripePayment stripePayment = new StripePayment();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripePayment);
        PaymentService paymentServiceWithStripe = new PaymentService(stripeProcessor);
        paymentServiceWithStripe.process(100.0);

        // Using PayPal through the adapter
        PayPalPayment payPalPayment = new PayPalPayment();
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPalPayment);
        PaymentService paymentServiceWithPayPal = new PaymentService(payPalProcessor);
        paymentServiceWithPayPal.process(200.0);
    }
}



