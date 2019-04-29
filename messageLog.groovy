import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;

def Message processData(Message message) {
    def body = message.getBody(java.lang.String) as String;
    def header = message.getHeaders() as String;
    def property = message.getProperties() as String;
    def messageLog = messageLogFactory.getMessageLog(message);
    if(messageLog != null){
        messageLog.setStringProperty("Logging#1", "Printing Payload As Attachment")
        messageLog.addAttachmentAsString("ResponsePayload:", body, "text/plain");
        messageLog.addAttachmentAsString("ResponseHeader:", header, "text/plain");
        messageLog.addAttachmentAsString("Properties:", property, "text/plain");
     }
    return message;
} 
