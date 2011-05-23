package org.chies.jmsspike;
import javax.jms.DeliveryMode;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import org.chies.jmsspike.SampleMessage;

@Path("/jms")
public class JMSResource {

	@PUT
	@Path("/produce")
	public void queue(SampleMessage sampleMessage) {
		try {
			InitialContext ctx = new InitialContext();
			Queue queue = (Queue) ctx.lookup("queue/ChiesQueue");
			QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup("ConnectionFactory");
			QueueConnection connection = factory.createQueueConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			ObjectMessage message = session.createObjectMessage(sampleMessage);
			MessageProducer producer = session.createProducer(queue);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			producer.send(message);
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}
}
