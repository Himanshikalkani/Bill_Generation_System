package com.Billing.Bill.Generation.System.Service;

import com.Billing.Bill.Generation.System.Configuration.TwilioConfig;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.twilio.type.PhoneNumber;

@Service
public class WhatsAppService {
    @Autowired
    private TwilioConfig twilioConfig;

    public void setWhatsAppMessage(String CustomerNumber, String message) {
        String customerPhoneNumber = "+91" + CustomerNumber;

        Message.creator(
                new PhoneNumber("whatsapp:+916354817011"),
                new PhoneNumber("whatsapp:+14155238886"),
                message
        ).create();

        System.out.println("WhatsApp message sent to customer ID: " + customerPhoneNumber + " with message: " + message);

    }
}
