package api_subscription_generator.deployment.Enum;


public enum DeploymentFlow {

    P,  // production only bug fix*
    PD, // production and development bug fix*
    R;  // deploy for release

}
