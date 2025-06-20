package com.scaler.paymentservice.adapters.paymentgatewaysadapters.stripe;

import org.springframework.stereotype.Service;

import com.scaler.paymentservice.adapters.paymentgatewaysadapters.PaymentGatewayAdapter;
import com.stripe.StripeClient;
import com.stripe.model.PaymentLink;
import com.stripe.param.PaymentLinkCreateParams;

@Service
public class StripePaymentGatewayAdapter implements PaymentGatewayAdapter {
    private final StripeClient stripeClient;

    public StripePaymentGatewayAdapter(StripeClient stripeClient) {
        this.stripeClient = stripeClient;
    }

    
    @Override
    public String createPaymentLink(Long price) throws Exception {

//         ProductCreateParams params =
//   ProductCreateParams.builder()
//     .setDescription("(created by Stripe Shell)")
//     .setName("Scaler Academy Course")
//     .setActive(true)
//     .setDefaultPriceData(
//       ProductCreateParams.DefaultPriceData.builder()
//         .setCurrency("inr")
//         .setUnitAmount(999999L)
//         .build()
//     )
//     .build();

// Product product = Product.create(params);

// PriceCreateParams params =
//   PriceCreateParams.builder()
//     .setCurrency("inr")
//     .setProduct("prod_QoQyJDl6Jf0JGx")
//     .setUnitAmount(999999L)
//     .build();

// Price price = Price.create(params);

        PaymentLinkCreateParams params =
            PaymentLinkCreateParams.builder()
                .setCurrency("inr")
                .addLineItem(
                PaymentLinkCreateParams.LineItem.builder()
                    .setPrice("price_1Pwo7cLbeILF4TqhDP2UjHpP")
                    .setQuantity(1L)
                    .build()
                )
                .setAfterCompletion(
                PaymentLinkCreateParams.AfterCompletion.builder()
                    .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                    .setRedirect(
                    PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                        .setUrl("https://scaler.com")
                        .build()
                    )
                    .build()
                )
                .setInvoiceCreation(
                PaymentLinkCreateParams.InvoiceCreation.builder().setEnabled(true).build()
                )
                .setPhoneNumberCollection(
                PaymentLinkCreateParams.PhoneNumberCollection.builder().setEnabled(false).build()
                )
                .build();

        PaymentLink paymentLink = PaymentLink.create(params);

        return paymentLink.getUrl();
    }

}
