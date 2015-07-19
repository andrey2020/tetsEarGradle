package net.andreynikolaev.testclientclient;

import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.NamingException;
import net.andreynikolaev.RemoteCalculator;

/**
 *
 * @author <a href="mailto:ich@andrey-nikolaev.net">Andrey Nikolaev</a>
 */

public class RemoteEJBClient {
    private int ff;

    public RemoteEJBClient() {
        try {
            final Hashtable props = new Hashtable();
            // setup the ejb: namespace URL factory
            props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            // create the InitialContext
            final Context context = new javax.naming.InitialContext(props);
 
            // Lookup the Greeter bean using the ejb: namespace syntax which is explained here https://docs.jboss.org/author/display/AS71/EJB+invocations+from+a+remote+client+using+JNDI
            final RemoteCalculator bean = (RemoteCalculator)
                    context.lookup("ServiceTestGradle/CalculatorBean/remote");
            ff = bean.add(4, 5);
        } catch (NamingException ex) {
            Logger.getLogger(RemoteEJBClient.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    public int getFf() {
        return ff;
    }

}