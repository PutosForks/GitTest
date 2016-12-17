package api_subscription_generator.deployment;

import api_subscription_generator.deployment.Enum.ActionEnum;
import api_subscription_generator.deployment.Enum.DeploymentFlow;
import api_subscription_generator.deployment.Enum.PatchApproveEnum;
import api_subscription_generator.deployment.Enum.SystemEnum;


public class XmlTaskInfo {
    private ActionEnum action;
    private SystemEnum system;
    private DeploymentFlow deploymentFlow;
    private String releaseName;
    private PatchApproveEnum patchApprove;
    private String patchDescription;

    /**
     * @return the action
     */
    public ActionEnum getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(ActionEnum action) {
        this.action = action;
    }

    /**
     * @return the system
     */
    public SystemEnum getSystem() {
        return system;
    }

    /**
     * @param system the system to set
     */
    public void setSystem(SystemEnum system) {
        this.system = system;
    }

    /**
     * @return the deploymentFlow
     */
    public DeploymentFlow getDeploymentFlow() {
        return deploymentFlow;
    }

    /**
     * @param deploymentFlow the deploymentFlow to set
     */
    public void setDeploymentFlow(DeploymentFlow deploymentFlow) {
        this.deploymentFlow = deploymentFlow;
    }

    /**
     * @return the releaseName
     */
    public String getReleaseName() {
        return releaseName;
    }

    /**
     * @param releaseName the releaseName to set
     */
    public void setReleaseName(String releaseName) {
        this.releaseName = releaseName;
    }

    /**
     * @return the patchApprove
     */
    public PatchApproveEnum getPatchApprove() {
        return patchApprove;
    }

    /**
     * @param patchApprove the patchApprove to set
     */
    public void setPatchApprove(PatchApproveEnum patchApprove) {
        this.patchApprove = patchApprove;
    }

    /**
     * @return the patchDescription
     */
    public String getPatchDescription() {
        return patchDescription;
    }

    /**
     * @param patchDescription the patchDescription to set
     */
    public void setPatchDescription(String patchDescription) {
        this.patchDescription = patchDescription;
    }


}
