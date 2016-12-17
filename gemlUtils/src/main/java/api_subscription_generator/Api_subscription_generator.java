package api_subscription_generator;

import api_subscription_generator.grants.DbGrants;
import api_subscription_generator.grants.Files;
import api_subscription_generator.grants.RoleGrants;
import api_subscription_generator.grants.Schema;
import db.DbConnector;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import settings.Settings;
import util.FilesCopy;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public class Api_subscription_generator {

    private static final Logger logger;
    private static final long startTime;

    static {
        startTime = System.currentTimeMillis();
        System.setProperty("logfilename", System.getProperty("user.dir") + "\\files\\log\\apiGenLog.log");
        PropertyConfigurator.configure(System.getProperty("user.dir") + "\\log4j.properties");
        logger = Logger.getLogger(Api_subscription_generator.class);
    }

    public static void main(String[] args) {

        System.out.println(System.getProperty("user.dir"));

        ArrayList<String> schemaList;
        Schema schema = new Schema();
        DbGrants dbGrants = new DbGrants();
        RoleGrants roleGrants = new RoleGrants();
        Files.mode = args[0];

        switch (Files.mode) {
            case "g":

                DbConnector.setCredentials(args[1], args[2], args[3]);

                ArrayList<String> strings = schema.get();

                for (String schemaName : strings) {
                    dbGrants.generate(schemaName);
                    dbGrants.toFile(schemaName);

                    File source = new File(Files.getName(schemaName));
                    File dest = new File(Files.getDest(schemaName));

                    new FilesCopy(source, dest);
                }
                break;
            case "r":
                DbConnector.setCredentials(args[1], args[2], args[3]);
                schemaList = schema.get();

                for (String schemaName : schemaList) {
                    roleGrants.generate(schemaName);
                    roleGrants.toFile(schemaName);

                }

                File source = new File(Settings.rolesTemplate + Settings.pristupovaMatice);
                File dest = new File(Settings.srcRoles + Settings.pristupovaMatice);

                new FilesCopy(source, dest);

                for (String schemaName : schemaList) {
                    roleGrants.toXLS(schemaName.toLowerCase());

                }


                break;
            case "d":

                try {
                    DocumentBuilderFactory dbFactory =
                            DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder =
                            dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.newDocument();
                    // root element
                    Element rootElement = doc.createElement("cars");
                    doc.appendChild(rootElement);

                    Element supercar = doc.createElement("supercars");
                    rootElement.appendChild(supercar);

                    Element bike = doc.createElement("bike");
                    rootElement.appendChild(bike);
                    bike.setTextContent("xxxx");


                    // write the content into xml file
                    TransformerFactory transformerFactory =
                            TransformerFactory.newInstance();
                    Transformer transformer =
                            transformerFactory.newTransformer();
                    DOMSource domSource = new DOMSource(doc);
                    StreamResult result =
                            new StreamResult(new File(Settings.deploymentFile));
                    transformer.transform(domSource, result);
                    // Output to console for testing
                    StreamResult consoleResult =
                            new StreamResult(System.out);
                    transformer.transform(domSource, consoleResult);
                } catch (Exception e) {
                    e.printStackTrace();
                }


                break;
        }

        /*
         Svn svn = new Svn("svn revert", TempSVNFile);
         svn.runCommand("svn revert -R.", TempSVNFile);
         svn.runCommand("svn update", TempSVNFile);
         svn.runCommand("svn revert -R", TempSVNFileApiGen);
         svn.runCommand("svn update", TempSVNFileApiGen);

         */
        /*
         FuncListToArray funcListCSV = new FuncListToArray();
         funcListCSV.toFuncList(apiFuncSrc, apiFuncTarg);

         FuncListDb fldb = new FuncListDb();
         fldb.toDb(funcListCSV.getFuncListCSV());

         FuncParamsToArray funcParamsCSV = new FuncParamsToArray();
         funcParamsCSV.toParmsList(apiFuncParamsSrc, apiFuncParamsTarg);

         FuncParamsDb fptdb = new FuncParamsDb();
         fptdb.toDb(fldb.funcList, funcParamsCSV.getFuncParamsCsv());

         ResultToFiles res = new ResultToFiles();
         FuncListToArray funcListCSVcomp = new FuncListToArray();
         funcListCSVcomp.toFuncList("", apiFuncComp);

         FuncParamsToArray funcParamsCSVcomp = new FuncParamsToArray();
         funcParamsCSVcomp.toParmsList("", apiParamsComp);

         CompareLists<FuncListCsv> c1 = new CompareLists(funcListCSV.getFuncListCSV(), funcListCSVcomp.getFuncListCSV());
         CompareLists<FuncParamsToArray> c2 = new CompareLists(funcParamsCSV.getFuncParamsCsv(), funcParamsCSVcomp.getFuncParamsCsv());

         c2.setDiffs(c1);

         String substrictionList = c2.getDiffs2String(",");

         if (!substrictionList.equals("")) {
         DASubscription da = new DASubscription();
         da.createDaSubscriptions(c2);
         XMLforDA xd = new XMLforDA(c1, c2);
         ApiGenData agd = new ApiGenData();
         agd.importDefinitions(c2);
         agd.writeApiGenTable(c2);
         agd.ResultToFiles();

         logger.info("!!!!!!SUBSCRIPTIONS GENERATED TO FILES!!!!!!!!!!!!!");
         } else {
         logger.info("!!!!!!NO CHANGE IN SUBSCRIPTIONS!!!!!!!!!!!!!");
         }

         XMLforEA ex = new XMLforEA();
         logger.info("!!!!!!ANALYSIS FILE CREATED!!!!!!!!!!!!!");




         svn.runCommand("svn revert -R.", TempSVNFile);

         elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
         logger.info("!!!!!GENERATED IN " + elapsedTime + " SECONDS!!!!!!");
         **/
    }

}
