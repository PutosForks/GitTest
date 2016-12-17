package api_subscription_generator.deployment;

import api_subscription_generator.deployment.Enum.*;

public class TaskGenerator {

	public static void main(String[] args) {
		Xml taskXml = new Xml();
		taskXml.xmlCommon.setEnvironment(EnvironmentsEnum.D);
		taskXml.xmlCommon.setObjectName("PCK_SAPI16.bdy");
		taskXml.xmlCommon.setReleaseId("1600");
		taskXml.xmlTaskInfo.setDeploymentFlow(DeploymentFlow.R);
		taskXml.xmlTaskInfo.setSystem(SystemEnum.GEML);
		taskXml.xmlCommon.setSchemaName(SchemaNameEnum.APEX_PORTAL_200);
		taskXml.xmlCommon.setObjectType(ObjectTypeEnum.bdy);
		taskXml.xmlTaskInfo.setPatchApprove(PatchApproveEnum.N);

		taskXml.generateTask();

	}
}
