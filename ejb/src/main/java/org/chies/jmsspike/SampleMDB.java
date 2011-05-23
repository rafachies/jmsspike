package org.chies.jmsspike;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@MessageDriven(
		name="ChiesQueue",
		activationConfig= {  
				@ActivationConfigProperty(propertyName="destination",propertyValue="queue/ChiesQueue"),  
				@ActivationConfigProperty(propertyName="destinationType",propertyValue="javax.jms.Queue")  
		}	
)
public class SampleMDB implements MessageListener{

	@Override
	public void onMessage(Message message) {
		try {
			ObjectMessage objectMessage = (ObjectMessage) message;
			SampleMessage sampleMessage = (SampleMessage) objectMessage.getObject();
			System.out.println("Msg received on Queue: sequential = " + sampleMessage.getSequential() + " description = " + sampleMessage.getDescription());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
