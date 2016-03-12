package ldaptest;

import javax.naming.*;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.ldap.LdapContext;
import java.util.Hashtable;

/**
     * Example code for retrieving a Users Primary Group
     * from Microsoft Active Directory via. its LDAP API
     *
     */
    public class LDAPTest {

        private static LdapContext ldapContext = null;


        public static void main(String[] args) throws NamingException {

            String url = "ldap://localhost:389";
            Hashtable env = new Hashtable();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, url);
            env.put(Context.SECURITY_AUTHENTICATION, "simple");
            env.put(Context.SECURITY_PRINCIPAL, "cn=manager,dc=maxcrc,dc=com");
            env.put(Context.SECURITY_CREDENTIALS, "secret");

            try {
                DirContext ctx = new InitialDirContext(env);
                System.out.println("connected");
                System.out.println(ctx.getEnvironment());

                ldapContext = (LdapContext) ctx.lookup("cn=person,dc=maxcrc,dc=com");

                System.out.println(getAttributeByName("telephoneNumber"));

                ctx.close();

            } catch (AuthenticationNotSupportedException ex) {
                System.out.println("The authentication is not supported by the server");
            } catch (AuthenticationException ex) {
                System.out.println("incorrect password or username");
;
            } catch (Exception e) {
                System.out.println(e);
            }

        }
            public static String getAttributeByName (String s)   {
                boolean inContext = false;
                try {
                Attributes attributes = ldapContext.getAttributes("");
                 return  getAttributeValue(attributes.get(s));

                } catch (NamingException ex) {
                    System.out.println("error when trying to create the context");
                }
            return null;
           }

        public static String getAttributeValue(Attribute attribute) {

            if (attribute == null) {
                return "Not in context";
            }

            String res =  attribute.toString();
            return res.substring(res.indexOf(":") + 1).trim();
        }



    }
