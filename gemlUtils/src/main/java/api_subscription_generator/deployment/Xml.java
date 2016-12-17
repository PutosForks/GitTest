package api_subscription_generator.deployment;

import api_subscription_generator.deployment.Enum.ActionEnum;
import api_subscription_generator.deployment.Enum.SystemEnum;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import settings.Settings;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Xml {

	public XmlItem xmlCommon = new XmlItem();
	public XmlTaskInfo xmlTaskInfo = new XmlTaskInfo();

	public void generateTask () {

		try {
			DocumentBuilderFactory dbFactory
					= DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder
					= dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			// root element
			Element rootElement = doc.createElement("TASK");
			doc.appendChild(rootElement);

			Element act = doc.createElement("ACTION");
			rootElement.appendChild(act);
			act.setTextContent(ActionEnum.DS.toString());

			Element relId = doc.createElement("REELASE_ID");
			rootElement.appendChild(relId);
			relId.setTextContent(xmlCommon.getReleaseId());

			Element depFlow = doc.createElement("DEPLOYMENT_FLOW");
			rootElement.appendChild(depFlow);
			depFlow.setTextContent(xmlTaskInfo.getDeploymentFlow().toString());

			Element relName = doc.createElement("RELEASE_NAME");
			rootElement.appendChild(relName);
			relName.setTextContent(xmlCommon.getReleaseName());

			Element sysName = doc.createElement("SYSTEM_NAME");
			rootElement.appendChild(sysName);
			sysName.setTextContent(SystemEnum.GEML.toString());
			sysName.setTextContent(xmlTaskInfo.getSystem().toString());

			Element schmName = doc.createElement("SCHEMA_NAME");
			rootElement.appendChild(schmName);
			schmName.setTextContent(xmlCommon.getSchemaName().toString());

			Element objName = doc.createElement("OBJECT_NAME");
			rootElement.appendChild(objName);
			objName.setTextContent(xmlCommon.getObjectName());

			Element objType = doc.createElement("OBJECT_DB_TYPE");
			rootElement.appendChild(objType);
			objType.setTextContent(xmlCommon.getObjectType().toString());

			Element scrtVers = doc.createElement("SCRIPT_VERSION_ID");
			rootElement.appendChild(scrtVers);

			Element depType = doc.createElement("DEPLOYMENT_TYPE");
			rootElement.appendChild(depType);

			Element env = doc.createElement("ENVIRONMENTS");
			rootElement.appendChild(env);

			Element rqType = doc.createElement("RQ_TYPE");
			rootElement.appendChild(rqType);
			rqType.setTextContent("RQ");

			Element rqId = doc.createElement("RQ_ID");
			rootElement.appendChild(rqId);

			Element rqName = doc.createElement("RQ_NAME");
			rootElement.appendChild(rqName);
			rqName.setTextContent("GEML Vyvoj");

			Element file = doc.createElement("FILE_PATH");
			rootElement.appendChild(file);
			file.setTextContent(xmlCommon.getFilePath());

			Element scriptComment = doc.createElement("SCRIPT_VERSION_COMMENT");
			rootElement.appendChild(scriptComment);
			scriptComment.setTextContent(xmlCommon.getScriptcomment());

			Element fileId = doc.createElement("FILE_ID");
			rootElement.appendChild(fileId);

			Element folderName = doc.createElement("FILE_FOLDER_NAME");
			rootElement.appendChild(folderName);

			Element folderSubName = doc.createElement("FILE_SUBFOLDER_NAME");
			rootElement.appendChild(folderSubName);

			Element fileName = doc.createElement("FILE_NAME");
			rootElement.appendChild(fileName);

			Element patchId = doc.createElement("PATCH_ID");
			rootElement.appendChild(patchId);

			Element fileVersion = doc.createElement("FILE_VERSION_ID");
			rootElement.appendChild(fileVersion);

			Element status = doc.createElement("STATUS");
			rootElement.appendChild(status);

			Element error = doc.createElement("ERROR");
			rootElement.appendChild(error);

			Element patchApprove = doc.createElement("PATCH_APPROVE_FOR_TEST");
			rootElement.appendChild(patchApprove);
			patchApprove.setTextContent(xmlTaskInfo.getPatchApprove().toString());

			Element patchDesc = doc.createElement("PATCH_DESCRIPTION");
			rootElement.appendChild(patchDesc);
			patchDesc.setTextContent(xmlTaskInfo.getPatchDescription());

			// write the content into xml file
			TransformerFactory transformerFactory
					= TransformerFactory.newInstance();
			Transformer transformer
					= transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result
					= new StreamResult(new File(Settings.deploymentFile));
			transformer.transform(source, result);
			// Output to console for testing
			StreamResult consoleResult
					= new StreamResult(System.out);
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, consoleResult);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
